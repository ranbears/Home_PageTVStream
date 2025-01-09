package com.example.a1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class guest extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_main);

        recyclerView = findViewById(R.id.recycler_view);

        itemList = new ArrayList<>();
        itemList.add(new Item("Home", R.drawable.mee));
        itemList.add(new Item("Channel", R.drawable.t));
        itemList.add(new Item("Massage", R.drawable.mail));
        itemList.add(new Item("Offers", R.drawable.persen));
        itemList.add(new Item("Netflix", R.drawable.flix));
        itemList.add(new Item("YouTube", R.drawable.tub));
        itemList.add(new Item("YouTube\nKids", R.drawable.kids));
        itemList.add(new Item("Vidio", R.drawable.vidio));
        itemList.add(new Item("Prime\nVideo", R.drawable.pr));
        itemList.add(new Item("Spotify", R.drawable.sp));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter(itemList, recyclerView, new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item, int position) {
                if ("Home".equalsIgnoreCase(item.getTitle())) {
                    Intent intent = new Intent(guest.this, profile.class);
                    startActivity(intent);
                }
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.requestFocus();
    }

    // Model class for items
    public static class Item {
        private final String title;
        private final int iconResId;

        public Item(String title, int iconResId) {
            this.title = title;
            this.iconResId = iconResId;
        }

        public String getTitle() {
            return title;
        }

        public int getIconResId() {
            return iconResId;
        }
    }
}
