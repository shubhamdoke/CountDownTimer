package com.example.timename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_timer=findViewById(R.id.tv_timer);
        EditText tv_name=findViewById(R.id.name);
        EditText tv_time=findViewById(R.id.time);
        Button set=findViewById(R.id.btn);


       set.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String time= tv_time.getText().toString();
               String name=tv_name.getText().toString();

               showTime(time, name, tv_timer);
           }
       });
    }

    private void showTime(String time, String name, TextView tv_timer) {

        long t = Long.parseLong(time);
        long s = t*1000;
        new CountDownTimer(s, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_timer.setText("just wait: " + millisUntilFinished / 1000);
                // logic to set the EditText could go here
            }

            public void onFinish() {

                tv_timer.setText("Hello "+name);

            }

        }.start();
    }
}