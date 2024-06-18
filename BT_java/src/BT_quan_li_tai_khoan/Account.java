package BT_quan_li_tai_khoan;

public class Account {
	private int id;
	private Customer customer;
	private double balance = 0.0;
	public Account(int id, Customer customer, double balance) {
		super();
		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}
	public Account(int id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getCustomerName() {
		return name+"("+id+")";
	}
	public Account deposit(double amount) {
		return this.amount;
	}
	
}
