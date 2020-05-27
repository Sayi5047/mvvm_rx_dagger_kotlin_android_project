package io.hustler.freshcopartner.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.hustler.freshcopartner.data.remote.firebase.FireBaseRepositry
import io.hustler.freshcopartner.data.remote.firebase.UserRepository
import io.hustler.freshcopartner.ui.home.HomeViewModel
import io.hustler.freshcopartner.utils.ViewModelProviderFactory
import io.hustler.freshcopartner.utils.network.NetworkHelper
import io.hustler.freshcopartner.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun providesHoeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository, fireBaseRepositry: FireBaseRepositry
    ): HomeViewModel =
        ViewModelProvider(activity,
            ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(
                    schedulerProvider,
                    compositeDisposable,
                    networkHelper,
                    userRepository,fireBaseRepositry
                )
            }).get(HomeViewModel::class.java)


}


