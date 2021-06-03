package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;

public class Assets {

    /*public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    public GigaManAssets gigaManAssets;
    private AssetManager assetManager;
    public PlatformAssets platformAssets;
    public EnemyAssets enemyAssets;
    public BulletAssets bulletAssets;
    public BurstAssets burstAssets;
    public PowerupAssets powerupAssets;
    public ExitPortalAssets exitPortalAssets;
    public MobileControlsAssets mobileControlsAssets;
    public ButtonAssets buttonAssets;
    private Assets() {
    }

    public void init() {
        this.assetManager = new AssetManager();
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        gigaManAssets = new GigaManAssets(atlas);
        platformAssets = new PlatformAssets(atlas);
        enemyAssets = new EnemyAssets(atlas);
        bulletAssets = new BulletAssets(atlas);
        burstAssets = new BurstAssets(atlas);
        powerupAssets = new PowerupAssets(atlas);
        exitPortalAssets = new ExitPortalAssets(atlas);
        mobileControlsAssets = new MobileControlsAssets(atlas);
        buttonAssets = new ButtonAssets(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public static class GigaManAssets {

        // AtlasRegion holds the standing, jumping right or left sprite
        public final AtlasRegion standingRight;
        public final AtlasRegion standingLeft;
        public final AtlasRegion jumpingLeft;
        public final AtlasRegion jumpingRight;
        public final AtlasRegion walkingLeft;
        public final AtlasRegion walkingRight;
        public final Animation<?> walkingLeftAnimation;
        public final Animation<?> walkingRightAnimation;

        public GigaManAssets(TextureAtlas atlas) {
            //  initialize the standing, jumping ... right-left AtlasRegion
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT);
            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT);
            walkingLeft = atlas.findRegion(Constants.WALKING_LEFT_2);
            walkingRight = atlas.findRegion(Constants.WALKING_RIGHT_2);

            Array<AtlasRegion> walkingLeftFrames = new Array<>();
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_2));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_1));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_2));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_3));
            walkingLeftAnimation = new Animation<>(Constants.WALK_LOOP_DURATION, walkingLeftFrames, Animation.PlayMode.LOOP);

            Array<AtlasRegion> walkingRightFrames = new Array<>();
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_1));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_3));
            walkingRightAnimation = new Animation<>(Constants.WALK_LOOP_DURATION, walkingRightFrames, Animation.PlayMode.LOOP);

        }
    }

    public static class PlatformAssets {
        public final NinePatch ninePatch;

        public PlatformAssets(TextureAtlas atlas) {
            AtlasRegion region = atlas.findRegion(Constants.PLATFORM);
            int edge = Constants.PLATFORM_EDGE;
            ninePatch = new NinePatch(region, edge, edge, edge, edge);
        }
    }

    public static class EnemyAssets {
        public final AtlasRegion enemy;
        public  EnemyAssets (TextureAtlas atlas) {
            enemy = atlas.findRegion(Constants.ENEMY);
        }
    }

    public static class BulletAssets {

        //Add an AtlasRegion to hold the bullet sprite
        public final AtlasRegion bullet;

        public BulletAssets(TextureAtlas atlas) {
            // Find the bullet atlas region
            bullet = atlas.findRegion(Constants.BULLET);
        }

    }

    public static class BurstAssets {

        public final Animation burst;

        public BurstAssets(TextureAtlas atlas) {

            // TODO: Populate the explosion animation
            // First find the appropriate AtlasRegions
            // Then pack them into an animation with the correct frame duration

            Array<AtlasRegion> burstRegions = new Array<>();
            burstRegions.add(atlas.findRegion(Constants.BURST_LARGE));
            burstRegions.add(atlas.findRegion(Constants.BURST_MEDIUM));
            burstRegions.add(atlas.findRegion(Constants.BURST_SMALL));

            burst = new Animation(Constants.BURST_DURATION / burstRegions.size,
                    burstRegions, Animation.PlayMode.NORMAL);
        }
    }

    public static class PowerupAssets {

        // TODO: Add an AtlasRegion to hold the powerup sprite
        public final AtlasRegion powerup;

        public PowerupAssets(TextureAtlas atlas) {
            // TODO: Find the powerup atlas region
            powerup = atlas.findRegion(Constants.POWERUP);
        }
    }

    public class ExitPortalAssets {

        // TODO: Add an Animation for the exit portal
        public final Animation exitPortal;

        public ExitPortalAssets(TextureAtlas atlas) {
            final AtlasRegion exitPortal1 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_1);
            final AtlasRegion exitPortal2 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_2);
            final AtlasRegion exitPortal3 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_3);
            final AtlasRegion exitPortal4 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_4);
            final AtlasRegion exitPortal5 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_5);
            final AtlasRegion exitPortal6 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_6);

            Array<AtlasRegion> exitPortalFrames = new Array<AtlasRegion>();

            // TODO: Add the frames to the exitPortalFrames array
            exitPortalFrames.addAll(exitPortal1, exitPortal2, exitPortal3, exitPortal4, exitPortal5, exitPortal6);

            // TODO: Package the frames into an animation, using the frame duration constant
            // Go define that constant in Constants.java if you haven't already
            exitPortal = new Animation(Constants.EXIT_PORTAL_FRAME_DURATION, exitPortalFrames);
        }
    }

    public class MobileControlsAssets {

        public final AtlasRegion moveRight;
        public final AtlasRegion moveLeft;
        public final AtlasRegion shoot;
        public final AtlasRegion jump;

        public MobileControlsAssets(TextureAtlas atlas) {
            moveRight = atlas.findRegion(Constants.MOVE_RIGHT_BUTTON);
            moveLeft = atlas.findRegion(Constants.MOVE_LEFT_BUTTON);
            shoot = atlas.findRegion(Constants.SHOOT_BUTTON);
            jump = atlas.findRegion(Constants.JUMP_BUTTON);
        }
    }

    public class ButtonAssets {
        public final AtlasRegion pause;

        public ButtonAssets(TextureAtlas atlas) {
            pause = atlas.findRegion(Constants.PAUSE);
        }
    }
*/
    private static HashMap<String, TextureRegion> texturesMap = new HashMap<>();
    private static HashMap<String, Animation> animationsMap = new HashMap<>();
    private static TextureAtlas textureAtlas;
    private static TextureAtlas textureAtlas2;
    private static BitmapFont smallFont;
    private static BitmapFont smallestFont;
    private static BitmapFont largeFont;
    private AssetManager assetManager;
    public BulletAssets bulletAssets;
    public static final Assets instance = new Assets();

