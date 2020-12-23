package vo;

public class MapData {
	
	private String Name;
	private String a;
	private String b;
	public String getName() {
		return Name;
	}
	public void setName(String chrName) {
		this.Name = chrName;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public MapData(String chrName, String a, String b) {
		super();
		this.Name = chrName;
		this.a = a;
		this.b = b;
	}
	public MapData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MapData [Name=" + Name + ", a=" + a + ", b=" + b + "]";
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
	
	

}
