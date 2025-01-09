package com.example.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class facilityAdapter extends RecyclerView.Adapter<facilityAdapter.FacilityViewHolder> {

    private final List<facylites.Facility> facilityList;
    private final OnFacilityItemClickListener listener;

    public facilityAdapter(List<facylites.Facility> facilityList, OnFacilityItemClickListener listener) {
        this.facilityList = facilityList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FacilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.facilityitem, parent, false);
        return new FacilityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilityViewHolder holder, int position) {
        facylites.Facility facility = facilityList.get(position);
        holder.facilityName.setText(facility.getName());
        holder.facilityImage.setImageResource(facility.getImageResId());
        holder.facilityMessage.setText(facility.getMessage());

        holder.itemView.setOnClickListener(v -> listener.onFacilityItemClick(facility));
    }

    @Override
    public int getItemCount() {
        return facilityList.size();
    }

    public interface OnFacilityItemClickListener {
        void onFacilityItemClick(facylites.Facility facility);
    }

    static class FacilityViewHolder extends RecyclerView.ViewHolder {
        TextView facilityName, facilityMessage;
        ImageView facilityImage;

        public FacilityViewHolder(View itemView) {
            super(itemView);
            facilityName = itemView.findViewById(R.id.facility_name);
            facilityMessage = itemView.findViewById(R.id.facility_message);
            facilityImage = itemView.findViewById(R.id.facility_image);
        }
    }
}
