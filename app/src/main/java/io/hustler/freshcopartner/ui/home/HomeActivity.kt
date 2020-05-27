package io.hustler.freshcopartner.ui.home

import android.os.Bundle
import io.hustler.freshcopartner.R
import io.hustler.freshcopartner.di.components.ActivityComponent
import io.hustler.freshcopartner.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>(){
    override fun provideLayout(): Int = R.layout.home_activity

    override fun injectDependencies(component: ActivityComponent) {
        component.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

}