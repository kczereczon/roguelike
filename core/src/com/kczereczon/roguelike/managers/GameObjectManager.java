package com.kczereczon.roguelike.managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.objects.Player;
import com.kczereczon.roguelike.objects.mobs.Rabbit;

public class GameObjectManager {

    AssetManager assetManager;

    private Player player;
    private Rabbit rabbit;

    public GameObjectManager(World world) {
        assetManager = new AssetManager();
        player = new Player(world, assetManager.getPlayerTexture());
        rabbit = new Rabbit(world);
    }

    public void update(float delta) {
        player.update(delta);
        rabbit.update(delta);
    }

    public void render(SpriteBatch batch) {
        player.draw(batch);
        rabbit.draw(batch);
    }

    public Player getPlayer() {
        return player;
    }

    public void dispose() {
        assetManager.dispose();
    }

}
