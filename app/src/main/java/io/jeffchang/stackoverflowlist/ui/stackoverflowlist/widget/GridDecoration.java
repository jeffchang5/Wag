package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.jeffchang.stackoverflowlist.utils.ResourceUtil;

public class GridDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(
            @NonNull Rect outRect,
            @NonNull View view,
            @NonNull RecyclerView parent,
            @NonNull RecyclerView.State state) {
        int gridMargin = ResourceUtil.convertDpToPixels(view.getContext(), 2);
        outRect.set(gridMargin, gridMargin, gridMargin, gridMargin);
    }

}
