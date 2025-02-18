package com.example.nameformapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameInput, lastNameInput;
    private TextView resultText;
    static final String FIRST_NAME_KEY = "FIRST_NAME";
    static final String LAST_NAME_KEY = "LAST_NAME";
    static final String RESULT_KEY = "RESULT";
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        resultText = findViewById(R.id.resultText);
    }

    public void onSendClick(View view) {
        String firstName = firstNameInput.getText().toString();
        String lastName = lastNameInput.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(FIRST_NAME_KEY, firstName);
        intent.putExtra(LAST_NAME_KEY, lastName);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultMessage = data.getStringExtra(RESULT_KEY);
            resultText.setText(resultMessage);
        }
    }
}