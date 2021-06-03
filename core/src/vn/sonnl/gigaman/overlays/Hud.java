/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.helpers.Utils;

public class Hud  {
    public final Viewport viewport;
    private final BitmapFont font;

    public Hud() {

        viewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);


        if(GameManager.getInstance().gameStartedFromMainMenu){
            GameManager.getInstance().gameStartedFromMainMenu = false;
            GameManager.getInstance().score = 0;
            GameManager.getInstance().lives = 3;
        }

        font = new BitmapFont();
        font.getData().setScale(1);
    }

    public void render(SpriteBatch batch, int lives, int bullet, int score) {

        viewport.apply();

        batch.setProjectionMatrix(viewport.getCamera().combined);

        final String hudString =
                Constants.HUD_SCORE_LABEL +score + "\n" +Constants.HUD_BULLET_LABEL + bullet;
        font.draw(
                batch,
                hudString,
                Constants.HUD_MARGIN,
                viewport.getWorldHeight() - Constants.HUD_MARGIN
        );
        final TextureRegion standingRight = Assets.instance.gigaManAssets.standingRight;
        for(int i=0; i<=lives; i++) {
            final Vector2 drawPosition = new Vector2(
                    viewport.getWorldWidth() - i * (Constants.HUD_MARGIN / 2 + standingRight.getRegionWidth()),
                    viewport.getWorldHeight() - Constants.HUD_MARGIN - standingRight.getRegionHeight()
            );
            Utils.drawTextureRegion(
                    batch,
                    standingRight,
                    drawPosition
            );
        }


    }
}
*/
