package vn.sonnl.gigaman.box2d;

import vn.sonnl.gigaman.enums.DataType;

public class GroundData extends Data {

    public GroundData(float width, float height) {
        super(width, height);
        dataType = DataType.GROUND;
    }

}
