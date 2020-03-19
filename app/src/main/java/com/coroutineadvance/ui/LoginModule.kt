package com.coroutineadvance.ui

import androidx.lifecycle.ViewModel
import com.coroutineadvance.di.scope.FragmentScoped
import com.coroutineadvance.di.scope.ViewModelKey
import com.coroutineadvance.ui.FirstFragment
import com.coroutineadvance.ui.SecondFragment
import com.coroutineadvance.viewmodel.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun injectFirstFragment(): FirstFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun injectSecondFragment(): SecondFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

}