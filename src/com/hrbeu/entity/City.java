package com.hrbeu.entity;

public class City {
    private int city_id;
    private String city_name;
    private Province province;

    public City(int city_id, String city_name, Province province) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.province = province;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
