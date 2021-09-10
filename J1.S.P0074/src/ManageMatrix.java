
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ducky
 */
public class ManageMatrix {


    public ManageMatrix() {
    }

    public boolean isSameLength(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }
        return true;
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if(!isSameLength(matrix1, matrix2)){
            return null;
        }
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if(!isSameLength(matrix1, matrix2)){
            return null;
        }
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return matrixResult;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return null;
        }
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;

        int[][] matrixResult = new int[row1][col2];

        for (int i = 0; i < row1; i++) {  
            for (int j = 0; j < col2; j++) { 
                for (int k = 0; k < col1; k++) { 
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return matrixResult;
    }
}
