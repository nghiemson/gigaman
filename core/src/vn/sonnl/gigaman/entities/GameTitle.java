package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;

public class GameTitle extends Actor {

    private Rectangle bounds;
    private BitmapFont font;

    public GameTitle(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = Assets.getLargeFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, Constants.GAME_NAME, bounds.x, bounds.y, bounds.width, 5,true);
    }

}
