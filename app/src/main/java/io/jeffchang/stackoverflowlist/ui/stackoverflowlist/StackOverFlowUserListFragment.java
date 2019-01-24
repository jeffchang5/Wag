package io.jeffchang.stackoverflowlist.ui.stackoverflowlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import io.jeffchang.stackoverflowlist.R;
import io.jeffchang.stackoverflowlist.ui.common.BaseFragment;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.StackOverflowUserListView;

/**
 * Fragment that displays a list of stack overflow users.
 */
public class StackOverFlowUserListFragment extends BaseFragment
        implements StackOverflowUserListView {

    public static StackOverFlowUserListFragment newInstance() {
        Bundle args = new Bundle();
        StackOverFlowUserListFragment fragment = new StackOverFlowUserListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stackoverflow_user_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
