package com.hrbeu.entity;

public class Qu {
    private int qu_id;
    private String qu_name;
    private City city;

    public Qu(int qu_id, String qu_name, City city) {
        this.qu_id = qu_id;
        this.qu_name = qu_name;
        this.city = city;
    }

    public int getQu_id() {
        return qu_id;
    }

    public void setQu_id(int qu_id) {
        this.qu_id = qu_id;
    }

    public String getQu_name() {
        return qu_name;
    }

    public void setQu_name(String qu_name) {
        this.qu_name = qu_name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
