package com.example.dhamarre.stressless.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhamarre.stressless.Home;
import com.example.dhamarre.stressless.Model.User;
import com.example.dhamarre.stressless.R;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class Stressless extends AppCompatActivity {


    private Button seeResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stressless);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        seeResult = (Button)findViewById(R.id.btnStresslessResult);
        seeResult.setOnClickListener(operation);


    }

    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnStresslessResult: goToActivity(Home.class);
                    break;
            }
        }
    };
    private void goToActivity(Class x){
        Intent intent = new Intent(this, x);
        startActivity(intent);
//        finish();
    }

}
