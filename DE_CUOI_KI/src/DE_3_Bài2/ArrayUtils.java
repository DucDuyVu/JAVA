package DE_3_Bài2;

import java.util.Scanner;

public class ArrayUtils {
    
    
	public static int[][] inputMatrix(Scanner reader){
		
		/*
		     Sử dụng biến reader ở trên để đọc dữ liệu từ bàn phím (không tạo biến Scanner mới)
		     Hàm thực hiện đọc số nguyên dương n, m từ bàn phím
		     Tạo ma trận mat với kích thước nxm
		     nhập vào n, m là kích thước hàng, cột trong ma trận
		     trả lại ma trận mat
		*/
		int n = reader.nextInt();
		int[][] matrix = new int [n][n];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = reader.nextInt();
			}
		}
		return matrix;
	}
	
	/*
	    Hàm trả về giá trị lớn nhất trong ma trận mat.
	*/
	public static int findMax(int[][] mat){
		int max = mat[0][0];
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] > max) {
					max = mat[i][j];
				}
			}
		}
		return max;
	}
	
	/*
	    Hàm trả về một mảng chỉ số các hàng có tổng lớn thứ hai trong ma trận.
	    Nếu không tồn tại hàng nào trả về giá trị null.
	*/
	public static int[] findRows(int[][] mat) {
		// Tính tổng các hàng, lưu lại thành một mảng
		int[] sum = new int[mat.length];
		int [] second;
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				sum[i] += mat[i][j];
			}
		}
		// Tìm max, max2
		int max = sum[0];
		for(int i = 0; i < mat.length; i++) {
			if(max < sum[i])
				max = sum[i];
			}
		int max2 = Integer.MIN_VALUE;
		for(int i = 0 ; i < sum.length; i++) {
			if(sum[i] != max && sum[i] > max2) {
				max2 = sum[i];
			}
		}
		
		// Tạo mảng chỉ số và đưa chỉ số max2 vào mảng 
		int count = 0;
		for(int i = 0 ; i < sum.length; i++)
			if(sum[i] == max2)
				count ++;

		int[] result = new int[count];
		int index = 0;
		for(int i = 0; i < sum.length ; i++)
			if(sum[i] == max2) {
				result[index] = i;
				index++;
			}
		return result;
		}
		
	/*
	    Hàm in ma trận mat
	    Hàm này sinh viên không cần thay đổi 
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

