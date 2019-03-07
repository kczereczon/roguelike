package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.config.ScreenConfig;

public class Existence {

    private String name;

    private int vitality = 0;
    private int strenght = 0;
    private int dexterity = 0;
    private int inteligance = 0;

    private Physics physics;
    private Sprite sprite;

    public Existence(World world, BodyDef.BodyType bodyType, Texture texture, String name) {
        sprite = new Sprite(texture, 32,32);
        System.out.println(texture.getTextureData());
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
        return new Vector2(getBody().getPosition().x - getPhysics().getBodySize().x, getBody().getPosition().y - getPhysics().getBodySize().y);
    }

    public Vector2 getFixedSize() {
        return  new Vector2(sprite.getWidth() / ScreenConfig.PPM, sprite.getHeight() / ScreenConfig.PPM);
    }



    public void movement(float delta){}

    public void update(float delta) {
        movement(delta);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(sprite, getFixedPosition().x, getFixedPosition().y, getFixedSize().x, getFixedSize().y);
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }
}
