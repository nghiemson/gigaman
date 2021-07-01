package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import vn.sonnl.gigaman.enums.GameState;
import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;

public class PausedLabel  extends Actor {

    private Rectangle bounds;
    private BitmapFont font;

    public PausedLabel(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = Assets.getSmallFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (GameManager.getInstance().getGameState() == GameState.PAUSED) {
            font.draw(batch, Constants.PAUSED_LABEL, bounds.x, bounds.y, bounds.width,
                    -25, true);
        }
    }

}

