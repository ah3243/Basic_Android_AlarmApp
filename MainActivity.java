package com.example.alberthiggins.examplealarmapp1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSet;
    EditText etTime;

//  Show chosen time in toast on button click
    private Button btn_show_time;
    private TimePicker time_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSet = (Button) findViewById(R.id.button);
        etTime = (EditText) findViewById(R.id.etAlarm);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        showTime();
    }
    public void showTime(){
        time_picker = (TimePicker) findViewById(R.id.timePicker);
        btn_show_time = (Button) findViewById(R.id.button2);

        btn_show_time.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(getBaseContext(), time_picker.getCurrentHour() + " : " + time_picker.getCurrentMinute(), Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }

    private void submitForm(){
//        Get text input parse into an int and store in time var
        int time = Integer.parseInt(etTime.getText().toString());
//        Create a new intent from the main activity to the Alarm class
        Intent i = new Intent(MainActivity.this, Alarm.class);
//        Create a pending intent
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
//        Create a new alarm service
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//        Set the new alarm service to the current time in milliseconds
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+time*1000, pi);
    }

}
