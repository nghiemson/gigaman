package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;

import vn.sonnl.gigaman.box2d.EnemyUserData;
import vn.sonnl.gigaman.enums.GameState;
import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.Enums.*;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.helpers.Utils;

public class Enemy extends GameActor{
    /*private final Platform platform;
    public Vector2 position;
    private Direction direction;
    final long initialTime;
    public  int health;
    private final float randomPhase;

    public Enemy(Platform platform) {
        this.platform = platform;
        direction = Direction.RIGHT;
        position = new Vector2(platform.left, platform.top + Constants.ENEMY_CENTER.y);
        initialTime = TimeUtils.nanoTime();
        health = Constants.ENEMY_HEALTH;
        randomPhase = MathUtils.random();
    }

    public void update(float delta) {
        switch (direction) {
            case LEFT:
                position.x -= Constants.ENEMY_MOVEMENT_SPEED * delta;
                break;
            case RIGHT:
                position.x += Constants.ENEMY_MOVEMENT_SPEED * delta;
        }

        // If the enemy is off the left side of the platform, set the enemy moving back to the right
        // also put the enemy back on the edge of the platform

        // If the enemy is off the right side of the platform, set the enemy moving back to the left
        if (position.x < platform.left) {
            position.x = platform.left;
            direction = Direction.RIGHT;
        } else if (position.x > platform.right) {
            position.x = platform.right;
            direction = Direction.LEFT;
        }

        // Find where in the bob cycle we're at
        final float elapsedTime = Utils.secondsSince(initialTime);
        final float bobMultiplier = 1 + MathUtils.sin(MathUtils.PI2 * (( elapsedTime / Constants.ENEMY_BOUNCE_PERIOD) +randomPhase));

        //Set the enemy vertical position

        position.y = platform.top + Constants.ENEMY_CENTER.y + Constants.ENEMY_BOUNCE_AMPLITUDE * bobMultiplier;
    }

    public void render(SpriteBatch batch) {
        final TextureRegion region = Assets.instance.enemyAssets.enemy;
        Utils.drawTextureRegion(
                batch,
                region,
                position,
                Constants.ENEMY_CENTER);
    }*/

    private Animation animation;
    private float stateTime;
    public  int health;
    public Enemy(Body body) {
        super(body);
        animation = Assets.getAnimation(getUserData().getAnimationAssetId());
        stateTime = 0f;
        health = Constants.ENEMY_HEALTH;
    }

    @Override
    public EnemyUserData getUserData() {
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (GameManager.getInstance().getGameState() != GameState.PAUSED) {
            stateTime += Gdx.graphics.getDeltaTime();
        }

        batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), (screenRectangle.x - (screenRectangle.width * 0.1f)),
                screenRectangle.y, screenRectangle.width * 1.2f, screenRectangle.height * 1.1f);
    }
}
