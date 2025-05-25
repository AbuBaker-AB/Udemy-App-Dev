package com.example.thehungrydeveloper;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView starterListView = findViewById(R.id.listView_starters);

        Dish dish1 = new Dish(
                "Spring Rolls",
                "Crispy rolls filled with vegetables and served with sweet chili sauce.",
                5
        );

        String[] dishes = {
            "Spring Rolls",
            "Garlic Bread",
            "Brochette",
            "Stuffed Mushrooms",
            "Caresse Salad",
            "Chicken Wings",
            "Nachos",
            "Hummus and Pita",
            "Cheese Platter",
            "Vegetable Samosas",
            "Deviled Eggs",
            "Onion Rings",
            "Mini Quiches",
            "Spinach and Artichoke Dip",
            "Meatballs",
            "Crispy Calamari",
            "Potato Skins",
            "Antipasto Skewers",
            "Buffalo Cauliflower Bites",
            "Brussels Sprouts with Bacon",
        };

        ArrayAdapter<String> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);

        starterListView.setAdapter(dishesAdapter);
    }
}