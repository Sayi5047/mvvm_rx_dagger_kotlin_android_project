package io.hustler.freshcopartner.di.components

import android.content.Context
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import io.hustler.freshcopartner.PartnerApplication
import io.hustler.freshcopartner.data.remote.firebase.FireBaseRepositry
import io.hustler.freshcopartner.data.remote.firebase.UserRepository
import io.hustler.freshcopartner.di.modules.ApplicationModule
import io.hustler.freshcopartner.di.qualifiers.ApplicationContextQualifier
import io.hustler.freshcopartner.utils.SharedPrefsUtils
import io.hustler.freshcopartner.utils.network.NetworkHelper
import io.hustler.freshcopartner.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
public interface ApplicationComponent {

    fun injectApplication(driverApplication: PartnerApplication?)


    fun getApplication(): PartnerApplication

    @ApplicationContextQualifier
    fun getContext(): Context

    fun getsharedPrefsUtils(): SharedPrefsUtils
    fun getfirebaseDatabase(): FirebaseDatabase
    fun getFirebaseStorage(): FirebaseStorage

    fun getCompositeDisposable(): CompositeDisposable
    fun getNetworkHelper(): NetworkHelper
    fun getSchedulerProvider(): SchedulerProvider
    fun getUserrepositry(): UserRepository
    fun getFirebaseRepositr(): FireBaseRepositry
}