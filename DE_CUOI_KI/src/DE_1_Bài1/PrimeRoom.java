package DE_1_Bài1;

public class PrimeRoom extends Room {
    private int services;
    private boolean catering;

    public PrimeRoom() {
    	
    }

    public PrimeRoom(String id, String name, boolean available, int days, double price,
            int services, boolean catering) {
    	super(id, name, available, days, price);
    	this.services = services;
    	this.catering = catering;
    }

    public int getServices() {
        return this.services;
    }

    public void setServices(int services) {
        this.services = services;
    }

    public boolean getCatering() {
        return this.catering;
    }

    public void setCatering(boolean catering) {
        this.catering = catering;
    }

    @Override
    public double getPayment() {
       if(catering) {
    	   return getDays() * (getPrice() + 0.3 * services * getPrice()) + 0.2*getDays()*getPrice();
       }
       return getDays() * (getPrice() + 0.3 * services * getPrice());
    }

    @Override
    public String toString() {
        return "PrimeRoom [id=" + getId()
            + ", name=" + getName()
            + ", available=" + getAvailable()
            + ", days=" + getDays()
            + ", price=" + getPrice()
            + ", services=" + getServices()
            + ", catering=" + getCatering() + "]";
    }
}
