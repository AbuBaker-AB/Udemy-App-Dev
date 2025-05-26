package com.example.thehungrydeveloper;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);

        ListView mainCoursesList = findViewById(R.id.listView_main_courses);

        Dish[] mainCourses = {
            new Dish("Grilled Chicken", "Juicy grilled chicken served with seasonal vegetables.", 500),
            new Dish("Vegetable Stir Fry", "A mix of fresh vegetables stir-fried in a savory sauce.", 400),
            new Dish("Beef Tacos", "Spicy beef tacos topped with fresh salsa and avocado.", 600),
            new Dish("Pasta Primavera", "Pasta tossed with fresh vegetables and a light garlic sauce.", 450),
            new Dish("Fish and Chips", "Crispy battered fish served with golden fries.", 550),
            new Dish("Lamb Curry", "Tender lamb cooked in a rich and aromatic curry sauce.", 700),
            new Dish("Quinoa Salad", "A healthy salad with quinoa, mixed greens, and a lemon vinaigrette.", 350),
            new Dish("Stuffed Bell Peppers", "Bell peppers stuffed with rice, beans, and cheese.", 480),
            new Dish("BBQ Ribs", "Slow-cooked BBQ ribs served with coleslaw and cornbread.", 800),
            new Dish("Mushroom Risotto", "Creamy risotto with sautéed mushrooms and parmesan cheese.", 520),
            new Dish("Vegetable Lasagna", "Layers of pasta, vegetables, and cheese baked to perfection.", 550),
            new Dish("Chicken Caesar Salad", "Grilled chicken on a bed of romaine lettuce with Caesar dressing.", 480),
            new Dish("Shrimp Scampi", "Succulent shrimp sautéed in garlic butter and served over pasta.", 650),
            new Dish("Eggplant Parmesan", "Breaded eggplant slices baked with marinara sauce and cheese.", 500)
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainCourses);
        mainCoursesList.setAdapter(dishesAdapter);

    }
}