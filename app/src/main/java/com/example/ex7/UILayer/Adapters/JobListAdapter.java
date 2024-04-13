package com.example.ex7.UILayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ex7.DataLayer.Models.Job;
import com.example.ex7.R;
import com.example.ex7.SelectedItem;

import java.util.List;

public class JobListAdapter extends
        RecyclerView.Adapter<JobListAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Job> items;
    private SelectedItem selectedItemListener;

    public JobListAdapter(Context context, List<Job> items, SelectedItem selectedItemListener) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.selectedItemListener = selectedItemListener;
    }

    @Override
    public JobListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void
    onBindViewHolder(JobListAdapter.ViewHolder holder, int position) {
        Job item = items.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(R.drawable.baseline_work);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemListener.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textViewItemName);
            imageView = view.findViewById(R.id.imageViewItemImage);
        }
    }
}
