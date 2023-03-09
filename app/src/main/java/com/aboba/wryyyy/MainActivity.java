package com.aboba.wryyyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button controlButton;
    MediaPlayer mp;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlButton = findViewById(R.id.control);
        controlButton.setOnClickListener(listener);
        mp = MediaPlayer.create(context, R.raw.lol);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(controlButton.getText()=="Пуск") {
                mp.start();
                controlButton.setText("Стоп");
            }else{
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(context, R.raw.lol);
                controlButton.setText("Пуск");
            }
        }
    };
}