package com.example.a1;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HotelPolicies extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotelPoliciesAdapter hotelPoliciesAdapter;
    private List<HotelPolicy> hotelPolicyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_policies);

        recyclerView = findViewById(R.id.menu_fac);

        hotelPolicyList = new ArrayList<>();
        hotelPolicyList.add(new HotelPolicy("Check-in Time", R.drawable.ho, "Check-in is available from 2 PM."));
        hotelPolicyList.add(new HotelPolicy("Check-out Time", R.drawable.spa, "Check-out is required by 12 PM."));
        hotelPolicyList.add(new HotelPolicy("Pets", R.drawable.se, "Pets are not allowed in the property."));
        hotelPolicyList.add(new HotelPolicy("Smoking", R.drawable.kopii, "Smoking is prohibited in all indoor areas."));
        hotelPolicyList.add(new HotelPolicy("Payment", R.drawable.pet, "Accepted payment methods: Credit Card, Cash."));

        hotelPoliciesAdapter = new HotelPoliciesAdapter(hotelPolicyList, policy ->
                Toast.makeText(HotelPolicies.this, "Policy: " + policy.getTitle(), Toast.LENGTH_SHORT).show()
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(hotelPoliciesAdapter);
    }

    public static class HotelPolicy {
        private final String title;
        private final int imageResId;
        private final String description;

        public HotelPolicy(String title, int imageResId, String description) {
            this.title = title;
            this.imageResId = imageResId;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getDescription() {
            return description;
        }
    }
}
