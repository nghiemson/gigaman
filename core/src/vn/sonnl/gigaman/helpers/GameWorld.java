package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import vn.sonnl.gigaman.box2d.EnemyData;
import vn.sonnl.gigaman.box2d.GigamanData;
import vn.sonnl.gigaman.box2d.GroundData;
import vn.sonnl.gigaman.enums.EnemyType;

public class GameWorld {
    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        body.setUserData(new GroundData(Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT));
        shape.dispose();
        return body;
    }

    public static Body createGigaMan(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.GIGAMAN_X, Constants.GIGAMAN_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GIGAMAN_WIDTH / 2, Constants.GIGAMAN_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.GIGAMAN_GRAVITY_SCALE);
        body.createFixture(shape, Constants.GIGAMAN_DENSITY);
        body.resetMassData();
        body.setUserData(new GigamanData(Constants.GIGAMAN_WIDTH, Constants.GIGAMAN_HEIGHT));
        shape.dispose();
        return body;
    }

    public static Body createEnemy(World world) {
        EnemyType enemyType = RandomUtils.getRandomEnemyType();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, enemyType.getDensity());
        body.resetMassData();
        EnemyData userData = new EnemyData(enemyType.getWidth(), enemyType.getHeight(),
                enemyType.getAnimationAssetId());
        body.setUserData(userData);
        shape.dispose();
        return body;
    }

}
