package com.hrbeu.Service;

import com.hrbeu.Dao.LocationDao;
import com.hrbeu.entity.City;
import com.hrbeu.entity.Qu;

import java.sql.Connection;
import java.util.List;

public class LocationService {
    private LocationDao locationDao = new LocationDao();
    public List<City> selectCityByProvince(int province_id){
        return locationDao.selectCityByProvince(province_id);
    }

    public List<Qu> selectQuByCity(int city_id) {
        return locationDao.selectQuByCity(city_id);
    }
}
