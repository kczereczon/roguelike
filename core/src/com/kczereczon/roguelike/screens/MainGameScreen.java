package com.kczereczon.roguelike.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.kczereczon.roguelike.RoguelikeGame;
import com.kczereczon.roguelike.objects.Player;
import com.kczereczon.roguelike.objects.mobs.Rabbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGameScreen implements Screen {

    final RoguelikeGame game;
    OrthographicCamera camera;

    Player player;

    List<Rabbit> rabbits = new ArrayList<Rabbit>();

    public MainGameScreen(final RoguelikeGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        player = new Player();

        for (int i = 0; i < 10; i++) {
            rabbits.add(new Rabbit());
        }
    }

    @Override
    public void show() {

    }

    public void update(float delta) {
        player.update(delta);

        System.out.println(new Vector2(player.getX(), player.getY()));
        System.out.println(camera.position);
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
        player.draw(game.batch);
        for (Rabbit rabbit: rabbits
        ) {
            rabbit.draw(game.batch);
        }
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

    }
}
