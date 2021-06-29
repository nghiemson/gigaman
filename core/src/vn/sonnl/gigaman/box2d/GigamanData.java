package vn.sonnl.gigaman.box2d;

import com.badlogic.gdx.math.Vector2;

import vn.sonnl.gigaman.enums.DataType;
import vn.sonnl.gigaman.helpers.Constants;

public class GigamanData extends Data {

    private final Vector2 runningPosition = new Vector2(Constants.GIGAMAN_X, Constants.GIGAMAN_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.GIGAMAN_SHOOT_X, Constants.GIGAMAN_SHOOT_Y);
    private Vector2 jumpingLinearImpulse;

    public GigamanData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.GIGAMAN_JUMPING_LINEAR_IMPULSE;
        dataType = DataType.GIGAMAN;
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
        return Constants.GIGAMAN_HIT_ANGULAR_IMPULSE;
    }

}
