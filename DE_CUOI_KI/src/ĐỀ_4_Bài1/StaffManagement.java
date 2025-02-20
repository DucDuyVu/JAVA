package ĐỀ_4_Bài1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagement {
    
    /* 
	    Hàm nhập dữ liệu từ tệp và trả về một ArrayList danh sách các nhân viên
	    Biến fileName là tên tệp dữ liệu
	    Nhập n nhân viên từ tệp dữ liệu
	   
	*/
	
	public ArrayList<Staff> readData(String fileName){
		ArrayList<Staff> list = new ArrayList<>();
		try {
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n ; i++) {
			int index = Integer.parseInt(sc.nextLine());
			String id = sc.nextLine();
			String name = sc.nextLine();
			int age = Integer.parseInt(sc.nextLine());
			int seniority = Integer.parseInt(sc.nextLine());
			double basicSalary = Double.parseDouble(sc.nextLine());
			String email = sc.nextLine();
			if(index == 1) {
				int no_constructions = Integer.parseInt(sc.nextLine());
				double reward = Double.parseDouble(sc.nextLine());
				Architect a = new Architect(id, name, age, seniority, basicSalary, email, no_constructions, reward);
				list.add(a);
			}
			else if(index == 0) {
				int no_violates = Integer.parseInt(sc.nextLine());
				Supervisor s = new Supervisor(id, name, age, seniority, basicSalary, email, no_violates);
				list.add(s);
			}
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	    In ra danh sách tất cả các nhân viên, mỗi nhân viên trên một hàng
	*/
	public void printInforStaffs(ArrayList <Staff> staffs) {
		for(Staff i : staffs) {
			System.out.println(i.toString());
		}
	}
	
	/*
	    Hàm trả về danh sách các kỹ thuật viên phụ trách chuyên môn "expertise". 
	    Nếu không có trả về giá trị null
	*/
	public ArrayList <Staff> filterExpert(ArrayList <Staff> staffs, String expertise){
		ArrayList<Staff> list = new ArrayList<>();
		for(Staff o : staffs) {
			if(o.equals(expertise)) {
				list.add(o);
			}
			return list;
		}
		return null;
	}
	
	
	/*
	    Hàm sắp xếp lương của nhân viên theo thứ tự tăng dần
	*/
	public void sortBySalary(ArrayList<Staff> arr_s){
		for(int i = 0; i < arr_s.size() - 1; i++) {
			for(int j = i + 1; j < arr_s.size(); j++) {
				if(arr_s.get(i).getSalary() > arr_s.get(j).getSalary()) {
					Staff temp = arr_s.get(i);
					arr_s.set(i, arr_s.get(j));
					arr_s.set(j, temp);
				}
			}
		}
	}
	
	
	/*
	    Hàm tìm những nhân viên giám sát có mức lương cao hơn mức lương thấp nhất 
	    của các kiến trúc sư. Yêu cầu kết quả đầu ra của nhân viên giám sát phải 
	    được sắp xếp theo thứ tự giảm dần của lương. Nếu không có trả về giá trị null. 
	*/
	public ArrayList <Staff> filterSupervisorBySalary(ArrayList<Staff> staffs){
		ArrayList<Staff> list = new ArrayList<>();
		
		
		// Tìm mức lương thấp nhất của kiến trúc sư
		double minA = 0;
		for(Staff s : staffs) {
			if(s instanceof Architect) {
				if(s.getSalary() < minA) {
					minA = s.getSalary();
				}
			}
		}
		
		// Tìm danh sách các giám sát viên có lương cao hơn minA(mức lương thấp nhất của kiến trúc sư)
		for(Staff s : staffs) {
			if(s instanceof Supervisor) {
				if(s.getSalary() > minA) {
					list.add(s);
				}
			}
		}
		// Sắp xếp theo thứ tự tăng dần của lương
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i+1 ; j < list.size(); j++) {
				if(list.get(i).getSalary() < list.get(j).getSalary()) {
					Staff temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		StaffManagement st = new StaffManagement();
		ArrayList<Staff> staffs = st.readData("data.txt");
		st.printInforStaffs(staffs);
		
		ArrayList<Staff> arr_s = st.filterExpert(staffs, "adjacent villa");
		st.printInforStaffs(arr_s);
		
		ArrayList<Staff> arr_ex = st.filterExpert(staffs, "apartment");
		st.printInforStaffs(arr_ex);
		
		st.sortBySalary(staffs);
		st.printInforStaffs(staffs);
		
		ArrayList<Staff> arr_sp = st.filterSupervisorBySalary(staffs);
		st.printInforStaffs(arr_sp);
	}
	
}
