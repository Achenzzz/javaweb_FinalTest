package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import Dao.InsertT_userDao;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("Username");
		String name= request.getParameter("Name");
		String email= request.getParameter("Email");
		String province= request.getParameter("Province");
		String city= request.getParameter("City");
		String password= request.getParameter("Password");
		Map<String, Object> map = new HashMap<String, Object>();

		
		/*
		 * System.out.println(province); System.out.println(city+"city");
		 */
		InsertT_userDao insertT_userDao=new InsertT_userDao();
		boolean res=insertT_userDao.insertT_user(userName, password, name, email, province, city);
		if (res) {
			map.put("code", 1);
			
		}else {
			map.put("code", 0);
		}
		String jsonStr = new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
