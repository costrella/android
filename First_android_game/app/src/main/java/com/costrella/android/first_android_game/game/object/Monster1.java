package com.costrella.android.first_android_game.game.object;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import com.costrella.android.first_android_game.R;

import org.jbox2d.collision.CircleDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class Monster1{
    public float x;
    public float y;
    private float radius;
    private boolean sensorInitial = true;
    private float xSensorInitial = 0;
    private float ySensorInitial = 0;
    private Body body;
    private Vec2 force = new Vec2(0, 0);
    private Vec2 point;
    private Vec2 pointOld = new Vec2(0, 0);
    private Movie mMovie;
    private long start;
	
	public void draw(Canvas canvas, Resources resources){
        Paint mPaint = new Paint();
        int duration;
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);

        //canvas.drawCircle(x, y, radius, mPaint);

        // GIF animation part
        try{
            if(mMovie == null){
                mMovie = Movie.decodeStream(resources.openRawResource(R.drawable.kingusuraimu));
//                mMovie = null;
                start = android.os.SystemClock.uptimeMillis();
                Log.d("Game", "Movie success");
            }

            duration = mMovie.duration();

            if(duration == 0){
                duration = 1000;
            }

            mMovie.setTime((int)(android.os.SystemClock.uptimeMillis() - start)%duration);
            mMovie.draw(canvas, x - mMovie.width()/2, y - mMovie.height()/2);
        }catch (Exception e) {
            Log.d("Game","Movie exception: "+e.toString());
        }

	}
	
	public Monster1(float _x, float _y, float _radius, World _world){
        x = _x;
        y = _y;
        radius = _radius;
        CircleDef shape = new CircleDef();
        shape.density = 0.1f;
        shape.friction = 0.0f;
        shape.radius = radius;
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x, y);
        body = _world.createDynamicBody(bodyDef);
        body.createShape(shape);
        body.setMassFromShapes();
	}
	

}
