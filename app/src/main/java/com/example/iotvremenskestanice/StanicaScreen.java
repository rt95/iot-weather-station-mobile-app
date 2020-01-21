package com.example.iotvremenskestanice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StanicaScreen extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stanica_screen_activity);


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

    //Back button
    public void imageClick(View view) {
        finish();
    }
}
