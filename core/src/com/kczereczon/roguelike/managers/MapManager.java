package com.kczereczon.roguelike.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.kczereczon.roguelike.config.ScreenConfig;
import com.kczereczon.roguelike.game.Map;
import javafx.scene.Camera;

import java.util.List;

public class MapManager implements Disposable {

    private Map currentMap = new Map("first_map");
    TiledMapRenderer tiledMapRenderer;

    public MapManager() {
        tiledMapRenderer = new OrthogonalTiledMapRenderer(currentMap.getTiledMap(), 1f/ScreenConfig.PPM);
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void render(OrthographicCamera camera) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap.dispose();
        this.currentMap = currentMap;
    }

    @Override
    public void dispose() {
        this.currentMap.dispose();
    }
}
