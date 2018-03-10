package com.example.ehnyn.taskjson.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ehnyn.taskjson.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button postButton = (Button) findViewById(R.id.btnPost);
        Button commentButton = (Button) findViewById(R.id.btnComment);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postIntent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(postIntent);
            }
        });

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent commentIntent = new Intent(MainActivity.this, CommentActivity.class);
                startActivity(commentIntent);
            }
        });

    }
}
