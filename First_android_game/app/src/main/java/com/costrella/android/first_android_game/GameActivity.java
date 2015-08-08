package com.costrella.android.first_android_game;

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

public class GameActivity extends MyActivity {

    private Game game;
    private GameView gameView;
    private SensorManager mSensorManager;
    private Handler mHandler;
    private WindowManager mWindowManager;
    private Display mDisplay;
    private boolean gameStart = false;

    AlertDialog alertDialog = null;

    private Runnable update = new Runnable() {
        public void run() {
            game.update();
            gameView.postInvalidate();
//            mHandler.postDelayed(update, (long)game.timeStep*1000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //System.out.println("test begin:");
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mDisplay = mWindowManager.getDefaultDisplay();

        Integer level = (Integer)getIntent().getSerializableExtra("level");
        initialize(level);
        gameStart = true;
    }

    protected void initialize(int stage) {
        game = new Game(stage, this);
        gameView = new GameView(this);
        setContentView(gameView);
        mHandler = new Handler();
        mHandler.post(update);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
         * when the activity is resumed, we acquire a wake-lock so that the
         * screen stays on, since the user will likely not be fiddling with the
         * screen or buttons.
         */
        //mWakeLock.acquire();

        // Start the simulation
        if (gameStart) gameView.startSimulation();

//        bgmManager.setBGM(this, R.raw.playing);
        bgmManager.play();
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
         * When the activity is paused, we make sure to stop the simulation,
         * release our sensor resources and wake locks
         */

        // Stop the simulation
        if (gameStart) gameView.stopSimulation();

        // and release our wake-lock
        //mWakeLock.release();

//
//        bgmManager.setBGM(this, R.raw.main);
        bgmManager.play();
    }

    class GameView extends View implements SensorEventListener {

        private Sensor mAccelerometer;

        public GameView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            this.startSimulation();
        }

        public void startSimulation() {
            /*
             * It is not necessary to get accelerometer events at a very high
             * rate, by using a slower rate (SENSOR_DELAY_UI), we get an
             * automatic low-pass filter, which "extracts" the gravity component
             * of the acceleration. As an added benefit, we use less power and
             * CPU resources.
             */
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
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
            /*
             * record the accelerometer data, the event's timestamp as well as
             * the current time. The latter is needed so we can calculate the
             * "present" time during rendering. In this application, we need to
             * take into account how the screen is rotated with respect to the
             * sensors (which always return data in a coordinate space aligned
             * to with the screen in its native orientation).
             */

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

            //super.onDraw(canvas);
            //this.canvas = canvas;

            game.draw(canvas, getResources());

        }
    }



}
