package io.jeffchang.stackoverflowlist.ui.stackoverflowlist;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provides dependencies into the list fragment.
 */

@Module
public abstract class StackOverflowUserListFragmentProvider {

    @ContributesAndroidInjector(modules = {StackOverflowUserListFragmentModule.class})
    abstract StackOverFlowUserListFragment provideStackOverFlowUserListFragment();
}