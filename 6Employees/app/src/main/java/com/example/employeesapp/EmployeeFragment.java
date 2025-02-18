package com.example.employeesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmployeeFragment extends Fragment {
    private EditText nameEdit, positionEdit;
    private ImageView photoView;
    private Employee currentEmployee;

    public EmployeeFragment() {
        super(R.layout.fragment_employee);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameEdit = view.findViewById(R.id.nameEdit);
        positionEdit = view.findViewById(R.id.positionEdit);
        photoView = view.findViewById(R.id.photoView);
        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            if (currentEmployee != null) {
                currentEmployee = new Employee(nameEdit.getText().toString(), positionEdit.getText().toString(), currentEmployee.getPhotoResId());
            }
        });
    }

    public void setEmployee(Employee employee) {
        this.currentEmployee = employee;
        if (nameEdit != null && positionEdit != null && photoView != null) {
            nameEdit.setText(employee.getName());
            positionEdit.setText(employee.getPosition());
            photoView.setImageResource(employee.getPhotoResId());
        }
    }
}