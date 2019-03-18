package com.kczereczon.roguelike.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.kczereczon.roguelike.objects.Colliders;
import com.kczereczon.roguelike.objects.Player;
import com.kczereczon.roguelike.objects.mobs.Rabbit;

import java.util.ArrayList;
import java.util.List;

public class GameObjectManager implements Disposable {

    AssetManager assetManager = new AssetManager();

    private Player player;
    private List<Rabbit> rabbits = new ArrayList<Rabbit>();

    World world;

    private List<Colliders> colliders = new ArrayList<Colliders>();

    public GameObjectManager(World world) {
        assetManager.load("Player.png", Texture.class);
        assetManager.load("Enemy.png", Texture.class);
        assetManager.finishLoading();

        player = new Player(world, assetManager.get("Player.png", Texture.class));
        this.world = world;
    }

    public void addColliders(MapObjects collidersObject) {
        for (MapObject object: collidersObject
             ) {

            colliders.add(new Colliders(world, object));
        }
    }

    public void addMobs(MapObjects mobsObjects) {
        for (MapObject object: mobsObjects
             ) {
            rabbits.add(new Rabbit(world, assetManager.get("Enemy.png", Texture.class), new Vector2(object.getProperties().get("x", Float.class), object.getProperties().get("y", Float.class))));
        }
    }


    public void update(float delta) {
        player.update(delta);

        for (Rabbit rabbit: rabbits
             ) {
            rabbit.update(delta);
        }
    }

    public void render(SpriteBatch batch) {
        player.draw(batch);
        for (Rabbit rabbit: rabbits
        ) {
            rabbit.draw(batch);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void dispose() {
        assetManager.dispose();
        world.dispose();
    }

}
