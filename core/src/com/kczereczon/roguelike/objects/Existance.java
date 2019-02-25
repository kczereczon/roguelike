package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Existance extends Sprite {

    String name;
    int health = 0;

    public Existance(Texture texture, int health, String name) {
        super(texture);
        this.health = health;
        this.name = name;
    }

    public void movement() {

    }

    public void update() {
        movement();
    }

}
