package BT_Motorbike;

public class Motorbike
{
    private String id;
	private String name;
	private String manu;
	private int quantity;
	private double price;
	private double weight;
	private String date;
	
	public String getId(){
	    return id;
	}
	public String getName(){
	    return name;
	}
	public String getManu(){
	    return manu;
	}
	public int getQuantity(){
	    return quantity;
	}
	public double getPrice(){
	    return price;
	}
	public double getWeight(){
	    return weight;
	}
	public String getDate(){
	    return date;
	}
	public void setId(String id){
	
	    this.id = id;
	}
	public void setName(String name){
	    this.name = name;
	}
	public void setManu(String manu){
	    this.manu = manu;
	}
	public void setQuantity(int quantity){
	    this.quantity = quantity;
	}
	public void setPrice(double price){
	    this.price = price;
	}
	public void setWeight(double weight){
	    this.weight = weight;
	}
	public void setDate(String date){
	    this.date = date;
	}
	public Motorbike(String id, String name, String manu, int quantity, double price, double weight, String date)
	{
	    this.id = id;
	    this.name = name;
	    this.manu = manu;
	    this.quantity = quantity;
	    this.price = price;
	    this.weight = weight;
	    this.date = date;
	}
	public String printMotorbike(){
	    return id +" "+ name + " " + manu + " " + quantity + " " + price + " " + weight + " " + date;
	}
}
