package com.example.airlyzer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvOxygenLevel;
    ProgressBar progressBar;
    Button btnAlert;
    int oxygenLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOxygenLevel = findViewById(R.id.tvOxygenLevel);
        progressBar = findViewById(R.id.progressBar);
        btnAlert = findViewById(R.id.btnAlert);

        updateOxygenLevel();

        btnAlert.setOnClickListener(v -> checkOxygenAlert());
    }

    private void updateOxygenLevel() {
        Random random = new Random();
        oxygenLevel = 90 + random.nextInt(10);  // Simulating random oxygen levels (90-99%)
        tvOxygenLevel.setText("Oxygen Level: " + oxygenLevel + "%");
        progressBar.setProgress(oxygenLevel);
    }

    private void checkOxygenAlert() {
        if (oxygenLevel < 92) {
            Toast.makeText(MainActivity.this, "⚠ Low Oxygen Level! Seek Medical Help!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "✅ Oxygen Level is Normal", Toast.LENGTH_SHORT).show();
        }
    }
}