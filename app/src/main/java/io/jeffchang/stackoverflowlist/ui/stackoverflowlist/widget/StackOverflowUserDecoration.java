package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StackOverflowUserDecoration extends RecyclerView.ItemDecoration {

    private int gridMargin = 2;

    @Override
    public void getItemOffsets(
            @NonNull Rect outRect,
            @NonNull View view,
            @NonNull RecyclerView parent,
            @NonNull RecyclerView.State state) {
        outRect.set(gridMargin, gridMargin, gridMargin, gridMargin);
    }

}
