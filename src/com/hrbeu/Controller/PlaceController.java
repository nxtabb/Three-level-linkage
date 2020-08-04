package com.hrbeu.Controller;

import com.hrbeu.Dao.LocationDao;
import com.hrbeu.Service.LocationService;
import com.hrbeu.entity.City;
import com.hrbeu.entity.Qu;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/place")
public class PlaceController extends HttpServlet {
    LocationService locationService = new LocationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String content = req.getParameter("content");
        switch (content){
            case "province":
                String province_idStr = req.getParameter("province_id");
                int province_id = Integer.parseInt(province_idStr);
                List<City> cities = locationService.selectCityByProvince(province_id);
                int cityid = cities.get(0).getCity_id();
                List<Qu> qus = locationService.selectQuByCity(cityid);
                List<Object> objects = new ArrayList<Object>();
                objects.add(cities.size());
                for(City city:cities){
                    objects.add(city);
                }
                for(Qu qu:qus){
                    objects.add(qu);
                }
                JSONArray jsonArray = JSONArray.fromObject(objects);
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(jsonArray.toString());
                break;
            case "city":
                String city_idStr = req.getParameter("city_id");
                int city_id = Integer.parseInt(city_idStr);
                qus = locationService.selectQuByCity(city_id);
                JSONArray qujson = JSONArray.fromObject(qus);
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(qujson.toString());
                break;
        }

    }
}
