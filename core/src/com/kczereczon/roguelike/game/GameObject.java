package com.kczereczon.roguelike.game;

public class GameObject {

    private String gameObjectName = "gameobject";
    private String getGameObjectTag = "tag";

    public GameObject(String objectName, String tag) {
        setGameObjectName(objectName);
        setGetGameObjectTag(tag);
    }

    public String getGameObjectName() {
        return gameObjectName;
    }

    public void setGameObjectName(String gameObjectName) {
        this.gameObjectName = gameObjectName;
    }

    public String getGetGameObjectTag() {
        return getGameObjectTag;
    }

    public void setGetGameObjectTag(String getGameObjectTag) {
        this.getGameObjectTag = getGameObjectTag;
    }
}
