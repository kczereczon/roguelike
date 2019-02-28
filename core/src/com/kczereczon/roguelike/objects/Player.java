package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Human {

    public Player(World world) {
        super(world, new Texture("hero.gif"), 100, 50, "Dovakin");
        physics.body.setFixedRotation(true);
    }

    @Override
    public void movement(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            physics.body.applyForceToCenter(new Vector2(100000, 0), true);
            System.out.println(physics.body.linVelLoc);
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            physics.body.applyForce(new Vector2(-100000, 0),physics.body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            physics.body.applyForce(new Vector2(0, 100000),physics.body.getPosition(), false);
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            physics.body.applyForce(new Vector2(0, -100000),physics.body.getPosition(), false);
        }

    }

}
