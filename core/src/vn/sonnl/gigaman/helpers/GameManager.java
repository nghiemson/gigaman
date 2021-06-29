package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.Gdx;
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
}
