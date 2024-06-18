package DE_2_Bài1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ComicStoreManagement {
    public ArrayList<Comic> readComics(String filename) {
    		ArrayList<Comic> comic = new ArrayList<>();
    		
        	try {
        		File file = new File("filename");
            	Scanner sc = new Scanner(file);
        		int n = Integer.parseInt(sc.nextLine());
        		for(int i = 0; i < n; i++) {
        			String id = sc.nextLine();
        			String name = sc.nextLine();
        			boolean available = Boolean.parseBoolean(sc.nextLine());
        			int days = Integer.parseInt(sc.nextLine());
        			double price = Double.parseDouble(sc.nextLine());
        			if(id.charAt(0) == 'N') {
        				Comic c = new Comic();
        				comic.add(c);
        			}
        			else if(id.charAt(0) == 'C') {
        				int nPages = Integer.parseInt(sc.nextLine());
        				boolean latest = Boolean.parseBoolean(sc.nextLine());
        				ColorComic cl = new ColorComic(id,  name,  available,  days,  price, nPages, latest);
        				comic.add(cl);
        			}
        			else {
        				int maxDays = Integer.parseInt(sc.nextLine());
        				boolean valuable = Boolean.parseBoolean(sc.nextLine());
        				SpecialComic sp = new SpecialComic(id,  name, available, days, price, maxDays, valuable);
        				comic.add(sp);
        			}
        		}
        	}catch(IOException e) {
        		e.printStackTrace();
        	}
        	
            return comic;
    }

    public void printComicsInfor(ArrayList<Comic> comics) {
        for(Comic i : comics)
    	System.out.println(i.toString());
    }

    public ArrayList<Comic> sortByPrice(ArrayList<Comic> comics) {
    	ArrayList<Comic> list = new ArrayList<>();
    	for(int i = 0; i < comics.size()-1; i++)
    		for(int j = i+1; j < comics.size(); j++)
    			if(comics.get(i).getPayment() < comics.get(j).getPayment()) {
    				Comic temp = comics.get(i);
    				list.set(i,comics.get(j));
    				list.set(j, temp);
    			}
        return list;
    }

    public ArrayList<Comic> getAvailableComics(ArrayList<Comic> comics) {
    	ArrayList<Comic> result = new ArrayList<>();
    	for(Comic i : comics) {
    		if(i.getAvailable()) {
    			result.add(i);
    		}
    	}
        return result;
    }

    public ArrayList<Comic> filterComicByPrice(ArrayList<Comic> comics, double minPrice, double maxPrice) {
        ArrayList<Comic> list = new ArrayList<>();
        for(Comic o : comics) {
        	if(minPrice <= o.getPrice() && o.getPrice() <= maxPrice) {
        		list.add(o);
        	}
        }
        return list;
    }
}
