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

    private static HashMap<String, TextureRegion> texturesMap = new HashMap<>();
    private static HashMap<String, Animation> animationsMap = new HashMap<>();
    private static TextureAtlas textureAtlas;
    private static TextureAtlas textureAtlas2;
    private static BitmapFont smallFont;
    private static BitmapFont smallestFont;
    private static BitmapFont largeFont;
    private AssetManager assetManager;

    private Assets() {
        this.assetManager = new AssetManager();
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();
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
        texturesMap.put(Constants.GIGAMAN_DODGING_ASSETS_ID,
                textureAtlas2.findRegion(Constants.GIGAMAN_DODGING_REGION_NAME));
        texturesMap.put(Constants.GIGAMAN_HIT_ASSETS_ID,
                textureAtlas2.findRegion(Constants.GIGAMAN_HIT_REGION_NAME));
        animationsMap.put(Constants.GIGAMAN_RUNNING_ASSETS_ID, createAnimation(textureAtlas2,
                Constants.GIGAMAN_RUNNING_REGION_NAMES));

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