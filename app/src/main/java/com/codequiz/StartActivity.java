package com.codequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    // selectedTopicName will be assigned by a topic name ('java', 'javascript', 'python', 'php')
    private String selectedTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

        // Initialize widgets from activity_splash_screen.xml
        final Button startBtn = findViewById(R.id.startQuizBtn);
        final Button practiceBtn = findViewById(R.id.startPractice);
        final LinearLayout javaLayout = findViewById(R.id.javaLayout);
        final LinearLayout phpLayout = findViewById(R.id.phpLayout);
        final LinearLayout pyLayout = findViewById(R.id.pyLayout);
        final LinearLayout jsLayout = findViewById(R.id.jsLayout);

        javaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign java to selectedTopicName
                selectedTopicName = "java";

                // select java layout
                javaLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                pyLayout.setBackgroundResource(R.drawable.round_back_white10);
                jsLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        phpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign php to selectedTopicName
                selectedTopicName = "php";

                // select php layout
                phpLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                pyLayout.setBackgroundResource(R.drawable.round_back_white10);
                jsLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        pyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign html to selectedTopicName
                selectedTopicName = "python";

                // select HTML layout
                pyLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                jsLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        jsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign android to selectedTopicName
                selectedTopicName = "js";

                // select Android layout
                jsLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                pyLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        practiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* if user not selected any topic yet then show a Toast message
                 * selectedTopicName will be empty or default value ("") if user not selected any topic yet*/
                if (selectedTopicName.isEmpty()) {
                    Toast.makeText(StartActivity.this, "Please select topic first", Toast.LENGTH_SHORT).show();
                } else {

                    // Create an Object of Intent to open quiz questions screen
                    final Intent intent = new Intent(StartActivity.this, MainActivity.class);

                    //put user entered name and selected topic name to intent for use in next activity
                    intent.putExtra("selectedTopic", selectedTopicName);
                    intent.putExtra("origin", "selectedTopicToPractice");

                    // call startActivity to open next activity along with data(userName, selectedTopicName)
                    startActivity(intent);

                    finish(); // finish (destroy) this activity
                }
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* if user not selected any topic yet then show a Toast message
                 * selectedTopicName will be empty or default value ("") if user not selected any topic yet*/
                if (selectedTopicName.isEmpty()) {
                    Toast.makeText(StartActivity.this, "Please select topic first", Toast.LENGTH_SHORT).show();
                } else {

                    // Create an Object of Intent to open quiz questions screen
                    final Intent intent = new Intent(StartActivity.this, MainActivity.class);

                    //put user entered name and selected topic name to intent for use in next activity
                    intent.putExtra("selectedTopic", selectedTopicName);
                    intent.putExtra("origin", "selectedTopic");

                    // call startActivity to open next activity along with data(userName, selectedTopicName)
                    startActivity(intent);

                    finish(); // finish (destroy) this activity
                }
            }
        });
    }
}