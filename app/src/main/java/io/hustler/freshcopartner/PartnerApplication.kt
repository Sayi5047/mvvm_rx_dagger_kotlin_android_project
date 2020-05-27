package io.hustler.freshcopartner

import android.app.Application
import android.content.Context
import io.hustler.freshcopartner.di.components.ApplicationComponent
import io.hustler.freshcopartner.di.components.DaggerApplicationComponent
import io.hustler.freshcopartner.di.modules.ApplicationModule
import io.hustler.freshcopartner.utils.network.NetworkHelper
import javax.inject.Inject

class PartnerApplication : Application() {
    var applicationComponent: ApplicationComponent? = null

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
        networkHelper.registerNetworkConnectivityChanges()
    }

    override fun onTerminate() {
        super.onTerminate()
        networkHelper.unRegisterNetworkConnectivityChanges()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent!!.injectApplication(this)
    }

    override fun getApplicationContext(): Context? {
        return super.getApplicationContext()
    }
}