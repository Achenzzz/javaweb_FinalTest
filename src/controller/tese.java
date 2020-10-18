package controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.ProvinceCityDao;
import Dao.T_userDao;

public class tese {
	public static void main(String[] args) {
		/*
		 * ProvinceCityDao provinceCityDao=new ProvinceCityDao();
		 * 
		 * List<String> list=provinceCityDao.queryProvince();
		 * System.out.println(list.size()); for (String string : list) {
		 * System.out.println(string); }
		 */
		/*
		 * ProvinceCityDao provinceCityDao=new ProvinceCityDao(); System.out.println(
		 * provinceCityDao.queryprovinceIdByprovine("北京"));
		 * 
		 */
		/*
		 * ProvinceCityDao provinceCityDao=new ProvinceCityDao(); List<String>
		 * list=provinceCityDao.queryCityByprovinceId(02);
		 * System.out.println(list.size()); for (String string : list) {
		 * System.out.println(string); }
		 */
		/*
		 * T_userDao t_userDao=new T_userDao(); List<String>
		 * list=t_userDao.findUsername(); for (String string : list) {
		 * System.out.println(string); }
		 */
	
			
			
				String str = "qweq23123";
				String pattern = "^[-_a-zA-Z0-9]{4,16}$";

				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(str);
				System.out.println(m.matches());
			}

		

	}


