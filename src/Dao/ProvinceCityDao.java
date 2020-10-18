package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import model.t_city;

//按省份privinceId查询所有城市
public class ProvinceCityDao {
	public List<String> queryCityByprovinceId(int provinceId) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<String> list=new ArrayList<String>();
        
        try {
            connection = DBUtil.getConnection2();
            String sqlString="select city \r\n" + 
            		"FROM t_city\r\n" + 
            		"WHERE provinceId=?";
            statement = connection.prepareStatement(sqlString);
            statement.setInt(1, provinceId);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	String string=resultSet.getString("city");
				list.add(string);
			}

		} catch (Exception e) {
		   	System.out.println("异常");
            e.printStackTrace();
		}
        finally {
            DBUtil.closeALL(resultSet, statement, connection);

		}
		return list;
		
	}
	
//按省名province查询对应的provinceId
	public int  queryprovinceIdByprovine(String province) {
		ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        int provinceId=0;
        
        try {
            connection = DBUtil.getConnection2();
            String sqlString="SELECT provinceId\r\n" + 
            		"from  t_province\r\n" + 
            		"WHERE province=?";
            statement = connection.prepareStatement(sqlString);
            statement.setString(1, province);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
				provinceId=resultSet.getInt("provinceId");
			}
		} catch (Exception e) {
		   	System.out.println("异常");
            e.printStackTrace();
		}
        finally {
            DBUtil.closeALL(resultSet, statement, connection);

		}
		return provinceId;
		
	}

//查询所有省份
	public List<String> queryProvince() {
		ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<String> list=new ArrayList<String>();
        
        try {
            connection = DBUtil.getConnection2();
            connection = DBUtil.getConnection2();
            String sqlString="select province \r\n" + 
            		"FROM t_province";
            statement = connection.prepareStatement(sqlString);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	String string=resultSet.getString("province");
				list.add(string);
            }

		}
            catch (Exception e) {
		   	System.out.println("异常");
            e.printStackTrace();
		}
        finally {
            DBUtil.closeALL(resultSet, statement, connection);

		}
		return list;
        }
	

}
