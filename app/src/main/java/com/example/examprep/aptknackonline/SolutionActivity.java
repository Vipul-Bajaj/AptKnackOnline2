package com.example.examprep.aptknackonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
    }

    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(this, SolutionWebViewActivity.class);
        switch (id) {
            case R.id.aptitudeHelpButton:
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.antonymsHelpButton:
                intent.putExtra("type", 2);
                startActivity(intent);
                break;
            case R.id.directionSenseHelpButton:
                intent.putExtra("type", 3);
                startActivity(intent);
                break;
            case R.id.idiomHelpButton:
                intent.putExtra("type", 4);
                startActivity(intent);
                break;
            case R.id.spottingHelpButton:
                intent.putExtra("type", 5);
                startActivity(intent);
                break;
            case R.id.synonymHelpButton:
                intent.putExtra("type", 6);
                startActivity(intent);
                break;
            case R.id.verbalHelpButton:
                intent.putExtra("type", 7);
                startActivity(intent);
                break;
            case R.id.verbalAllHelpButton:
                intent.putExtra("type", 8);
                startActivity(intent);
                break;
        }
    }
}
