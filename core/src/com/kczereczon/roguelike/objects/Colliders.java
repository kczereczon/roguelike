package com.kczereczon.roguelike.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.kczereczon.roguelike.config.ScreenConfig;

public class Colliders {

    Body body;
    Fixture fixture;
    private Vector2 bodySize;

    public Colliders(World world, MapObject collider){
        body = createBody(world, BodyDef.BodyType.StaticBody);
        fixture = createFixture(world, collider);

        body.setLinearDamping(2);
        body.setFixedRotation(true);
        body.setTransform((collider.getProperties().get("x", Float.class) + collider.getProperties().get("width", Float.class)/2) / ScreenConfig.PPM , (collider.getProperties().get("y", Float.class) + collider.getProperties().get("height", Float.class)/2) / ScreenConfig.PPM, 0);
        System.out.println(body.getPosition());
    }

    private Body createBody(World world, BodyDef.BodyType bodyType) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        //bodyDef.position.set(sprite.getWidth() / ScreenConfig.PPM, sprite.getHeight()/ScreenConfig.PPM);
        return  world.createBody(bodyDef);
    }

    private Fixture createFixture(World world, MapObject collider) {
        PolygonShape shape = new PolygonShape();

        bodySize = new Vector2(collider.getProperties().get("width", Float.class) / ScreenConfig.PPM / 2, collider.getProperties().get("height", Float.class) / ScreenConfig.PPM / 2);

        shape.setAsBox(bodySize.x, bodySize.y);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;



        return body.createFixture(fixtureDef);
    }
}
