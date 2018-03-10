package com.example.examprep.aptknackonline.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import com.example.examprep.aptknackonline.R;

public class SolutionWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_web_view);
        int type = getIntent().getIntExtra("type", 1);
        WebView webView = findViewById(R.id.webView);
        String url = "file:///android_res/raw/htmfile.html";
        switch (type) {
            case 1:
                url = "file:///android_res/raw/htmfile.html";
                break;
            case 2:
                url = "file:///android_res/raw/antonyms.html";
                break;
            case 3:
                url = "file:///android_res/raw/direction_sense.html";
                break;
            case 4:
                url = "file:///android_res/raw/idioms.html";
                break;
            case 5:
                url = "file:///android_res/raw/spotting_errors.html";
                break;
            case 6:
                url = "file:///android_res/raw/synonyms.html";
                break;
            case 7:
                url = "file:///android_res/raw/verbal_analogy.html";
                break;
            case 8:
                url = "file:///android_res/raw/verbal_all.html";
                break;
        }
        webView.loadUrl(url);
    }
}
