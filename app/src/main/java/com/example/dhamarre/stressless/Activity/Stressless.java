package com.example.dhamarre.stressless.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.dhamarre.stressless.Model.User;
import com.example.dhamarre.stressless.R;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class Stressless extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stressless);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



    }

}
