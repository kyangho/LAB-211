
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
public class ViewMatrix extends ManageMatrix {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void menu() {
        boolean isStop = false;

        while (!isStop) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validation.inputIntLimit("Your choice: ", 1, 4, false);
            switch (choice) {
                case 1:
                    while (true) {
                        addTwoMatrix();
                        if (!Validation.checkYesNo(ANSI_RED +"Do you want to add another matrices?(Y/N): " + ANSI_RESET)) {
                            break;
                        }
                    }

                    break;

                case 2:
                    while (true) {
                        subTwoMatrix();
                        if (!Validation.checkYesNo(ANSI_RED + "Do you want to subtruct another matrices?(Y/N): " + ANSI_RESET)) {
                            break;
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        multiTwoMatrix();
                        if (!Validation.checkYesNo(ANSI_RED + "Do you want to multi another matrices?(Y/N): " + ANSI_RESET)) {
                            break;
                        }
                    }
                    break;

                case 4:
                    isStop = true;
                    break;

            }
            System.out.println("");
        }
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public int[][] inputMatrix(int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Row Matrix" + n + ": ");
        int row = Validation.inputSize();
        System.out.print("Enter Colum Matrix" + n + ": ");
        int col = Validation.inputSize();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ");
                matrix[i][j] = Validation.inputInt();
            }
        }
        return matrix;
    }

    public void addTwoMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("--------Addition--------");
        matrix1 = inputMatrix(1);
        System.out.println("");
        matrix2 = inputMatrix(2);

        if (!isSameLength(matrix1, matrix2)) {
            System.out.println(ANSI_RED + "Can't Add Matrices!" + ANSI_RESET);
            return;
        }

        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(additionMatrix(matrix1, matrix2));
    }

    public void subTwoMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("--------Subtraction--------");
        matrix1 = inputMatrix(1);
        System.out.println("");
        matrix2 = inputMatrix(2);

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println(ANSI_RED + "Can't Subtract Matrices" + ANSI_RESET);
            return;
        }

        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(subtractionMatrix(matrix1, matrix2));
    }

    public void multiTwoMatrix() {
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("--------Multiplication--------");
        matrix1 = inputMatrix(1);
        System.out.println("");
        matrix2 = inputMatrix(2);

        if (matrix1[0].length != matrix2.length) {
            System.out.println(ANSI_RED + "Can't Multiply Matrices" + ANSI_RESET);
            return;
        }

        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(multiplicationMatrix(matrix1, matrix2));

    }
}
