package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMapDataDAO;
import service.IMapDataService;
import vo.MapData;
import vo.MapData1;


@Service
public class MapDataImpl implements IMapDataService{
	
	@Autowired
	private IMapDataDAO mapdataDAO;
	@Override
	public List<MapData> get() {
		// TODO Auto-generated method stub
		return mapdataDAO.get();
	}
	

	@Override
	public List<MapData1> getNameAndValue(){
		
		return mapdataDAO.getNameAndValue();
		
	}
}
