package com.example.examprep.aptknackonline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initOneTmSetup();

        ImageButton testImageButton = findViewById(R.id.testImageButton);
        ImageButton tutorImageButton = findViewById(R.id.tutorImageButton);

        testImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestHomeActivity.class);
                startActivity(intent);
            }
        });

        tutorImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SolutionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initOneTmSetup() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("IS_FIRST", true);
        if (isFirst == true) {
            //	Toast.makeText(this, "This is first time", Toast.LENGTH_LONG).show();
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("IS_FIRST", false);
            e.commit();
            copyFile("examprep.sqlite", R.raw.examprep);
        } else {
            Log.d("Vipul", "initOneTmSetup: " + getApplicationInfo().dataDir);
            File f = new File(getApplicationInfo().dataDir + "/examprep.sqlite");
            if (f.exists() == false) {
                Toast.makeText(this, "file currupted Creating Syllabus ", Toast.LENGTH_LONG).show();
                copyFile("examprep.sqlite", R.raw.examprep);
            }

//			-------DEBUGGING----------------------------
//			try {
//				ZipFile z =new ZipFile("aa.zip");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			--------------------------------------------
        }
    }

    private void copyFile(String dest, int res) {
        File f = new File(getApplicationInfo().dataDir + "/" + dest);
        try {
            boolean isCreated = f.createNewFile();

            if (isCreated == false)
                return;
            FileOutputStream fout = new FileOutputStream(f);
            //Toast.makeText(this, "is  not null ", Toast.LENGTH_LONG).show();
            InputStream is = getResources().openRawResource(res);
            byte[] buff = new byte[1000];
            int len;
            while ((len = is.read(buff)) != -1) {
                fout.write(buff, 0, len);
            }
            fout.close();
            is.close();
        } catch (IOException ee) {
            Toast.makeText(this, "Exception Occured", Toast.LENGTH_LONG).show();
        }
    }
}
