package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);

        RecyclerView menuRecyclerView = findViewById(R.id.menu_recycler_view);

        List<String> menuItems = Arrays.asList(
                "Home",
                "Facilities And Amenities",
                "Entertainment Attraction",
                "Traffic CCTV",
                "Hotel Policies"
        );

        menu_recycler_view adapter = new menu_recycler_view(menuItems, this::onMenuItemClick);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuRecyclerView.setAdapter(adapter);
    }

    private void onMenuItemClick(String menuItem) {
        Intent intent = null;

        switch (menuItem) {
            case "Home":
                intent = new Intent(this, guest.class);
                break;

            case "Facilities And Amenities":
                intent = new Intent(this, facylites.class);
                break;

            case "Entertainment Attraction":
                intent = new Intent(this, entertainment.class);
                break;

            case "Traffic CCTV":
                intent = new Intent(this, Traffic.class);
                break;

            case "Hotel Policies":
                intent = new Intent(this, HotelPolicies.class);
                break;

            default:

                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
