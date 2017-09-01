package com.example.helen.kupchinonews;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

public class Main extends Activity {

    Context mainContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mainContext = this;

        ((Button)findViewById(R.id.Button02)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goExtendedMail = new Intent(mainContext, com.example.helen.kupchinonews.ExtendedMail.class);
                startActivity(goExtendedMail);
            }
        });
        ((Button)findViewById(R.id.Button03)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goChat = new Intent(mainContext, com.example.helen.kupchinonews.Chat.class);
                startActivity(goChat);
            }
        });
        ((Button)findViewById(R.id.Button04)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goFeed = new Intent(mainContext, com.example.helen.kupchinonews.Feed.class);
                startActivity(goFeed);
            }
        });
    }
}