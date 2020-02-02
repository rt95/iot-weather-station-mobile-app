package com.example.iotvremenskestanice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class StanicaScreen extends AppCompatActivity {

    private Button button;
    TextView naziv;
    TextView datum;
    TextView dan;
    TextView vrijeme;

    Calendar c;
    int hour,min;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stanica_screen_activity);

        naziv = findViewById(R.id.naziv);
        datum = findViewById(R.id.datum);
        dan = findViewById(R.id.dan);
        vrijeme = findViewById(R.id.selectedTime);

        c = Calendar.getInstance();

        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);

        //potrebno za marquee
        naziv.setSelected(true);

        naziv.setText(getIntent().getStringExtra("ImeStanice"));

        vrijeme.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                otvoriTimePicker();
            }
        });

        datum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriDatePicker();
            }
        });

        button = (Button) findViewById(R.id.btn_lokacija);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                otvoriKartu();
            }
        });
    }

    public void otvoriKartu(){
        Intent intent = new Intent(this, KartaScreen.class);
        startActivity(intent);
    }

    public void  otvoriTimePicker(){
        TimePickerDialog timePicker = new TimePickerDialog(StanicaScreen.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(minute == 0){
                    vrijeme.setText(String.valueOf(hourOfDay + ":" + minute + "0"));
                }
                else{
                    vrijeme.setText(String.valueOf(hourOfDay + ":" + minute));
                }
            }
        },0,0,true);
        timePicker.show();
    }

    public void otvoriDatePicker(){
        DatePickerDialog datePicker = new DatePickerDialog(StanicaScreen.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                datum.setText(dayOfMonth + "." + (month + 1) + "." + year);
                c.set(year, month, dayOfMonth);
                String dayLongName = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                String upperString = dayLongName.substring(0,1).toUpperCase() + dayLongName.substring(1);
                dan.setText(upperString);
            }
        }, year, month, day);
        datePicker.show();
    }

    //Back button
    public void imageClick(View view) {
        finish();
    }
}
