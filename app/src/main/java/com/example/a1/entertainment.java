package com.example.a1;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class entertainment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private entertaimentAdapter entertaimentAdapter;
    private List<Entertainment> entertainmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertaiment);

        recyclerView = findViewById(R.id.menu_fac);

        entertainmentList = new ArrayList<>();
        entertainmentList.add(new Entertainment("Cinema", R.drawable.ho, "Watch the latest movies in our state-of-the-art cinema."));
        entertainmentList.add(new Entertainment("Arcade Zone", R.drawable.spa, "Enjoy classic and modern arcade games."));
        entertainmentList.add(new Entertainment("Karaoke Lounge", R.drawable.ho, "Sing your heart out in our private karaoke rooms."));
        entertainmentList.add(new Entertainment("Bowling Alley", R.drawable.se, "Challenge your friends at our bowling alley."));
        entertainmentList.add(new Entertainment("Live Music", R.drawable.spa, "Experience live performances by talented artists."));

        entertaimentAdapter = new entertaimentAdapter(entertainmentList, entertainment ->
                Toast.makeText(entertainment.this, "Clicked: " + entertainment.getName(), Toast.LENGTH_SHORT).show()
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(entertaimentAdapter);
    }

    public static class Entertainment {
        private final String name;
        private final int imageResId;
        private final String message;

        public Entertainment(String name, int imageResId, String message) {
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
