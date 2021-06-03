/*
package vn.sonnl.gigaman.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
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
import vn.sonnl.gigaman.entities.GigaMan;
import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.helpers.Utils;
import vn.sonnl.gigaman.screens.GameplayScreen;
import vn.sonnl.gigaman.screens.MainMenu;

public class MobileControls extends InputAdapter {

    public final Viewport viewport;
    public GigaMan gigaMan;
    private Vector2 moveLeftCenter = new Vector2();
    private Vector2 moveRightCenter = new Vector2();
    private Vector2 shootCenter = new Vector2();
    private Vector2 jumpCenter = new Vector2();
    private Vector2 pauseCenter = new Vector2();
    private int moveLeftPointer;
    private int moveRightPointer;
    private int jumpPointer;
    private ImageButton resumeBtn, quitBtn;
    private Image pausePanel;
    private Stage stage;
    private SpriteBatch batch;
    private GigaManGame game;
    private GameplayScreen gameplayScreen;
    public MobileControls() {
        game = new GigaManGame();
        batch = new SpriteBatch();
        gameplayScreen = new GameplayScreen();
        this.viewport = new ExtendViewport(
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE,
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE);
        stage = new Stage(viewport,batch);
        recalculateButtonPositions();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));

        if (viewportPosition.dst(shootCenter) < Constants.BUTTON_RADIUS) {

            gigaMan.shoot();
            Gdx.app.log("shoot", "Pressed");

        } else if (viewportPosition.dst(jumpCenter) < Constants.BUTTON_RADIUS) {

            // TODO: Save the jumpPointer and set gigaGal.jumpButtonPressed = true
            jumpPointer = pointer;
            gigaMan.jumpButtonPressed = true;

        } else if (viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RADIUS) {

            // TODO: Save the moveLeftPointer, and set gigaGal.leftButtonPressed = true
            moveLeftPointer = pointer;
            gigaMan.leftButtonPressed = true;

        } else if (viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RADIUS) {

            // TODO: Save the moveRightPointer, and set gigaGal.rightButtonPressed = true
            moveRightPointer = pointer;
            gigaMan.rightButtonPressed = true;

        } else if(viewportPosition.dst(pauseCenter) < Constants.BUTTON_RADIUS) {
            gameplayScreen.checkFirstTouch();
                GameManager.getInstance().isPaused = true;
                createPausePanel();
                Gdx.app.log("pause", "Pressed");

        }

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));

        if (pointer == moveLeftPointer && viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RADIUS) {

            // Inform GigaGal that the left button is no longer pressed
            gigaMan.leftButtonPressed = false;

            // Inform GigaGal that the right button is now pressed
            gigaMan.rightButtonPressed = true;

            // Zero moveLeftPointer
            moveLeftPointer = 0;

            // Save moveRightPointer
            moveRightPointer = pointer;

        }

        if (pointer == moveRightPointer && viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RADIUS) {

            // TODO: Handle the case where the right button touch has been dragged to the left button
            gigaMan.rightButtonPressed = false;
            gigaMan.leftButtonPressed = true;
            moveRightPointer = 0;
            moveLeftPointer = pointer;

        }

        return super.touchDragged(screenX, screenY, pointer);
    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);


        if (!Gdx.input.isTouched(jumpPointer)) {
            gigaMan.jumpButtonPressed = false;
            jumpPointer = 0;
        }

        // TODO: If the moveLeftPointer is no longer touched, inform GigaGal and zero moveLeftPointer
        if (!Gdx.input.isTouched(moveLeftPointer)) {
            gigaMan.leftButtonPressed = false;
            moveLeftPointer = 0;
        }

        // TODO: Do the same for moveRightPointer
        if (!Gdx.input.isTouched(moveRightPointer)) {
            gigaMan.rightButtonPressed = false;
            moveRightPointer = 0;
        }

        Utils.drawTextureRegion(
                batch,
                Assets.instance.mobileControlsAssets.moveLeft,
                moveLeftCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.mobileControlsAssets.moveRight,
                moveRightCenter,
                Constants.BUTTON_CENTER
        );

        // TODO: Render the shoot and jump buttons, using the shootCenter and jumpCenter defined below

        Utils.drawTextureRegion(
                batch,
                Assets.instance.mobileControlsAssets.shoot,
                shootCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.mobileControlsAssets.jump,
                jumpCenter,
                Constants.BUTTON_CENTER
        );
        final TextureRegion pause = Assets.instance.buttonAssets.pause;

        Utils.drawTextureRegion(
                batch,
                pause,
                pauseCenter,
                Constants.BUTTON_CENTER
        );
    }

    public void recalculateButtonPositions() {
        moveLeftCenter.set(Constants.BUTTON_RADIUS * 3 / 4, Constants.BUTTON_RADIUS);
        moveRightCenter.set(Constants.BUTTON_RADIUS * 2, Constants.BUTTON_RADIUS * 3 / 4);


        //Set shootCenter and jumpCenter, mirroring the positions of the move buttons
        shootCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RADIUS * 2f,
                Constants.BUTTON_RADIUS * 3 / 4
        );

        jumpCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RADIUS * 3 / 4,
                Constants.BUTTON_RADIUS
        );
        pauseCenter.set( viewport.getWorldWidth() -   (Constants.HUD_MARGIN / 2 + Assets.instance.buttonAssets.pause.getRegionWidth()),
                viewport.getWorldHeight() - Constants.HUD_MARGIN );

    }
    void createPausePanel(){
        pausePanel= new Image(new Texture("images/Pause Panel.png"));
        pausePanel.setPosition(400, 240, Align.center);
        resumeBtn= new ImageButton(new SpriteDrawable(new Sprite(new Texture("images/Resume.png"))));
        quitBtn= new ImageButton(new SpriteDrawable(new Sprite(new Texture("images/Quit.png"))));

        resumeBtn.setPosition(400, 290, Align.center);
        quitBtn.setPosition(400, 160, Align.center);

        resumeBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(GameManager.getInstance().isPaused){
                    GameManager.getInstance().isPaused=false;
                    removepausePanel();
                }

            }
        });

        quitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        stage.addActor(pausePanel);
        stage.addActor(resumeBtn);
        stage.addActor(quitBtn);
        Gdx.app.log("pause panel", "created");
    }

    void removepausePanel(){
        pausePanel.remove();
        resumeBtn.remove();
        quitBtn.remove();
    }
    public Stage getStage() {
        return stage;
    }
}
*/
