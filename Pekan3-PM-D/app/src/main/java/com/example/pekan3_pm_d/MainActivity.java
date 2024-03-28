package com.example.pekan3_pm_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_students = findViewById(R.id.rv_students);

        rv_students.setLayoutManager(new GridLayoutManager(this, 2));
//        rv_students.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rv_students.setHasFixedSize(true);


        StudentAdapter studentAdapter = new StudentAdapter(DataSource.students);

        rv_students.setAdapter(studentAdapter);

    }
}