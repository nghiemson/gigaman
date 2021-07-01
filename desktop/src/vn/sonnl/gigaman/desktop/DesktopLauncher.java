package vn.sonnl.gigaman.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import vn.sonnl.gigaman.GigamanGame;
import vn.sonnl.gigaman.helpers.GameEventListener;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		new Lwjgl3Application(new GigamanGame(
				new GameEventListener() {
					@Override
					public void displayAd() {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "displayAd");
					}

					@Override
					public void hideAd() {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "hideAd");
					}

					@Override
					public void submitScore(int score) {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "submitScore");
					}

					@Override
					public void displayLeaderboard() {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "displayLeaderboard");
					}

					@Override
					public void displayAchievements() {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "displayAchievements");
					}

					@Override
					public void share() {
						Gdx.app.log(GameEventListener.class.getSimpleName(), "share");
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

				}), config);
	}
}
