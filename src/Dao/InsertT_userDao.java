package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBUtil.DBUtil;

public class InsertT_userDao {
	public boolean insertT_user(String userName, String password, String name, String email, String province,
			String city) {
		boolean res=false;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
            connection = DBUtil.getConnection2();
            String sqlString="INSERT INTO t_user (userName,password,name,email,province,city) \r\n" + 
            		"VALUES (?,?,?,?,?,?);";
            statement=connection.prepareStatement(sqlString);
            statement.setString(1,userName);
            statement.setString(2, password);
            statement.setString(3,name);
            statement.setString(4,email);
            statement.setString(5,province);
            statement.setString(6,city);

            int result = statement.executeUpdate();
			if (result != 0) {
				System.out.println("插入成功！");
				res=true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			   DBUtil.closeALL(resultSet, statement, connection);

		}
		return res;
	}

}
