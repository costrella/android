package com.costrella.android.first_android_game.game.map;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.costrella.android.first_android_game.game.object.GameObject;
import com.costrella.android.first_android_game.game.object.Wall;

import org.jbox2d.dynamics.World;

public class NMap3 extends GameMap {

	private GameObject gameObjectArray[];
	private int numOfObject;

	public NMap3(World world){
		numOfObject = 11;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(0, 200, 20, 300, world);
        gameObjectArray[1] = new Wall(0, 300, 200, 320, world);
        gameObjectArray[2] = new Wall(0, 200, 100, 220, world);
        gameObjectArray[3] = new Wall(100, 0, 120, 200, world);
        gameObjectArray[4] = new Wall(100, 0, 400, 20, world);
        gameObjectArray[5] = new Wall(200, 100, 220, 300, world);
        gameObjectArray[6] = new Wall(200, 100, 300, 220, world);
        gameObjectArray[7] = new Wall(400, 0, 420, 300, world);
        gameObjectArray[8] = new Wall(300, 100, 320, 200, world);
        gameObjectArray[9] = new Wall(200, 200, 300, 220, world);
        gameObjectArray[10] = new Wall(200, 300, 400, 320, world);

	}
	
	@Override
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.YELLOW);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}

}
