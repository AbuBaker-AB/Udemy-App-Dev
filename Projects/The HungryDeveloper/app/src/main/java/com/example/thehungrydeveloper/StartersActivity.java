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

        Dish[] dishes = {
                new Dish(
                        "Spring Rolls",
                        "Crispy rolls filled with vegetables and served with sweet chili sauce.",
                        5
                ),
                new Dish(
                        "Garlic Bread",
                        "Toasted bread topped with garlic butter and herbs.",
                        4
                ),
                new Dish(
                        "Brochette",
                        "Grilled skewers of marinated meat and vegetables.",
                        7
                ),
                new Dish(
                        "Stuffed Mushrooms",
                        "Mushrooms filled with a savory mixture of cheese and herbs.",
                        6
                ),
                new Dish(
                        "Caresse Salad",
                        "A fresh salad with mixed greens, cherry tomatoes, and a light vinaigrette.",
                        8
                ),
                new Dish(
                        "Chicken Wings",
                        "Spicy chicken wings served with a side of blue cheese dressing.",
                        9
                ),
                new Dish(
                        "Nachos",
                        "Crispy tortilla chips topped with melted cheese, jalapeños, and salsa.",
                        10
                ),
                new Dish(
                        "Hummus and Pita",
                        "Creamy hummus served with warm pita bread.",
                        5
                ),
                new Dish(
                        "Cheese Platter",
                        "A selection of fine cheeses served with crackers and fruit.",
                        12
                ),
                new Dish(
                        "Vegetable Samosas",
                        "Crispy pastry filled with spiced vegetables.",
                        6
                ),
                new Dish(
                        "Deviled Eggs",
                        "Hard-boiled eggs filled with a creamy yolk mixture.",
                        4
                ),
                new Dish(
                        "Onion Rings",
                        "Crispy battered onion rings served with a tangy dipping sauce.",
                        5
                ),
                new Dish(
                        "Mini Quiches",
                        "Small quiches filled with cheese, vegetables, and meats.",
                        8
                ),
                new Dish(
                        "Spinach and Artichoke Dip",
                        "A creamy dip made with spinach and artichokes, served with tortilla chips.",
                        7
                ),
                new Dish(
                        "Meatballs",
                        "Juicy meatballs served with marinara sauce.",
                        9
                )
        };



        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);

        starterListView.setAdapter(dishesAdapter);
    }
}