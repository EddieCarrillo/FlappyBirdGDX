package com.ecarrilo.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by ecarrillo on 12/17/16.
 */
public class Tube {
    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Texture topTube, bottomTube;
    private Vector2 postTopTube, posBotTube;
    private Rectangle boundsTop, boundsBotton;

    private Random rand;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();

        postTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP  + LOWEST_OPENING);
        posBotTube = new Vector2(x, postTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(postTopTube.x, postTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBotton = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());

    }



    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPostTopTube() {
        return postTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void reposition(float x){
        postTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP  + LOWEST_OPENING);
        posBotTube.set(x, postTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(postTopTube.x, postTopTube.y);
        boundsBotton.setPosition(posBotTube.x, posBotTube.y);

    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBotton);
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
