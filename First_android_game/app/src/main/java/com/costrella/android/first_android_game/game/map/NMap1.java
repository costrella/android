package com.costrella.android.first_android_game.game.map;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.costrella.android.first_android_game.game.object.GameObject;
import com.costrella.android.first_android_game.game.object.Wall;

import org.jbox2d.dynamics.World;

public class NMap1 extends GameMap {

	private GameObject gameObjectArray[];
	private int numOfObject;

	public NMap1(World world){
		numOfObject = 5;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(0, 0, 300, 20, world);
        gameObjectArray[1] = new Wall(0, 0, 20, 400, world);
        gameObjectArray[2] = new Wall(300, 0, 320, 400, world);
        gameObjectArray[3] = new Wall(0, 400, 300, 420, world);
        gameObjectArray[4] = new Wall(200, 0, 220, 300, world);
	}
	
	@Override
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
//		canvas.drawColor(Color.RED);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}

}
