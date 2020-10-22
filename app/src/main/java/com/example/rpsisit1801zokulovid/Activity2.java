package com.example.rpsisit1801zokulovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
    Button BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        BtnBack = (Button) findViewById(R.id.BtnBack);
        BtnBack.setOnClickListener(this);
    }

    @Override

    //Кнопка Back
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnBack:
                Intent intent = new Intent (this, MainActivity.class);
                startActivity (intent);
                this.finish();
                break;
            default:
                break;
        }
    }

}