package com.example.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class entertaimentAdapter extends RecyclerView.Adapter<entertaimentAdapter.EntertainmentViewHolder> {

    private final List<entertainment.Entertainment> entertainmentList;
    private final OnItemClickListener onItemClickListener;

    // Interface untuk menangani klik item
    public interface OnItemClickListener {
        void onItemClick(entertainment.Entertainment entertainment);
    }

    // Constructor adapter
    public entertaimentAdapter(List<entertainment.Entertainment> entertainmentList, OnItemClickListener onItemClickListener) {
        this.entertainmentList = entertainmentList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public EntertainmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entertainment_item, parent, false);
        return new EntertainmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntertainmentViewHolder holder, int position) {
        entertainment.Entertainment entertainment = entertainmentList.get(position);
        holder.name.setText(entertainment.getName());
        holder.image.setImageResource(entertainment.getImageResId());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(entertainment));
    }

    @Override
    public int getItemCount() {
        return entertainmentList.size();
    }

    public static class EntertainmentViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public EntertainmentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.facility_name); // Pastikan ID ini cocok dengan XML
            image = itemView.findViewById(R.id.facility_image); // Pastikan ID ini cocok dengan XML
        }
    }
}
