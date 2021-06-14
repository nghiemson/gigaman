package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import vn.sonnl.gigaman.box2d.GigamanUserData;
import vn.sonnl.gigaman.enums.Difficulty;
import vn.sonnl.gigaman.enums.GameState;
import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.AudioUtils;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.GameManager;


public class GigaMan extends GameActor{

    private boolean dodging;
    private boolean jumping;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion dodgingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    private Sound jumpSound;
    private Sound hitSound;

    private int jumpCount;

    public GigaMan(Body body) {
        super(body);
        jumpCount = 0;
        runningAnimation = Assets.getAnimation(Constants.GIGAMAN_RUNNING_ASSETS_ID);
        stateTime = 0f;
        jumpingTexture = Assets.getTextureRegion(Constants.GIGAMAN_JUMPING_ASSETS_ID);
        dodgingTexture = Assets.getTextureRegion(Constants.RUNNER_DODGING_ASSETS_ID);
        hitTexture = Assets.getTextureRegion(Constants.GIGAMAN_HIT_ASSETS_ID);
        jumpSound = AudioUtils.getInstance().getJumpSound();
        hitSound = AudioUtils.getInstance().getHitSound();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.5f;

        if (dodging) {
            batch.draw(dodgingTexture, x, y + screenRectangle.height / 4, width*0.9f, screenRectangle.height*0.9f);
        } else if (hit) {
            // When he's hit we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, x, y, width * 0.5f, screenRectangle.height * 0.5f, width, screenRectangle.height, 1f,
                    1f, (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            batch.draw(jumpingTexture, x, y, width, screenRectangle.height);
        } else {
            // Running
            if (GameManager.getInstance().getGameState() == GameState.RUNNING) {
                stateTime += Gdx.graphics.getDeltaTime();
            }
            batch.draw((TextureRegion) runningAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        }
    }

    @Override
    public GigamanUserData getUserData() {
        return (GigamanUserData) userData;
    }

    public void jump() {

        if (!(jumping || dodging || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
            AudioUtils.getInstance().playSound(jumpSound);
            jumpCount++;
        }

    }

    public void landed() {
        jumping = false;
    }

    public void dodge() {
        if (!(jumping || hit)) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        // If the runner is hit don't force him back to the running position
        if (!hit) {
            body.setTransform(getUserData().getRunningPosition(), 0f);
        }
    }

    public boolean isDodging() {
        return dodging;
    }

    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
        AudioUtils.getInstance().playSound(hitSound);
    }

    public boolean isHit() {
        return hit;
    }

    public void onDifficultyChange(Difficulty newDifficulty) {
        setGravityScale(newDifficulty.getRunnerGravityScale());
        getUserData().setJumpingLinearImpulse(newDifficulty.getRunnerJumpingLinearImpulse());
    }

    public void setGravityScale(float gravityScale) {
        body.setGravityScale(gravityScale);
        body.resetMassData();
    }

    public int getJumpCount() {
        return jumpCount;
    }
}
