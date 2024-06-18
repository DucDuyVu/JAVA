package DE_1_Bài1;
import java.util.*;
import java.io.*;
public class RoomManagement {
    public ArrayList<Room> readData(String filename) {
    	ArrayList<Room> r = new ArrayList<>();
    	try {
    		File file = new File(filename);
    		Scanner sc = new Scanner(file);
    		int n = Integer.parseInt(sc.nextLine());
    		for(int i = 0; i < n; i++) {
    			String id = sc.nextLine();
    			String name = sc.nextLine();
    			boolean available = Boolean.parseBoolean(sc.nextLine());
    			int days =  Integer.parseInt(sc.nextLine());
    			double price = Double.parseDouble(sc.nextLine());
    			if(id.charAt(0) == 'R') {
    				Room room = new Room(id, name, available, days, price);
    				r.add(room);
    			}
    			else if(id.charAt(0) == 'L') {
    				int nBeds = Integer.parseInt(sc.nextLine());
    				boolean view = Boolean.parseBoolean(sc.nextLine());
    				LuxuryRoom luxury = new LuxuryRoom(id, name, available, days, price, nBeds, view);
    			    r.add(luxury);
    			}
    			else {
    				int services = Integer.parseInt(sc.nextLine());
    				boolean catering = Boolean.parseBoolean(sc.nextLine());
    				PrimeRoom p = new PrimeRoom(id, name, available, days, price, services, catering);
    				r.add(p);
    			}
    			
    		}
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
		return r;
    }

    public void printRoomsInfor(ArrayList<Room> rooms) {
        for(Room i : rooms) {
        	System.out.println(i.toString());
        }
    }

    public ArrayList<Room> sortByPrice(ArrayList<Room> rooms) {
    	ArrayList<Room> result = new ArrayList<>();
    	for(Room i : rooms) {
    		if(! i.getAvailable()) {
    			result.add(i);
    		}
    	}
    	for(int i = 0; i < result.size()-1; i++) {
    		for(int j = i + 1; j < result.size(); j++) {
    			if(result.get(i).getPayment() > result.get(j).getPayment() ) {
    				Room temp = result.get(i);
    				result.set(i, result.get(j));
    				result.set(j,temp);
    			}
    		}
    	}
        return result;
    }

    public ArrayList<Room> getAvailableRooms(ArrayList<Room> rooms) {
    	ArrayList<Room> list = new ArrayList<>();
    	for(Room i : rooms) {
    		if(i.getAvailable()) {
    			list.add(i);
    		}
    	}
    	return list;
    }

    public ArrayList<Room> filterRoomByPrice(ArrayList<Room> rooms, double minPrice, double maxPrice) {
        ArrayList<Room> listroom = new ArrayList<>();
        for(Room i : rooms) {
        	if(minPrice <= i.getPrice() && i.getPrice() <= maxPrice) {
        		listroom.add(i);
        	}
        }
        return listroom;
    }
}
