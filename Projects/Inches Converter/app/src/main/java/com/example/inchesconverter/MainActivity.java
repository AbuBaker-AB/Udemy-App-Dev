package com.example.inchesconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpButtonCLickConverter();
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private void setUpButtonCLickConverter() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                } else {
                    double result = calculateHeight(inchesString);
                    displayResult(result);
                }
            }
        });
    }


    private double calculateHeight(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void displayResult(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);
        resultTextView.setText(resultString + " meters");
    }
}