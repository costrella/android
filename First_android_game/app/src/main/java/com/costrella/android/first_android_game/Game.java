package com.costrella.android.first_android_game;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.costrella.android.first_android_game.game.map.GameMap;
import com.costrella.android.first_android_game.game.map.NMap0;
import com.costrella.android.first_android_game.game.map.NMap1;
import com.costrella.android.first_android_game.game.map.NMap2;
import com.costrella.android.first_android_game.game.map.NMap3;
import com.costrella.android.first_android_game.game.object.Monster1;
import com.costrella.android.first_android_game.game.object.Pillar;
import com.costrella.android.first_android_game.game.object.Pillar2;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.ShapeType;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
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
    private Pillar player;
    private Pillar2 finish, pillar3, pillar4;
    private Monster1 monster;
    private GameMap map;
    private int _stage;
    private Context _context;

    private void goToLevel(int _stage) {
        world = new World(worldAABB, gravity, doSleep);
        if (_stage == 1) start1Level();
        if (_stage == 2) start2Level();
        if (_stage == 3) start3Level();
        if (_stage == 4) start4Level();
        world.setListener(collisionDetection);
    }

    public ContactListener collisionDetection = new ContactListener() {
        @Override
        public void add(ContactPoint arg0) {
            // TODO Auto-generated method stub
            Body body1 = arg0.shape1.getBody();
            Body body2 = arg0.shape2.getBody();

            //1 - circle
            if ((body1.getShapeList().getType() == ShapeType.CIRCLE_SHAPE)) {
                _stage = _stage + 1;
                if (_stage == 5)
                    new AlertDialog.Builder(_context)
                            .setTitle("Android game").setMessage("You Win!!")
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    }).show();
                goToLevel(_stage);
            } else if ((body1.getShapeList().getType() == ShapeType.POLYGON_SHAPE)) {
                new AlertDialog.Builder(_context)
                        .setTitle("Android game").setMessage("AJJ!!!")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        goToLevel(_stage);
                                    }
                                }).show();
            }

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

        goToLevel(_stage);

        world.setListener(collisionDetection);
    }

    private void start1Level() {

        player = new Pillar(70, 440, 15, world);

        finish = new Pillar2(500, 500, 25, Color.BLACK, world);

        pillar3 = new Pillar2(250, 410, 10, Color.GRAY, world);
        pillar4 = new Pillar2(4500, 200, 50, Color.MAGENTA, world);

        map = new NMap0(world);
    }

    private void start2Level() {

        player = new Pillar(70, 440, 15, world);

        finish = new Pillar2(300, 500, 25, Color.BLACK, world);

        pillar3 = new Pillar2(250, 410, 10, Color.GRAY, world);
        pillar4 = new Pillar2(4500, 200, 50, Color.MAGENTA, world);

        map = new NMap1(world);
    }

    private void start3Level() {

        player = new Pillar(70, 440, 15, world);

        finish = new Pillar2(300, 500, 25, Color.BLACK, world);

        pillar3 = new Pillar2(250, 410, 10, Color.GRAY, world);
        pillar4 = new Pillar2(4500, 200, 50, Color.MAGENTA, world);

        map = new NMap2(world);
    }

    private void start4Level() {

        player = new Pillar(70, 440, 15, world);

        finish = new Pillar2(300, 500, 25, Color.BLACK, world);

        pillar3 = new Pillar2(250, 410, 10, Color.GRAY, world);
        pillar4 = new Pillar2(4500, 200, 50, Color.MAGENTA, world);

        map = new NMap3(world);
    }

    public void positionUpdate(float sensorX, float sensorY) {
        player.update(sensorX, sensorY);
    }

    public void update() {
        world.step(timeStep, iterations);
    }

    public void draw(Canvas canvas, Resources resources) {
        canvas.translate(200 - player.x, 200 - player.y);
        map.draw(canvas, resources);
        player.draw(canvas, resources);
        finish.draw(canvas);
        pillar3.draw(canvas);
        pillar4.draw(canvas);
    }
}
