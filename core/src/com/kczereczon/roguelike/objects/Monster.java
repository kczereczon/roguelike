package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

public class Monster extends Existence {

    public float moveTimer;
    public float moveLimiter;
    public Random rand = new Random();


    public Monster(World world, Texture texture, int health, int mass, String name) {
        super(texture, health, mass, name);
        physics = new Physics(world, BodyDef.BodyType.DynamicBody, this);
        resetMoveTimer(2, 4);
    }

    @Override
    public void movement(float delta) {
        if(shouldMove()){
            move();
        } else {
            moveTimer += delta;
        }

    }

    public boolean shouldMove() {
        if(moveTimer >= moveLimiter) {
            resetMoveTimer(2, 4);
            return true;
        }
        return false;
    }

    public void resetMoveTimer(int min, int max) {
        moveTimer = 0;
        moveLimiter = getRandInt(min, max);
    }

    public int getRandInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public void move() {
        Vector2 randomVector = new Vector2().setToRandomDirection();
        this.translate(randomVector.x * 10, randomVector.y * 10);
    }
}
