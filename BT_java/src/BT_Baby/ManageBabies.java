package BT_Baby;



import java.util.Scanner;

public class ManageBabies {
	
    
	
	/*  Nhap vao thong tin cua n baby tu ban phim. Cac thong tin theo thu tu ten, ngay thang nam sinh, gioi tinh
	gioi tinh, can nang, chieu cao
	*/
	private int n;
	// nhap vao so nguyen duong n va thong tin cua n baby
	Baby[] createData (Scanner sc)
	{
	   
	    
	     n = Integer.parseInt(sc.nextLine());
	     Baby[] babies = new Baby[n];
	    for(int i = 0 ; i < n ; i++)
	    {
	        String name = sc.nextLine();
	        String day = sc.nextLine();
	        boolean gender = Boolean.parseBoolean(sc.nextLine());
	        double weight = Double.parseDouble(sc.nextLine());
	        double length = Double.parseDouble(sc.nextLine());
	        babies[i] = new Baby(name,day,gender,weight,length);
	    }
	    return babies;
	}
	
	 // In ra thong tin cua n baby sau khi chuan hoa ho ten
	void printInforBabies (Baby babies[])
	{
	    for(Baby baby : babies)
	    {
	        System.out.println(baby.toString());
	    }
	}
	// Sap xep cac baby theo trong luong giam dan
	void sortWeight (Baby babies[])
	{
	    Baby a;
	    for(int i = 0 ; i < n - 1 ; i++)
	    {
	        for(int j = i + 1 ; j < n ; j++)
	        {
	            if(babies[i].getWeight() < babies[j].getWeight())
	              {
	               a = babies[i];
	               babies[i] = babies[j];
	               babies[j] = a;
	              }
	        }
	    }
	}
	// Loc ra tat ca nhung baby co gioi tinh la gender
	void filterGender(Baby babies[], String gender)
	{
	    for(Baby baby : babies)
	    {
	        if(baby.getGender().equals(gender))
	        {
	            System.out.println(baby.toString());
	        }
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
       
        ManageBabies manageBabies = new ManageBabies();
        Baby[] babies = manageBabies.createData(sc);
        manageBabies.printInforBabies(babies);
        manageBabies.sortWeight(babies);
        
         String gender = sc.nextLine();
        manageBabies.filterGender(babies, gender);
	}

}
