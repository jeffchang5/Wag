package io.jeffchang.stackoverflowlist.ui.stackoverflowlist.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.jeffchang.stackoverflowlist.R;
import io.jeffchang.stackoverflowlist.models.StackOverflowUser;

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
        private final TextView stackOverflowBadgeTextView;
        private final ImageView stackOverflowGravitarImageView;

        StackOverflowUserViewHolder(@NonNull View itemView) {
            super(itemView);
            stackOverflowUserNameTextView = itemView
                    .findViewById(R.id.stack_overflow_item_username);
            stackOverflowBadgeTextView = itemView
                    .findViewById(R.id.stack_overflow_item_badge_textview);
            stackOverflowGravitarImageView = itemView
                    .findViewById(R.id.stack_overflow_item_gravitar_imageview);
        }

        public void bind(StackOverflowUser stackOverflowUser) {
            stackOverflowUserNameTextView.setText(stackOverflowUser.getDisplayName());
//            stackOverflowBadgeTextView.setText(stackOverflowUser.getBadgeCounts());
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
