package com.example.dhamarre.stressless.Activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.dhamarre.stressless.Home;
import com.example.dhamarre.stressless.Model.User;
import com.example.dhamarre.stressless.R;

import java.util.Calendar;

import io.realm.Realm;

public class SignUp2Activity extends AppCompatActivity {

    private RadioGroup gender;
    private EditText height;
    private EditText weight;
    private CheckBox defaultBMI;
    private Button go;
    private Spinner spinHeight;
    private Spinner spinWeight;
    Realm realm;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        realm = Realm.getDefaultInstance();

        extras = getIntent().getExtras();


        gender = (RadioGroup)findViewById(R.id.rbGender);
        height = (EditText)findViewById(R.id.etHeight);
        weight = (EditText)findViewById(R.id.etWeight);

        defaultBMI = (CheckBox)findViewById(R.id.cbDefault);
//        spinHeight = (Spinner)findViewById(R.id.spinnerHeight);
//        spinWeight = (Spinner)findViewById(R.id.spinnerWeight);
//
        go = (Button)findViewById(R.id.btnGo);
//        defaultBMI.setOnCheckedChangeListener(operation);
        go.setOnClickListener(op);

    }



    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final User user = new User(); // Create a new object
            user.setFirstName(extras.get("firstName").toString());
            user.setLastName(extras.get("lastName").toString());
            user.setBirthDay(extras.get("bday").toString());

//            user.setEmail("xx@xx.xx");
            if (gender.getCheckedRadioButtonId() == R.id.rbMale){
                user.setGender("Male");
//                Log.d("Gender","Male");
            }else{
                user.setGender("Female");
//                Log.d("Gender","Female");
            }
            if (defaultBMI.isChecked()){
                //height equals
                //weight equals
                Log.d("bmi","default");
                user.setWeight(65);
                user.setHeight(170);
            }else{
                user.setHeight(Float.valueOf(height.getText().toString()));
                user.setWeight(Float.valueOf(weight.getText().toString()));
            }

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User realmUser = realm.copyToRealm(user);
                }
            });
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
    };











}
