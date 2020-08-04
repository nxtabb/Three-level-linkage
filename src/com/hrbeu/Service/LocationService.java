package com.hrbeu.Service;

import com.hrbeu.Dao.LocationDao;
import com.hrbeu.entity.City;
import com.hrbeu.entity.Qu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LocationService {
    private LocationDao locationDao = new LocationDao();

    public List<Object> selectAllByProvince(int province_id) {
        List<City> cities = locationDao.selectCityByProvince(province_id);
        int cityid = cities.get(0).getCity_id();
        List<Qu> qus = this.locationDao.selectQuByCity(cityid);
        List<Object> objects = new ArrayList<Object>();
        objects.add(cities.size());
        objects.addAll(cities);
        objects.addAll(qus);
        return objects;
    }

    public List<Qu> selectQuByCity(int city_id) {
        return locationDao.selectQuByCity(city_id);
    }
}
