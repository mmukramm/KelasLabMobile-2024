package com.example.pekan5_pm_ab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        Button btn_start = findViewById(R.id.btn_start);
        TextView tv_status = findViewById(R.id.tv_status);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        btn_start.setOnClickListener(v -> {

            executor.execute(() -> {
                try {
                    for (int i = 0; i <= 10; i++) {
                        Thread.sleep(500);
                        int persen = i * 10;

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (persen == 100) {
                                    tv_status.setText("Task Complete");
                                } else {
                                    tv_status.setText(String.format(getString(R.string.compressing), persen));
                                }
                            }
                        });


                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(5000);
//
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                tv.setText("Halo dunia======");
//                                tv_status.setText("Hai");
//                            }
//                        });
//
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }).start();


        });
    }
}