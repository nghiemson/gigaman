/*
package vn.sonnl.gigaman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.overlays.MainMenuButton;

public class MainMenu extends ScreenAdapter {
    private GigaManGame game;

    private Viewport viewport;

    private Texture MainMenubg;

    private MainMenuButton btn;

    public MainMenu(GigaManGame game) {
        this.game = game;

        viewport = new StretchViewport(1920, 1080);
        MainMenubg = new Texture("images/bg.png");
        btn = new MainMenuButton(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(MainMenubg, 0, 0);
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(btn.getStage().getCamera().combined);
        btn.getStage().draw();
        btn.getStage().act();
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
        MainMenubg.dispose();
        btn.getStage().dispose();
    }
}
*/
