package DE_2_Bài1;

public class ColorComic extends Comic {
    private int nPages;
    private boolean latest;

    public ColorComic() {
        
    }

    public ColorComic(String id, String name, boolean available, int days, double price,
            int nPages, boolean latest) {
    	super(id,  name, available, days, price);
    	this.nPages = nPages;
    	this.latest = latest;
        
    }

    public int getNPages() {
        return this.nPages;
    }

    public void setNPages(int nPages) {
        this.nPages = nPages;
    }

    public boolean getLatest() {
        return this.latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    @Override
    public double getPayment() {
        double payment = super.getPayment() * (1 + 0.01 * nPages);
        if(latest) {
        	payment += 0.1 * super.getDays() * super.getPrice();
        }
        return payment;
    }

    @Override
    public String toString() {
        return "ColorComic [id=" + getId()
            + ", name=" + getName()
            + ", available=" + getAvailable()
            + ", days=" + getDays()
            + ", price=" + getPrice()
            + ", nPages=" + getNPages()
            + ", latest=" + getLatest() + "]";
    }
}

