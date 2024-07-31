package app;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TwoArray twoArray = new TwoArray();
        Scanner scanner = new Scanner(System.in);

        // creating double array with user size
        twoArray.printUserNumberSizeTwoArr();
        int userNumbersSizeTwoArr = scanner.nextInt();
        int [][] intTwoArr = new int[userNumbersSizeTwoArr][userNumbersSizeTwoArr];

        // setting range for random method
        twoArray.printUserNumberOriginRangeRandom();
        int UserNumberOriginRangeRandom = scanner.nextInt();
        twoArray.setUserNumberOriginRangeRandom(UserNumberOriginRangeRandom);

        twoArray.printUserNumberBoundRangeRandom();
        int UserNumberBoundRangeRandom= scanner.nextInt();
        twoArray.setUserNumberBoundRangeRandom(UserNumberBoundRangeRandom);

        // filling of double array with integers
        int [][] resultFillIntTwoArr = twoArray.fillRandomNumbersTwoArr(intTwoArr);
        twoArray.setUserNumbersSizeTwoArr(userNumbersSizeTwoArr);
        twoArray.printTwoArray(resultFillIntTwoArr);

        // making variable for results of methods
        int resultSumEvenRowsElements = twoArray.getSumEvenRowsElements(intTwoArr);
        int resultSumOddRowsElements = twoArray.getSumOddRowsElements(intTwoArr);
        double resultMultiplicationEvenRowsElements = twoArray.getMultiplicationEvenColumnsElements(intTwoArr);
        double resultMultiplicationOddRowsElements = twoArray.getMultiplicationOddCulumnsElements(intTwoArr);
        boolean resultSquareArray = twoArray.getIsMagicSquare(intTwoArr);

        // printing result
        twoArray.printResults(resultSumEvenRowsElements, resultSumOddRowsElements,
                resultMultiplicationEvenRowsElements, resultMultiplicationOddRowsElements, resultSquareArray);
    }
}


class TwoArray {
    Random random = new Random();
    private int UserNumberOriginRangeRandom;
    private int UserNumberBoundRangeRandom;
    int userNumbersSizeTwoArr;

    public void setUserNumbersSizeTwoArr(int userNumbersSizeTwoArr) {
        this.userNumbersSizeTwoArr = userNumbersSizeTwoArr;
    }
    public void setUserNumberOriginRangeRandom(int UserNumberOriginRangeRandom) {
        this.UserNumberOriginRangeRandom = UserNumberOriginRangeRandom;
    }
    public void setUserNumberBoundRangeRandom(int UserNumberBoundRangeRandom) {
        this.UserNumberBoundRangeRandom = UserNumberBoundRangeRandom;
    }

    public int[][] fillRandomNumbersTwoArr(int[][] intTwoArray) {
        for (int i = 0; i < intTwoArray.length; i++) {
            for (int j = 0; j < intTwoArray.length; j++) {
                intTwoArray[i][j] = random.nextInt(UserNumberOriginRangeRandom, UserNumberBoundRangeRandom);
            }
        }
        return intTwoArray;
    }

    public void printTwoArray(int[][] twoArray) {
        System.out.printf("Matrix %dx%d: %n", userNumbersSizeTwoArr,userNumbersSizeTwoArr );
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray.length; j++) {
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSumEvenRowsElements(int[][] intTwoArray) {
        int sumEvenLineElements = 0;
        for (int i = 0; i < intTwoArray.length; i++) {
            for (int j = 0; j < intTwoArray.length; j++) {
                if (i % 2 == 0) {
                    sumEvenLineElements += intTwoArray[i][j];
                }
            }
        }
        return sumEvenLineElements;
    }

    public int getSumOddRowsElements(int[][] intTwoArray) {
        int sumOddLineElements = 0;
        for (int i = 0; i < intTwoArray.length; i++) {
            for (int j = 0; j < intTwoArray.length; j++) {
                if (i % 2 != 0) {
                    sumOddLineElements += intTwoArray[i][j];
                }
            }
        }
        return sumOddLineElements;
    }

    public double getMultiplicationEvenColumnsElements(int[][] intTwoArray) {
        double multiplicationEvenСolumnElementsValue = 1;
        for (int i = 0; i < intTwoArray.length; i++) {
            for (int j = 0; j < intTwoArray.length; j++) {
                if (i % 2 == 0) {
                    multiplicationEvenСolumnElementsValue *= intTwoArray[j][i];
                }
            }
        }
        return multiplicationEvenСolumnElementsValue;
    }

    public double getMultiplicationOddCulumnsElements(int[][] intTwoArray) {
        double multiplicationOddRowElementsValue = 1;
        for (int i = 0; i < intTwoArray.length; i++) {
            for (int j = 0; j < intTwoArray.length; j++) {
                if (i % 2 != 0) {
                    multiplicationOddRowElementsValue *= intTwoArray[j][i];
                }
            }
        }
        return multiplicationOddRowElementsValue;
    }

    public boolean getIsMagicSquare(int[][] intTwoArray) {
        int sumMainDiagonal = 0;
        int sumSideDiagonal = 0;
        int twoArrLength = intTwoArray.length;
        //  counting sum of rows
        for (int i = 0; i < twoArrLength; i++) {
            int sumRows = 0;
            for (int j = 0; j < twoArrLength; j++) {
                sumRows += intTwoArray[i][j];
            }
            if (sumRows != twoArrLength * (twoArrLength * twoArrLength + 1) / 2) {
                return false;
            }
        }
        // counting sum of columns
        for (int i = 0; i < twoArrLength; i++) {
            int sumColumns = 0;
            for (int j = 0; j < twoArrLength; j++) {
                sumColumns += intTwoArray[j][i];
            }
            if (sumColumns != twoArrLength * (twoArrLength * twoArrLength + 1) / 2) {
                return false;
            }
        }
        // counting sum of main diagonal
        for (int i = 0; i < twoArrLength; i++) {
            sumMainDiagonal += intTwoArray[i][i];
        }
        if (sumMainDiagonal != twoArrLength * (twoArrLength * twoArrLength + 1) / 2) {
            return false;
        }
        // counting sum of side diagonal
        for (int i = 0; i < twoArrLength; i++) {
            sumSideDiagonal += intTwoArray[i][i];
        }
        if (sumSideDiagonal != twoArrLength * (twoArrLength * twoArrLength + 1) / 2) {
            return false;
        }
        return true;
    }

    public void printUserNumberSizeTwoArr(){
        System.out.print("Enter size of square matrix: " );
    }

    public void  printUserNumberOriginRangeRandom() {
        System.out.print("Enter the range of numbers: \norigin: ");
    }

    public void  printUserNumberBoundRangeRandom() {
        System.out.print("bound: ");
    }

    public void printResults(int resultSumEvenRowsElements, int resultOddRowsElements,
                             double multiplicationEvenRowsElements, double multiplicationOddRowsElements,
                             boolean resultSquareArray) {
        System.out.println("Sum elements in even rows (0, 2) is: " + resultSumEvenRowsElements);
        System.out.println("Sum elements in odd rows (1, 3) is: " + resultOddRowsElements);
        System.out.printf("Multiplication elements in even columns (0, 2) is: %2.0f %n" , multiplicationEvenRowsElements);
        System.out.printf("Multiplication elements in odd columns (1, 3) is: %2.0f %n", multiplicationOddRowsElements);
        System.out.println("The matrix" + ((resultSquareArray) ? " is " : " isn't ") + "a magic square.");
    }
}

