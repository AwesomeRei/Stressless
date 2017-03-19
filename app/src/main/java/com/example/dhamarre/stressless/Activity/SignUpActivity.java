package com.example.dhamarre.stressless.Activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dhamarre.stressless.Fragment.PickerFragment;
import com.example.dhamarre.stressless.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText birthdate;
    private Spinner day;
    private Spinner month;
    private Spinner year;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        firstName = (EditText)findViewById(R.id.etFirstName);
        firstName.addTextChangedListener(watcher);
        lastName = (EditText)findViewById(R.id.etLastName);
//        lastName.setError("Wrong");
        setDaySpinner(1);
        setMonthSpinner();
        setYearSpinner();
//        birthdate = (EditText)findViewById(R.id.etBDay);
//        birthdate.setClickable(true);
//        birthdate.setOnClickListener(operation);
        next = (Button)findViewById(R.id.btnNext);
        next.setOnClickListener(operation);



    }
    public void setDaySpinner(int x){
        day = (Spinner)findViewById(R.id.spinnerDay);
        List<String> list = new ArrayList<String>();
        list.clear();
        int max;
        if (x==2 ){
            max = 28;
        }else if(x==1){
            max = 31;
        }else {
            max = 30;
        }
        for (int j=1;j<=max;j++){
            list.add(String.valueOf(j));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(dataAdapter);
    }
    public void setMonthSpinner(){
        month = (Spinner)findViewById(R.id.spinnerMonth);
        List<String> list = new ArrayList<String>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("Nopember");
        list.add("December");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(dataAdapter);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String x = adapterView.getItemAtPosition(i).toString();
                if (x.equals("February")){
                    setDaySpinner(2);
                }else if (i%2 == 0){
                    setDaySpinner(0);
                }else {
                    setDaySpinner(1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void setYearSpinner(){
        year = (Spinner)findViewById(R.id.spinnerYear);
        List<String> list = new ArrayList<String>();
        for (int i = 1989;i<2018;i++){
            list.add(String.valueOf(i));
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(dataAdapter);

    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (firstName.getText().hashCode() == editable.hashCode()){
                Log.d("String",firstName.getText().toString());
                errorEditText(firstName);
            }
            if (lastName.getText().hashCode() == editable.hashCode()){
                errorEditText(lastName);
            }
        }
    };
    private void errorEditText(EditText x){
        if (x.getText().equals("") || x.getText().length()==0){
            x.setError("Must not be empty");
        }else {
            x.setError(null);
        }

    }


    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnNext : toNextActivity();
                    break;
//                case R.id.etBDay : showDatePickerDialog(view);

            }
        }
    };


    private void toNextActivity(){
        if (firstName.getText().toString().isEmpty() || firstName.getText().length()==0 || firstName.getText() == null){
            errorEditText(firstName);
        }else if (lastName.getText().toString().isEmpty() || firstName.getText().length()==0 || firstName.getText() == null){
            errorEditText(lastName);
        }else {
            Intent intent = new Intent(this,SignUp2Activity.class);
            intent.putExtra("firstName",firstName.getText());
            intent.putExtra("lastName",lastName.getText());
            intent.putExtra("bday",year.getSelectedItem().toString());
            startActivity(intent);
        }
        Log.d("Content",firstName.getText()+" "+lastName.getText()+" "+day.getSelectedItem().toString()+"/"+month.getSelectedItem().toString()+"/"+year.getSelectedItem().toString());

    }
}
