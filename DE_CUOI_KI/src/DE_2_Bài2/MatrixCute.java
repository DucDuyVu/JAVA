package DE_2_Bài2;

import java.util.Scanner;


public class MatrixCute {
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

    public static boolean isOESumBalance(int[][] matr) {
    	int No = 0; 
    	int Ne = 0;
    	int n =  matr.length;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(matr[i][j] % 2 == 0) {
    				Ne += matr[i][j];
    			}
    			else {
    				No += matr[i][j];
    			}
    		}
    	}
        return Math.abs(No - Ne) <= n;
    }

    public static boolean isContainsHill(int[][] matr) {
    	
        return false;
    }
}
