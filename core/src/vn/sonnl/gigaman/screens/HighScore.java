/*
package vn.sonnl.gigaman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.helpers.FollowCam;
import vn.sonnl.gigaman.overlays.HighScoreButton;

public class HighScore extends ScreenAdapter {
    private GigaManGame game;
    private FollowCam followCam;
    private Viewport viewport;
    private Texture bg;
    private HighScoreButton btn;

    public HighScore(GigaManGame game) {
        this.game = game;

        followCam = new FollowCam();
        viewport = new StretchViewport(800, 480);

        bg = new Texture("images/bg.png");

        btn = new HighScoreButton(game);
    }



    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        game.getBatch().end();
        game.getBatch().setProjectionMatrix(btn.getStage().getCamera().combined);
        btn.getStage().draw();
    }



    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
    }



    @Override
    public void pause() {

    }



    @Override
    public void resume() {

    }



    @Override
    public void hide() {

    }



    @Override
    public void dispose() {
        bg.dispose();
        btn.getStage().dispose();
    }
}
*/
