package com.example.brianyoung.galactica;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"feedback@galactica.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback for Galactica");
                intent.putExtra(Intent.EXTRA_TEXT," ");
                intent.putExtra(Intent.EXTRA_CC,"feedback@galactica.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send Feedback "));
            }
        });

        //set the share button
        buttonShareFbd = findViewById(R.id.btnFdbShare);
        buttonShareFbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "This app is AWESOME, it's called Galactica!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check this cool application that will make you want to learn more about planets in the solar system!");
                startActivity(Intent.createChooser(shareIntent, "Share to "));
            }
        });



    }
}
