package com.example.bucketlist;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BucketListEntryAdapter extends RecyclerView.Adapter<BucketListEntryAdapter.BucketListViewHolder> {

    BucketListEntry[] entries;

    public BucketListEntryAdapter(BucketListEntry[] entries) {
        this.entries = entries;
    }

    @NonNull
    @Override
    public BucketListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class BucketListViewHolder extends RecyclerView.ViewHolder {
        public BucketListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        // ViewHolder implementation
    }
}
