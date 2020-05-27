package io.hustler.freshcopartner.ui.home

import io.hustler.freshcopartner.data.remote.firebase.FireBaseRepositry
import io.hustler.freshcopartner.data.remote.firebase.UserRepository
import io.hustler.freshcopartner.ui.base.BaseViewModel
import io.hustler.freshcopartner.utils.network.NetworkHelper
import io.hustler.freshcopartner.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
//import ph.bilidito..driver.data.remote.firebase.FireBaseRepositry
//import ph.bilidito..driver.utils.network.NetworkHelper
//import ph.bilidito..driver.utils.rx.SchedulerProvider

class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
    private val fireBaseRepositry: FireBaseRepositry
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        TODO("Not yet implemented")
    }

}