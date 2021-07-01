package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.physics.box2d.Body;

import vn.sonnl.gigaman.box2d.Data;
import vn.sonnl.gigaman.enums.DataType;

public class BodyUtils {
    public static boolean bodyInBounds(Body body) {
        Data data = (Data) body.getUserData();

        switch (data.getUserDataType()) {
            case GIGAMAN:
            case ENEMY:
                return body.getPosition().x + data.getWidth() / 2 > 0;
        }

        return true;
    }

    public static boolean bodyIsEnemy(Body body) {
        Data data = (Data) body.getUserData();

        return data != null && data.getUserDataType() == DataType.ENEMY;
    }

    public static boolean bodyIsGigaman(Body body) {
        Data data = (Data) body.getUserData();

        return data != null && data.getUserDataType() == DataType.GIGAMAN;
    }

    public static boolean bodyIsGround(Body body) {
        Data data = (Data) body.getUserData();

        return data != null && data.getUserDataType() == DataType.GROUND;
    }
}
