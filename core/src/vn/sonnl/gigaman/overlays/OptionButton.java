/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.GigaManGame;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.screens.MainMenu;

public class OptionButton {
    private GigaManGame game;
    private Stage stage;
    private Viewport viewport;

    private ImageButton lv1, lv2, lv3;
    private Image tick;

    private ImageButton backBtn;

    public OptionButton(GigaManGame game) {
        this.game = game;

        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        stage = new Stage(viewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);

        createAndPositionButtons();
        addAllListeners();

        stage.addActor(lv1);
        stage.addActor(lv2);
        stage.addActor(lv3);
        stage.addActor(tick);
        stage.addActor(backBtn);

    }

    private void createAndPositionButtons() {

        lv1 = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/level1.png"))));

        lv2 = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/level2.png"))));

        lv3 = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/level3.png"))));

        backBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("images/Back.png"))));

        tick = new Image(
                new Texture("images/tick.png"));

        backBtn.setPosition(17, 17, Align.bottomLeft);

        lv1.setPosition(  Constants.WORLD_SIZE/2, Constants.WORLD_SIZE/2 + 40, Align.center);
        lv2.setPosition(Constants.WORLD_SIZE/2, Constants.WORLD_SIZE/2 - 40, Align.center);
        lv3.setPosition(  Constants.WORLD_SIZE/2, Constants.WORLD_SIZE/2 - 120, Align.center);

        positionTheTick();

    }

    void addAllListeners(){
        lv1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                tick.setY(lv1.getY() + 13);
            }
        });

        lv2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                tick.setY(lv2.getY() + 13);
            }
        });

        lv3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                tick.setY(lv3.getY() + 13);
            }
        });

        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

    }

    void positionTheTick() {

        if(GameManager.getInstance().gameData.isLevel1()){
            tick.setPosition(Constants.WORLD_SIZE / 2 +76, lv1.getY() +13, Align.bottomLeft);
        }

        if(GameManager.getInstance().gameData.isLevel2()){
            tick.setPosition(Constants.WORLD_SIZE / 2 +76, lv2.getY() +13, Align.bottomLeft);
        }

        if(GameManager.getInstance().gameData.isLevel3()){
            tick.setPosition(Constants.WORLD_SIZE / 2 +76, lv3.getY() +13, Align.bottomLeft);
        }
    }

    void changeDifficulty(int difficulty){
        switch (difficulty){
            case 0:
                GameManager.getInstance().gameData.setLevel1(true);
                GameManager.getInstance().gameData.setLevel2(false);
                GameManager.getInstance().gameData.setLevel3(false);
                break;
            case 1:
                GameManager.getInstance().gameData.setLevel1(false);
                GameManager.getInstance().gameData.setLevel2(true);
                GameManager.getInstance().gameData.setLevel3(false);
                break;
            case 2:
                GameManager.getInstance().gameData.setLevel1(false);
                GameManager.getInstance().gameData.setLevel2(false);
                GameManager.getInstance().gameData.setLevel3(true);
                break;

        }

        GameManager.getInstance().saveData();
    }

    public Stage getStage() {
        return stage;
    }
}
*/
