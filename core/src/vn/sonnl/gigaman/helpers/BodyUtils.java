package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.physics.box2d.Body;

import vn.sonnl.gigaman.box2d.UserData;
import vn.sonnl.gigaman.enums.UserDataType;

public class BodyUtils {
    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();

        switch (userData.getUserDataType()) {
            case GIGAMAN:
            case ENEMY:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }

        return true;
    }

    public static boolean bodyIsEnemy(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

    public static boolean bodyIsRunner(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GIGAMAN;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
}
