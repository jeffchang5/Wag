package io.jeffchang.stackoverflowlist.ui.stackoverflowlist;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.jeffchang.stackoverflowlist.R;
import io.jeffchang.stackoverflowlist.di.modules.DaggerViewModelFactory;
import io.jeffchang.stackoverflowlist.ui.common.BaseFragment;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.viewmodel.StackOverflowUserViewModel;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.GridDecoration;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.StackOverflowUserListView;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.StackOverflowUserRecyclerViewAdapter;

import static io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget.StackOverflowUserRecyclerViewAdapter.StackOverflowUserDiffCallback;

/**
 * Fragment that displays a list of stack overflow users.
 */
public class StackOverFlowUserListFragment extends BaseFragment
        implements StackOverflowUserListView {

    @Inject
    DaggerViewModelFactory viewModelFactory;

    private StackOverflowUserViewModel stackOverflowUserViewModel;

    private StackOverflowUserRecyclerViewAdapter stackOverflowUserRecyclerViewAdapter;

    private RecyclerView stackOverflowUserRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stackOverflowUserViewModel =
                ViewModelProviders
                        .of(this,viewModelFactory)
                        .get(StackOverflowUserViewModel.class);
        subscribeUI();
        stackOverflowUserViewModel.getStackOverflowUsers();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stackOverflowUserRecyclerView = view.findViewById(R.id.list_fragment_recycler_view);
        showProgressBar(getString(R.string.loading_stack_overflow_users));
        initRecyclerView();
    }

    public static StackOverFlowUserListFragment newInstance() {
        Bundle args = new Bundle();
        StackOverFlowUserListFragment fragment = new StackOverFlowUserListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void subscribeUI() {
        stackOverflowUserViewModel
                .getStackOverflowUserListLiveData()
                .observe(this, stackOverflowUsers -> {
                    showMainContent();
                    stackOverflowUserRecyclerViewAdapter.submitList(stackOverflowUsers);
                });

        stackOverflowUserViewModel
                .getErrorTypeLiveData()
                .observe(this, errorType -> {
                    switch (errorType) {
                        case NETWORK:
                            showErrorView(R.drawable.ic_cloud_off_black_24dp,
                                    getString(R.string.no_internet_connection), () ->
                                            stackOverflowUserViewModel.getStackOverflowUsers());
                            break;
                        case OTHER:
                            showErrorView(R.drawable.ic_cloud_off_black_24dp,
                                    getString(R.string.unknown_error),
                                    () -> stackOverflowUserViewModel.getStackOverflowUsers());
                            break;
                    }
                });
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_stackoverflow_user_list;
    }

    private void initRecyclerView() {
        stackOverflowUserRecyclerViewAdapter = new StackOverflowUserRecyclerViewAdapter(
                new StackOverflowUserDiffCallback());
        stackOverflowUserRecyclerView.setLayoutManager(
                new GridLayoutManager(getContext(), 3));
        stackOverflowUserRecyclerView.addItemDecoration(new GridDecoration());
        stackOverflowUserRecyclerView.setAdapter(stackOverflowUserRecyclerViewAdapter);
    }

}
