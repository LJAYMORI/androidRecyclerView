package com.ljaymori.samplerecyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView imageView;
    TextView tvTitle;
    TextView tvDescription;

    public ItemViewHolder(View view) {
        super(view);
        cardView = (CardView) view.findViewById(R.id.cardView);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        tvTitle = (TextView) view.findViewById(R.id.text_title);
        tvDescription = (TextView) view.findViewById(R.id.text_description);
    }

    public void setItemView(ItemData id) {
        imageView.setImageResource(id.getImageId());
        tvTitle.setText(id.getTitle());
        tvDescription.setText(id.getDescription());
    }
}
