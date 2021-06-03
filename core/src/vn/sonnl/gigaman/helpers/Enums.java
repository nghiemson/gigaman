package vn.sonnl.gigaman.helpers;

public class Enums {
    public enum Direction {
        LEFT,
        RIGHT
    }

    public enum JumpState {
        JUMPING,
        FALLING,
        GROUNDED,
        REBOUND
    }

    public enum WalkState {
        STANDING,
        WALKING
    }
}
