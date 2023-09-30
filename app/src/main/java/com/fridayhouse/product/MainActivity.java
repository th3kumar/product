package com.fridayhouse.product;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText editTextName, editTextAge, editTextNum1, editTextNum2;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements by finding their respective views
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener for the "Calculate" button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateProduct();
            }
        });
    }

    // Method to calculate and display the product
    // Method to calculate and display the product
    private void calculateProduct() {
        // Retrieve user inputs from EditText fields
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();
        String num1Str = editTextNum1.getText().toString();
        String num2Str = editTextNum2.getText().toString();

        // Validate input for num1
        if (num1Str.isEmpty()) {
            editTextNum1.setError("Please enter a number");
            return; // Exit the method if num1 is empty
        }

        // Validate input for num2
        if (num2Str.isEmpty()) {
            editTextNum2.setError("Please enter a number");
            return; // Exit the method if num2 is empty
        }

        try {
            // Parse the input strings to integers
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Calculate the product of the two numbers
            int product = num1 * num2;

            // Create a result message
            String resultText = "Name: " + name + "\nAge: " + age + "\nProduct: " + product;

            // Display the result in the TextView
            textViewResult.setText(resultText);
        } catch (NumberFormatException e) {
            // Handle the case where non-integer input is provided
            editTextAge.setError("Invalid input");
            editTextNum1.setError("Invalid input");
            editTextNum2.setError("Invalid input");
        }
    }

}
