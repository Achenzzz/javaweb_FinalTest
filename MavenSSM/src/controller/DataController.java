package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.IMapDataService;
import vo.MapData;
import vo.MapData1;

@Controller
public class DataController {
	//private IMapDataService
	@Autowired
	private IMapDataService imapservice;
	



	// 获取对象数据
	@RequestMapping(value = "/ajaxGetData.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<Double>> echartsJSON() {		
		// 存放返回信息的Map
		Map<String, List<Double>> map = new HashMap<String, List<Double>>();
		List<MapData> mapDatas=imapservice.get();
		for (MapData mapData : mapDatas) {
			List<Double> list = new ArrayList();
			list.add(Double.parseDouble(mapData.getA()));
			list.add(Double.parseDouble(mapData.getB()));
			
 			//map.put("name", mapData.getChrName());
			map.put(mapData.getName(), list);
			
		}

		return map;

	}
	
	// 获取对象数据
	@RequestMapping(value = "/ajaxGetData1.do", method = RequestMethod.POST)
	@ResponseBody
	public List<MapData1> echartsJSON1() {		
		// 存放返回信息的Map
		//Map<String, Object> map = new HashMap<String, Object>();
		List<MapData1> mapData1s=imapservice.getNameAndValue();
		System.out.println(mapData1s);
		
		System.err.println( mapData1s);

		return mapData1s;

	}
}