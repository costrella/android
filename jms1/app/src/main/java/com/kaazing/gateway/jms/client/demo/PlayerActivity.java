package com.kaazing.gateway.jms.client.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;


public class PlayerActivity extends Activity {
    private PlayerEnum selectedPlayer;
    private String textMsg;

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
        selectedPlayer = PlayerEnum.PLAYER_ONE; //default
        textMsg = "1";
        player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedPlayer = PlayerEnum.PLAYER_ONE;
                textMsg = "1";
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedPlayer = PlayerEnum.PLAYER_TWO;
                textMsg = "2";
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JMSDemoActivity.dispatchQueue.dispatchAsync(new Runnable() {
                    public void run() {
                        try {
                            MessageProducer producer = JMSDemoActivity.session.createProducer(JMSDemoActivity.getDestination(JMSDemoActivity.destinationText.getText().toString()));
                            Message message;
                            message = JMSDemoActivity.session.createTextMessage(textMsg);
                            message.setStringProperty("turn_left"+textMsg, "");
                            producer.send(message);
                            producer.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JMSDemoActivity.dispatchQueue.dispatchAsync(new Runnable() {
                    public void run() {
                        try {
                            MessageProducer producer = JMSDemoActivity.session.createProducer(JMSDemoActivity.getDestination(JMSDemoActivity.destinationText.getText().toString()));
                            Message message;
                            message = JMSDemoActivity.session.createTextMessage(textMsg);
                            message.setStringProperty("turn_right"+textMsg, "");
                            producer.send(message);
                            producer.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btn_top.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JMSDemoActivity.dispatchQueue.dispatchAsync(new Runnable() {
                    public void run() {
                        try {
                            MessageProducer producer = JMSDemoActivity.session.createProducer(JMSDemoActivity.getDestination(JMSDemoActivity.destinationText.getText().toString()));
                            Message message;
                            message = JMSDemoActivity.session.createTextMessage(textMsg);
                            message.setStringProperty("turn_top"+textMsg, "");
                            producer.send(message);
                            producer.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btn_bottom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JMSDemoActivity.dispatchQueue.dispatchAsync(new Runnable() {
                    public void run() {
                        try {
                            MessageProducer producer = JMSDemoActivity.session.createProducer(JMSDemoActivity.getDestination(JMSDemoActivity.destinationText.getText().toString()));
                            Message message;
                            message = JMSDemoActivity.session.createTextMessage(textMsg);
                            message.setStringProperty("turn_bottom"+textMsg, "");
                            producer.send(message);
                            producer.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
