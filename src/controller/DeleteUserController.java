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

import model.User;

import com.google.gson.Gson;

import Dao.UserDao;

@WebServlet(urlPatterns = "/deleteUser.do")
public class DeleteUserController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		// 调用dao进行处理
		
		UserDao dao = new UserDao();
		boolean success=false;
		try {
			success = dao.delete(ids);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		if (success) {
			map.put("code", 0);
			map.put("info", "删除成功!");
		} else {
			map.put("code", 1);
			map.put("info", "删除失败!");
		}

		//.调用谷歌的Gson库将map类型数据转换为json字符串
		String jsonStr = new Gson().toJson(map);
		// 字符流输出字符串
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();

	}

}
