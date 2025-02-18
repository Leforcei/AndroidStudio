package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.resultText);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        input += button.getText().toString();
        resultText.setText(input);
    }

    public void onOperatorClick(View view) {
        if (!input.isEmpty()) {
            firstNumber = Double.parseDouble(input);
            input = "";
            Button button = (Button) view;
            operator = button.getText().toString();
        }
    }

    public void onEqualsClick(View view) {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = secondNumber != 0 ? firstNumber / secondNumber : 0;
                    break;
            }

            resultText.setText(String.valueOf(result));
            input = "";
            operator = "";
        }
    }

    public void onClearClick(View view) {
        input = "";
        operator = "";
        firstNumber = 0;
        resultText.setText("0");
    }
}