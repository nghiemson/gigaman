package vn.sonnl.gigaman.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.viewport.Viewport;

import vn.sonnl.gigaman.GameStage;
import vn.sonnl.gigaman.box2d.UserData;
import vn.sonnl.gigaman.helpers.Assets;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.Enums.*;
import vn.sonnl.gigaman.helpers.Utils;

public class Bullet extends GameActor {

    private final Vector2 position;
    public boolean active;
    private GameStage stage;
    private Enemy enemy;

    public Bullet(Body body, Vector2 position) {
        super(body);
        this.position = position;
        active = true;
        stage = new GameStage();
        enemy = new Enemy(body);

    }

    public void update(float delta) {
                position.x += delta * Constants.BULLET_MOVE_SPEED;

        //Get the world width from the level's viewport
        final float worldWidth = Constants.APP_WIDTH;

        //Get the level's viewport's camera's horizontal position
        final float cameraX = stage.getCamera().position.x;

        //If the bullet is offscreen, not active
        if (position.x < cameraX - worldWidth / 2 || position.x > cameraX + worldWidth / 2) {
            active = false;
        }
        for (Enemy enemy : stage.getEnemies()) {
            //if the bullet is within the enemy hit detection radius, active false & decrement health
            if(position.dst(new Vector2(enemy.getX(),enemy.getY())) < Constants.ENEMY_SHOT_RADIUS){
                //level.generateBurst(position);
                active = false;
                enemy.health -= 1;
            }
        }
    }

    public void draw(SpriteBatch batch) {
        TextureRegion region = Assets.instance.bulletAssets.bullet;
        Utils.drawTextureRegion(batch, region, position, Constants.BULLET_CENTER);
    }



    @Override
    public UserData getUserData() {
        return null;
    }
}
