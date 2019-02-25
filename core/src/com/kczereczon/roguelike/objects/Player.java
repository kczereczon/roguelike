package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Existance {

    public Player() {
        super(new Texture("hero.png"), 100, "Dovakin");
    }

    @Override
    public void movement() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setPosition(getX()+1, getY());
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            setPosition(getX()-1, getY());
        }
    }

}
