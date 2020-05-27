package io.hustler.freshcopartner.ui.home.frags

import io.hustler.freshcopartner.ui.base.BaseFragment
import io.hustler.freshcopartner.ui.home.HomeViewModel
import android.view.View
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.di.components.FragmentComponent


class OrdersFragment : BaseFragment<HomeViewModel>() {
    override fun provideLayoutId(): Int = R.layout.orders_fragment

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {

    }

}