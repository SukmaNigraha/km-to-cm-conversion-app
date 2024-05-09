package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView outputTextView = findViewById(R.id.outputTextView);
        double result = getIntent().getDoubleExtra("result", 0.0);
        String resultWithUnit = String.format("%.2f meter", result);
        outputTextView.setText(resultWithUnit);

        Button shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buat pesan yang akan dibagikan
                String message = "Hasil konversi: " + resultWithUnit;

                // Buat Intent untuk berbagi pesan
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, message);

                // Jalankan Intent
                startActivity(Intent.createChooser(shareIntent, "Bagikan hasil via"));
            }
        });

        Button backToSecondButton = findViewById(R.id.backToSecondButton);
        backToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


