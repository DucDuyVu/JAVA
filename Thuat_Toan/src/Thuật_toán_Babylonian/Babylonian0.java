package Thuật_toán_Babylonian;

import java.util.Scanner;

public class Babylonian0 {
    
    public static void main (String[] args) {
        /* TODO */
    	Scanner sc = new Scanner (System.in);
    	int x = sc.nextInt();
    	System.out.println(babylonian(x));
    }
    
    public static double babylonian(int x) {
        /* TODO */
    	double y = 1.0, r = 1.0;
    	while(r < 0.00000000001) {
    		y = (y + x/y) / 2;
    		r = Math.abs(y - x/y);
    	}
    	return y;
    }
}
