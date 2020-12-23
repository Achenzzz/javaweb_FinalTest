package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;



public class MapData {
	
	public static void main(String[] args) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		String string1= "赵,钱,孙,李,周,吴,郑,王,冯,陈,褚,卫,蒋,沈,韩,杨,朱,秦,尤,许,何,吕,施,张,孔,曹,严,华,金,魏,陶,姜,戚,谢,邹,喻,柏,水,窦,章,云,苏,潘,葛,奚,范,彭,郎,鲁,韦,昌,马,苗";
		String string2="澄邈、德泽、海超、海阳、海荣、海逸、海昌、瀚钰、瀚文、涵亮、涵煦、明宇、涵衍、浩皛、浩波、浩博、浩初、浩宕、浩歌、浩广、浩邈、浩气、浩思、浩言、鸿宝、鸿波、鸿博、鸿才、鸿畅、鸿畴、鸿达、鸿德、鸿飞、鸿风、鸿福、鸿光、鸿晖、鸿朗、鸿文、鸿轩、鸿煊、鸿骞、鸿远、鸿云、鸿哲、鸿祯、鸿志、鸿卓、嘉澍、光济、澎湃、彭泽、鹏池、鹏海、浦和、浦泽、瑞渊、越泽、博耘、德运、辰宇、辰皓、辰钊、辰铭、辰锟、辰阳、辰韦、辰良、辰沛、晨轩、晨涛、晨濡、晨潍、鸿振、吉星、铭晨、起运、运凡、运凯、运鹏、运浩、运诚、运良、运鸿、运锋、运盛、运升、运杰、运珧、运骏、运凯、运乾、维运、运晟、运莱、运华、耘豪、星爵、星腾、星睿、星泽、星鹏、星然、震轩、震博、康震、震博、振强、振博、振华、振锐、振凯、振海、振国、振平、昂然、昂雄、昂杰、昂熙、昌勋、昌盛、昌淼、昌茂、昌黎、昌燎、昌翰、晨朗、德明、德昌、德曜、范明、飞昂、高旻、晗日、昊然、昊天、昊苍、昊英、昊宇、昊嘉、昊明、昊伟、昊硕、昊磊、昊东、鸿晖、鸿朗、华晖、金鹏、晋鹏、敬曦、景明、景天、景浩、俊晖、君昊、昆琦、昆鹏、昆纬、昆宇、昆锐、昆卉、昆峰、昆颉、昆谊、昆皓、昆鹏、昆明、昆杰、昆雄、昆纶、鹏涛、鹏煊、曦晨、曦之、新曦、旭彬、旭尧、旭鹏、旭东、旭炎、炫明、宣朗、学智、轩昂、彦昌、曜坤、曜栋、曜文、曜曦、曜灿、曜瑞、智伟、智杰、智刚、智阳、昌勋、昌盛、昌茂、昌黎、昌燎、昌翰、晨朗、昂然、昂雄、昂杰、昂熙、范明、飞昂、高朗";
	String[] strings1=string1.split(",");
	String[] strings2=string2.split("、");
	/*
	 * for (String string : strings2) { System.out.println(string); } for (String
	 * string : strings1) { System.out.println(string); }
	 */
	for(int i=1;i<201;i++){
		// 范围98.0 ~ 120.0
		// 范围24.0 ~ 40.0
		Random random=new Random();
		int num = random.nextInt(strings1.length);
		String ChrName=strings1[num]+strings2[num];
		//System.out.println(ChrName); 
		double a = Math.random() * 22.0 + 98.0;
		double b = Math.random() * 16.0 + 24.0;
		String sqlString="INSERT INTO MapData (ChrName,a,b) VALUES ('"+ChrName+"', '"+a+"', '"+b+"');";
		System.out.println(sqlString);


	
	try {
        connection = DBUtil.getConnection();
        
        statement=connection.prepareStatement(sqlString);
       
        int result = statement.executeUpdate();
		if (result != 0) {
			System.out.println("插入成功！");
		}
	} catch (Exception e) {
		e.printStackTrace();

	}finally {
		   DBUtil.closeALL(resultSet, statement, connection);

	}
	}
	}
}
