package com.kczereczon.roguelike.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kczereczon.roguelike.RoguelikeGame;
import com.kczereczon.roguelike.objects.Player;
import com.kczereczon.roguelike.objects.mobs.Rabbit;

import java.util.ArrayList;
import java.util.List;

public class MainGameScreen implements Screen {

    final RoguelikeGame game;
    OrthographicCamera camera;
    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    public World world;

    Player player;

    List<Rabbit> rabbits = new ArrayList<Rabbit>();

    public MainGameScreen(final RoguelikeGame game) {
        this.game = game;
        world = new World(new Vector2(0,0), true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800/2, 600/2);

        player = new Player(world);

        for (int i = 0; i < 10; i++) {
            rabbits.add(new Rabbit(world));
        }
    }

    @Override
    public void show() {

    }

    public void update(float delta) {
        player.update(delta);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        camera.position.set(new Vector3(player.getX(), player.getY(), 0));
        camera.update();
        for (Rabbit rabbit: rabbits
             ) {
            rabbit.update(delta);
        }
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);

        game.batch.begin();
        game.batch.draw(player, player.physics.body.getPosition().x, player.physics.body.getPosition().y);
        for (Rabbit rabbit: rabbits
        ) {
            game.batch.draw(rabbit, rabbit.physics.body.getPosition().x, rabbit.physics.body.getPosition().y);
        }
        debugRenderer.render(world, camera.combined);
        game.batch.end();
        game.batch.setProjectionMatrix(camera.combined);

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
        world.dispose();
    }
}
