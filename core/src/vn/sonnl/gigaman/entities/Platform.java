/*
package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import vn.sonnl.gigaman.helpers.Assets;

public class Platform {
   public final float top;
   public final float bottom;
   public final float left;
   public final float right;

    public Platform(float left, float top, float width, float height) {
        this.top = top;
        this.bottom = top - height;
        this.left = left;
        this.right = left + width;
    }

    public void render(SpriteBatch batch) {
        float width = right - left;
        float height = top - bottom;

        // Draw the platform using the NinePatch
        Assets.instance.platformAssets.ninePatch.draw(batch, left - 1, bottom - 1, width + 2, height + 2);
    }

}

*/
