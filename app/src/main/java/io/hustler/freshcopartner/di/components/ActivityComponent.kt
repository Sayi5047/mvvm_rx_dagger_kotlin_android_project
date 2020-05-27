package io.hustler.freshcopartner.di.components

import io.hustler.freshcopartner.di.modules.ActivityModule
import io.hustler.freshcopartner.di.scopes.ActivityScope
import io.hustler.freshcopartner.ui.home.HomeActivity
import dagger.Component

//import ph.bilidito..driver.di.modules.io.hustler.freshcopartner.di.modules.ActivityModule

////import ph.bilidito..driver.v1.Activities.DriverHomeActivity
////import ph.bilidito..driver.v1.Activities.LoginActivity
////import ph.bilidito..driver.v1.Activities.ProfileUpdateActivity
////import ph.bilidito..driver.ui.splash.SplashActivity
////import ph.bilidito..driver.di.modules.io.hustler.freshcopartner.di.modules.ActivityModule
////import ph.bilidito..driver.di.scopes.ActivityScope
////import ph.bilidito..driver.service.MyFirebaseMessagingService
////import ph.bilidito..driver.ui.home.HomeActivityV2
////import ph.bilidito..driver.ui.login.LoginActivityV2
////import ph.bilidito..driver.ui.tripnotification.TripNotificationActivity
////import ph.bilidito..driver.ui.profile.ProfileActivity
////import ph.bilidito..driver.ui.profile.UpdateProfileActivityV2
////import ph.bilidito..driver.ui.signup.SignupActivityV2

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
public interface ActivityComponent {
    fun inject(homeActivity: HomeActivity)

}