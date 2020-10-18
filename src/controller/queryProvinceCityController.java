package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.ProvinceCityDao;

/**
 * Servlet implementation class queryProvinceCityController
 */
@WebServlet("/queryProvinceCityController")
public class queryProvinceCityController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jsonStr="";
		ProvinceCityDao provinceCityDao=new ProvinceCityDao();
		
		String province=request.getParameter("provinceCode");
		/* System.out.println(province); */
		if (province!=null) {
			//获取所有城市
			int provinceId=provinceCityDao.queryprovinceIdByprovine(province);
			List<String> list = provinceCityDao.queryCityByprovinceId(provinceId);
			/*
			 * for (String string : list) { System.out.println(string); }
			 */
			jsonStr=new Gson().toJson(list);
		}else {
			//获取所有省份
			List<String> list = provinceCityDao.queryProvince();
			jsonStr=new Gson().toJson(list);
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
		
	}

}
