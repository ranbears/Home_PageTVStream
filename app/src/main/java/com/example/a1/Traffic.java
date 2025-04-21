package com.example.a1;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Traffic extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrafficAdapter trafficAdapter;
    private List<TrafficData> trafficList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_cctv);

        recyclerView = findViewById(R.id.menu_fac);

        trafficList = new ArrayList<>();
        trafficList.add(new TrafficData("Intersection A", R.drawable.se, "Heavy traffic reported."));
        trafficList.add(new TrafficData("Highway B", R.drawable.ho, "Traffic flowing smoothly."));
        trafficList.add(new TrafficData("Downtown C", R.drawable.spa, "Moderate congestion."));
        trafficList.add(new TrafficData("Bridge D", R.drawable.kopii, "Accident reported, expect delays."));
        trafficList.add(new TrafficData("Tunnel E", R.drawable.se, "Clear traffic."));

        trafficAdapter = new TrafficAdapter(trafficList, trafficData ->
                Toast.makeText(Traffic.this, "Clicked: " + trafficData.getName(), Toast.LENGTH_SHORT).show()
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(trafficAdapter);
    }

    public static class TrafficData {
        private final String name;
        private final int imageResId;
        private final String message;

        public TrafficData(String name, int imageResId, String message) {
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
