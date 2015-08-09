package com.costrella.android.first_android_game.game.map;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.costrella.android.first_android_game.game.object.GameObject;
import com.costrella.android.first_android_game.game.object.Wall;

import org.jbox2d.dynamics.World;

public class NMap4 extends GameMap {

	private GameObject gameObjectArray[];
	private int numOfObject;

	public NMap4(World world){
		numOfObject = 6;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(0, 0, 300, 20, world);
        gameObjectArray[1] = new Wall(0, 0, 20, 300, world);
        gameObjectArray[2] = new Wall(0, 300, 300, 320, world);
        gameObjectArray[3] = new Wall(300, 0, 320, 300, world);
        gameObjectArray[4] = new Wall(100, 100, 120, 300, world);
        gameObjectArray[5] = new Wall(200, 0, 220, 200, world);
	}
	
	@Override
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.GREEN);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}

}
