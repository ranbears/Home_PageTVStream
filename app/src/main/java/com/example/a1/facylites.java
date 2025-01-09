package com.example.a1;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class facylites extends AppCompatActivity {

    private LinearLayout facilityListContainer;
    private List<Facility> facilityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facilytes);

        facilityListContainer = findViewById(R.id.menu_fac);

        facilityList = new ArrayList<>();
        facilityList.add(new Facility("Security", R.drawable.pet, "Security service available 24 hours a day."));
        facilityList.add(new Facility("Lemon Rooftop", R.drawable.ho, "Experience a beautiful view from the Lemon Rooftop."));
        facilityList.add(new Facility("Spa", R.drawable.spa, "Enjoy a luxurious spa experience."));
        facilityList.add(new Facility("Meeting Room", R.drawable.pet, "A perfect place for business meetings."));
        facilityList.add(new Facility("Fitness Corner", R.drawable.spa, "Stay fit at our fitness corner."));

        for (Facility facility : facilityList) {
            addFacilityItem(facility);
        }
    }

    private void addFacilityItem(Facility facility) {

        View itemView = LayoutInflater.from(this).inflate(R.layout.facilityitem, null);

        ImageView imageView = itemView.findViewById(R.id.facility_image);
        TextView nameTextView = itemView.findViewById(R.id.facility_name);
        TextView messageTextView = itemView.findViewById(R.id.facility_message);

        imageView.setImageResource(facility.getImageResId());
        nameTextView.setText(facility.getName());
        messageTextView.setText(facility.getMessage());

        facilityListContainer.addView(itemView);

        itemView.setOnClickListener(v ->
                Toast.makeText(facylites.this, "Clicked: " + facility.getName(), Toast.LENGTH_SHORT).show());
    }

    public static class Facility {
        private final String name;
        private final int imageResId;
        private final String message;

        public Facility(String name, int imageResId, String message) {
            this.name = name;
            this.imageResId = imageResId;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getMessage() {
            return message;
        }
    }
}
