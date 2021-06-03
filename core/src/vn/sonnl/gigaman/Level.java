/*
package vn.sonnl.gigaman;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vn.sonnl.gigaman.entities.Bullet;
import vn.sonnl.gigaman.entities.Burst;
import vn.sonnl.gigaman.entities.Enemy;
import vn.sonnl.gigaman.entities.GigaMan;
import vn.sonnl.gigaman.entities.Platform;
import vn.sonnl.gigaman.entities.Powerup;
import vn.sonnl.gigaman.helpers.Constants;
import vn.sonnl.gigaman.helpers.Enums.*;
import vn.sonnl.gigaman.entities.ExitPortal;
import vn.sonnl.gigaman.helpers.GameManager;


public class Level {

    private Viewport viewport;
    private GigaMan gigaMan;
    private Array<Platform> platforms;
    private DelayedRemovalArray<Enemy> enemies;
    private DelayedRemovalArray<Bullet> bullets;
    private DelayedRemovalArray<Burst> bursts;
    private  DelayedRemovalArray<Powerup> powerups;
    private ExitPortal exitPortal;
    public  boolean gameOver;
    public  boolean winning;
    public int score;
    private GigaManGame game;

    public Level() {
        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        gigaMan = new GigaMan(Constants.DEFAULT_APPEAR_LOCATION, this);
        platforms = new Array<>();
        enemies = new DelayedRemovalArray<>();
        bullets = new DelayedRemovalArray<>();
        bursts = new DelayedRemovalArray<>();
        powerups = new DelayedRemovalArray<>();
        exitPortal = new ExitPortal(Constants.EXIT_PORTAL_DEFAULT_LOCATION);
        gameOver = false;
        winning = false;
        score = GameManager.getInstance().score;
    }

    public static Level initLevel() {
        Level level = new Level();
        level.initializeLevel();
        return level;
    }

    public void update(float delta) {
        if (gigaMan.getLives() <= 0) gameOver =true;

        else if (gigaMan.getPosition().dst(exitPortal.position) < Constants.EXIT_PORTAL_RADIUS)
            winning = true;
        if (!gameOver && !winning) {
            gigaMan.update(delta, platforms);
            // Update Bullets
            bullets.begin();
            for (Bullet bullet : bullets) {
                bullet.update(delta);
                if (!bullet.active) {
                    bullets.removeValue(bullet, false);
                }
            }
            bullets.end();
            //update enemies
            enemies.begin();
            for (int i = 0; i < enemies.size; i++) {
                Enemy enemy = enemies.get(i);
                enemy.update(delta);
                if (enemy.health < 1) {
                    generateBurst(enemy.position);
                    enemies.removeIndex(i);
                    score += Constants.ENEMY_KILL_SCORE;
                }
            }
            enemies.end();

            bursts.begin();
            for (int i = 0; i < bursts.size; i++) {
                if (bursts.get(i).isFinished()) {
                    bursts.removeIndex(i);
                }
            }
            bursts.end();
        }
    }

    public void render(SpriteBatch batch) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        for (Platform platform : platforms) {
            platform.render(batch);
        }

        exitPortal.render(batch);
        for(Enemy enemy : enemies) {
            enemy.render(batch);
        }
        gigaMan.render(batch);
        for(Bullet bullet:bullets) {
            bullet.render(batch);
        }

        for(Burst burst : bursts) burst.render(batch);
        for(Powerup powerup : powerups) powerup.render(batch);
    }

    private void initializeLevel() {
        gigaMan = new GigaMan(new Vector2(15, 40), this);
        platforms = new Array<>();
        bullets = new DelayedRemovalArray<>();
        enemies = new DelayedRemovalArray<>();
        bursts = new DelayedRemovalArray<>();
        powerups = new DelayedRemovalArray<>();
        platforms.add(new Platform(75, 90, 100, 65));
        platforms.add(new Platform(10, 20, 20, 9));
        platforms.add(new Platform(100, 110, 30, 9));
        platforms.add(new Platform(200, 130, 30, 40));
        platforms.add(new Platform(150, 150, 30, 9));
        platforms.add(new Platform(150, 180, 30, 9));
        platforms.add(new Platform(200, 200, 9, 9));
        platforms.add(new Platform(280, 100, 30, 9));
        platforms.add(new Platform(15,100, 30, 20));
        Platform enemyPlatform = new Platform(75, 90, 100, 65);
        //add an enemy sitting on enemyPlatform
        enemies.add(new Enemy(enemyPlatform));
        enemies.add(new Enemy(new Platform(230, 50, 100, 150)));
        platforms.add(enemyPlatform);
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));
        platforms.add(new Platform(230, 50, 100, 150));
        platforms.add(new Platform(250, 90, 30, 15));
        powerups.add(new Powerup(new Vector2(20,110)));
        exitPortal = new ExitPortal(new Vector2(150, 150));
    }

    public void generateBullet(Vector2 position, Direction direction) {
        bullets.add(new Bullet(position, direction, this));
    }

    public void generateBurst(Vector2 position) {
        bursts.add(new Burst(position));
    }

    public Array<Platform> getPlatforms() {
        return platforms;
    }
    public GigaMan getGigaMan() {
        return gigaMan;
    }

    public void setGigaMan(GigaMan gigaMan) {
        this.gigaMan = gigaMan;
    }

    public void setPlatforms(Array<Platform> platforms) {
        this.platforms = platforms;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public DelayedRemovalArray<Enemy> getEnemies() {
        return enemies;
    }
    public DelayedRemovalArray<Powerup> getPowerups() {
        return powerups;
    }
    public void setExitPortal(ExitPortal exitPortal) {
        this.exitPortal = exitPortal;
    }
}

*/
