package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Monster extends Existence {

    public float moveTimer;
    public float moveLimiter;
    public Random rand;



    public Monster(Texture texture, int health, int mass, String name) {
        super(texture, health, mass, name);
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
        if(moveTimer >= moveTimer) {
            resetMoveTimer(2, 4);
            return true;
        }
        return false;
    }

    public void resetMoveTimer(int min, int max) {
        moveTimer = 0;
        moveLimiter = rand.nextInt((max - min) + 1) + min;
    }

    public void move() {
        Vector2 randomVector = new Vector2().setToRandomDirection();
        this.translate(randomVector.x * 10, randomVector.y * 10);
    }
}
