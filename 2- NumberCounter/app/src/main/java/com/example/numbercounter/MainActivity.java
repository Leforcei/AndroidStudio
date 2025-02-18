package com.example.numbercounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = findViewById(R.id.numberText);
        Button btnPlus1 = findViewById(R.id.btnPlus1);
        Button btnMinus1 = findViewById(R.id.btnMinus1);
        Button btnPlus2 = findViewById(R.id.btnPlus2);
        Button btnMinus2 = findViewById(R.id.btnMinus2);

        btnPlus1.setOnClickListener(v -> updateCounter(1));
        btnMinus1.setOnClickListener(v -> updateCounter(-1));
        btnPlus2.setOnClickListener(v -> updateCounter(2));
        btnMinus2.setOnClickListener(v -> updateCounter(-2));
    }

    private void updateCounter(int value) {
        counter += value;
        numberText.setText(String.valueOf(counter));
    }
}