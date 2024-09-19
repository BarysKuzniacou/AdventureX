package com.example.adventurex;

import android.view.View;

public class Story {

    GameScreen gs;
    String nextPosition_1, nextPosition_2, nextPosition_3, nextPosition_4;

    public Story(GameScreen gs) {
        this.gs = gs;
    }

    public void switchPosition(String position) {
        switch (position) {
            case "startingPoint" :
                startingPoint();
                break;
            case "sign" :
                sign();
                break;
            case "pipe" :
                pipe();
                break;
            case "plant" :
                plant();
                break;
            case "sword" :
                sword(); // 8:25 https://www.youtube.com/watch?v=Lr3hj2eNf5I&list=PL_QPQmz5C6WVWGhGVlT25UGYFUt7k9DGX&index=8
                break;
            case "gameOver" :
                gameOver();
                break;
            case "goMainScreen" :
                gs.goMainScreen();
                break;
        }
    }

    public void setButtonsVisible(boolean button1, boolean button2, boolean button3, boolean button4) {
        if (button1 == true) {
            gs.button_1.setVisibility(View.VISIBLE);
        } else {
            gs.button_1.setVisibility(View.INVISIBLE);
        }
        if (button2 == true) {
            gs.button_2.setVisibility(View.VISIBLE);
        } else {
            gs.button_2.setVisibility(View.INVISIBLE);
        }
        if (button3 == true) {
            gs.button_3.setVisibility(View.VISIBLE);
        } else {
            gs.button_3.setVisibility(View.INVISIBLE);
        }
        if (button4 == true) {
            gs.button_4.setVisibility(View.VISIBLE);
        } else {
            gs.button_4.setVisibility(View.INVISIBLE);
        }
    }

    public void setTextView(String str1, String str2, String str3, String str4) {
        gs.textView.setText(str1 + "\n\n" + str2 + "\n\n" + str3 + "\n\n" + str4);
    }

    public void setButtonText(String str1, String str2, String str3, String str4) {
        gs.button_1.setText(str1);
        gs.button_2.setText(str2);
        gs.button_3.setText(str3);
        gs.button_4.setText(str4);
    }

    public void setNextPosition(String pos1, String pos2, String pos3, String pos4) {
        nextPosition_1 = pos1;
        nextPosition_2 = pos2;
        nextPosition_3 = pos3;
        nextPosition_4 = pos4;
    }

    public void startingPoint() {
        gs.imageView.setImageResource(R.drawable.path);
        setTextView("You are on the road. There is the wooden sign nearby",
                "What will you do?", "", "");
        //setButtonsVisible(true, true, true, true);
        gs.button_1.setVisibility(View.VISIBLE);
        gs.button_2.setVisibility(View.VISIBLE);
        gs.button_3.setVisibility(View.VISIBLE);
        gs.button_4.setVisibility(View.VISIBLE);
        setButtonText("Go North", "Go East", "Go West", "Read the sign");
        setNextPosition("monster", "sword", "pipe", "sign");
    }

    public void sign() {
        gs.imageView.setImageResource(R.drawable.sign);
        setTextView("The sign says:",
                "MONSTER AHEAD!!!", "", "");
        //setButtonsVisible(true, false, false, false);
        gs.button_1.setVisibility(View.VISIBLE);
        gs.button_2.setVisibility(View.INVISIBLE);
        gs.button_3.setVisibility(View.INVISIBLE);
        gs.button_4.setVisibility(View.INVISIBLE);
        setButtonText("Back", "", "", "");
        setNextPosition("startingPoint", "", "", "");
    }

    public void pipe() {
        gs.imageView.setImageResource(R.drawable.pipe);
        setTextView("You find a gigantic pipe.",
                "What will you do?", "", "");
        setButtonsVisible(true, true, false, false);
        setButtonText("Look inside", "Go back", "", "");
        setNextPosition("plant", "startingPoint", "", "");
    }

    public void plant() {
        gs.imageView.setImageResource(R.drawable.pipe);
        setTextView("Piranha plant is inside.",
                "You are eaten by it!!!", "", "");
        setButtonsVisible(true, false, false, false);
        setButtonText(">", "", "", "");
        setNextPosition("gameOver", "", "", "");
    }

    public void sword() {
        gs.imageView.setImageResource(R.drawable.sword);
        setTextView("Amazing! You find a master sword!",
                "(You have a master sword now)", "", "");
        setButtonsVisible(true, false, false, false);
        setButtonText("Back", "", "", "");
        setNextPosition("startingPoint", "", "", "");
    }

    public void gameOver() {
        gs.imageView.setImageResource(R.drawable.gameoverrip);
        setTextView("You are dead...",
                "Your adventure ends here", "", "GAME OVER");
        setButtonsVisible(true, false, false, false);
        setButtonText("To the main screen", "", "", "");
        setNextPosition("goMainScreen", "", "", "");
    }
}
