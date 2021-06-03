/*
package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.Utils;

public class Burst {

    private final Vector2 position;
    private final long initialTime;
    public float offset = 0;

    public Burst(Vector2 position) {
        this.position = position;
        initialTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        //Select and draw the appropriate frame of the explosion animation
        Utils.drawTextureRegion(
                batch,
                (TextureRegion) Assets.instance.burstAssets.burst.getKeyFrame(Utils.secondsSince(initialTime)),
                position,
                Constants.BURST_CENTER
        );
    }

    public boolean isFinished() {
        final float elapsedTime = Utils.secondsSince(initialTime);
        return Assets.instance.burstAssets.burst.isAnimationFinished(elapsedTime);
    }
}
*/
