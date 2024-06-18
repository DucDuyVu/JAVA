package DE_3_Bài1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
	
	/* 
	    Hàm nhập dữ liệu từ tệp và trả về một ArrayList danh sách các nhân viên
	    Biến fileName là tên tệp dữ liệu
	    Nhập n nhân viên từ tệp dữ liệu
	   
	*/
	public ArrayList<Employee> readData(String fileName){
		ArrayList<Employee> ems = new ArrayList<>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			int n = Integer.parseInt(scan.nextLine());
			
			for(int i = 0; i < n; i++) {
				int index = Integer.parseInt(scan.nextLine());
				String id = scan.nextLine();
				String name = scan.nextLine();
				int age = Integer.parseInt(scan.nextLine());
				String address = scan.nextLine();
				double basicSalary = Double.parseDouble(scan.nextLine());
				String email = scan.nextLine();
				
				if(index == 1) {
					int no_test_equipments = Integer.parseInt(scan.nextLine());
					double allowance = Double.parseDouble(scan.nextLine());
					Technician t = new Technician(id, name, age, address, basicSalary, email, no_test_equipments, allowance);
					ems.add(t);
				}
				else{
					int no_customers = Integer.parseInt(scan.nextLine());
					Marketer m = new Marketer(id, name, age, address, basicSalary, email, no_customers);
					ems.add(m);
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		return ems;
	}
	
	/*
	    In ra danh sách tất cả các nhân viên, mỗi nhân viên trên một hàng
	*/
	public void printInforEmployees(ArrayList <Employee> employees) {
		for(Employee em : employees) {
			System.out.println(em.toString());
		}
	}
	
	/*
	    Hàm trả về danh sách các kỹ thuật viên phụ trách lĩnh vực "field". 
	    Nếu không có trả về giá trị null
	*/
	public ArrayList <Employee> filterTech(ArrayList <Employee> employees, String fields){
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee em : employees) {
			if(em instanceof Technician)
			{
				Technician a = (Technician) em;
				if(a.getField().equals(fields))
					result.add(a);
			}
		}
		return result;
	}
	
	/*
	    Hàm sắp xếp lương của nhân viên theo thứ tự tăng dần
	*/
	public void sortBySalary(ArrayList<Employee> arr_e){
		for(int i = 0; i < arr_e.size() - 1 ; i++)
			for(int j = i + 1 ; j < arr_e.size(); j++)
				if(arr_e.get(i).getSalary() > arr_e.get(j).getSalary()) {
					Employee temp = arr_e.get(i);
					arr_e.set(i, arr_e.get(j));
					arr_e.set(j, temp);
				}
	}
	
	/*
	    Hàm tìm những nhân viên tiếp thị có mức lương cao hơn mức lương cao nhất 
	    của các kỹ thuật viên. Yêu cầu kết quả đầu ra của nhân viên tiếp thị phải 
	    được sắp xếp theo thứ tự tăng dần của lương  
	*/
	public ArrayList <Employee> filterMarketerBySalary(ArrayList<Employee> employees){
		double maxT = 0;
		for(Employee e : employees)
			if(e instanceof Technician) {
				if(e.getSalary() > maxT) {
					maxT = e.getSalary();
				}
			}
		
		// Tìm lương nhân viên tiếp thị > kĩ thuật viên và thêm vào 1 danh sách
		ArrayList<Employee> listM = new ArrayList<>();
		for(Employee i : employees)
			if(i instanceof Marketer) {
				if(i.getSalary() > maxT) {
					listM.add(i);
				}
			}
		
		for(int i = 0; i < listM.size() - 1; i++)
			for(int j = i + 1 ; j < listM.size(); j++)
				if(listM.get(i).getSalary() > listM.get(j).getSalary()) {
					Employee t = listM.get(i);
					listM.set(i, listM.get(j));
					listM.set(j, t);
				}
		
		return listM;
	}
	
	public static void main(String[] args) {
		EmployeeManagement st = new EmployeeManagement();
		ArrayList<Employee> staffs = st.readData("data.txt");
		st.printInforEmployees(staffs);
		
		ArrayList<Employee> arr_s = st.filterTech(staffs, "computer");
		st.printInforEmployees(arr_s);
		
		st.sortBySalary(staffs);
		st.printInforEmployees(staffs);
		
		ArrayList<Employee> arr_sp = st.filterMarketerBySalary(staffs);
		st.printInforEmployees(arr_sp);
	}
	
}
