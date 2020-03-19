package com.coroutineadvance.ui

import android.content.Context
import com.coroutineadvance.di.context.ActivityContext
import com.coroutineadvance.di.scope.ActivityScoped
import dagger.Module

import dagger.Provides


@Module
class MainActivityContextModule(private val mainActivity: MainActivity) {
    var context: Context
    @Provides
    @ActivityScoped
    fun providesMainActivity(): MainActivity {
        return mainActivity
    }

    @Provides
    @ActivityScoped
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

    init {
        context = mainActivity
    }
}