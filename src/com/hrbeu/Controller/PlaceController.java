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
                //接收省份id
                String province_idStr = req.getParameter("province_id");
                int province_id = Integer.parseInt(province_idStr);
                //得到如下list：{市的个数，市，第一个市的区}
                List<Object> objects = locationService.selectAllByProvince(province_id);
                //转化为json串
                JSONArray jsonArray = JSONArray.fromObject(objects);
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(jsonArray.toString());
                break;
            case "city":
                String city_idStr = req.getParameter("city_id");
                int city_id = Integer.parseInt(city_idStr);
                List<Qu>qus = locationService.selectQuByCity(city_id);
                JSONArray qujson = JSONArray.fromObject(qus);
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(qujson.toString());
                break;
        }

    }
}
