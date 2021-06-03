/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.helpers.Constants;

public class Winning {
    public final Viewport viewport;
    final BitmapFont font;
    Array<Burst> bursts;

    public Winning() {
        this.viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(1);
    }

    public void init() {
        bursts = new Array<>(Constants.BURST_COUNT);

        // TODO: Fill the explosions array with explosions at random locations within the viewport
        // Also, set the offset of each explosion to a random float from 0 -- Constants.LEVEL_END_DURATION

        for (int i = 0; i < Constants.BURST_COUNT; i++) {


            Burst burst = new Burst(new Vector2(
                    MathUtils.random(viewport.getWorldWidth()),
                    MathUtils.random(viewport.getWorldHeight())
            ));
            burst.offset = MathUtils.random(Constants.LEVEL_END_DURATION);

            bursts.add(burst);
        }
    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        //Render the explosions/fireworks
        for (Burst burst : bursts){
            burst.render(batch);
        }
        //Draw a victory message
        font.draw(
                batch,
                Constants.WINNING_MESSAGE,
                viewport.getWorldWidth() / 2,
                viewport.getWorldHeight() / 2.5f,
                0, Align.center,
                false);

        batch.end();

    }
}
*/
