package com.coroutineadvance.di.context

import android.content.Context
import com.coroutineadvance.di.scope.ApplicationScoped
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {
    @Provides
    @ApplicationScoped
    fun provideContext(): Context {
        return context
    }

}