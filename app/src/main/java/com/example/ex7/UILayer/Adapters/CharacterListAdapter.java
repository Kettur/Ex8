package com.example.ex7.UILayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.R;
import com.example.ex7.SelectedItem;

import java.util.List;

public class CharacterListAdapter extends
        RecyclerView.Adapter<CharacterListAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Character> items;
    private SelectedItem selectedItemListener;

    public CharacterListAdapter(Context context, List<Character> items, SelectedItem selectedItemListener) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.selectedItemListener = selectedItemListener;
    }

    @Override
    public CharacterListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void
    onBindViewHolder(CharacterListAdapter.ViewHolder holder, int position) {
        Character item = items.get(position);

        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(R.drawable.baseline_man);
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
