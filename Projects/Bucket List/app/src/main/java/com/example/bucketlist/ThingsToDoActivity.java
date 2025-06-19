package com.example.bucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);
        setupList();
    }

    private void setupList() {

        BucketListEntry[] thingsDo = {
                new BucketListEntry("Climb Mt kilimanjaro", "Do it the difficult way!", R.drawable.kilimanjaro, 5),
                new BucketListEntry("Visit the Grand Canyon", "A natural wonder of the world", R.drawable.northern_lights, 4.5f),
                new BucketListEntry("Skydiving in Dubai", "Experience the thrill of freefall", R.drawable.skydive, 4.8f),
                new BucketListEntry("Explore the Amazon Rainforest", "Adventure in the heart of nature", R.drawable.amazon, 4.7f),
                new BucketListEntry("Scuba Diving in the Great Barrier Reef", "Discover underwater wonders", R.drawable.japan, 4.9f),
                new BucketListEntry("Hike the Inca Trail to Machu Picchu", "A journey through history", R.drawable.road_trip, 4.6f),
                new BucketListEntry("Safari in Serengeti", "Witness the great migration", R.drawable.iceland, 4.8f),
                new BucketListEntry("Visit the Pyramids of Giza", "Explore ancient wonders", R.drawable.scubadive, 4.5f),
                new BucketListEntry("Hot Air Balloon Ride in Cappadocia", "Soar over unique landscapes", R.drawable.vietnam, 4.7f),
                new BucketListEntry("Explore the Northern Lights in Iceland", "A magical natural phenomenon", R.drawable.kerala, 4.9f)
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view_things_to_do);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(thingsDo);
        recyclerView.setAdapter(adapter);
    }
}