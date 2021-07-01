package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.math.Rectangle;

import vn.sonnl.gigaman.helpers.AudioUtils;

public class MusicButton extends GameButton {

    public MusicButton(Rectangle bounds) {
        super(bounds);
    }

    protected String getRegionName() {
        return AudioUtils.getInstance().getMusicRegionName();
    }

    public void touched() {
        if (AudioUtils.getInstance().getMusic().isPlaying()) {
            AudioUtils.getInstance().pauseMusic();
        }
        AudioUtils.getInstance().toggleMusic();
        AudioUtils.getInstance().playMusic();
    }

}
