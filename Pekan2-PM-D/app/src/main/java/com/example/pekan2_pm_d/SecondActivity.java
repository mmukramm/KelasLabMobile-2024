package com.example.pekan2_pm_d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static String EXTRA_STUDENT = "extra_student";
    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.button);
        tv = findViewById(R.id.tv);

        Mahasiwa mhs = getIntent().getParcelableExtra(EXTRA_STUDENT);

        tv.setText("NIM :" + mhs.getNim() + "\nNama :" + mhs.getNama() + "\nProdi :" + mhs.getProdi());

        button.setOnClickListener(view -> {
            finish();
        });
    }
}