package DE_1_Bài1;

public class LuxuryRoom extends Room {
    private int nBeds;
    private boolean view;

    public LuxuryRoom() {
    	
    }

    public LuxuryRoom(String id, String name, boolean available, int days, double price,
            int nBeds, boolean view) {
            super(id, name, available, days, price);
            this.nBeds = nBeds;
            this.view = view;
    }

    public int getNBeds() {
        return this.nBeds;
    }

    public void setNBeds(int nBeds) {
        this.nBeds = nBeds;
    }

    public boolean getView() {
        return this.view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    @Override
    public double getPayment() {
        if(view) {
        	return getDays() * (getPrice() + 0.2* nBeds * getPrice()) + 0.05 * getDays()*getPrice();
        }
        return getDays() * (getPrice() + 0.2* nBeds * getPrice());
    }

    @Override
    public String toString() {
        return "LuxuryRoom [id=" + getId()
            + ", name=" + getName()
            + ", available=" + getAvailable()
            + ", days=" + getDays()
            + ", price=" + getPrice()
            + ", nBeds=" + getNBeds()
            + ", view=" + getView() + "]";
    }
}
