package com.costrella.android.first_android_game.game.object;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import org.jbox2d.collision.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class Wall extends GameObject{
	public float left;
	public float top;
	public float right;
	public float bottom;
	
	private Body body;
	
	public void draw(Canvas canvas, Resources resources){		
		Paint mPaint = new Paint();
		
		// Flame
//		Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.lava);
        Bitmap bitmap = null;
		RectF rect = new RectF(left, top, right, bottom);
		
		canvas.drawBitmap(bitmap, null, rect, mPaint);	
	}
	
	public Wall(float initLeft, float initTop, float initRight, float initBottom, World physicsWorld){
		left = initLeft;
		top = initTop;
		right = initRight;
		bottom = initBottom;

		PolygonDef shape = new PolygonDef();	
		shape.density = 0.1f;  
		shape.friction = 0.0f;  	
		shape.setAsBox((float)(initRight - initLeft)/2.0f, (float)(initBottom - initTop)/2.0f);
		
		  
		BodyDef bodyDef = new BodyDef();  
		bodyDef.position.set((float)(initRight + initLeft)/2.0f, (float)(initBottom + initTop)/2.0f);
		
		body = physicsWorld.createStaticBody(bodyDef);
		body.createShape(shape);  
		body.setMassFromShapes();	 
	}

	@Override
	public void horizontalTranslation(int initX, int endX, float speedIndex) {
		// TODO Auto-generated method stub
		// Dummy
	}
}
