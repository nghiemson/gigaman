package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.math.Rectangle;

import vn.sonnl.gigaman.helpers.AudioUtils;

public class SoundButton extends GameButton {

    public SoundButton(Rectangle bounds) {
        super(bounds);
    }

    @Override
    protected String getRegionName() {
        return AudioUtils.getInstance().getSoundRegionName();
    }

    @Override
    public void touched() {
        AudioUtils.getInstance().toggleSound();
    }

}
