package com.coroutineadvance.di

import com.coroutineadvance.CoroutineApp
import com.coroutineadvance.di.context.ActivityContext
import com.coroutineadvance.di.context.ContextModule
import com.coroutineadvance.network.RetrofitModule
import com.coroutineadvance.ui.MainActivityContextModule
import com.google.samples.apps.iosched.shared.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        RetrofitModule::class,
//        ContextModule::class,
//        MainActivityContextModule::class,
        ActivityBindingModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: CoroutineApp): AppComponent
    }
}