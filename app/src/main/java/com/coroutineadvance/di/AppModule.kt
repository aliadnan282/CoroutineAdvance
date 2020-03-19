package com.coroutineadvance.di

import android.app.Application
import android.content.Context
import com.coroutineadvance.local.MovieDb
import com.coroutineadvance.network.MovieInterface
import com.coroutineadvance.network.MovieRepo
import com.coroutineadvance.utils.MoviePreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
    @Singleton
    @Provides
    fun provideRepo(movieInterface: MovieInterface) : MovieRepo {
        return MovieRepo(movieInterface)
    }
    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDb{
        return MovieDb.buildDatabase(context)
    }

    @Singleton
    @Provides
    fun provideSharedPref(context: Context): MoviePreference{
        return MoviePreference(context)
    }
}