package com.kaazing.gateway.jms.client.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public class PlayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        Button btn_left, btn_right, btn_top, btn_bottom, player1, player2;
        btn_left = (Button) findViewById(R.id.button_left);
        btn_right = (Button) findViewById(R.id.button_right);
        btn_top = (Button) findViewById(R.id.button_top);
        btn_bottom = (Button) findViewById(R.id.button_bottom);
        player1 = (Button) findViewById(R.id.button_player1);
        player2 = (Button) findViewById(R.id.button_player2);

    }



}
