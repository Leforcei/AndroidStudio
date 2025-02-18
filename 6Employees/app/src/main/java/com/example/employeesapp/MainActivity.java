package com.example.employeesapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements EmployeeListFragment.OnEmployeeSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onEmployeeSelected(Employee employee) {
        // Проверяем, есть ли второй фрагмент (альбомная ориентация)
        EmployeeFragment fragment = (EmployeeFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if (fragment != null && getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragment.setEmployee(employee);
        } else {
            // Если портретная ориентация – открываем новую Activity
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("employee_name", employee.getName());
            intent.putExtra("employee_position", employee.getPosition());
            intent.putExtra("employee_photo", employee.getPhotoResId());
            startActivity(intent);
        }
    }
}