package vn.sonnl.gigaman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.screens.GameplayScreen;

public class GigaManGame extends Game {
	private SpriteBatch batch;
	private final AssetManager assetManager = new AssetManager();
	public GigaManGame() {
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		Assets.loadAssets();
		setScreen(new GameplayScreen());
	}

	@Override
	public void render () {
		super.render();
	}

	public SpriteBatch getBatch(){
		return this.batch;
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	public AssetManager getAssetManager() {
		return assetManager;
	}
}
