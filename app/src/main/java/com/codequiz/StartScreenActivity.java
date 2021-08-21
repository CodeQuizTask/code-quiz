package com.codequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void getStarted(View view) {
//        Intent i = new Intent(this, StartActivity.class);
//        startActivity(i);
    }

    public void about(View view) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
}