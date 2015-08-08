package com.costrella.android.first_android_game.game.object;

import android.content.res.Resources;
import android.graphics.Canvas;

public abstract class GameObject{
	public abstract void draw(Canvas canvas, Resources resources);
	public abstract void horizontalTranslation(int initX, int endX, float speedIndex);
}
