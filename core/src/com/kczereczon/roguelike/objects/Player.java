package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Human {


    public Player() {
        super(new Texture("hero.png"), 100, 50, "Dovakin");
    }

    @Override
    public void movement(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            translateX(10);
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            translateX(-10);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            translateY(10);
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            translateY(-10);
        }

    }

}
