/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.screens.MainMenu;

public class HighScoreButton {
    private GigaManGame game;
    private Stage stage;
    private Viewport viewport;
    private  Image showScore;
    private Label scoreLabel;
    private ImageButton backBtn;



    public  HighScoreButton(GigaManGame game) {
        this.game = game;

        viewport = new ExtendViewport(800,480 );

        stage = new Stage(viewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);
        createAndPositionUIElements();
        addAllListeners();
        stage.addActor(showScore);
        stage.addActor(scoreLabel);
        stage.addActor(backBtn);
    }
    private void createAndPositionUIElements() {

        backBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Back.png"))));
        showScore = new Image(new Texture("images/Show Score.png"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/blow.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 50;

        BitmapFont scoreFont = generator.generateFont(parameters);
//        BitmapFont coinsFont = generator.generateFont(parameters);

        scoreLabel = new Label(String.valueOf(GameManager.getInstance().gameData.getHighscore()),
                new Label.LabelStyle(scoreFont, Color.WHITE));

        backBtn.setPosition(17, 17, Align.bottomLeft);
        showScore.setPosition(400, 240,Align.center);
        scoreLabel.setPosition(400, 200);

    }
    private void addAllListeners() {

        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });
    }

    public Stage getStage() {
        return stage;
    }
}
*/
