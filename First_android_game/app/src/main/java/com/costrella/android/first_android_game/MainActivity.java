package com.costrella.android.first_android_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {
    //    ImageButton playBtn, highScoreBtn, settingsBtn;
    Button playBtn, levelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.btnPlay);
        levelBtn = (Button) findViewById(R.id.btnLevel);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LevelSelector.class);
                startActivity(i);
            }
        });

        levelBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(getApplicationContext(), LevelSelector.class);
                                            startActivity(i);
                                        }
                                    }
        );
    }
}
