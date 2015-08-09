package com.costrella.android.first_android_game.game.map;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.costrella.android.first_android_game.game.object.GameObject;
import com.costrella.android.first_android_game.game.object.Wall;

import org.jbox2d.dynamics.World;

public class NMap2 extends GameMap {

	private GameObject gameObjectArray[];
	private int numOfObject;

	public NMap2(World world){
		numOfObject = 8;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(0, 0, 200, 20, world);
        gameObjectArray[1] = new Wall(0, 0, 20, 400, world);
        gameObjectArray[2] = new Wall(200, 0, 220, 300, world);
        gameObjectArray[3] = new Wall(200, 300, 600, 320, world);
        gameObjectArray[4] = new Wall(0, 400, 500, 420, world);
        gameObjectArray[5] = new Wall(500, 400, 520, 600, world);
        gameObjectArray[6] = new Wall(600, 300, 620, 600, world);
        gameObjectArray[7] = new Wall(500, 600, 600, 620, world);
	}
	
	@Override
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.RED);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}

}
