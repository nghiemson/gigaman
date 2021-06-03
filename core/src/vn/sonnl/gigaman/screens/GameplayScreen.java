package vn.sonnl.gigaman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.ScreenAdapter;


import vn.sonnl.gigaman.GameStage;

public class GameplayScreen extends ScreenAdapter {


    /*Level level;
    private FollowCam followCam;
    private Hud hud;
    long levelEndOverlayStartTime;
    private Winning winning;
    private GameOver gameOver;
    MobileControls mobileControls;
    PauseButton pauseBtn;
    private GigaManGame game;
    private Sprite bgsprite;
    private float lastXPosition;
    SpriteBatch batch;
    private boolean firstTimeTouched = false;

    @Override
    public void show() {
        Assets.instance.init();
        batch = new SpriteBatch();
        level = new Level();
        game = new GigaManGame();
        followCam = new FollowCam();
        hud = new Hud();
        winning = new Winning();
        gameOver = new GameOver();
        mobileControls = new MobileControls();
        createBackgrounds();
        pauseBtn = new PauseButton();
        if(Gdx.app.getType() == ApplicationType.Android)
            Gdx.input.setInputProcessor(mobileControls);
        startNewLevel();
    }

   public void checkFirstTouch() {
        if(!firstTimeTouched) {
            if (Gdx.input.justTouched()) {
                firstTimeTouched = true;
                GameManager.getInstance().isPaused = false;
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        //hud.viewport.update(width, height, true);
        level.getViewport().update(width, height, true);
        followCam.camera = level.getViewport().getCamera();
        winning.viewport.update(width, height, true);
        gameOver.viewport.update(width, height, true);
        mobileControls.viewport.update(width, height, true);
        mobileControls.recalculateButtonPositions();
        pauseBtn.viewport.update(width, height, true);
        hud.viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

    @Override
    public void render(float delta) {

        level.update(delta);
        followCam.update(delta);
        // Clear the screen to the BACKGROUND_COLOR
        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        drawBackgrounds();
        //Render the level
        level.render(batch);
        if(Gdx.app.getType() == ApplicationType.Android)
            mobileControls.render(batch);
        //render the hud
        hud.render(
                batch,
                level.getGigaMan().getLives(),
                level.getGigaMan().getBullets(),
                level.score
                );
        renderLevelEndOverlays(batch);
        batch.setProjectionMatrix(mobileControls.getStage().getCamera().combined);
        mobileControls.getStage().draw();
        mobileControls.getStage().act();
        batch.end();
        //drawBackgrounds();
    }

    private void startNewLevel() {
        String levelNumber = Constants.LEVELS[MathUtils.random(Constants.LEVELS.length - 1)];
        level = LevelLoader.load(levelNumber);
        followCam.camera = level.getViewport().getCamera();
        followCam.target = level.getGigaMan();
        mobileControls.gigaMan = level.getGigaMan();
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    private void renderLevelEndOverlays(SpriteBatch batch) {

        if (level.winning) {
            if (levelEndOverlayStartTime == 0) {
                levelEndOverlayStartTime = TimeUtils.nanoTime();
                winning.init();
            }
            winning.render(batch);

            if (Utils.secondsSince(levelEndOverlayStartTime) > Constants.LEVEL_END_DURATION) {
                //Reset levelEndOverlayStartTime
                levelEndOverlayStartTime = 0;

                levelComplete();
            }
        }
        if (level.gameOver) {
            GameManager.getInstance().checkForNewHighscores();
            if (levelEndOverlayStartTime == 0) {
                levelEndOverlayStartTime = TimeUtils.nanoTime();
                gameOver.init();
            }
            gameOver.render(batch);
            if (Utils.secondsSince(levelEndOverlayStartTime) > Constants.LEVEL_END_DURATION) {
                levelEndOverlayStartTime = 0;
                levelFailed();
            }
        }
    }

    public void levelComplete() {
        startNewLevel();
    }

    public void levelFailed() {
        startNewLevel();
    }

    void createBackgrounds(){
        bgsprite = new Sprite();

            bgsprite = new Sprite(new Texture("images/bg.png"));
            bgsprite.setPosition(0,-bgsprite.getWidth());

        lastXPosition = Math.abs(bgsprite.getX());

    }

    void drawBackgrounds(){
            batch.draw(bgsprite, bgsprite.getX(), bgsprite.getY());
        }

    @Override
    public void pause() {
        super.pause();
    }*/

    private GameStage stage;

    public GameplayScreen() {
        stage = new GameStage();
    }

    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
