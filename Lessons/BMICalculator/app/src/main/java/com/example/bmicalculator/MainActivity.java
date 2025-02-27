package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views by their IDs
        RadioButton radioButtonMale = findViewById(R.id.radio_button_male);
        RadioButton radioButtonFemale = findViewById(R.id.radio_button_female);

        EditText editTextAge = findViewById(R.id.edit_text_age);
        EditText editTextWeight = findViewById(R.id.edit_text_weight);
        EditText editTextHeight = findViewById(R.id.edit_text_feet);
        EditText editTextHeightInches = findViewById(R.id.edit_text_inches);

        Button buttonCalculate = findViewById(R.id.button_calculate);

        TextView resultText = findViewById(R.id.text_view_result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Yo, it works!", Toast.LENGTH_LONG).show();
            }
        });

    }
}