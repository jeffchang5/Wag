package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.jeffchang.stackoverflowlist.R;
import io.jeffchang.stackoverflowlist.models.StackOverflowUser;
import timber.log.Timber;

public class StackOverflowUserRecyclerViewAdapter extends ListAdapter<
        StackOverflowUser,
        StackOverflowUserRecyclerViewAdapter.StackOverflowUserViewHolder> {

    public StackOverflowUserRecyclerViewAdapter(
            @NonNull StackOverflowUserDiffCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StackOverflowUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stack_overflow_item, parent, false);
        return new StackOverflowUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StackOverflowUserViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class StackOverflowUserViewHolder extends RecyclerView.ViewHolder {

        private final TextView stackOverflowUserNameTextView;
        private final ImageView stackOverflowBadgeImageView;
        private final ImageView stackOverflowGravitarImageView;
        private final ProgressBar stackOverflowGravitarProgressBar;

        StackOverflowUserViewHolder(@NonNull View itemView) {
            super(itemView);
            stackOverflowUserNameTextView = itemView
                    .findViewById(R.id.stack_overflow_item_username);
            stackOverflowBadgeImageView = itemView
                    .findViewById(R.id.stack_overflow_item_badge_textview);
            stackOverflowGravitarImageView = itemView
                    .findViewById(R.id.stack_overflow_item_gravitar_imageview);
            stackOverflowGravitarProgressBar = itemView
                    .findViewById(R.id.stack_overflow_item_gravitar_progressbar);
        }

        void bind(StackOverflowUser stackOverflowUser) {
            int progressBarVisibility = stackOverflowGravitarProgressBar.getVisibility();

            // when recycled, this may not be set.
            if (progressBarVisibility != View.VISIBLE) {
                stackOverflowGravitarProgressBar.setVisibility(View.VISIBLE);
            }
            stackOverflowUserNameTextView.setText(stackOverflowUser.getDisplayName());

            Picasso.with(itemView.getContext())
                    .load(stackOverflowUser.getProfileImage())
                    .fit()
                    .centerCrop()
                    .into(stackOverflowGravitarImageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            stackOverflowGravitarProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            // Ideally, log this to the server.
                            Timber.e("Failed to load image");
                        }
                    });
        }
    }

    public static class StackOverflowUserDiffCallback extends DiffUtil.ItemCallback<StackOverflowUser> {

        @Override
        public boolean areItemsTheSame(
                @NonNull StackOverflowUser oldItem,
                @NonNull StackOverflowUser newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(
                @NonNull StackOverflowUser oldItem,
                @NonNull StackOverflowUser newItem) {
            return oldItem == newItem;
        }
    }
}
