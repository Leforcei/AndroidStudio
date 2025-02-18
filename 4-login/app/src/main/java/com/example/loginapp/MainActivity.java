package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText loginInput, passwordInput;

    private final String[][] users = {
            {"admin", "1234", "Админ, Полный доступ"},
            {"user", "pass", "Обычный, ограниченный доступ"},
            {"guest", "guest", "Гость, только просмотр данных"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginInput = findViewById(R.id.loginInput);
        passwordInput = findViewById(R.id.passwordInput);
    }

    public void onLoginClick(View view) {
        String login = loginInput.getText().toString();
        String password = passwordInput.getText().toString();

        for (String[] user : users) {
            if (user[0].equals(login) && user[1].equals(password)) {
                Intent intent = new Intent(this, UserActivity.class);
                intent.putExtra("username", login);
                intent.putExtra("info", user[2]);
                startActivity(intent);
                return;
            }
        }

        Toast.makeText(this, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
    }
}