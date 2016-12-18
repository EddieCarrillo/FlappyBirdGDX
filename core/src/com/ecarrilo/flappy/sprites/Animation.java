package com.ecarrilo.flappy.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by ecarrillo on 12/17/16.
 */
public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime){
        //The different animation pictures (3 for flappy bird)
        frames = new Array<TextureRegion>();
        //The image that holds all the animation images / # of images
        int frameWidth = (region.getRegionWidth() / frameCount);
        //Cutting the texture region into pieces
        for (int i = 0 ; i < frameCount; i++){
            frames.add(new TextureRegion(region, i* frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        //This is the most time each animation frame will recieve
        maxFrameTime = cycleTime / frameCount ;
        //Start with the first animation
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime +=dt;
        if (currentFrameTime > maxFrameTime){
            frame++;
            //Reset time counter
            currentFrameTime = 0;
        }
        if (frame >= frameCount){
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
