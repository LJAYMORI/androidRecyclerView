package com.ljaymori.samplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private ArrayList<ItemData> items = new ArrayList<ItemData>();
    private Context mContext;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyRecyclerViewAdapter(Context context, ArrayList<ItemData> myDataset) {
        mContext = context;
        items = myDataset;
    }

    public void add(ItemData id, int position) {
        items.add(position, id);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_cardview, parent, false);
        // set the view's size, margins, paddings and layout parameters
        // ...

        ItemViewHolder viewHolder = new ItemViewHolder(v);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.setItemView(items.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}
