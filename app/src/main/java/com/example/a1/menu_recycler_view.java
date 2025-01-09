package com.example.a1;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class menu_recycler_view extends RecyclerView.Adapter<menu_recycler_view.MenuViewHolder> {

    private List<String> menuItems;
    private OnMenuItemClickListener onMenuItemClickListener;

    public menu_recycler_view(List<String> menuItems, OnMenuItemClickListener onMenuItemClickListener) {
        this.menuItems = menuItems;
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        String menuItem = menuItems.get(position);
        holder.menuItemTextView.setText(menuItem);
        holder.menuItemTextView.setFocusable(true);
        holder.menuItemTextView.setFocusableInTouchMode(true);

        holder.menuItemTextView.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                updateTextViewStyle((TextView) v, true);
            } else {
                updateTextViewStyle((TextView) v, false);
            }
        });
        holder.menuItemTextView.setOnClickListener(v -> {
            onMenuItemClickListener.onMenuItemClick(menuItem);
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public interface OnMenuItemClickListener {
        void onMenuItemClick(String menuItem);
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView menuItemTextView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            menuItemTextView = itemView.findViewById(R.id.menu_name);
        }
    }

    private void updateTextViewStyle(TextView textView, boolean isFocused) {
        if (isFocused) {
            textView.setTextColor(textView.getContext().getResources().getColor(android.R.color.holo_blue_dark));
            textView.setTypeface(null, android.graphics.Typeface.BOLD);
        } else {
            textView.setTextColor(textView.getContext().getResources().getColor(android.R.color.white));
            textView.setTypeface(null, Typeface.NORMAL);
        }
    }
}
