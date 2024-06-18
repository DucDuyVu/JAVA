package Đọc_File_Object;

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
 	public static void outputObject(String fileName, ArrayList<Computer> coms) {
 		//ObjectOutputStream buff = null;
 		try {
 			FileOutputStream f = new FileOutputStream(filename);
 			ObjectOutputStream oos = new ObjectOutputStream(f);
 			for(Computer i : coms) {
 				oos.writeObject(i);
 			}
 		}catch(IOException e) {
 			e.printStackTrace();
 		}
		
 	}
	
 	public static void inputObject(String fileName, ArrayList<Computer> coms) {
		//ObjectInputStream buff = null;
		try {
			FileInputStream f = new FileInputStream(fileName);
			ObjectInputStream bff = new ObjectInputStream(f);
			Computer x;
			while(true) {
				try {
					x = (Computer) bff.readObject();
					coms.add(x);
				}catch(EOFException e) {
					break;
				}
			}
			bff.close();
		}catch(IOException e) {
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
	
	}
	
	// Hàm trả về các máy tính có giá lớn nhất
	public static ArrayList<Computer> getMaxPrice(ArrayList<Computer> coms)
	{
	
	}
	
	// Hàm trả về danh sách các máy tính có hãng sản xuất là Dell
	public static ArrayList<Computer> getDell(ArrayList<Computer> coms)
	{
	
	}
	
	// Hàm sắp xếp theo giá giảm dần và in ra danh sách các máy tính sau khi sắp xếp
	public static void sort(ArrayList<Computer> coms)
	{
		
	}
	
	public static void main(String[] args) {
		ComputerTest test = new ComputerTest();
		ArrayList<Computer> newC = new ArrayList<>();
		test.inputObject("computer.dat", newC);
		ArrayList<Computer> dell = test.getDell(newC);
		test.outputObject("dell.dat", dell);
	}

}
