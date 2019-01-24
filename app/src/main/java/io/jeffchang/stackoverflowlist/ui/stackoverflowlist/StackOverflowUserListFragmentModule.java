package io.jeffchang.stackoverflowlist.ui.stackoverflowlist;

import dagger.Binds;
import dagger.Module;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.StackOverflowUserListView;

/**
 * Provides dependencies for stack overflow user fragment module.
 */

@Module
abstract class StackOverflowUserListFragmentModule {

    @Binds
    abstract StackOverflowUserListView provideStackOverflowUserListView(
            StackOverFlowUserListFragment stackOverFlowUserListFragment);

}