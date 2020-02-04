package com.example.touchit;

public class Model {

    String img1, tv1;
    boolean check;

    public Model(String img1, String tv1, boolean check) {
        this.img1 = img1;
        this.check = check;
        this.tv1 = tv1;

    }

    public Model(String img1, String tv1) {
        this.img1 = img1;
        this.tv1 = tv1;
    }

    public Model() {
    }


    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }


    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }


}
