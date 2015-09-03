package com.costrella.android.first_android_game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mike on 2015-08-08.
 */

public class GameActivity extends Activity {

    private Game game;
    private GameView gameView;
    private SensorManager mSensorManager;
    private Handler mHandler;
    private WindowManager mWindowManager;
    private Display mDisplay;

    AlertDialog alertDialog = null;

    private Runnable update = new Runnable() {
        public void run() {
            game.update();
            gameView.postInvalidate();
            mHandler.postDelayed(update, (long) game.timeStep * 1000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //System.out.println("test begin:");
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mDisplay = mWindowManager.getDefaultDisplay();

        Integer level = (Integer) getIntent().getSerializableExtra("level");
        initialize(level);
    }

    protected void initialize(int stage) {
        game = new Game(stage, this);
        gameView = new GameView(this);
        setContentView(gameView);
        mHandler = new Handler();
        mHandler.post(update);
    }


    class GameView extends View implements SensorEventListener {

        private Sensor mAccelerometer;

        public GameView(Context context) {
            super(context);
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            this.startSimulation();
        }

        public void startSimulation() {
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
        }

        public void stopSimulation() {
            mSensorManager.unregisterListener(this);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {

            float mSensorX = 0;
            float mSensorY = 0;

            // TODO Auto-generated method stub
            //System.out.println("test seonsor changed");
            if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
                return;

            switch (mDisplay.getRotation()) {
                case Surface.ROTATION_0:
                    mSensorX = -event.values[0];
                    mSensorY = event.values[1];
                    break;
                case Surface.ROTATION_90:
                    mSensorX = event.values[1];
                    mSensorY = event.values[0];
                    break;
                case Surface.ROTATION_180:
                    mSensorX = event.values[0];
                    mSensorY = -event.values[1];
                    break;
                case Surface.ROTATION_270:
                    mSensorX = -event.values[1];
                    mSensorY = -event.values[0];
                    break;
            }
            game.positionUpdate(mSensorX, mSensorY);

        }

        @Override
        protected void onDraw(Canvas canvas) {

            game.draw(canvas, getResources());

        }
    }


}
