package io.jeffchang.stackoverflowlist.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;

import dagger.android.support.DaggerAppCompatActivity;
import io.jeffchang.stackoverflowlist.R;
import io.jeffchang.stackoverflowlist.ui.stackoverflowlist.StackOverFlowUserListFragment;

/**
 * Hosts our stack overflow user service.
 */
public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToListFragment();
    }

    void goToListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container,
                        StackOverFlowUserListFragment.newInstance())
                .commit();
    }
}