    private Assets() {
        this.assetManager = new AssetManager();
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        bulletAssets = new BulletAssets(atlas);
    }
    public void init() {


    }
    public static void loadAssets() {

        // Background
        texturesMap.put(Constants.BACKGROUND_ASSETS_ID,
                new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_IMAGE_PATH))));

        // Ground
        texturesMap.put(Constants.GROUND_ASSETS_ID,
                new TextureRegion(new Texture(Gdx.files.internal(Constants.GROUND_IMAGE_PATH))));

        textureAtlas = new TextureAtlas(Constants.SPRITES_ATLAS_PATH);
        textureAtlas2 = new TextureAtlas(Constants.GIGAMAN_ATLAS_PATH);

        // GigaMan
        texturesMap.put(Constants.GIGAMAN_JUMPING_ASSETS_ID,
                textureAtlas2.findRegion(Constants.GIGAMAN_JUMPING_REGION_NAME));
        texturesMap.put(Constants.RUNNER_DODGING_ASSETS_ID,
                textureAtlas2.findRegion(Constants.RUNNER_DODGING_REGION_NAME));
        texturesMap.put(Constants.GIGAMAN_HIT_ASSETS_ID,
                textureAtlas2.findRegion(Constants.GIGAMAN_HIT_REGION_NAME));
        animationsMap.put(Constants.GIGAMAN_RUNNING_ASSETS_ID, createAnimation(textureAtlas2,
                Constants.GIGAMAN_RUNNING_REGION_NAMES));

        //Bullet
        texturesMap.put(Constants.BULLET_ASSETS_ID, textureAtlas2.findRegion(Constants.BULLET_REGION_NAME));
        // Enemies
        animationsMap.put(Constants.RUNNING_SMALL_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.RUNNING_SMALL_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_BIG_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.RUNNING_BIG_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_LONG_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.RUNNING_LONG_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.RUNNING_WIDE_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.RUNNING_WIDE_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.FLYING_SMALL_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.FLYING_SMALL_ENEMY_REGION_NAMES));
        animationsMap.put(Constants.FLYING_WIDE_ENEMY_ASSETS_ID, createAnimation(textureAtlas,
                Constants.FLYING_WIDE_ENEMY_REGION_NAMES));

        // Tutorial
        texturesMap.put(Constants.TUTORIAL_LEFT_REGION_NAME,
                textureAtlas.findRegion(Constants.TUTORIAL_LEFT_REGION_NAME));
        texturesMap.put(Constants.TUTORIAL_RIGHT_REGION_NAME,
                textureAtlas.findRegion(Constants.TUTORIAL_RIGHT_REGION_NAME));

        // Fonts
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_NAME));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        smallFont = generator.generateFont(parameter);
        smallFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 72;
        largeFont = generator.generateFont(parameter);
        largeFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 24;
        smallestFont = generator.generateFont(parameter);
        smallestFont.setColor(.21f, .22f, .21f, 1f);
        generator.dispose();

    }

    public static class BulletAssets {

        //Add an AtlasRegion to hold the bullet sprite
        public final TextureAtlas.AtlasRegion bullet;

        public BulletAssets(TextureAtlas atlas) {
            // Find the bullet atlas region
            bullet = atlas.findRegion(Constants.BULLET);
        }

    }

    public static TextureRegion getTextureRegion(String key) {
        return texturesMap.get(key);
    }

    public static Animation getAnimation(String key) {
        return animationsMap.get(key);
    }

    private static Animation createAnimation(TextureAtlas textureAtlas, String[] regionNames) {

        Object[] runningFrames = new TextureRegion[regionNames.length];

        for (int i = 0; i < regionNames.length; i++) {
            String path = regionNames[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }

        return new Animation(0.1f, runningFrames);

    }

    public static TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    public static BitmapFont getLargeFont() {
        return largeFont;
    }

    public static BitmapFont getSmallestFont() {
        return smallestFont;
    }

    public static void dispose() {
        textureAtlas.dispose();
        smallestFont.dispose();
        smallFont.dispose();
        largeFont.dispose();
        texturesMap.clear();
        animationsMap.clear();
    }

}