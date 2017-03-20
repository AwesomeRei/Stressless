package com.example.dhamarre.stressless.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.dhamarre.stressless.R;

public class Statistic extends AppCompatActivity {

    TextView defaultHealth,occHealth,badMS,goodMS,averageMS,badFs,averageFS,goodFS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        defaultHealth = (TextView)findViewById(R.id.tvStatisticNumber);
        occHealth = (TextView)findViewById(R.id.tvStatisticNumberOccupational);

        badMS = (TextView)findViewById(R.id.tvMentalityBadUsed);
        goodMS = (TextView)findViewById(R.id.tvMentalityGoodUsed);
        averageMS = (TextView)findViewById(R.id.tvMentalityAverageUsed);
        badFs = (TextView)findViewById(R.id.tvFisicallyBadUsed);
        averageFS =(TextView)findViewById(R.id.tvFisicallyAverageUsed);
        goodFS = (TextView)findViewById(R.id.tvFisicallyGoodUsed);

        defaultHealth.setText("0");
        occHealth.setText("0");
        badMS.setText("0");
        averageMS.setText("0");
        goodMS.setText("0");
        badFs.setText("0");
        averageFS.setText("0");
        goodFS.setText("0");



    }

}
