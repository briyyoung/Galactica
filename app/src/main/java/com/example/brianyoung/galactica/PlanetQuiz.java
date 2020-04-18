package com.example.brianyoung.galactica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PlanetQuiz extends AppCompatActivity {
    private Button choiceOne, choiceTwo, choiceThree;
    private TextView scoreValue, planetQuestion;
    private Quiz mQuiz = new Quiz();
    private int mScore = 0;
    public static final String ARG_PLANET_QUIZ = "";
    private Planet planet;
    public int planetNumber;
    public String mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_quiz);

        Intent intent = getIntent();
        planet = Planet.getPlanet(intent.getStringExtra(ARG_PLANET_QUIZ));

        //Get the planet's number based on the order that we use in the Planet.java
        //Using the picture number as the planet's number
        planetNumber = planet.getPicture();

        scoreValue = findViewById(R.id.scoreValue);
        planetQuestion = findViewById(R.id.planetQuestion);
        choiceOne = findViewById(R.id.choice1);
        choiceTwo = findViewById(R.id.choice2);
        choiceThree = findViewById(R.id.choice3);

        //Display the score as 0 when the quiz first started
        scoreValue.setText(String.valueOf(mScore));

        //Invoke the nextQuestion method when the screen is created so that we can fill in everything
        Random r = new Random();
        nextQuestion(r.nextInt(3));

            //Set the button listener
            choiceOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choiceOne.getText().equals(mAnswer) && mScore <= 2) {
                        mScore++;
                        scoreValue.setText(Integer.toString(mScore));
                        nextQuestion(r.nextInt(3));
                        System.out.println("It's correct!");
                    } else {
                        System.out.println("You click the wrong answer");
                        finishQuiz();
                    }
                }
            });


            choiceTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choiceTwo.getText().equals(mAnswer) && mScore <= 2) {
                        mScore++;
                        scoreValue.setText(Integer.toString(mScore));
                        nextQuestion(r.nextInt(3));
                        System.out.println("It's correct!");
                    } else {
                        System.out.println("You click the wrong answer");
                        finishQuiz();
                    }
                }
            });

            choiceThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choiceThree.getText().equals(mAnswer) && mScore <= 2) {
                        mScore++;
                        scoreValue.setText(Integer.toString(mScore));
                        nextQuestion(r.nextInt(3));
                        System.out.println("It's correct!");
                    } else {
                        System.out.println("You click the wrong answer");
                        finishQuiz();
                    }
                }
            });

    }

    //Method to move to the next question
    //a should be the next question's number so between 2-10
    private void nextQuestion(int a) {
        //Mercury's number is 1-1 = 0 to get the right questions
        int number = planetNumber - 1;

        //Set the questions according to the planet's number
        String[][] questions = mQuiz.getQuestions();
        planetQuestion.setText(questions[number][a]);

        //Set the right answers
        String[][] correctAnswer = mQuiz.getCorrectAnswers();
        mAnswer = correctAnswer[number][a];

        //Set the options
        String[][] optionOne = mQuiz.getChoiceOne();
        choiceOne.setText(optionOne[number][a]);

        String[][] optionTwo = mQuiz.getChoiceTwo();
        choiceTwo.setText(optionTwo[number][a]);

        String[][] optionThree = mQuiz.getChoiceThree();
        choiceThree.setText(optionThree[number][a]);
    }

    private void finishQuiz() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanetQuiz.this);
        dialog.setMessage("Congratulations! You finish the test! Your total score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNeutralButton("Share Result", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //put a share option here, not sure if it will work tho
                        String finalResult = "Hey! I got " + String.valueOf(mScore) + " for my " + planet.getName() +" quiz!" ;
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, finalResult);
                        startActivity(Intent.createChooser(sharingIntent, "Share text via"));
                    }
                });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


}
