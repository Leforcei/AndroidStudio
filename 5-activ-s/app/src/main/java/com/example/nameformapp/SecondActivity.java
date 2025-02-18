package com.example.nameformapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private String firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameText = findViewById(R.id.nameText);
        Intent intent = getIntent();
        firstName = intent.getStringExtra(MainActivity.FIRST_NAME_KEY);
        lastName = intent.getStringExtra(MainActivity.LAST_NAME_KEY);

        nameText.setText("Имя: " + firstName + "\nФамилия: " + lastName);
    }

    public void onMessageClick(View view) {
        Button button = (Button) view;
        String message = button.getText().toString()
                .replace("<Имя>", firstName)
                .replace("<Фамилия>", lastName);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.RESULT_KEY, message);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}