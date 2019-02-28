package com.kczereczon.roguelike.objects.mobs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.objects.Existence;

public class Rabbit extends Existence {

    public Rabbit(World world) {
        super(world, BodyDef.BodyType.DynamicBody, new Texture("rabbit.gif"), "Rabbit");
        //getBody().setTransform(R, getRandInt(-240,240),0);
        //System.out.println("Created: " + new Vector2(getX(), getY()));
    }
}
