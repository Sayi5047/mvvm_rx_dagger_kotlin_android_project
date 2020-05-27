package io.hustler.freshcopartner.ui.base

import io.hustler.freshcopartner.di.modules.ActivityModule
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.hustler.freshcopartner.PartnerApplication
import io.hustler.freshcopartner.di.components.ActivityComponent
import io.hustler.freshcopartner.di.components.DaggerActivityComponent
import io.hustler.freshcopartner.utils.common.Status
import io.hustler.freshcopartner.utils.display.Toaster
import io.hustler.freshcopartner.utils.log.TimberLogger
//import ph.bilidito..driver.di.components.ActivityComponent
//import ph.bilidito..driver.utils.common.Status
//import ph.bilidito..driver.utils.display.Toaster
//import ph.bilidito..driver.utils.log.TimberLogger

import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
    @Inject
    lateinit var viewModel: VM


    lateinit var TAG: String

    /*Abstract methods all the child classes should implement*/
    @LayoutRes
    protected abstract fun provideLayout(): Int

    protected abstract fun injectDependencies(component: ActivityComponent)
    protected abstract fun setupView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        setupObservers()
        setupView(savedInstanceState)
        setupInternet()
        viewModel.onCreate()
        TAG = viewModel.javaClass.name
        TimberLogger.d(TAG, "BASE ON CREATE", TAG)
    }

    override fun onStart() {
        super.onStart()
        viewModel.registerNetworkListener()
        TimberLogger.d(TAG, "Network Registered", TAG)

    }
    private fun setupInternet() {


    }

    protected open fun setupObservers() {
        viewModel.addWindowListnersLiveData.observe(this, Observer {
            /*ae will show error screen when connection lost and it is False*/
            if (!it) addUntouchableFlags()
            else clearUnTouchableFlags()
        })

        viewModel.messageString.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.run { showMessage(this) }
                }
                Status.ERROR -> {
                    it.data?.run { showErrorMessage(this) }
                }
                Status.LOADING -> {
                }
                Status.UNKNOWN -> {
                }
            }
        })

        viewModel.messageStringId.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.run { showMessage(this) }
                }
                Status.ERROR -> {
                    it.data?.run { showErrorMessage(this) }
                }
                Status.LOADING -> {
                }
                Status.UNKNOWN -> {
                }
            }
        })
        viewModel.errormessageString.observe(this, Observer {
            it.data?.run { showErrorMessage(this) }

        })
        viewModel.errormessageStringId.observe(this, Observer {
            it.data?.run { showErrorMessage(this) }

        })
    }

    private fun showErrorMessage(s: String) {
        Toaster.makeSmallErrorToast(applicationContext, s)
    }

    private fun showErrorMessage(i: Int) {
        Toaster.makeBigErrorToast(applicationContext, getString(i))
    }

    private fun showMessage(s: String) {
        Toaster.makeSmallToast(applicationContext, s)
    }

    private fun showMessage(i: Int) {
        Toaster.makeBigToast(applicationContext, getString(i))
    }

    private fun buildActivityComponent(): ActivityComponent =
            DaggerActivityComponent
                    .builder()
                    .applicationComponent((application as PartnerApplication).applicationComponent)
                    .activityModule(ActivityModule(this))
                    .build()

    override fun onBackPressed() {
        super.onBackPressed()
    }

    protected fun addUntouchableFlags() = window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    protected fun clearUnTouchableFlags() = window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)


}