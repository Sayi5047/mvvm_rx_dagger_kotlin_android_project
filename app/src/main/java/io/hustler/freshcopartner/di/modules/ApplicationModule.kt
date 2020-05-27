package io.hustler.freshcopartner.di.modules

import android.content.Context
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import io.hustler.freshcopartner.PartnerApplication
import io.hustler.freshcopartner.data.remote.firebase.FireBaseRepositry
import io.hustler.freshcopartner.data.remote.firebase.UserRepository
import io.hustler.freshcopartner.di.qualifiers.ApplicationContextQualifier
import io.hustler.freshcopartner.utils.SharedPrefsUtils
import io.hustler.freshcopartner.utils.network.NetworkHelper
import io.hustler.freshcopartner.utils.rx.RxSchedulerProvider
import io.hustler.freshcopartner.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val partnerApplication: PartnerApplication) {


    @Provides
    @Singleton
    fun providesApplication(): PartnerApplication = partnerApplication

    @Provides
    @Singleton
    @ApplicationContextQualifier
    fun providesContext(): Context = partnerApplication


    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPrefsUtils {
        return SharedPrefsUtils.getInstance(providesContext())
    }


    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(providesContext())

    @Provides
    @Singleton
    fun getSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Provides
    @Singleton
    fun getUserRepository(): UserRepository = UserRepository(provideSharedPrefs())


    @Provides
    @Singleton
    fun getCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun providesFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun providesFirebaseRepositry(): FireBaseRepositry = FireBaseRepositry(provideFirebaseDatabase(), providesFirebaseStorage())


}