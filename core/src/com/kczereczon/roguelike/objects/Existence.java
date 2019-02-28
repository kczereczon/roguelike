package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Existence {

    private String name;

    private int vitality = 0;
    private int strenght = 0;
    private int dexterity = 0;
    private int inteligance = 0;

    private Physics physics;
    private Sprite sprite;

    public Existence(World world, BodyDef.BodyType bodyType, Texture texture, String name) {
        sprite = new Sprite(texture);
        physics = new Physics(world, bodyType, sprite);
        this.name = name;
    }

    public Physics getPhysics() {
        return physics;
    }

    public Body getBody() {
        return physics.body;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Vector2 getFixedPosition() {
        return new Vector2( getBody().getPosition().x - sprite.getWidth()/2, getBody().getPosition().y - sprite.getHeight()/2);
    }

    public void movement(float delta){}

    public void update(float delta) {
        movement(delta);
    }

}
