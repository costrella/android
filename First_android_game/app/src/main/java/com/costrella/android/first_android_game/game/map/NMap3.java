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
		numOfObject = 4;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(10, 350, 700, 400, world);//top
        gameObjectArray[1] = new Wall(10, 580, 700, 630, world);//bottom

        gameObjectArray[2] = new Wall(10, 400, 30, 580, world);//left
        gameObjectArray[3] = new Wall(700, 400, 730, 580, world);//right
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
