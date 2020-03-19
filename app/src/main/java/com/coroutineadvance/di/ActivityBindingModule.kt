package com.coroutineadvance.di

import com.coroutineadvance.di.scope.ActivityScoped
import com.coroutineadvance.ui.LoginModule
import com.coroutineadvance.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun mainActivity(): MainActivity
}