package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Existence {

    public Player(World world) {
        super(world, BodyDef.BodyType.DynamicBody, new Texture("hero.png"), "Dovakin");
    }

    @Override
    public void movement(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            getBody().applyForceToCenter(new Vector2(20, 0), true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            getBody().applyForce(new Vector2(-20, 0),getBody().getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            getBody().applyForce(new Vector2(0, 20),getBody().getPosition(), true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            getBody().applyForce(new Vector2(0, -20),getBody().getPosition(), true);
        }

    }

}
