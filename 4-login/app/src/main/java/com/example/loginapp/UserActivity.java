package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String info = intent.getStringExtra("info");

        TextView userInfo = findViewById(R.id.userInfo);
        userInfo.setText("Добро пожаловать, пользователь с ником: " + username + "!\n\n" + info);
    }

    public void onBackClick(View view) {
        finish();
    }
}