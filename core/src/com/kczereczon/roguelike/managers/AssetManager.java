package com.kczereczon.roguelike.managers;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    private Texture playerTexture = new Texture("Player.png");
    private Texture enemyTexture = new Texture("Enemy.png");

    public Texture getEnemyTexture() {
        return enemyTexture;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public void dispose() {
        playerTexture.dispose();
        enemyTexture.dispose();
    }
}
