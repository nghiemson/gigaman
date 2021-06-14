package vn.sonnl.gigaman.box2d;

import com.badlogic.gdx.math.Vector2;

import vn.sonnl.gigaman.enums.UserDataType;
import vn.sonnl.gigaman.helpers.Constants;

public class GigamanUserData extends UserData {

    private final Vector2 runningPosition = new Vector2(Constants.GIGAMAN_X, Constants.GIGAMAN_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.GIGAMAN_SHOOT_X, Constants.GIGAMAN_SHOOT_Y);
    private Vector2 jumpingLinearImpulse;

    public GigamanUserData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.GIGAMAN;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

    public float getDodgeAngle() {
        // In radians
        return (float) (90f * (Math.PI / 180f));
    }

    public Vector2 getRunningPosition() {
        return runningPosition;
    }

    public Vector2 getDodgePosition() {
        return dodgePosition;
    }

    public float getHitAngularImpulse() {
        return Constants.RUNNER_HIT_ANGULAR_IMPULSE;
    }

}
