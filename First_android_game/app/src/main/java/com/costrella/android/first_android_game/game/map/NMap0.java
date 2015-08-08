package com.costrella.android.first_android_game.game.map;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.costrella.android.first_android_game.game.object.GameObject;
import com.costrella.android.first_android_game.game.object.Wall;

import org.jbox2d.dynamics.World;

public class NMap0 extends GameMap {

	private GameObject gameObjectArray[];
	private int numOfObject;

	public NMap0(World world){
		numOfObject = 1;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(10, 400, 400, 430, world);
	}
	
	@Override
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.RED);
		
		try{
			for(int i=0; i<1; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}

}
