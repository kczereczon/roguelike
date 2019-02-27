package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Existence extends Sprite {

    private String name;
    private int health = 0;

    public Existence(Texture texture, int health, int mass, String name) {
        super(texture);
        this.health = health;
        this.name = name;
    }

    public void movement(float delta){}

    public void update(float delta) {
        movement(delta);
    }

}
