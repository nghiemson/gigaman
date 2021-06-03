package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vn.sonnl.gigaman.helpers.Constants;

public class GameOver {
    public final Viewport viewport;
    final BitmapFont font;
    long startTime;

    public GameOver() {
        this.viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(1);
    }

    public void init() {
        startTime = TimeUtils.nanoTime();

    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        //Draw a game over message
        font.draw(batch,
                Constants.GAME_OVER_MESSAGE,
                viewport.getWorldWidth() / 2,
                viewport.getWorldHeight() / 2.5f, 0,
                Align.center,
                false);

        batch.end();

    }
}
