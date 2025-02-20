package Đề_4_Bài2;


import java.util.Scanner;

public class ArrayUtils {
    /*
		     Sử dụng biến reader ở trên để đọc dữ liệu từ bàn phím (không tạo biến Scanner mới)
		     Hàm thực hiện đọc số nguyên dương n, m từ bàn phím
		     Tạo ma trận mat với kích thước nxm
		     nhập vào n, m là kích thước hàng, cột trong ma trận
		     trả lại ma trận mat
	*/
	public static int[][] inputMatrix(Scanner reader){
	    int n = reader.nextInt();
	    int[][] mat = new int[n][n];
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < n; j++){
	            mat[i][j] = reader.nextInt();
	        }
	    }
		return mat;
	}
	
	
	/*
	    Hàm tìm phần tử có giá trị nhỏ nhất trong ma trận
	 */
	public static int findMin(int[][] mat){
	    int min = Integer.MAX_VALUE;
	    int n = mat.length;
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < n; j++){
	            if(mat[i][j] < min){
	                min = mat[i][j];
	            }
	        }
	    }
		return min;
	}
	
	/*
	    Hàm trả về một mảng chỉ số các cột có tổng lớn thứ hai trong ma trận.
	    Nếu không tồn tại cột nào có tổng lớn thứ hai thì trả về giá trị null
	*/
	public static int[] findColumns(int[][] mat) {
	    int[] arr2 = new int[mat[0].length];
	    //int sum = 0;
	    // Tính tổng các cột và  lưu thành một mảng
	    for(int j = 0; j < mat[0].length; j++) {
	    	for(int i = 0; i < mat.length; i++) {
	    		arr2[j] += mat[i][j];
	    	}
	    }
	    
	    
	    
	    // Tìm tổng các phần tử của cột lớn nhất
	    int max = Integer.MIN_VALUE;
	    for(int s : arr2) {
	    	if(s > max) {
	    		max = s;
	    	}
	    }
	    
	    int max2 = Integer.MIN_VALUE;
	    for(int s : arr2) {
	    	if(s != max && s > max2) {
	    		max2 = s;
	    	}
	    }
	    
	    // Tạo mảng chỉ số và đưa tổng bằng max2 vào mảng
	    int count = 0;
	    for(int i = 0; i < mat[0].length; i++) {
	    	if(arr2[i] == max2) {
	    		count++;
	    	}
	    }
	    
	    int[] result = new int[count];
	    int index = 0;
	    for(int i =0; i < arr2.length; i++) {
	    	if(arr2[i] == max2) {
	    	result[index] = i;
	    	index++;
	      }
	    }
	    
			   return result;
	}
	
	/*
	    Hàm in ma trận mat 
	    Hàm này sinh viên không cần chỉnh sửa
	*/
	public static void printMatrix(int[][] mat) {
		if(mat == null) {
			System.out.println("NULL");
			return;
		}
	
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
