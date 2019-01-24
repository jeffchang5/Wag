package io.jeffchang.stackoverflowlist.ui.common;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.jeffchang.stackoverflowlist.R;

/**
 * View that displays a progress bar and a message that is the rationale for the progress bar.
 */

public class ProgressBarView extends RelativeLayout {

    private TextView progressLoadingTextView;
    private ProgressBar progressBar;

    public ProgressBarView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ProgressBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, 0);
    }

    public void setLoadingText(String text) {
        progressLoadingTextView.setText(text);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = inflate(context, R.layout.view_progress_bar, this);
        progressLoadingTextView = view.findViewById(R.id.progress_loading_textview);
        progressBar = view.findViewById(R.id.progress_progress_bar);
        progressBar.getProgressDrawable().setColorFilter(
                Color.WHITE,
                android.graphics.PorterDuff.Mode.SRC_IN);
        progressBar.getIndeterminateDrawable().setColorFilter(
                Color.WHITE,
                android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
