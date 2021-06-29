package vn.sonnl.gigaman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.AudioUtils;
import vn.sonnl.gigaman.helpers.GameEventListener;
import vn.sonnl.gigaman.helpers.GameManager;
import vn.sonnl.gigaman.screens.GameplayScreen;

public class GigamanGame extends Game {
	private SpriteBatch batch;
	public GigamanGame(GameEventListener listener) {
		GameManager.getInstance().setGameEventListener(listener);
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
		super.dispose();
		batch.dispose();
		AudioUtils.dispose();
		Assets.dispose();
	}
}
