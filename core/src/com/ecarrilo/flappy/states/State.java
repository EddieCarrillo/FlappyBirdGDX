package com.ecarrilo.flappy.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by ecarrillo on 12/17/16.
 */
public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3  mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        this.mouse = new Vector3();
        this.cam = new OrthographicCamera();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render (SpriteBatch sb);
    public abstract void dispose();

}
