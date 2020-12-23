package dao;

import java.util.List;

import vo.MapData;
import vo.MapData1;

public interface IMapDataDAO {

	//获取所有数据
	public List<MapData> get();
	//获取部分数据
	public List<MapData1> getNameAndValue();
}
