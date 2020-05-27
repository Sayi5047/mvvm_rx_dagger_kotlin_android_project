package io.hustler.freshcopartner.data.remote.firebase

import android.location.Location
import android.net.Uri
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import io.hustler.freshcopartner.utils.constants.Constants
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.util.*
import javax.inject.Singleton

@Singleton
class FireBaseRepositry(
    private val firebaseDatabase: FirebaseDatabase,
    private val firebaseStorage: FirebaseStorage
) {

    companion object {
        const val DRIVER_TRIP_LOCATION_NODE = "DriverLocation"
        const val LOCATIONS_NODE = "locations"
        const val ALL_DRIVER_LOCATION_NODE = "AllDriverLocation"
    }

    fun uploadImage(filePath: Uri): Single<String> {
        val storageReference = firebaseStorage.reference
            .child("driverimages/" + UUID.randomUUID().toString())
        return Single.create { emitter: SingleEmitter<String> ->
            storageReference.putFile(filePath)
                .addOnSuccessListener {
                    storageReference.downloadUrl.addOnSuccessListener {
                        emitter.onSuccess(it.toString())
                    }
                }
                .addOnFailureListener {
                    emitter.onError(it)
                }
        }
    }

    fun updateDriverLocation(location: Location, driverId: Int): Single<String> =
        Single.create { emitter: SingleEmitter<String> ->
            firebaseDatabase.getReference(ALL_DRIVER_LOCATION_NODE)
                .child(driverId.toString())
                .setValue(LocationUpdates(location.latitude, location.longitude))
                .addOnSuccessListener {
                    emitter.onSuccess("Success")
                }
                .addOnFailureListener {
                    emitter.onError(it)

                }
        }

    fun updateDriverLocationWhileOnTrip(location: Location, driverId: Int, tripId: Long) =
        Single.create { emitter: SingleEmitter<String> ->
            firebaseDatabase
                .getReference(DRIVER_TRIP_LOCATION_NODE)
                .child(driverId.toString())
                .child(LOCATIONS_NODE)
                .child(System.currentTimeMillis().toString())
                .setValue(LocationUpdates(location.latitude, location.longitude))
                .addOnSuccessListener {
                    emitter.onSuccess("Success")

                }
                .addOnFailureListener {
                    emitter.onError(it)
                }


        }

    fun setupListenerForCurrenttask(tripId: String): Observable<Boolean> {
        return Observable.create { emitter: ObservableEmitter<Boolean> ->
            firebaseDatabase.reference.child("shipments")
                .child(tripId)
                .child("status")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        emitter.onError(p0.toException())
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val data = dataSnapshot.getValue(String::class.java)
                        if (data.equals("DRIVER_VERIFIED", true)) {
                            emitter.onNext(true)
                        } else {
                            emitter.onNext(false)
                        }
                    }

                })
        }
    }

    fun updateDriverStatusForTripBroadCast(
        bcNumber: String,
        tripId: String,
        driverId: Int,
        status: String
    ): Single<Boolean> {

        return Single.create { emitter: SingleEmitter<Boolean> ->
            firebaseDatabase.reference
                .child(Constants.TRIP_BROADCAST_ROOT_NODE)
                .child(tripId)
                .child(bcNumber)
                .child("driverId$driverId")
                .setValue(status)
                .addOnSuccessListener { emitter.onSuccess(true) }
                .addOnFailureListener { emitter.onError(it) }

        }
    }

    fun addTheDriversTripDecisionToFireBase(
        tripId: String,
        driverId: Int,
        isAccept: Boolean
    ): Single<Boolean> {
        val childNodeName = if (isAccept) "acceptedId" else "rejectedId"
        val childNodeValue = (if (isAccept) driverId.toString() else "id$driverId")

        return Single.create { emitter ->
            firebaseDatabase.getReference("trips")
                .child(tripId)
                .child(childNodeName)
                .child(childNodeValue)
                .setValue(driverId)
                .addOnSuccessListener { emitter.onSuccess(true) }
                .addOnFailureListener { emitter.onError(it) }


        }
    }

    private class LocationUpdates internal constructor(var lati: Double, var longi: Double)

}