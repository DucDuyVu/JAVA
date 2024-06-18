package CT_Tính_Diện_Tích_Hình_Thang;

public class TrapezoidalRule {
    public static void main (String[] args) {
        /* TODO */
    }
    
    public static double f(double x) {
        /* TODO */
    	return Math.sqrt(x * x + 1);
    }
    
    public static double integrate(double a, double b, int n) {
        /* TODO */
    	double h = (b - a) / n;
    	double sum = 0.5 * (f(a) - f(b)) / 2;
    	for(int i = 0; i < n; i++) {
    		double xi = a + i * h;
    		sum += f(xi);
    	}
    	return  h * sum;
    }
    
    public static double integrate(double a, double b) {
        /* TODO */
    	int no = 1;
    	double result;
    	do {
    		no *= 2;
    		result = integrate(a, b, no / 2);
    	} while (Math.abs(integrate(a, b, no) - result) >= Math.pow(10,-6));
    	return result;
    }
}