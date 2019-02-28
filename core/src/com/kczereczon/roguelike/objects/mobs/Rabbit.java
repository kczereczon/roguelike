package com.kczereczon.roguelike.objects.mobs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.objects.Monster;

public class Rabbit extends Monster {

    public Rabbit(World world) {
        super(world, new Texture("rabbit.gif"), 100, 6, "Rabbit");
        physics.body.setTransform(getRandInt(-400, 400), getRandInt(-240,240),0);
        System.out.println("Created: " + new Vector2(getX(), getY()));
    }
    public Rabbit(World world, Vector2 position) {
        super(world, new Texture("rabbit.gif"), 100, 6, "Rabbit");
        setPosition(position.x, position.y);
    }

}
