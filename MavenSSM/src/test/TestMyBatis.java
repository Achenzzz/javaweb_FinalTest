package test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.IMapDataService;

import vo.MapData;
import vo.MapData1;

//让测试在Spring容器环境下执行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger log = LogManager.getLogger(Test.class.getName());


	
	@Autowired
	private IMapDataService mapdataservice;


	@Test
	public void test5() {

		List<MapData1> mapDatas = mapdataservice.getNameAndValue();
		for (MapData1 mapData : mapDatas) {
			System.err.println(mapData+"OOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		}
	}
}
