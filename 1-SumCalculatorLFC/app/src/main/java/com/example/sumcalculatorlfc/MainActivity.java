package com.example.sumcalculatorlfc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Button calculateBtn = findViewById(R.id.calculateBtn);
        TextView result = findViewById(R.id.result);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNum1 = num1.getText().toString();
                String strNum2 = num2.getText().toString();

                if (strNum1.isEmpty() || strNum2.isEmpty()) {
                    result.setText("Ошибка: введите оба числа!");
                    return;
                }

                try {
                    double number1 = Double.parseDouble(strNum1);
                    double number2 = Double.parseDouble(strNum2);
                    double sum = number1 + number2;

                    result.setText(number1 + " + " + number2 + " = " + sum);
                } catch (NumberFormatException e) {
                    result.setText("Ошибка: введите корректные числа!");
                }
            }
        });
    }
}