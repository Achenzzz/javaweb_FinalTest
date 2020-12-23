package service;

import java.util.List;

import vo.MapData;
import vo.MapData1;

public interface IMapDataService {

	public List<MapData> get();
	
	public List<MapData1> getNameAndValue();
	
}
