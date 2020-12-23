package vo;

public class MapData1 {
	private String Name;
	private int value;
	public MapData1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MapData1 [Name=" + Name + ", value=" + value + "]";
	}
	public MapData1(String charName, int value) {
		super();
		this.Name = charName;
		this.value = value;
	}
	public String getName() {
		return Name;
	}
	public void setName(String charName) {
		this.Name = charName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
