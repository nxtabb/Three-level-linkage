package com.hrbeu.Dao;

import com.hrbeu.Util.DBUtil;
import com.hrbeu.entity.City;
import com.hrbeu.entity.Province;
import com.hrbeu.entity.Qu;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<City> selectCityByProvince(int province_id) {
        Province province = this.selectProvinceById(province_id);
        List<City> cities = new ArrayList<City>();
        connection= DBUtil.getConnection();
        String sql = "select * from city where province_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,province_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String city_name = resultSet.getString(2);
                City city = new City(id,city_name,province);
                cities.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return cities;
    }


    public Province selectProvinceById(int province_id) {
        Province province = null;
        connection= DBUtil.getConnection();
        String sql = "select * from province where province_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,province_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String province_name = resultSet.getString(2);
                province = new Province(id,province_name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return province;
    }

    public List<Qu> selectQuByCity(int city_id) {
        City city = this.selectOneCityById(city_id);
        List<Qu> qus = new ArrayList<Qu>();
        connection= DBUtil.getConnection();
        String sql = "select * from qu where city_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,city_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String qu_name = resultSet.getString(2);
                Qu qu = new Qu(id,qu_name,city);
                qus.add(qu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return qus;

    }

    private City selectOneCityById(int city_id) {
        Province province = null;
        City city = null;
        connection= DBUtil.getConnection();
        String sql = "select * from city where city_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,city_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt(1);
                String city_name = resultSet.getString(2);
                int province_id = resultSet.getInt(3);
                province = selectProvinceById(province_id);
                city = new City(id,city_name,province);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return city;
    }


}
