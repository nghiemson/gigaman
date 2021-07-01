package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.math.Rectangle;

import vn.sonnl.gigaman.enums.GameState;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;

public class LeaderboardButton extends GameButton {

    public interface LeaderboardButtonListener {
        public void onLeaderboard();
    }

    private LeaderboardButtonListener listener;

    public LeaderboardButton(Rectangle bounds, LeaderboardButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.LEADERBOARD_REGION_NAME;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManager.getInstance().getGameState() != GameState.OVER) {
            remove();
        }
    }

    @Override
    public void touched() {
        listener.onLeaderboard();
    }

}

