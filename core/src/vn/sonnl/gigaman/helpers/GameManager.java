package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;

import vn.sonnl.gigaman.enums.Difficulty;
import vn.sonnl.gigaman.enums.GameState;

public class GameManager implements  GameEventListener{
    private static final GameManager gameManager = new GameManager();

    public static final String PREFERENCES_NAME = "preferences";
    private static final String MAX_SCORE_PREFERENCE = "max_score";
    private static final String ACHIEVEMENT_COUNT_PREFERENCE_SUFFIX = "_count";
    private static final String ACHIEVEMENT_UNLOCKED_PREFERENCE_SUFFIX = "_unlocked";

    private GameState gameState;
    private Difficulty difficulty;
    private GameEventListener gameEventListener;

    public static GameManager getInstance() {
        return gameManager;
    }

    private GameManager() {
        gameState = GameState.OVER;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isMaxDifficulty() {
        return difficulty == Difficulty.values()[Difficulty.values().length - 1];
    }

    public void resetDifficulty() {
        setDifficulty(Difficulty.values()[0]);
    }

    public void setGameEventListener(GameEventListener gameEventListener) {
        this.gameEventListener = gameEventListener;
    }

    @Override
    public void displayAd() {
        gameEventListener.displayAd();
    }

    @Override
    public void hideAd() {
        gameEventListener.hideAd();
    }

    @Override
    public void submitScore(int score) {
        gameEventListener.submitScore(score);

        if (score > 5000 && !isAchievementUnlocked(get5kClubAchievementId())) {
            unlockAchievement(get5kClubAchievementId());
        }

        if (score > 10000 && !isAchievementUnlocked(get10kClubAchievementId())) {
            unlockAchievement(get10kClubAchievementId());
        }

    }

    private boolean isAchievementUnlocked(String id) {
        return getPreferences().getBoolean(getAchievementUnlockedId(id), false);
    }

    @Override
    public void displayLeaderboard() {
        gameEventListener.displayLeaderboard();
    }

    @Override
    public void displayAchievements() {
        gameEventListener.displayAchievements();
    }

    @Override
    public void share() {

    }

    @Override
    public void unlockAchievement(String id) {
        gameEventListener.unlockAchievement(id);
    }

    @Override
    public void incrementAchievement(String id, int steps) {
        gameEventListener.incrementAchievement(id, steps);
    }

    @Override
    public String getGettingStartedAchievementId() {
        return gameEventListener.getGettingStartedAchievementId();
    }

    @Override
    public String getLikeARoverAchievementId() {
        return gameEventListener.getLikeARoverAchievementId();
    }

    @Override
    public String getSpiritAchievementId() {
        return gameEventListener.getSpiritAchievementId();
    }

    @Override
    public String getCuriosityAchievementId() {
        return gameEventListener.getCuriosityAchievementId();
    }

    @Override
    public String get5kClubAchievementId() {
        return gameEventListener.get5kClubAchievementId();
    }

    @Override
    public String get10kClubAchievementId() {
        return gameEventListener.get10kClubAchievementId();
    }

    @Override
    public String get10JumpStreetAchievementId() {
        return gameEventListener.get10JumpStreetAchievementId();
    }

    @Override
    public String get100JumpStreetAchievementId() {
        return gameEventListener.get100JumpStreetAchievementId();
    }

    @Override
    public String get500JumpStreetAchievementId() {
        return gameEventListener.get500JumpStreetAchievementId();
    }

    public boolean hasSavedMaxScore() {
        return getPreferences().getInteger(MAX_SCORE_PREFERENCE, 0) > 0;
    }

    private Preferences getPreferences() {
        return Gdx.app.getPreferences(PREFERENCES_NAME);
    }

    public void submitSavedMaxScore() {
        Preferences preferences = getPreferences();
        submitScore(preferences.getInteger(MAX_SCORE_PREFERENCE, 0));
        preferences.remove(MAX_SCORE_PREFERENCE);
        preferences.flush();
    }

    public void saveScore(int score) {
        Preferences preferences = getPreferences();
        int maxScore = preferences.getInteger(MAX_SCORE_PREFERENCE, 0);
        if (score > maxScore) {
            preferences.putInteger(MAX_SCORE_PREFERENCE, score);
            preferences.flush();
        }
    }

    public void setAchievementUnlocked(String id) {
        getPreferences().putBoolean(getAchievementUnlockedId(id), true);

    }

    private String getAchievementUnlockedId(String id) {
        return id + ACHIEVEMENT_UNLOCKED_PREFERENCE_SUFFIX;
    }

    public void incrementAchievementCount(String id, int steps) {
        Preferences preferences = getPreferences();
        int count = preferences.getInteger(getAchievementCountId(id), 0);
        count += steps;
        preferences.putInteger(getAchievementCountId(id), count);
        preferences.flush();
    }

    private String getAchievementCountId(String id) {
        return id + ACHIEVEMENT_COUNT_PREFERENCE_SUFFIX;
    }

    public void addGamePlayed() {

        // No need to keep counting if all achievements have been unlocked
        if (getAchievementCount(getCuriosityAchievementId()) > 500) {
            return;
        }

        if (!isAchievementUnlocked(getGettingStartedAchievementId())) {
            unlockAchievement(getGettingStartedAchievementId());
        }

        if (getAchievementCount(getLikeARoverAchievementId()) <= 10) {
            incrementAchievement(getLikeARoverAchievementId(), 1);
        }

        if (getAchievementCount(getSpiritAchievementId()) <= 100) {
            incrementAchievement(getSpiritAchievementId(), 1);
        }

        incrementAchievement(getCuriosityAchievementId(), 1);

    }

    private int getAchievementCount(String id) {
        return getPreferences().getInteger(getAchievementCountId(id), 0);
    }

    public void addJumpCount(int count) {

        if (count <= 0) {
            return;
        }

        if (getAchievementCount(get500JumpStreetAchievementId()) > 500) {
            return;
        }

        if (getAchievementCount(get500JumpStreetAchievementId()) <= 10) {
            incrementAchievement(get10JumpStreetAchievementId(), count);
        }

        if (getAchievementCount(get500JumpStreetAchievementId()) <= 100) {
            incrementAchievement(get100JumpStreetAchievementId(), count);
        }

        incrementAchievement(get500JumpStreetAchievementId(), count);

    }
}
