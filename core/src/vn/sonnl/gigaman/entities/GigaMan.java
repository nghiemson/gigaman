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

    /*private Vector2 appearPosition;
    private Vector2 position;
    private Direction direction;
    private Vector2 velocity;
    private JumpState jumpState;
    private WalkState walkState;
    private long jumpInitialTime;
    private long walkInitialTime;
    private Vector2 lastFramePosition;
    private Level level;
    private int bullets;
    private int lives;
    public boolean jumpButtonPressed;
    public boolean leftButtonPressed;
    public boolean rightButtonPressed;

    public GigaMan(Vector2 appearPosition, Level level) {
        this.appearPosition = appearPosition;
        position = new Vector2();
        lastFramePosition = new Vector2();
        velocity = new Vector2();
        init();
        this.level = level;
    }

    public int getBullets() {
        return bullets;
    }

    public int getLives() {
        return lives;
    }

    public void init() {
        bullets = Constants.INITIAL_BULLET;
        lives = GameManager.getInstance().lives;
        revival();
    }
    private void revival() {
        position.set(appearPosition);
        lastFramePosition.set(appearPosition);
        velocity.setZero();
        jumpState = Enums.JumpState.FALLING;
        direction = Direction.RIGHT;
        walkState = WalkState.STANDING;
    }

    public void update(float delta, Array<Platform> platforms){
        //update lastFramePos
        lastFramePosition.set(position);
        // Accelerate down
        velocity.y -= delta * Constants.GRAVITY;
        //Apply G's velocity to it's position
        position.mulAdd(velocity, delta);

        //If below the kill plane, init()
        if(position.y <Constants.KILL_PLANE) {
            lives--;
            revival();
        }
        // If isn't JUMPING, then FALLING
        if (jumpState != JumpState.JUMPING) {
            if (jumpState != JumpState.REBOUND)
            jumpState = JumpState.FALLING;

            for(Platform platform:platforms) {
                if(landedOnPlatform(platform)){
                    jumpState = JumpState.GROUNDED;
                    velocity.y = 0;
                    velocity.x = 0;
                    position.y = platform.top + Constants.GIGAMAN_EYE_HEIGHT;
                }
            }
        }



        if (Gdx.input.isKeyPressed(Keys.SPACE) || jumpButtonPressed) {
            // Handle jump key
            // If the jump key is pressed and G is GROUNDED, then startJump()
            // If JUMPING, then continueJump()
            switch (jumpState) {
                case GROUNDED:
                    startJump();
                    break;
                case JUMPING:
                    continueJump();
            }
        } else {
            //If the jump key wasn't pressed, endJump()
            endJump();
        }

        if(jumpState != JumpState.REBOUND) {
            boolean left = Gdx.input.isKeyPressed(Keys.LEFT) || leftButtonPressed;
            boolean right = Gdx.input.isKeyPressed(Keys.RIGHT) || rightButtonPressed;

            if (left && !right) {
                moveLeft(delta);
            } else if (right && !left) {
                moveRight(delta);
            } else {
                walkState = WalkState.STANDING;
            }
        }
        // Collide with enemies

        Rectangle gigaManBounds = new Rectangle(
                position.x - Constants.GIGAMAN_STANCE_WIDTH / 2,
                position.y - Constants.GIGAMAN_EYE_HEIGHT,
                Constants.GIGAMAN_STANCE_WIDTH,
                Constants.GIGAMAN_HEIGHT);

        for (Enemy enemy : level.getEnemies()) {
            Rectangle enemyBounds = new Rectangle(
                    enemy.position.x - Constants.ENEMY_COLLISION_RADIUS,
                    enemy.position.y - Constants.ENEMY_COLLISION_RADIUS,
                    2 * Constants.ENEMY_COLLISION_RADIUS,
                    2 * Constants.ENEMY_COLLISION_RADIUS
            );
            if (gigaManBounds.overlaps(enemyBounds)) {

                if (position.x < enemy.position.x) {
                    reboundFromEnemy(Direction.LEFT);
                } else {
                    reboundFromEnemy(Direction.RIGHT);
                }
            }
        }
        // add shoot
        if (Gdx.input.isKeyJustPressed(Keys.X)) shoot();

        // should pick up a powerup or not?
        DelayedRemovalArray<Powerup> powerups = level.getPowerups();
        powerups.begin();
        for (int i = 0; i < powerups.size; i++) {
            Powerup powerup = powerups.get(i);
            Rectangle powerupBounds = new Rectangle(
                    powerup.position.x - Constants.POWERUP_CENTER.x,
                    powerup.position.y - Constants.POWERUP_CENTER.y,
                    Assets.instance.powerupAssets.powerup.getRegionWidth(),
                    Assets.instance.powerupAssets.powerup.getRegionHeight()
            );
            if (gigaManBounds.overlaps(powerupBounds)) {
                bullets += Constants.POWERUP_BULLET;
                level.score += Constants.POWERUP_SCORE;
                powerups.removeIndex(i);
            }
        }
        powerups.end();

    }

    public void shoot() {
        if (bullets > 0) {
            bullets--;
            Vector2 bulletPosition;
            // bullet position =  GigaGal's position + cannon offset
            if (direction == Direction.RIGHT) {
                bulletPosition = new Vector2(
                        position.x + Constants.CANNON_OFFSET.x,
                        position.y + Constants.CANNON_OFFSET.y
                );
            }
            //negate the x component of the cannon offset
            else {
                bulletPosition = new Vector2(
                        position.x - Constants.CANNON_OFFSET.x,
                        position.y + Constants.CANNON_OFFSET.y
                );
            }
            level.generateBullet(bulletPosition, direction);
        }
    }
    public Vector2 getPosition() {
        return position;
    }


    private void reboundFromEnemy(Direction direction) {

        jumpState = JumpState.REBOUND;
        //Set vertical speed
        velocity.y = Constants.REBOUND_VELOCITY.y;

        //Set horizontal speed (in the correct direction)
        if (direction == Direction.LEFT) {
            velocity.x = -Constants.REBOUND_VELOCITY.x;
        } else {
            velocity.x = Constants.REBOUND_VELOCITY.x;
        }
    }

    boolean landedOnPlatform (Platform platform) {
        boolean leftFootIn = false;
        boolean rightFootIn = false;
        boolean straddle = false;

        // check if feet were above the platform top last frame and below the platform top this frame
        if (lastFramePosition.y - Constants.GIGAMAN_EYE_HEIGHT >= platform.top &&
                position.y - Constants.GIGAMAN_EYE_HEIGHT < platform.top) {

            // If so, find the position of G's left and right toes
            float leftFoot = position.x - Constants.GIGAMAN_STANCE_WIDTH / 2;
            float rightFoot = position.x + Constants.GIGAMAN_STANCE_WIDTH / 2;

            // Check if either of G's toes are on the platform
            leftFootIn = (platform.left < leftFoot && platform.right > leftFoot);
            rightFootIn = (platform.left < rightFoot && platform.right > rightFoot);

            // Check if G is straddling the platform
            straddle = (platform.left > leftFoot && platform.right < rightFoot);
        }

        //Return whether or not G had landed on the platform
        return leftFootIn || rightFootIn || straddle;
    }

    private void startJump() {
        jumpState = JumpState.JUMPING;
        jumpInitialTime = TimeUtils.nanoTime();
        continueJump();
    }

    private void continueJump() {
        // Check if JUMPING, if not, return
        if (jumpState == JumpState.JUMPING) {
            // If we have been jumping for less than the max jump duration, set vertical speed to the jump speed constant
            // Else, call endJump()
            if (Utils.secondsSince(jumpInitialTime) < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED;
            } else {
                endJump();
            }
        }
    }

    private void endJump() {
        if (jumpState == JumpState.JUMPING) {
            jumpState = JumpState.FALLING;
        }
    }

    private void moveLeft(float delta) {
        // If GROUNDED and not WALKING, save the walkInitialTime
        if (jumpState == JumpState.GROUNDED && walkState != WalkState.WALKING) {
            walkInitialTime = TimeUtils.nanoTime();
        }
        walkState = WalkState.WALKING;
        direction = Direction.LEFT;
        position.x -= delta * Constants.GIGAMAN_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        if (jumpState == JumpState.GROUNDED && walkState != WalkState.WALKING) {
            walkInitialTime = TimeUtils.nanoTime();
        }
        walkState = WalkState.WALKING;
        direction = Direction.RIGHT;
        position.x += delta * Constants.GIGAMAN_MOVE_SPEED;
    }

    public void render(SpriteBatch batch) {

        TextureRegion region = Assets.instance.gigaManAssets.standingRight;

        if (direction == Direction.RIGHT && jumpState != JumpState.GROUNDED) {
            region = Assets.instance.gigaManAssets.jumpingRight;
        } else if (direction == Direction.RIGHT && walkState == WalkState.WALKING) {
            // Calculate how long we've been walking in seconds
            float walkTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkInitialTime);
            // Select the correct frame from the walking right animation
            region = (TextureRegion) Assets.instance.gigaManAssets.walkingRightAnimation.getKeyFrame(walkTimeSeconds);
        } else if (direction == Direction.LEFT && jumpState != JumpState.GROUNDED) {
            region = Assets.instance.gigaManAssets.jumpingLeft;
        } else if (direction == Direction.LEFT && walkState == WalkState.STANDING) {
            region = Assets.instance.gigaManAssets.standingLeft;
        } else if (direction == Direction.LEFT && walkState == WalkState.WALKING) {
            // Calculate how long we've been walking in seconds
            float walkTimeSeconds = Utils.secondsSince(walkInitialTime);

            // Select the correct frame from the walking left animation
            region = (TextureRegion) Assets.instance.gigaManAssets.walkingLeftAnimation.getKeyFrame(walkTimeSeconds);
        }


        Utils.drawTextureRegion(
                batch,
                region,
                position.x - Constants.GIGAMAN_EYE_POSITION.x,
                position.y - Constants.GIGAMAN_EYE_POSITION.y);
    }*/

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
            batch.draw(dodgingTexture, x, y + screenRectangle.height / 4, width, screenRectangle.height * 0.8f);
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
