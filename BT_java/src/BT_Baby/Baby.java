package BT_Baby;

public class Baby {
    private String day = "01/01/2020";
    private String name = "UnRegistered";
    private boolean gender;
    private double weight, length;
	public Baby() {
		
	}

	public Baby(String bbName, String bbDay, boolean bbGender, double bbWeight, double bbLength) {
	    this.name = bbName;
	    this.day = bbDay;
	    this.gender = bbGender;
	    this.weight = bbWeight;
	    this.length = bbLength;
	}
	
    /*
        Lưu ý, đối với hàm public String getGender() sẽ trả về Boy nếu gender = false, ngược lại trả về "Girl"
    */
   
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}
	public String getGender() {
		if(gender == true) {
			return "Girl";
		} else {
			return "Boy";
		}
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String toString() {
	    return getName() + " " + this.day + " " + getGender() + "  " + this.length + " " + this.weight;
	}

}