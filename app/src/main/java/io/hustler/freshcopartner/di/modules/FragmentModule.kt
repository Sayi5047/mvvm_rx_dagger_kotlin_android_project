package io.hustler.freshcopartner.di.modules

import io.hustler.freshcopartner.ui.home.HomeViewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.tasks.Task
import io.hustler.freshcopartner.data.remote.firebase.UserRepository
import io.hustler.freshcopartner.di.scopes.FragmentScope
import io.hustler.freshcopartner.utils.network.NetworkHelper
import io.hustler.freshcopartner.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.hustler.freshcopartner.data.remote.firebase.FireBaseRepositry
import io.hustler.freshcopartner.utils.ViewModelProviderFactory

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    fun providesHoeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository, fireBaseRepositry: FireBaseRepositry
    ): HomeViewModel =
        ViewModelProvider(fragment.requireActivity(),
            ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(
                    schedulerProvider,
                    compositeDisposable,
                    networkHelper,
                    userRepository, fireBaseRepositry
                )
            }).get(HomeViewModel::class.java)

    @Provides
    @FragmentScope
    fun providesLocationRequest(): LocationRequest = LocationRequest.create()
        .apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 10 * 1000
            fastestInterval = 1 * 1000
        }

    @Provides
    @FragmentScope
    fun providesLocationSettingsRequest(): Task<LocationSettingsResponse> {
        return LocationServices
            .getSettingsClient(fragment.requireActivity())
            .checkLocationSettings(
                LocationSettingsRequest
                    .Builder()
                    .addLocationRequest(providesLocationRequest())
                    .setAlwaysShow(true)
                    .build()
            )
    }

}
