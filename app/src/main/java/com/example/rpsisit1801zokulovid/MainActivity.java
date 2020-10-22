package com.example.rpsisit1801zokulovid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button BtnRules,BtnRockChoice,BtnPaperChoice,BtnScissorsChoice;
    TextView TxtTotalScore;
    ImageView imageView4, ImgScore2;
    String UserChoice, PCChoice;
    Random RandomChoice = new Random();
    int Point=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnRules = (Button) findViewById(R.id.BtnRules);
        BtnRules.setOnClickListener(this);

        imageView4 = (ImageView) findViewById(R.id.imageView4);
        BtnRockChoice = (Button) findViewById(R.id.BtnRockChoice);
        BtnPaperChoice = (Button) findViewById(R.id.BtnPaperChoice);
        BtnScissorsChoice = (Button) findViewById(R.id.BtnScissorsChoice);

        TxtTotalScore = (TextView) findViewById(R.id.TxtTotalScore);
        ImgScore2 = (ImageView) findViewById(R.id.ImgScore2);

        BtnRockChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserChoice = "Rock";
                GameWork();
                TxtTotalScore.setText(Integer.toString(Point)+" points");
            }
        });

        BtnPaperChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserChoice = "Paper";
                GameWork();
                TxtTotalScore.setText(Integer.toString(Point)+" points");
            }
        });

        BtnScissorsChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserChoice = "Scissors";
                GameWork();
                TxtTotalScore.setText(Integer.toString(Point)+" points");
            }
        });
    }

    //Рандомный ответ PC
    public void GameWork () {
        int l=RandomChoice.nextInt(3); //задаем рандомное число до 3
        if (l==0) {
            PCChoice="Rock";
            imageView4.setImageResource(R.drawable.rock);
        } else
            if (l==1) {
            PCChoice="Paper";
            imageView4.setImageResource(R.drawable.paper);
        } else {
                PCChoice="Scissors";
                imageView4.setImageResource(R.drawable.scissors);
            }
            //Описываем правила, счет очков и вывод победа/проигрыш
           if (UserChoice.equals("Rock") && PCChoice.equals("Paper")) {
               Point--;
               ImgScore2.setImageResource(R.drawable.starnolight);
               Toast toast = Toast.makeText(getApplicationContext(),"You lost. Don't give up!", Toast.LENGTH_SHORT);
               toast.setGravity(Gravity.CENTER, 0, 0);
               toast.show();
            } else
            if (UserChoice == PCChoice){
                ImgScore2.setImageResource(R.drawable.starnolight);
            } else
            if (UserChoice.equals("Rock") && PCChoice.equals("Scissors")){
                Point++;
                ImgScore2.setImageResource(R.drawable.starlight);
                Toast toast = Toast.makeText(getApplicationContext(),"You win! Yor're the BEST!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else
            if (UserChoice.equals("Paper") && PCChoice.equals("Rock")){
                Point++;
                ImgScore2.setImageResource(R.drawable.starlight);
                Toast toast = Toast.makeText(getApplicationContext(),"You win! Yor're the BEST!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else
            if (UserChoice.equals("Paper") && PCChoice.equals("Scissors")){
                Point--;
                ImgScore2.setImageResource(R.drawable.starnolight);
                Toast toast = Toast.makeText(getApplicationContext(),"You lost. Don't give up!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else
            if (UserChoice.equals("Scissors") && PCChoice.equals("Paper")){
                Point++;
                ImgScore2.setImageResource(R.drawable.starlight);
                Toast toast = Toast.makeText(getApplicationContext(),"You win! Yor're the BEST!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else
            if (UserChoice.equals("Scissors") && PCChoice.equals("Rock")){
                Point--;
                ImgScore2.setImageResource(R.drawable.starnolight);
                Toast toast = Toast.makeText(getApplicationContext(),"You lost. Don't give up!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
    }

    //Кнопка Rules
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.BtnRules:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
                this.finish();
                break;
            default:
                break;
        }
    }

    //Кнопка Exit
    public void onClick2(View v2) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
