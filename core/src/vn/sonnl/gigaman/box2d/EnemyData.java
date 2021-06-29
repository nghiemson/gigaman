package vn.sonnl.gigaman.box2d;

import com.badlogic.gdx.math.Vector2;

import vn.sonnl.gigaman.enums.DataType;
import vn.sonnl.gigaman.helpers.Constants;

public class EnemyData extends Data {

    private Vector2 linearVelocity;
    private String animationAssetId;

    public EnemyData(float width, float height, String animationAssetId) {
        super(width, height);
        dataType = DataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.animationAssetId = animationAssetId;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public String getAnimationAssetId() {
        return animationAssetId;
    }

}
