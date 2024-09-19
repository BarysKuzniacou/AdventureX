package com.example.adventurex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button_1, button_2, button_3, button_4;
    Story story = new Story(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        imageView = (ImageView) findViewById(R.id.gameImageView);
        textView = (TextView) findViewById(R.id.gameTextView);
        button_1 = (Button) findViewById(R.id.choiceButton1);
        button_2 = (Button) findViewById(R.id.choiceButton2);
        button_3 = (Button) findViewById(R.id.choiceButton3);
        button_4 = (Button) findViewById(R.id.choiceButton4);

        button_1.setTransformationMethod(null);
        button_2.setTransformationMethod(null);
        button_3.setTransformationMethod(null);
        button_4.setTransformationMethod(null);

        story.startingPoint();
    }

    public void setButton_1(View view) {
        story.switchPosition(story.nextPosition_1);
    }

    public void setButton_2(View view) {
        story.switchPosition(story.nextPosition_2);
    }

    public void setButton_3(View view) {
        story.switchPosition(story.nextPosition_3);
    }

    public void setButton_4(View view) {
        story.switchPosition(story.nextPosition_4);
    }

    public void goMainScreen() {
        Intent mainScreen = new Intent(this, MainScreen.class);
        startActivity(mainScreen);
    }
}