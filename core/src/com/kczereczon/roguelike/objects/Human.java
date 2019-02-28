package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Human extends Existence {


    public Human(World world, Texture texture, int health, int mass, String name) {
        super(texture, health, mass, name);
        physics = new Physics(world, BodyDef.BodyType.DynamicBody, this);
    }
}
