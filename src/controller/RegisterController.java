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
import Dao.UserDao;
import model.User;

@WebServlet(urlPatterns = "/register.do")
public class RegisterController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		String userName= request.getParameter("Username");
		String name= request.getParameter("Name");
		String email= request.getParameter("Email");
		String province= request.getParameter("Province");
		String city= request.getParameter("City");
		String password= request.getParameter("Password");
		Map<String, Object> map = new HashMap<String, Object>();

		User user=new User(userName, password, name, email, province, city);
	
		/*
		 * System.out.println(province); System.out.println(city+"city");
		 */
		InsertT_userDao insertT_userDao=new InsertT_userDao();
		UserDao dao = new UserDao();
		boolean res=false;
		String info="";
		if(action.equals("") || action.equals("insert")){
			res = insertT_userDao.insertT_user(userName, password, name, email, province, city);
			info="新增";
		}
		else if(action.equals("update")){
			try {
				res = dao.update(user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			info="修改";
		}
		res=insertT_userDao.insertT_user(userName, password, name, email, province, city);
		if (res) {
			map.put("code", 0);
			map.put("info", info+"成功!");
			
		}else {
			map.put("code", 1);
			map.put("info", info+"失败!");
		}
		String jsonStr = new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
