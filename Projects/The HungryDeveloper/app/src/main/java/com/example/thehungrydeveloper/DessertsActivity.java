package com.example.thehungrydeveloper;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DessertsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        ListView dessertsListView = findViewById(R.id.listView_desserts);

        Dish[] desserts = {
                new Dish("Chocolate Cake", "Rich and moist chocolate cake with a creamy frosting.", 300),
                new Dish("Cheesecake", "Creamy cheesecake with a graham cracker crust.", 350),
                new Dish("Apple Pie", "Classic apple pie with a flaky crust and cinnamon filling.", 280),
                new Dish("Tiramisu", "Italian dessert made with coffee-soaked ladyfingers and mascarpone cheese.", 400),
                new Dish("Ice Cream Sundae", "Vanilla ice cream topped with chocolate sauce, nuts, and a cherry.", 250),
                new Dish("Panna Cotta", "Creamy Italian dessert topped with berry compote.", 320),
                new Dish("Brownie", "Fudgy brownie served warm with a scoop of vanilla ice cream.", 300),
                new Dish("Fruit Tart", "Fresh fruit tart with a creamy custard filling.", 350),
                new Dish("Lemon Meringue Pie", "Tangy lemon filling topped with fluffy meringue.", 280),
                new Dish("Banoffee Pie", "A delicious pie made with bananas, toffee, and whipped cream.", 320),
                new Dish("Crème Brûlée", "Rich custard topped with a layer of caramelized sugar.", 400),
                new Dish("Chocolate Mousse", "Light and airy chocolate mousse topped with whipped cream.", 350),
                new Dish("Carrot Cake", "Moist carrot cake with cream cheese frosting.", 300),
                new Dish("Pistachio Baklava", "Layers of phyllo pastry filled with pistachios and honey syrup.", 320),
                new Dish("Rice Pudding", "Creamy rice pudding flavored with cinnamon and vanilla.", 250)
        };

        ArrayAdapter<Dish> dessertsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, desserts);
        dessertsListView.setAdapter(dessertsAdapter);

    }
}