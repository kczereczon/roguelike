package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.kczereczon.roguelike.config.ScreenConfig;

class Physics {

    Body body;
    Fixture fixture;
    private Vector2 bodySize;

    public Physics(World world, BodyDef.BodyType bodyType, Sprite sprite) {
        body = createBody(world, bodyType, sprite);
        fixture = createFixture(world, sprite);

        body.setLinearDamping(5);
        body.setFixedRotation(true);
    }

    private Body createBody(World world, BodyDef.BodyType bodyType, Sprite sprite) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        //bodyDef.position.set(sprite.getWidth() / ScreenConfig.PPM, sprite.getHeight()/ScreenConfig.PPM);
        return  world.createBody(bodyDef);
    }

    private Fixture createFixture(World world, Sprite sprite) {
        PolygonShape shape = new PolygonShape();

        bodySize = new Vector2(sprite.getWidth() / ScreenConfig.PPM / 2, sprite.getHeight() / ScreenConfig.PPM / 2);

        shape.setAsBox(bodySize.x, bodySize.y);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;



        return body.createFixture(fixtureDef);
    }

    public Vector2 getBodySize() {
        return bodySize;
    }

    public void updateDamping(float dexterity) {
        body.setLinearDamping(dexterity/2);
    }

}
