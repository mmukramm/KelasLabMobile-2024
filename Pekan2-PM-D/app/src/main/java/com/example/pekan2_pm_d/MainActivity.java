package com.example.pekan2_pm_d;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private ImageView imageView;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.iv);
        editText = findViewById(R.id.et);

        imageView.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });


        button.setOnClickListener(view -> {
            String editTextValue = editText.getText().toString();
            Mahasiwa mhs = new Mahasiwa(editTextValue, "H071292242", "Sisfo");

            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(SecondActivity.EXTRA_STUDENT, mhs);
            startActivity(intent);
        });
    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    Uri image = data.getData();
                    imageView.setImageURI(image);
                }
            }
    );
}