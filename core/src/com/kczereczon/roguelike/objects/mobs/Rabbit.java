package com.kczereczon.roguelike.objects.mobs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.kczereczon.roguelike.objects.Monster;

public class Rabbit extends Monster {

    public Rabbit() {
        super(new Texture("rabbit.gif"), 100, 6, "Rabbit");
        setPosition(getRandInt(0, 800), getRandInt(0,480));
        System.out.println("Created: " + new Vector2(getX(), getY()));
    }
    public Rabbit(Vector2 position) {
        super(new Texture("rabbit.gif"), 100, 6, "Rabbit");
        setPosition(position.x, position.y);
    }

}
