package model;

public class t_city {
	private int cityId;
	private int provinceId;
	private String city;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "t_city [cityId=" + cityId + ", provinceId=" + provinceId + ", city=" + city + "]";
	}
	public t_city(int cityId, int provinceId, String city) {
		super();
		this.cityId = cityId;
		this.provinceId = provinceId;
		this.city = city;
	}
	

}
