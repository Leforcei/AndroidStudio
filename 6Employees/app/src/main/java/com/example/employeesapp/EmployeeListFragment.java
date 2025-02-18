package com.example.employeesapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmployeeListFragment extends Fragment {
    private OnEmployeeSelectedListener callback;

    public interface OnEmployeeSelectedListener {
        void onEmployeeSelected(Employee employee);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnEmployeeSelectedListener) {
            callback = (OnEmployeeSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnEmployeeSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Employee[] employees = {
                new Employee("Иван Иванов", "Разработчик", R.drawable.ic_person),
                new Employee("Анна Смирнова", "Менеджер", R.drawable.ic_person),
                new Employee("Петр Петров", "Тестировщик", R.drawable.ic_person)
        };

        Button emp1 = view.findViewById(R.id.emp1);
        Button emp2 = view.findViewById(R.id.emp2);
        Button emp3 = view.findViewById(R.id.emp3);

        emp1.setOnClickListener(v -> callback.onEmployeeSelected(employees[0]));
        emp2.setOnClickListener(v -> callback.onEmployeeSelected(employees[1]));
        emp3.setOnClickListener(v -> callback.onEmployeeSelected(employees[2]));
    }
}