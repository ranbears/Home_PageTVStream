package com.example.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HotelPoliciesAdapter extends RecyclerView.Adapter<HotelPoliciesAdapter.PolicyViewHolder> {

    private final List<HotelPolicies.HotelPolicy> hotelPolicyList;
    private final OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(HotelPolicies.HotelPolicy policy);
    }

    public HotelPoliciesAdapter(List<HotelPolicies.HotelPolicy> hotelPolicyList, OnItemClickListener onItemClickListener) {
        this.hotelPolicyList = hotelPolicyList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PolicyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new PolicyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PolicyViewHolder holder, int position) {
        HotelPolicies.HotelPolicy policy = hotelPolicyList.get(position);
        holder.title.setText(policy.getTitle());
        holder.description.setText(policy.getDescription());
        holder.image.setImageResource(policy.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            onItemClickListener.onItemClick(policy);
            Toast.makeText(v.getContext(), "Policy: " + policy.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return hotelPolicyList.size();
    }

    public static class PolicyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView image;
        public PolicyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.facility_name); // Ensure these IDs are correct
            description = itemView.findViewById(R.id.facility_message); // Ensure these IDs are correct
            image = itemView.findViewById(R.id.facility_image); // Ensure these IDs are correct
        }
    }
}
