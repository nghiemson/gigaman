package vn.sonnl.gigaman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.games.Games;
import com.google.games.basegameutils.GameHelper;

import vn.sonnl.gigaman.helpers.GameEventListener;
import vn.sonnl.gigaman.helpers.GameManager;

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
		layout.addView(gameView);
		adView = createAdView();
		adView.loadAd(createAdRequest());
		layout.addView(adView, getAdParams());
		setContentView(layout);

		gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
		gameHelper.setup(this);
		gameHelper.setMaxAutoSignInAttempts(0);
	}

	@Override
	protected void onStart() {
		super.onStart();
		gameHelper.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		gameHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		gameHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(SAVED_LEADERBOARD_REQUESTED, leaderboardRequested);
		outState.putBoolean(SAVED_ACHIEVEMENTS_REQUESTED, achievementsRequested);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		leaderboardRequested = savedInstanceState.getBoolean(SAVED_LEADERBOARD_REQUESTED, false);
		achievementsRequested = savedInstanceState.getBoolean(SAVED_ACHIEVEMENTS_REQUESTED, false);
	}

	private RelativeLayout.LayoutParams getAdParams() {
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

		return adParams;
	}

	private AdRequest createAdRequest() {
		return new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.build();
	}

	private AdView createAdView() {
		AdView adView = new AdView(this);

		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(getString(R.string.admob_id));

		return adView;
	}


	@Override
	public void displayAd() {
		adView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideAd() {
		adView.setVisibility(View.GONE);
	}

	@Override
	public void submitScore(int score) {
		if (gameHelper.isSignedIn()) {
			Games.Leaderboards.submitScore(gameHelper.getApiClient(),
					getString(R.string.leaderboard_high_scores), score);
		} else {
			GameManager.getInstance().saveScore(score);
		}
	}

	@Override
	public void displayLeaderboard() {
		if (gameHelper.isSignedIn()) {
			startActivityForResult(Games.Leaderboards.getLeaderboardIntent(gameHelper.getApiClient(),
					getString(R.string.leaderboard_high_scores)), 24);
		} else {
			gameHelper.beginUserInitiatedSignIn();
			leaderboardRequested = true;
		}
	}

	@Override
	public void displayAchievements() {
		if (gameHelper.isSignedIn()) {
			startActivityForResult(
					Games.Achievements.getAchievementsIntent(gameHelper.getApiClient()), 25);
		} else {
			gameHelper.beginUserInitiatedSignIn();
			achievementsRequested = true;
		}
	}

	@Override
	public void share() {

	}


	@Override
	public void unlockAchievement(String id) {
		if (gameHelper.isSignedIn()) {
			Games.Achievements.unlock(gameHelper.getApiClient(), id);
			GameManager.getInstance().setAchievementUnlocked(id);
		}
	}

	@Override
	public void incrementAchievement(String id, int steps) {
		if (gameHelper.isSignedIn()) {
			Games.Achievements.increment(gameHelper.getApiClient(), id, steps);
			GameManager.getInstance().incrementAchievementCount(id, steps);
		}
	}

	@Override
	public String getGettingStartedAchievementId() {
		return getString(R.string.achievement_getting_started);
	}

	@Override
	public String getLikeARoverAchievementId() {
		return getString(R.string.achievement_like_a_rover);
	}

	@Override
	public String getSpiritAchievementId() {
		return getString(R.string.achievement_spirit);
	}

	@Override
	public String getCuriosityAchievementId() {
		return getString(R.string.achievement_curiosity);
	}

	@Override
	public String get5kClubAchievementId() {
		return getString(R.string.achievement_5k_club);
	}

	@Override
	public String get10kClubAchievementId() {
		return getString(R.string.achievement_10k_club);
	}

	@Override
	public String get25kClubAchievementId() {
		return getString(R.string.achievement_25k_club);
	}

	@Override
	public String get50kClubAchievementId() {
		return getString(R.string.achievement_50k_club);
	}

	@Override
	public String get10JumpStreetAchievementId() {
		return getString(R.string.achievement_10_jump_street);
	}

	@Override
	public String get100JumpStreetAchievementId() {
		return getString(R.string.achievement_100_jump_street);
	}

	@Override
	public String get500JumpStreetAchievementId() {
		return getString(R.string.achievement_500_jump_street);
	}

	@Override
	public void onSignInFailed() {
		leaderboardRequested = false;
		achievementsRequested = false;
	}

	@Override
	public void onSignInSucceeded() {
		if (GameManager.getInstance().hasSavedMaxScore()) {
			GameManager.getInstance().submitSavedMaxScore();
		}

		if (leaderboardRequested) {
			displayLeaderboard();
			leaderboardRequested = false;
		}

		if (achievementsRequested) {
			displayAchievements();
			achievementsRequested = false;
		}
	}
}
