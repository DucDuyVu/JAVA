package BT_Quản_Lí_Máy_Tính;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ComputerTest {

    // hàm ghi ra file dưới dạng Object, trong đó filename là tên file truyền vào, coms là danh sách các Computer muốn ghi ra file
	// Ghi file dùng     " FileOutputObject "
 	public static void outputObject(String fileName, ArrayList<Computer> coms) {
 		ObjectOutputStream buff = null;
 		try {
 			FileOutputStream fo = new FileOutputStream(fileName);
 			ObjectOutputStream bff = new ObjectOutputStream(fo);
 			for(Computer i : coms) {
 				bff.writeObject(i);
 			}
 			bff.close();
 		}catch(IOException e) {
 			e.printStackTrace();
 		}
 		
 		
		
 	}
	
 	// Đọc file từ Object dùng    " FileInputObject "
	public static void inputObject(String fileName, ArrayList<Computer> coms) {
//		ObjectInputStream buff = null;
		try {
			FileInputStream fi = new FileInputStream(fileName);
			ObjectInputStream bff = new ObjectInputStream(fi);
			Computer x;
			while(true) {
				try {
					x = (Computer) bff.readObject();
					coms.add(x);
				}catch(EOFException e){
					break;
				}
			}
			bff.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	// Hàm in ra màn hình thông tin của các máy tính trong danh sách computers
	public static void output(ArrayList<Computer> computers)
	{
		for(int i =0; i < computers.size(); i ++)
			System.out.println(computers.get(i).toString());
	}
	
	// Hàm trả về giá trung bình của các máy tính trong danh sách coms
	public static double getAvgPrice(ArrayList<Computer> coms)
	{
		double sum = 0;
		for(Computer i : coms) {
			sum += i.getPrice();
		}
		return sum / coms.size();
	}
	
	// Hàm trả về các máy tính có giá lớn nhất
	public static ArrayList<Computer> getMaxPrice(ArrayList<Computer> coms)
	{
		ArrayList<Computer> listmax = new ArrayList<>();
		double max = 0;
		for(Computer i : coms) {
			if(i.getPrice() > max) {
				max = i.getPrice();
			}
		}
		for(Computer o : coms) {
			if(max == o.getPrice()) {
				listmax.add(o);
			}
		}
		return listmax;
	}
	
	// Hàm trả về danh sách các máy tính có hãng sản xuất là Dell
	public static ArrayList<Computer> getDell(ArrayList<Computer> coms)
	{
		ArrayList<Computer> result = new ArrayList<>();
		for(Computer i : coms) {
			if(i.getManu().equals("Dell")) {
				result.add(i);
			}
		}
		return result;
	}
	
	// Hàm sắp xếp theo giá giảm dần và in ra danh sách các máy tính sau khi sắp xếp
	public static void sort(ArrayList<Computer> coms)
	{
		ArrayList<Computer> list = new ArrayList<>();
		for(int i = 0; i < coms.size()-1; i++) 
			for(int j = i+1; j < coms.size(); j++)
					if(coms.get(i).getPrice() < coms.get(j).getPrice()) {
						Computer temp = coms.get(i);
						list.set(i, coms.get(j));
						list.set(j, temp);
				}
	}
	
	public static void main(String[] args) {
		ComputerTest test = new ComputerTest();
		ArrayList<Computer> newC = new ArrayList<>();
		test.inputObject("computer.dat", newC);
		ArrayList<Computer> dell = test.getDell(newC);
		test.outputObject("dell.dat", dell);
	}

}


