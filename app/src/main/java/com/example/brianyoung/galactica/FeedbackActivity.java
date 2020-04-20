package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FeedbackActivity extends AppCompatActivity {
    private Button buttonShareFbd;
    private Button buttonFdbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_activity);

        //set the feedback button
        buttonFdbk = findViewById(R.id.btnFdbk);
        buttonFdbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fdbIntent = new Intent(Intent.ACTION_SEND);
                fdbIntent.setType("text/plain");
                fdbIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Galactica");
                fdbIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(fdbIntent, "Share to "));
            }
        });

        //set the share button
        buttonShareFbd = findViewById(R.id.btnFdbShare);
        buttonShareFbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "This App is AWESOME, IT IS GALACTICA!!!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check this cool application that will make you learn more about Planets in Solar System");
                startActivity(Intent.createChooser(shareIntent, "Share to "));
            }
        });



    }
}
