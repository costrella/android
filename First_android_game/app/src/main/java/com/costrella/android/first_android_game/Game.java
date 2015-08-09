package com.costrella.android.first_android_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.costrella.android.first_android_game.game.map.GameMap;
import com.costrella.android.first_android_game.game.map.NMap0;
import com.costrella.android.first_android_game.game.object.Monster1;
import com.costrella.android.first_android_game.game.object.Pillar;
import com.costrella.android.first_android_game.game.object.Pillar2;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.ContactListener;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.ContactPoint;


public class Game {

    private World world;        //--- var of world
    private AABB worldAABB;
    private Vec2 gravity;
    private boolean doSleep;
    float timeStep;
    int iterations;
    //private Body body;         //-- var of obj
    //private final static int RATE = 10;
    //private float x, y;
    private Pillar pillar;
    private Pillar2 pillar2, pillar3, pillar4;
    private Monster1 monster;
    private GameMap map;
    private int _stage;
    private Context _context;

    public ContactListener collisionDetection = new ContactListener() {
        @Override
        public void add(ContactPoint arg0) {
            // TODO Auto-generated method stub
            Log.i("DOTKNIECIE !Game", "Contact detected");




        }

        @Override
        public void persist(ContactPoint arg0) {
            // TODO Auto-generated method stub
            Log.d("Game", "Contact persisting");
        }

        @Override
        public void remove(ContactPoint arg0) {
            // TODO Auto-generated method stub
            Log.d("Game", "Contact removed");
        }
    };

    void restart() {

    }

    public Game(int stage, Context context) {
        _stage = stage;
        _context = context;
        worldAABB = new AABB();
        worldAABB.lowerBound.set(-1000.0f, -1000.0f);
        worldAABB.upperBound.set(1200.0f, 1200.0f);
        gravity = new Vec2(0.0f, 0.0f);
        doSleep = true;
        timeStep = 1.0f / 60.0f;
        iterations = 10;
        world = new World(worldAABB, gravity, doSleep);
        pillar = new Pillar(30, 420, 15, world);

        pillar2 = new Pillar2(100, 500, 25, Color.RED, world);
        pillar3 = new Pillar2(250, 410, 10, Color.GRAY, world);
        pillar4 = new Pillar2(4500, 200, 50, Color.MAGENTA, world);
        monster = new Monster1(600, 400, 40, world);

//		if (stage == 1) map = new Map1(world);
//		if (stage == 2) map = new Map2(world);
//		if (stage == 3) map = new Map3(world);
//		if (stage == 4) map = new Map4(world);
        map = new NMap0(world);
        world.setListener(collisionDetection);
    }

    public void positionUpdate(float sensorX, float sensorY) {
        pillar.update(sensorX, sensorY);
    }

    public void update() {
        world.step(timeStep, iterations);

        //pillar.update();
        //pillar2.x = pillar2.body.getPosition().x;
        //pillar2.y = pillar2.body.getPosition().y;
    }

    public void draw(Canvas canvas, Resources resources) {
        canvas.translate(200 - pillar.x, 200 - pillar.y);
        map.draw(canvas, resources);
        pillar.draw(canvas, resources);
        pillar2.draw(canvas);
        pillar3.draw(canvas);
        pillar4.draw(canvas);
        monster.draw(canvas, resources);
    }
}
