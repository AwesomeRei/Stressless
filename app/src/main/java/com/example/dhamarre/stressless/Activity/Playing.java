package com.example.dhamarre.stressless.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.dhamarre.stressless.Home;
import com.example.dhamarre.stressless.R;

public class Playing extends AppCompatActivity {

    ProgressBar progressBar;
    CountDownTimer timer;
    Button start,skip;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progressBar = (ProgressBar)findViewById(R.id.playing_progressBar);
        progressBar.setProgress(i);
        start = (Button)findViewById(R.id.btnPlayingStart);
        skip = (Button)findViewById(R.id.btnSkip);

        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                start.setClickable(false);
                Log.d("Seconds to finish", ""+l/1000);
                i++;
                progressBar.setProgress(i);
            }

            @Override
            public void onFinish() {
                i++;
                progressBar.setProgress(i);
                start.setClickable(true);
            }
        };

        start.setOnClickListener(operation);
        skip.setOnClickListener(operation);

    }
    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnPlayingStart:
                    i=0;
                    timer.start();
                    break;
                case R.id.btnSkip:
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
