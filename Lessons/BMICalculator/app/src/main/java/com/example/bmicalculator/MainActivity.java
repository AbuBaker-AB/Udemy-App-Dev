package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //class variables; also known as fields
    private TextView resultText;
    private Button buttonCalculate;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextWeight;
    private EditText editTextFeet;
    private EditText editTextInches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews(){
        // Find the views by their IDs
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextWeight = findViewById(R.id.edit_text_weight);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        buttonCalculate = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               double bmiResult = calculateBMI();

                String ageText = editTextAge.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18){
                    displayResult(bmiResult);
                }else {
                    displayGuidance(bmiResult);
                }

               displayResult(bmiResult);
            }
        });
    }

    private double calculateBMI() {
//       String ageText = editTextAge.getText().toString();
       String weightText = editTextWeight.getText().toString();
       String feetText = editTextFeet.getText().toString();
       String inchesText = editTextInches.getText().toString();

       //Convert the strings to numbers
//        int age = Integer.parseInt(ageText);
        int weight = Integer.parseInt(weightText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);

        // Calculating the height in inches
        int totalInches = (feet * 12) + inches;

        // Converting the height in inches to meters
        double heightInMeters = totalInches * 0.0254;

        // Calculating the BMI

//        // Must convert the result to a string
//        String bmiTextResult = String.valueOf(bmi);
        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5){
            // display underweight
            fullResultString = bmiTextResult + " - You are underweight";
        }else if(bmi > 25){
            // display overweight
            fullResultString = bmiTextResult + " - You are overweight";
        }else {
            //display healthy
            fullResultString = bmiTextResult + " - You are healthy";
        }

        // Displaying the result
        resultText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;

        if(radioButtonMale.isChecked()){
            // display male guidance
            fullResultString = bmiTextResult + " - As you are under 18, consult with your doctor for the best advice for boys";
        } else if (radioButtonFemale.isChecked()) {
            //display female guidance
            fullResultString = bmiTextResult + " - As you are under 18, consult with your doctor for the best advice for girls";
        }else {
            //display general guidance
            fullResultString = bmiTextResult + " - As you are under 18, consult with your doctor for the best advice";
        }

        resultText.setText(fullResultString);

    }
    
}