package com.example.adventurex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setText("START GAME");

        TextView mainTextView = (TextView) findViewById(R.id.mainTextView);
        mainTextView.setText("AdventureX");
    }

    public void goGameScreen(View view) {
        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }
}