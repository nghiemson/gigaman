package vn.sonnl.gigaman;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.games.basegameutils.GameHelper;

import vn.sonnl.gigaman.helpers.GameEventListener;

public class AndroidLauncher extends AndroidApplication implements GameEventListener, GameHelper.GameHelperListener {

	private static String SAVED_LEADERBOARD_REQUESTED = "SAVED_LEADERBOARD_REQUESTED";
	private static String SAVED_ACHIEVEMENTS_REQUESTED = "SAVED_ACHIEVEMENTS_REQUESTED";

	private GameHelper gameHelper;

	private AdView adView;
	private boolean leaderboardRequested;
	private boolean achievementsRequested;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		View gameView = initializeForView(new GigamanGame(this), config);

		adView = createAdView();
	}

	private AdView createAdView() {
		AdView adView = new AdView(this);

		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(getAdMobUnitId());

		return adView;
	}

	@Override
	public void displayAd() {

	}

	@Override
	public void hideAd() {

	}

	@Override
	public void submitScore(int score) {

	}

	@Override
	public void displayLeaderboard() {

	}

	@Override
	public void displayAchievements() {

	}

	@Override
	public void share() {

	}

	@Override
	public void unlockAchievement(String id) {

	}

	@Override
	public void incrementAchievement(String id, int steps) {

	}

	@Override
	public String getGettingStartedAchievementId() {
		return null;
	}

	@Override
	public String getLikeARoverAchievementId() {
		return null;
	}

	@Override
	public String getSpiritAchievementId() {
		return null;
	}

	@Override
	public String getCuriosityAchievementId() {
		return null;
	}

	@Override
	public String get5kClubAchievementId() {
		return null;
	}

	@Override
	public String get10kClubAchievementId() {
		return null;
	}

	@Override
	public String get25kClubAchievementId() {
		return null;
	}

	@Override
	public String get50kClubAchievementId() {
		return null;
	}

	@Override
	public String get10JumpStreetAchievementId() {
		return null;
	}

	@Override
	public String get100JumpStreetAchievementId() {
		return null;
	}

	@Override
	public String get500JumpStreetAchievementId() {
		return null;
	}

	@Override
	public void onSignInFailed() {

	}

	@Override
	public void onSignInSucceeded() {

	}
}
