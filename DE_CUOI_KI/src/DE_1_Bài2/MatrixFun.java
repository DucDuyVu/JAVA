package DE_1_Bài2;


import java.util.Scanner;




public class MatrixFun {
    public static int[][] inputMatrix(Scanner reader) {
    	int n = reader.nextInt();
    	int[][] mat = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			mat[i][j] = reader.nextInt();
    		}
    	}
        return mat;
    }

    public static boolean isOEBalance(int[][] matr) {
    	int No = 0;
    	int Ne = 0;
    	int n = matr.length;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(matr[i][j] % 2 == 0) {
    				Ne++;
    			}
    			else {
    				No++;
    			}
    		}
    	}
        return Math.abs(No - Ne) <= 1;
    }

    public static boolean isContainsHole(int[][] matr) {
    	int n = matr.length;
    	int m = matr[0].length;
    	for(int i = 1; i < n - 1; i++) {
    		for(int j = 1; j < m - 1; j++) {
    			boolean belowAll = true;
    			if(matr[i][j] >= matr[i-1][j-1] || matr[i][j] >= matr[i-1][j] || matr[i][j] >= matr[i-1][j+1] || matr[i][j] >= matr[i][j-1] || matr[i][j] >= matr[i][j+1] || matr[i][j] >= matr[i+1][j-1] || matr[i][j] >= matr[i+1][j] || matr[i][j] >= matr[i+1][j+1]) {
    				belowAll = false;
    			}		
    			if(belowAll)
        			return true;
    		}
    		
    	}
        return false;
    }
}
