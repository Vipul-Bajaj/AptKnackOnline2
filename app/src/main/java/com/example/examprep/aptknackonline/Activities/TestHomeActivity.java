package com.example.examprep.aptknackonline.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.examprep.aptknackonline.R;

public class TestHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_home);

        ImageButton aptitudeImageButton = findViewById(R.id.aptituteTestImageButton);
        ImageButton verbalImageButton = findViewById(R.id.verbalTestImageButton);
        ImageButton reasoningImageButton = findViewById(R.id.reasoningTestImageButton);
        ImageButton selfImageButton = findViewById(R.id.selfAssesmentImageButton);

        aptitudeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestHomeActivity.this, MockTest.class);
                intent.putExtra("testType", "Aptitude");
                startActivity(intent);
            }
        });

        verbalImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestHomeActivity.this, MockTest.class);
                intent.putExtra("testType", "Verbal");
                startActivity(intent);
            }
        });

        reasoningImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestHomeActivity.this, MockTest.class);
                intent.putExtra("testType", "Reasoning");
                startActivity(intent);
            }
        });

        selfImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestHomeActivity.this, MockTest.class);
                intent.putExtra("testType", "Self");
                startActivity(intent);
            }
        });
    }
}
