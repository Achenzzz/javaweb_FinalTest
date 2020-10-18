package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.T_userDao;
import Dao.UserDao;

/**
 * Servlet implementation class CheckuserNameController
 */
@WebServlet("/CheckuserNameController")
public class CheckuserNameController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean res = false;
		// 存放返回值信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		// 验证用户名
		String userNameString = request.getParameter("username");
		T_userDao t_userDao = new T_userDao();
		List<String> list = t_userDao.findUsername();
		for (String string : list) {
			if (userNameString.equals(string)) {
				res = true;
			
			}
			if (res) {
				map.put("code", 1);
				map.put("info", "用户名重复，请换一个！");
			} else {
				String pattern = "^[-_a-zA-Z0-9]{4,15}$";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(userNameString);
				//System.out.println(m.matches());
				if (m.matches()) {
					map.put("code", 0);
					map.put("info", "符合！");
				} else {
					map.put("code", 2);
					map.put("info", "用户名格式不正确，必须为用户名只能使用英文字母和数字，以字母开头，长度为4到15个字符");
				}
			}

		}
		String jsonStr = new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
