package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Physics {

    public Body body;
    Fixture fixture;

    public Physics(World world, BodyDef.BodyType bodyType, Sprite sprite) {
        body = createBody(world, bodyType, sprite);
        fixture = createFixture(world, sprite);

    }

    private Body createBody(World world, BodyDef.BodyType bodyType, Sprite sprite) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
       // bodyDef.position.(sprite.getX() - sprite.getWidth()/2, sprite.getY() + sprite.getHeight());
        return  world.createBody(bodyDef);
    }

    private Fixture createFixture(World world, Sprite sprite) {
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        return body.createFixture(fixtureDef);
    }


}
