package io.jeffchang.stackoverflowlist.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.stackoverflowlist.ui.MainActivity;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.StackOverflowUserListFragmentProvider;

/**
 * Module that exposes the main view components.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            StackOverflowUserListFragmentProvider.class,
    })
    abstract MainActivity bindMainActivity();
}
