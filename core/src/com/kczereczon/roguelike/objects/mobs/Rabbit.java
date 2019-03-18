package com.kczereczon.roguelike.objects.mobs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.config.ScreenConfig;
import com.kczereczon.roguelike.objects.Existence;

public class Rabbit extends Existence {

    float moveTimer, moveDelay;

    public Rabbit(World world, Texture rabbitTexture, Vector2 position) {
        super(world, BodyDef.BodyType.DynamicBody, rabbitTexture, "Rabbit");
        resetTimer();
        getBody().setTransform(position.x / ScreenConfig.PPM, position.y / ScreenConfig.PPM,0);
        System.out.println("XD");
    }

    @Override
    public void movement(float delta) {
        super.movement(delta);
        if(moveTimer > moveDelay) {
            getBody().applyLinearImpulse(new Vector2(MathUtils.random(-5, 5) , MathUtils.random(-5, 5)), getBody().getWorldCenter(),true);
            resetTimer();
        } else {
            moveTimer += delta;
        }
    }

    public void resetTimer() {
        moveTimer = 0;
        moveDelay = MathUtils.random(2f, 5f);
    }
}
