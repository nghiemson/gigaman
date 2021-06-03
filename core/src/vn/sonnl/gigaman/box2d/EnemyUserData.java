package vn.sonnl.gigaman.box2d;

import com.badlogic.gdx.math.Vector2;

import vn.sonnl.gigaman.enums.UserDataType;
import vn.sonnl.gigaman.helpers.Constants;

public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String animationAssetId;

    public EnemyUserData(float width, float height, String animationAssetId) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
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
