package com.example.dhamarre.stressless.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dhamarre.stressless.R;

public class StresslessResult extends AppCompatActivity {

    Button set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stressless_result);

        set = (Button)findViewById(R.id.btnSetNow);
        set.setOnClickListener(operation);
    }
    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnSetNow: goToActivity(StresslessResult.class);
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
