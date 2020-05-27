package io.hustler.freshcopartner.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.LocationSettingsStatusCodes
import com.google.android.gms.tasks.Task
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.di.scopes.ActivityScope
import io.hustler.freshcopartner.utils.log.TimberLogger
import java.lang.Exception
import java.util.*
import javax.inject.Inject

/**
 * Created by anvaya5 on 18/12/2017.
 */
/*   Copyright [2018] [Sayi Manoj Sugavasi]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/
@ActivityScope
class PermissionUtils @Inject constructor(val activity: Activity) {

    companion object {
        const val STORAGE_PERMISSION_CODE = 200
        const val LOCATION_PERMISSION_CODE = 201
        const val LOCATION_SETTINGS_PERMISSION_CODE = 202
        const val LOCATION_BACKGROUND_PERMISSION_CODE = 203

        const val SUCCESS = "SUCCESS"
        const val NO_SETTINGS = "NO_SETTINGS"
    }

    fun isStoragePermissionAvailable(): Boolean {
        return (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)

    }

    fun isCameraPermissionAvailable(): Boolean {
        return (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
    }


    fun isLocationPermissionAvailable(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ((ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    &&
                    (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    &&
                    (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED))
        } else {
            ((ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    &&
                    (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED))
        }
    }


    private fun isLocationPermissionDenied(): Boolean =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                ((ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED)
                        &&
                        (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED))
            } else {
                ((ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED)
                        &&
                        (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED)
                        &&
                        (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_DENIED))
            }


    fun showPermissionDetailsDialogForAccess(permissionResultListener: PermissionResultListener) {
        val builder: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(activity)
        builder.setTitle(activity.getString(R.string.we_require_your_permission))
        builder.setMessage(activity.getString(R.string.we_need_access_to_your_gallery))
        builder.setNegativeButton(activity.getString(R.string.DENY)) { _, _ -> permissionResultListener.onDecline() }
        builder.setPositiveButton(activity.getString(R.string.GRANT)) { _, _ ->
            run {
                ActivityCompat.requestPermissions(Objects.requireNonNull(activity), arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE
                )
            }
        }
        builder.show()
    }

    fun showCoarsePermissionDetailsDialogMessageForAccess(permissionResultListener: PermissionResultListener) {
        TimberLogger.e("LOC DAILOG", "--> CALLED")
        val builder: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(activity)
        builder.setTitle(activity.getString(R.string.we_require_your_permission))
        builder.setMessage(activity.getString(R.string.we_need_access_to_your_location))
        builder.setNegativeButton(activity.getString(R.string.DENY)) { _, _ -> permissionResultListener.onDecline() }
        builder.setPositiveButton(activity.getString(R.string.GRANT)) { di, _ ->
            run {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        ActivityCompat.requestPermissions(Objects.requireNonNull(activity),
                                arrayOf(
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                                LOCATION_PERMISSION_CODE
                        )
                    } else {
                        ActivityCompat.requestPermissions(Objects.requireNonNull(activity), arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_CODE
                        )
                    }
                } catch (exce: Exception) {
                    exce.printStackTrace()
                }
            }
        }
//        builder.setOnDismissListener {
//            Handler().postDelayed({
//                if (!isLocationPermissionAvailable()) {
//                    permissionResultListener.onDecline()
//                }
//            }, 2000)
//        }
        builder.show()
    }

    fun showBackgroundLocationPermissionDetailsDialogMessageForAccess(permissionResultListener: PermissionResultListener) {
        val builder: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(activity)
        builder.setTitle(activity.getString(R.string.we_require_your_permission))
        builder.setMessage(activity.getString(R.string.we_need_access_of_bg_location))
        builder.setNegativeButton(activity.getString(R.string.DENY)) { _, _ -> permissionResultListener.onDecline() }
        builder.setPositiveButton(activity.getString(R.string.GRANT)) { _, _ ->
            run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    ActivityCompat.requestPermissions(Objects.requireNonNull(activity), arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), LOCATION_BACKGROUND_PERMISSION_CODE)
                }
            }
        }

        builder.show()
    }

    fun launchGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(intent, STORAGE_PERMISSION_CODE)
    }

    interface PermissionResultListener {
        fun onDecline()
    }


    fun openLocationSettingsClient(locationSettingsRequestTask: Task<LocationSettingsResponse>, resolverListener: ResolvableApiExceptionListener) {

        locationSettingsRequestTask.addOnCompleteListener {
            try {
                it.getResult(ApiException::class.java)
            } catch (exception: ApiException) {
                when (exception.statusCode) {
                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                        try {
                            resolverListener.onResolution(exception)
                        } catch (exception: IntentSender.SendIntentException) {
                            exception.message.toString()
                        }
                    }
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                    }
                }
            }

        }


    }

    interface ResolvableApiExceptionListener {
        fun onResolution(exception: ApiException)
    }
}