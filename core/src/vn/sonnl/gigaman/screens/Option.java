/*
package vn.sonnl.gigaman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.FollowCam;
import vn.sonnl.gigaman.overlays.OptionButton;

public class Option extends ScreenAdapter {
    private GigaManGame game;

    private FollowCam followCam;
    private Viewport viewport;

    private Texture bg;

    private OptionButton btns;


    public Option(GigaManGame game) {
        this.game = game;

        followCam = new FollowCam();
        viewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);
        bg = new Texture("images/bg.png");

        btns = new OptionButton(game);
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
        game.getBatch().setProjectionMatrix(
                btns.getStage().getCamera().combined);
        btns.getStage().draw();

    }



    @Override
    public void resize(int width, int height) {
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
        btns.getStage().dispose();
    }
}
*/
