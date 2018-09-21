package com.example.scs.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText userNumber;
    Button userButton;
    TextView userScore;
    ProgressBar gameProgress;
    int guessNumber, number, chances = 0, score = 0;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        guessNumber = rand.nextInt(20) + 1;

        userNumber = (EditText) findViewById(R.id.number);
        userButton = (Button) findViewById(R.id.button);
        userScore = (TextView) findViewById(R.id.score);
        gameProgress = (ProgressBar) findViewById(R.id.progressbar);

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chances++;
                number = Integer.parseInt(userNumber.getText().toString());
                gameProgress.setProgress(gameProgress.getProgress() - 2);

                if(chances <= 50){
                    if(guessNumber == number){
                        Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        guessNumber = rand.nextInt(20) + 1;
                        score++;
                        userScore.setText(score + "");
                    }
                    else if(guessNumber > number)
                        Toast.makeText(MainActivity.this, "Go Higher", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "Go Lower", Toast.LENGTH_SHORT).show();
                }

                if(chances == 50)
                    Toast.makeText(MainActivity.this, "GAME END", Toast.LENGTH_SHORT).show();
            }
        });
    }
}