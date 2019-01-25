package io.jeffchang.stackoverflowlist.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import io.jeffchang.stackoverflowlist.di.ViewModelKey;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.viewmodel.StackOverflowUserViewModel;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(StackOverflowUserViewModel.class)
    abstract ViewModel provideStackOverflowUserViewModel(
            StackOverflowUserViewModel stackOverflowUserViewModel);

}
