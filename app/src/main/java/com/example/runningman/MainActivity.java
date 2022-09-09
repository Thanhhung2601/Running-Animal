package com.example.runningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textScore ;
    SeekBar seek1 , seek2 , seek3 ;
    CheckBox check1 , check2 ,check3 ;
    ImageButton btnPlay ;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComponents();
        CountDownTimer countDownTimer = new CountDownTimer(60000 , 300) {
            @Override
            public void onTick(long l) {
                int number = 5 ;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(seek1.getProgress() >= seek1.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TIGER WIN", Toast.LENGTH_SHORT).show();
                    if(check1.isChecked()){
                        score += 20 ;
                    }else{
                        score -= 20;
                    }
                    textScore.setText(Integer.toString(score));
                    stateActive(true);
                }
                if(seek2.getProgress() >= seek2.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "MONKEY WIN", Toast.LENGTH_SHORT).show();
                    if(check2.isChecked()){
                        score += 20 ;
                    }else{
                        score -= 20;
                    }
                    textScore.setText(Integer.toString(score));
                    stateActive(true);
                }

                if(seek3.getProgress() >= seek3.getMax()){
                    this.cancel();
                    btnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "HOURSE WIN", Toast.LENGTH_SHORT).show();
                    if(check3.isChecked()){
                        score += 20 ;
                    }else{
                        score -= 20;
                    }
                    textScore.setText(Integer.toString(score));
                    stateActive(true);
                }
                seek1.setProgress(seek1.getProgress() + one);
                seek2.setProgress(seek2.getProgress() + two);
                seek3.setProgress(seek3.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1.isChecked() || check2.isChecked() || check3.isChecked()){
                    seek1.setProgress(0);
                    seek2.setProgress(0);
                    seek3.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    stateActive(false);
                }else{
                    Toast.makeText(MainActivity.this, "YOU NEED CHOOSE ONE ANIMAL", Toast.LENGTH_SHORT).show();
                }
            }
        });
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    check2.setChecked(false);
                    check3.setChecked(false);
                }
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    check1.setChecked(false);
                    check3.setChecked(false);
                }
            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    check1.setChecked(false);
                    check2.setChecked(false);
                }
            }
        });
    }

    private void stateActive (boolean state){
        check1.setEnabled(state);
        check2.setEnabled(state);
        check3.setEnabled(state);

        seek1.setEnabled(state);
        seek2.setEnabled(state);
        seek3.setEnabled(state);
    }

    private void getComponents(){
        textScore = findViewById(R.id.score);
        btnPlay = findViewById(R.id.btnPlay);
        seek1 = findViewById(R.id.seekBarOne);
        seek2 = findViewById(R.id.seekBarTwo);
        seek3 = findViewById(R.id.seekBarThree);

        check1 = findViewById(R.id.checkBoxOne);
        check2 = findViewById(R.id.checkBoxTwo);
        check3 = findViewById(R.id.checkBoxThree);

    }
}