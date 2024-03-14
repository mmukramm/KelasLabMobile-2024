package com.example.pekan1_pm_d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.money_tv);
        et = findViewById(R.id.input_money_et);
        btn = findViewById(R.id.change_money_btn);

        btn.setOnClickListener(view -> {
            tv.setText(et.getText());
        });

    }
}