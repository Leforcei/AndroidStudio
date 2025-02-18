package com.example.employeesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView photoView = findViewById(R.id.photoView);
        EditText nameEdit = findViewById(R.id.nameEdit);
        EditText positionEdit = findViewById(R.id.positionEdit);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("employee_name");
            String position = intent.getStringExtra("employee_position");
            int photoResId = intent.getIntExtra("employee_photo", R.drawable.ic_person);

            nameEdit.setText(name);
            positionEdit.setText(position);
            photoView.setImageResource(photoResId);
        }
    }
}