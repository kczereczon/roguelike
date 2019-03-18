package com.kczereczon.roguelike.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.managers.GameObjectManager;
import com.kczereczon.roguelike.managers.MapManager;
import com.kczereczon.roguelike.screens.MainGameScreen;

public class GameWorld {

    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private World world;
    private OrthographicCamera camera;

    private MapManager mapManager;
    private GameObjectManager gameObjectManager;

    public GameWorld(MainGameScreen screen) {
        camera = screen.getCamera();

        world = new World(new Vector2(0,0), true);
        mapManager = new MapManager();
        //mapManager.setCurrentMap(new Map("first_map"));
        debugRenderer.render(world, camera.combined);

        gameObjectManager = new GameObjectManager(world);
        gameObjectManager.addColliders(mapManager.getCurrentMap().getColliders());
        gameObjectManager.addMobs(mapManager.getCurrentMap().getMobs());
    }

    public void update(float delta) {
        world.step(1f/60f, 6, 6);
        cameraFollow();
        gameObjectManager.update(delta);
        mapManager.render(camera);
        debugRenderer.render(world,camera.combined);
    }

    public void render(SpriteBatch batch) {
        gameObjectManager.render(batch);


    }

    public void cameraFollow() {
        camera.position.set(gameObjectManager.getPlayer().getBody().getPosition(), 0);
    }

    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
        mapManager.dispose();
        gameObjectManager.dispose();

    }


}
