package vn.sonnl.gigaman.box2d;

import vn.sonnl.gigaman.enums.DataType;

public class Data {

    protected DataType dataType;
    protected float width;
    protected float height;

    public Data() {

    }

    public Data(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public DataType getUserDataType() {
        return dataType;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
