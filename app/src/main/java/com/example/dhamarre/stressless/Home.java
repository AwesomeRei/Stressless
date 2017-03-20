package com.example.dhamarre.stressless;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhamarre.stressless.Activity.Achievements;
import com.example.dhamarre.stressless.Activity.ActivityListAll;
import com.example.dhamarre.stressless.Activity.Playing;
import com.example.dhamarre.stressless.Activity.SignUpActivity;
import com.example.dhamarre.stressless.Activity.Statistic;
import com.example.dhamarre.stressless.Activity.Stressless;
import com.example.dhamarre.stressless.Activity.StresslessResult;
import com.example.dhamarre.stressless.Model.User;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView firstName,fullName,gender;
    private TextView lastName;
    private TextView years,weight,height,bmi,statisticNumber;
    private LinearLayout occupation,achievement,statistic,allActivity;
    private Button go;

    Realm realm;
//    AlarmActivity alarm = new AlarmActivity();
//    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        firstName = (TextView)findViewById(R.id.tvFirstNameView);
        lastName = (TextView)findViewById(R.id.tvLastNameView);
        fullName = (TextView)header.findViewById(R.id.tvName);
        gender = (TextView)header.findViewById(R.id.tvGender);
        years = (TextView)findViewById(R.id.tvYears);
        weight = (TextView)findViewById(R.id.tvWeight);
        height = (TextView)findViewById(R.id.tvHeight);
        bmi = (TextView)findViewById(R.id.tvBmi_set);
        statisticNumber = (TextView)findViewById(R.id.tvStatisticNumberHome);

        go = (Button)findViewById(R.id.btnLetsGoHealthy);
        achievement = (LinearLayout)findViewById(R.id.btnAchievement);
        statistic = (LinearLayout)findViewById(R.id.btnStatistic);
        allActivity = (LinearLayout)findViewById(R.id.btnAllActivity);
        occupation = (LinearLayout)findViewById(R.id.btnOccupation);
        achievement.setOnClickListener(operation);
        go.setOnClickListener(operation);
        statistic.setOnClickListener(operation);
        allActivity.setOnClickListener(operation);
        occupation.setOnClickListener(operation);

        realm = Realm.getDefaultInstance();
        RealmQuery<User> query = realm.where(User.class);

        realm.beginTransaction();
        RealmResults<User> result1 = query.findAll();

        realm.commitTransaction();

        if (!result1.isEmpty() || result1.size()>0){
//            Log.d("User",result1.get(0).getFirstName());
            User user = result1.first();
//
//
//
//            realm = Realm.getDefaultInstance();
//            RealmQuery<User> query = realm.where(User.class);
//
//            realm.beginTransaction();
//            RealmResults<User> result1 = query.findAll();
//            result1.size();
//            realm.commitTransaction();
//            User user = result1.first();


            int age = Calendar.getInstance().get(Calendar.YEAR)- Integer.valueOf(user.getBirthDay());
//            Log.d("Age ", String.valueOf(age));
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            fullName.setText(user.getFirstName()+" "+user.getLastName());
            gender.setText(user.getGender());
            years.setText(String.valueOf(age));
            int w = (int )user.getWeight();
            int y = (int) user.getHeight();

            weight.setText( String.valueOf(w));
            height.setText(String.valueOf(y));
            float x = user.getWeight()/((user.getHeight()/100)*(user.getHeight()/100));
            if (x >= 25){
                bmi.setText("Overweight");
            }else if (x>=18.5){
                bmi.setText("Normal");
            }else{
                bmi.setText("Underweight");
            }
//
//            Intent intent = new Intent(this, Stressless.class);
//            startActivity(intent);
//            finish();
//            name.setText(result1.toString());
        }else{
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }

        statisticNumber.setText("0");

//        Home.setLayoutManager(new LinearLayoutManager(this));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

//    public static void setLayoutManager(LinearLayoutManager linearLayoutManager) {
//    }

    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnAchievement : goToActivity(Achievements.class);
                    break;
                case R.id.btnStatistic: goToActivity(Statistic.class);
                    break;
                case R.id.btnAllActivity : goToActivity(ActivityListAll.class);
                    break;
                case R.id.btnOccupation : goToActivity(StresslessResult.class);
                    break;
                case R.id.btnLetsGoHealthy : goToActivity(Stressless.class);
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            goToActivity(SignUpActivity.class);
//            Log.d("Alarm","Activated");
//            alarm.setAlarm(this);
//            return true;
            // Handle the camera action
        } else if (id == R.id.nav_achievement) {
//            goToActivity(Achievements.class);
        } else if (id == R.id.nav_statistic) {
//            goToActivity(Statistic.class);
        } else if (id == R.id.nav_playing) {
            goToActivity(Playing.class);
        } else if (id == R.id.nav_share) {
//            goToActivity(Stressless.class);
        } else if (id == R.id.nav_logOut) {

            RealmQuery<User> query = realm.where(User.class);
            final RealmResults<User> result1 = query.findAll();

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    result1.deleteAllFromRealm();
                }
            });
            goToActivity(SplashScreen.class);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goToActivity(Class x){
        Intent intent = new Intent(this, x);
        startActivity(intent);
//        finish();
    }


}
