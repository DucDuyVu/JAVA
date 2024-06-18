package BT_Motorbike;

import java.util.ArrayList;
import java.util.Scanner;
public class MotorbikeTest{
    
    static Scanner sc = new Scanner(System.in);

    public static void inputMotorbike (ArrayList<Motorbike> motorbikes, int n)
	{
	    for(int i = 0 ; i < n ; i++)
	    {
	        String id = sc.nextLine();
        	String name = sc.nextLine();
            String manu = sc.nextLine();
        	int quantity = Integer.parseInt(sc.nextLine());
        	double price = Double.parseDouble(sc.nextLine());
        	double weight = Double.parseDouble(sc.nextLine());
        	String date = sc.nextLine();
        	Motorbike motorbike = new Motorbike(id, name, manu, quantity, price, weight, date);
        	motorbikes.add(motorbike);
	    }
	 
	}
	public static void ouputMotorbike (ArrayList<Motorbike> motorbikes)
	{
		for(Motorbike motorbike : motorbikes)
		{
		    System.out.println(motorbike.printMotorbike());
		    
		}
	}
	public static ArrayList<Motorbike> search (String manu, ArrayList<Motorbike> motorbikes)
	{
        ArrayList<Motorbike> motorbikeList = new ArrayList<Motorbike>();
		for(Motorbike motorbike : motorbikes)
		{
		    if(motorbike.getManu().equals(manu))
		    {
		        motorbikeList.add(motorbike);
		    }
		}
        return motorbikeList;
	}
	public static ArrayList<Motorbike> maxWeight (ArrayList<Motorbike> motorbikes)
	{
	    ArrayList<Motorbike> maxList = new ArrayList<Motorbike>();
	    double max = 0;
	    for(Motorbike motorbike : motorbikes)
	    {
	        if(motorbike.getWeight() > max)
			{
			    max = motorbike.getWeight();
			    maxList.add(motorbike);
			}
	    }
	
        return maxList;
	}
	public static ArrayList<Motorbike> minQuantuty (ArrayList<Motorbike> motorbikes)
	{
        ArrayList<Motorbike> minList = new ArrayList<Motorbike>();
	    double min = 0;
	    for(Motorbike motorbike : motorbikes)
	    {
	        if(motorbike.getQuantity() < min)
	           {
	            min = motorbike.getQuantity();
			    minList.add(motorbike);
	           }
	    }
	   
        return minList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = Integer.parseInt(sc.nextLine());
        ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();
		inputMotorbike(motorbikes, n);
		int c = Integer.parseInt(sc.nextLine());
		if(c == 1)
		{
		    String a  = "Honda";
		    ArrayList<Motorbike> hondaMotorbikes = search(a, motorbikes);
		    ouputMotorbike(hondaMotorbikes);
		}
		else if(c ==2 )
		{
		      ArrayList<Motorbike> max = maxWeight(motorbikes); 
		      ouputMotorbike(max);
		}
		else if (c == 3)
		{
		       ArrayList<Motorbike> min = minQuantuty(motorbikes);
		       ouputMotorbike(min);
		}
	}		
}

