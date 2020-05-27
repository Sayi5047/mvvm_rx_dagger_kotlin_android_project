package io.hustler.freshcopartner.ui.home.frags

import io.hustler.freshcopartner.ui.base.BaseFragment
import io.hustler.freshcopartner.ui.home.HomeViewModel
import android.view.View
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.di.components.FragmentComponent


class HomeFragment : BaseFragment<HomeViewModel>() {
    override fun provideLayoutId(): Int = R.layout.home_fragment

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.injectHomeFragment(this)
    }

    override fun setupView(view: View) {
        TODO("Not yet implemented")
    }

}