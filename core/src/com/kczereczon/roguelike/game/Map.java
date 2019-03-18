package com.kczereczon.roguelike.game;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Disposable;

public class Map implements Disposable {

    private TiledMap tiledMap;
    private MapLayer collidersLayer;
    private MapLayer mobsLayer;

    public Map(String mapName) {
        tiledMap = new TmxMapLoader().load(mapName+".tmx");
        collidersLayer = tiledMap.getLayers().get("colliders");
        mobsLayer = tiledMap.getLayers().get("mobs");
    }

    public void getPlayer() {

    }

    public MapObjects getMobs() {
        return mobsLayer.getObjects();
    }

    public MapObjects getColliders() {
        return collidersLayer.getObjects();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }
}
