package com.example.android.americanfootball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private static final String stateTeamAScore = "scoreTeamA";
    private static final String stateTeamBScore = "scoreTeamB";

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    TextView ScoreViewA;
    TextView ScoreViewB;

    /**
     * Use onSaveInstanceState(Bundle).
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(stateTeamAScore, scoreTeamA);
        savedInstanceState.putInt(stateTeamBScore, scoreTeamB);

    }

    /**
     * Use onRestoreInstanceState.
     */

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //Saves the user current game state

        scoreTeamA = savedInstanceState.getInt(stateTeamAScore);
        scoreTeamB = savedInstanceState.getInt(stateTeamBScore);

        //Restores state  from saved instance.

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScoreViewA = findViewById(R.id.team_a_score);
        ScoreViewB = findViewById(R.id.team_b_score);

        Button b1 = findViewById(R.id.touch_a);
        b1.setOnClickListener(this);
        Button b2 = findViewById(R.id.touch_b);
        b2.setOnClickListener(this);
        Button b3 = findViewById(R.id.extra_a);
        b3.setOnClickListener(this);
        Button b4 = findViewById(R.id.extra_B);
        b4.setOnClickListener(this);
        Button b5 = findViewById(R.id.conversion_a);
        b5.setOnClickListener(this);
        Button b6 = findViewById(R.id.conversion_b);
        b6.setOnClickListener(this);
        Button b7 = findViewById(R.id.field_a);
        b7.setOnClickListener(this);
        Button b8 = findViewById(R.id.field_B);
        b8.setOnClickListener(this);
    }

    public void onClick(View view) {
        // Perform action on click
        switch (view.getId()) {
            case R.id.touch_a:
                //add six points for team A.
                scoreTeamA = scoreTeamA + 6;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.touch_b:
                //add six points for team B .
                scoreTeamB = scoreTeamB + 6;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.extra_a:
                //add one point for team A.
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.extra_B:
                //add one point for team B.
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.conversion_a:
                //add two points for team A.
                scoreTeamA = scoreTeamA + 2;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.conversion_b:
                //add two points for team B.
                scoreTeamB = scoreTeamB + 2;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.field_a:
                //add three points for team A.
                scoreTeamA = scoreTeamA + 3;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.field_B:
                //add three points for team B.
                scoreTeamB = scoreTeamB + 3;
                displayForTeamB(scoreTeamB);
                break;
        }
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        ScoreViewA.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        ScoreViewB.setText(String.valueOf(score));
    }

    /**
     * This method resets the score for both of the teams to zero.
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
