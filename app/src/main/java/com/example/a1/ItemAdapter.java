package com.example.a1;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final List<guest.Item> itemList;
    private final OnItemClickListener listener;
    private final RecyclerView recyclerView;
    private int selectedPosition = RecyclerView.NO_POSITION;
    private RelativeLayout parentLayout;

    public interface OnItemClickListener {
        void onItemClick(guest.Item item, int position);
    }

    public ItemAdapter(List<guest.Item> itemList, RecyclerView recyclerView, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        ImageView iconImageView = view.findViewById(R.id.icon_image);
        TextView titleTextView = view.findViewById(R.id.title_text);
        parentLayout = view.findViewById(R.id.parentLayout);
        return new ItemViewHolder(view, iconImageView, titleTextView, parentLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        guest.Item currentItem = itemList.get(position);

        holder.titleTextView.setText(currentItem.getTitle());
        holder.iconImageView.setImageResource(currentItem.getIconResId());

        holder.parentLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    holder.iconImageView.setColorFilter(Color.parseColor("#7A7A80"), PorterDuff.Mode.SRC_ATOP);
                    holder.titleTextView.setTextColor(Color.parseColor("#7A7A80"));
                    holder.iconImageView.setScaleX(1.3f);
                    holder.iconImageView.setScaleY(1.3f);
                }else {
                    holder.iconImageView.setColorFilter(Color.WHITE);
                    holder.titleTextView.setTextColor(Color.WHITE);
                    holder.iconImageView.setScaleX(1f);
                    holder.iconImageView.setScaleY(1f);
                }
            }
        });

        holder.itemView.setOnClickListener(v -> {
            int previousPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();

            notifyItemChanged(previousPosition);
            notifyItemChanged(selectedPosition);

            if (listener != null) {
                listener.onItemClick(currentItem, selectedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void scaleItem(int position, float scale) {
        RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(position);
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            itemHolder.itemView.setScaleX(scale);
            itemHolder.itemView.setScaleY(scale);
        }
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
        RelativeLayout parentLayout;
        public ItemViewHolder(View itemView, ImageView iconImageView, TextView titleTextView, RelativeLayout parentLayout) {
            super(itemView);
            this.iconImageView = iconImageView;
            this.titleTextView = titleTextView;
            this.parentLayout = parentLayout;
        }
    }
}
