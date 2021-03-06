package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import vn.sonnl.gigaman.box2d.Data;
import vn.sonnl.gigaman.enums.GameState;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;

public abstract class GameActor extends Actor {

    protected Body body;
    protected Data data;
    protected Rectangle screenRectangle;

    public GameActor(Body body) {
        this.body = body;
        this.data = (Data) body.getUserData();
        screenRectangle = new Rectangle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (GameManager.getInstance().getGameState() == GameState.PAUSED) {
            return;
        }

        if (body.getUserData() != null) {
            updateRectangle();
        } else {
            // This means the world destroyed the body (enemy or Gfigaman went out of bounds)
            remove();
        }

    }

    public abstract Data getUserData();

    private void updateRectangle() {
        screenRectangle.x = transformToScreen(body.getPosition().x - data.getWidth() / 2);
        screenRectangle.y = transformToScreen(body.getPosition().y - data.getHeight() / 2);
        screenRectangle.width = transformToScreen(data.getWidth());
        screenRectangle.height = transformToScreen(data.getHeight());
    }

    protected float transformToScreen(float n) {
        return Constants.WORLD_TO_SCREEN * n;
    }

}
