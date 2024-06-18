package BT_quan_li_Sach;

class ReferenceBook extends Book
{
	private double tax;
//	public ReferenceBook(String id, String name, int quantity, String publisher, double price) {
//		
//		// TODO Auto-generated constructor stub
//		super(id, name, quantity, publisher, price);
//	}
// 	public ReferenceBook(){
// 	}
	
	public ReferenceBook(String id, String name, int quantity, String publisher, double price, double tax) {
		super(id, name, quantity, publisher, price);
		this.tax = tax;
	}
	


	public double getTax() {
		return tax;
	}



	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return super.getPrice() * super.getQuantity() + tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [tax=" + tax + ", getId()=" + getId() + ", getName()=" + getName() + ", getQuantity()="
				+ getQuantity() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()+ ", getAmount()=" + getAmount() +  "]";
	}
}
