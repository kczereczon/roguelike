package com.kczereczon.roguelike.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.RoguelikeGame;
import com.kczereczon.roguelike.config.ScreenConfig;
import com.kczereczon.roguelike.game.GameWorld;
import com.kczereczon.roguelike.objects.Player;
import com.kczereczon.roguelike.objects.mobs.Rabbit;

import java.util.ArrayList;
import java.util.List;

public class MainGameScreen implements Screen {

    private final RoguelikeGame game;
    private OrthographicCamera camera;
    private GameWorld gameWorld;

    public MainGameScreen(final RoguelikeGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,
                ScreenConfig.WIDTH / ScreenConfig.PPM * ScreenConfig.WORLD_SCALE,
                ScreenConfig.HEIGHT / ScreenConfig.PPM * ScreenConfig.WORLD_SCALE);

        gameWorld = new GameWorld(this);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        camera.update();
        gameWorld.update(delta);

        game.batch.begin();
        gameWorld.render(game.batch);
        game.batch.end();



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gameWorld.dispose();
    }
}
