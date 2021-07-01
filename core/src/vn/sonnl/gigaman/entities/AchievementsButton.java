package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.math.Rectangle;

import vn.sonnl.gigaman.helpers.Constants;

public class AchievementsButton extends GameButton{
    public interface AchievementsButtonListener {
         void onAchievements();
    }

    private AchievementsButtonListener listener;

    public AchievementsButton(Rectangle bounds, AchievementsButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.ACHIEVEMENTS_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onAchievements();
    }
}
