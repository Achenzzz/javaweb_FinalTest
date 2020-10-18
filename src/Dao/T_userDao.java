package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;

public class T_userDao {
	public List<String> findUsername() {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String> list=new ArrayList<String>();
		
		try {
            connection = DBUtil.getConnection2();
            String sqlString="select userName\r\n" + 
            		"FROM t_user";
            statement = connection.prepareStatement(sqlString);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	String string=resultSet.getString("userName");
				list.add(string);
			}
			
		} catch (Exception e) {
			
		}finally {
			   DBUtil.closeALL(resultSet, statement, connection);
		}
		return list;

	}

}
