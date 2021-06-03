/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.screens.GameplayScreen;
import vn.sonnl.gigaman.screens.HighScore;
import vn.sonnl.gigaman.screens.Option;

public class MainMenuButton {
    private GigaManGame game;
    private Stage stage;
    private Viewport viewport;

    private ImageButton playBtn;
    private ImageButton highscoresBtn;
    private ImageButton optionsBtn;
    private ImageButton quitBtn;
    private ImageButton musicBtn;

    public MainMenuButton(GigaManGame game) {
        this.game = game;

        viewport = new StretchViewport(800, 480);
        stage = new Stage(viewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);
        createAndPositionButtons();
        addAllListeners();

        stage.addActor(playBtn);
        stage.addActor(highscoresBtn);
        stage.addActor(optionsBtn);
        stage.addActor(quitBtn);
        stage.addActor(musicBtn);

        //checkMusic();

    }
    private void createAndPositionButtons() {

        playBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Start Game.png"))));

        highscoresBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Highscore.png"))));

        optionsBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Options.png"))));

        quitBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Quit.png"))));

        musicBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Music On.png"))));


        playBtn.setPosition(320, 290, Align.center);
        highscoresBtn.setPosition(340, 220, Align.center);
        optionsBtn.setPosition( 360, 150, Align.center);
        quitBtn.setPosition(    380, 80, Align.center);
        musicBtn.setPosition(   760 , 40, Align.right);

    }
    void addAllListeners(){
        playBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().gameStartedFromMainMenu=true;
                game.setScreen(new GameplayScreen());
            }
        });

        highscoresBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new HighScore(game));
            }
        });

        optionsBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Option(game));
            }
        });

        quitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
                System.exit(0);
            }
        });

        musicBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                if (GameManager.getInstance().gameData.isMusicOn()){
                    GameManager.getInstance().gameData.setMusicOn(false);
                    GameManager.getInstance().stopMusic();
                }else {
                    GameManager.getInstance().gameData.setMusicOn(true);
                    GameManager.getInstance().playMusic();
                }
                GameManager.getInstance().saveData();
            }
        });
    }

//    void checkMusic(){
//        if (GameManager.getInstance().gameData.isMusicOn()){
//            GameManager.getInstance().playMusic();
//        }
//    }

    public Stage getStage() {
        return stage;
    }

}
*/
