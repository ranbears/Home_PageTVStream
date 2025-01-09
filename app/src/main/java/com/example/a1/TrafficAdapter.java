package com.example.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TrafficAdapter extends RecyclerView.Adapter<TrafficAdapter.TrafficViewHolder> {

    private final List<Traffic.TrafficData> trafficList;
    private final OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Traffic.TrafficData trafficData);
    }

    public TrafficAdapter(List<Traffic.TrafficData> trafficList, OnItemClickListener onItemClickListener) {
        this.trafficList = trafficList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TrafficViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.traffic_cctv_item, parent, false);
        return new TrafficViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrafficViewHolder holder, int position) {
        Traffic.TrafficData trafficData = trafficList.get(position);
        holder.name.setText(trafficData.getName());
        holder.image.setImageResource(trafficData.getImageResId());
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(trafficData));
    }

    @Override
    public int getItemCount() {
        return trafficList.size();
    }

    public static class TrafficViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public TrafficViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.facility_name);
            image = itemView.findViewById(R.id.facility_image);
        }
    }
}
