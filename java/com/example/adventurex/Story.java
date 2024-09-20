package com.example.adventurex;

import android.view.View;

public class Story {

    GameScreen gs;
    String nextPosition_1, nextPosition_2, nextPosition_3, nextPosition_4;

    Equipment equipment = new Equipment();

    Сharacteristics сharacteristics = new Сharacteristics();

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
            case "gargoyle" :
                gargoyle();
                break;
            case "sword" :
                sword();
                break;
            case "attack" :
                attack();
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
        setButtonsVisible(true, true, true, true);
        setButtonText("Go North", "Go East", "Go West", "Read the sign");
        setNextPosition("gargoyle", "sword", "pipe", "sign");
    }

    public void sign() {
        gs.imageView.setImageResource(R.drawable.sign);
        setTextView("The sign says:",
                "MONSTER AHEAD!!!", "", "");
        setButtonsVisible(true, false, false, false);
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
        if (equipment.sword == true) {
            gs.imageView.setImageResource(R.drawable.pipe);
            setTextView("You have defeated the piranha plant with your sword.",
                    "You feel much stronger now.", "", "");
            setButtonsVisible(true, false, false, false);
            setButtonText("Back", "", "", "");
            setNextPosition("startingPoint", "", "", "");

            сharacteristics.piranhaPlantDefeated = true;
            сharacteristics.monstersDefeated += 1;
            сharacteristics.strength += 1;
        } else {
            gs.imageView.setImageResource(R.drawable.pipe);
            setTextView("Piranha plant is inside.",
                    "You are eaten by it!!!", "", "");
            setButtonsVisible(true, false, false, false);
            setButtonText(">", "", "", "");
            setNextPosition("gameOver", "", "", "");
        }
    }

    public void gargoyle() {
        gs.imageView.setImageResource(R.drawable.gargoyle);
        setTextView("A gargoyle suddenly attacks you.",
                "",
                "What will you do?", "");
        setButtonsVisible(true, true, false, false);
        setButtonText("Attack", "Run away", "", "");
        setNextPosition("attack", "startingPoint", "", "");
    }

    public void sword() {
        gs.imageView.setImageResource(R.drawable.sword);
        setTextView("Amazing! You find a master sword!",
                "(You have a master sword now)", "", "");
        setButtonsVisible(true, false, false, false);
        setButtonText("Back", "", "", "");
        setNextPosition("startingPoint", "", "", "");

        equipment.sword = true;
    }

    public void attack() {
        if (сharacteristics.piranhaPlantDefeated == true && equipment.sword && сharacteristics.strength > 1) {
            gs.imageView.setImageResource(R.drawable.treasure);
            setTextView("You defeated the gargoyle!...",
                    "and found the treasure!!!", "You feel much stronger now.", "This is the end of your adventure.");
            setButtonsVisible(true, false, false, false);
            setButtonText("Go to main screen", "", "", "");
            setNextPosition("goMainScreen", "", "", "");

            сharacteristics.gargoyleDefeated = true;
            сharacteristics.monstersDefeated += 1;
            сharacteristics.strength += 1;
        } else {
            gs.imageView.setImageResource(R.drawable.gargoyle);
            setTextView("You fought bravely and selflessly, but the gargoyle was stronger than you.",
                    "It killed you", "", "");
            setButtonsVisible(true, false, false, false);
            setButtonText(">", "", "", "");
            setNextPosition("gameOver", "", "", "");
        }
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
