package app;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CountArray countArray = new CountArray();
        Scanner scanner = new Scanner(System.in);

        countArray.printUserNumberSizeArr();
        int userNumbSizeArr = scanner.nextInt();
        countArray.setUserNumbSizeArr(userNumbSizeArr);

        countArray.printUserNumbOriginRange();
        int userNumbOriginRange = scanner.nextInt();
        countArray.setUserNumbOriginRange(userNumbOriginRange);

        countArray.printUserNumbBoundRange();
        int userNumbBoundRange = scanner.nextInt();
        countArray.setUserNumbBoundRange(userNumbBoundRange);

        int[] intArray = countArray.createArr();

        countArray.printArr(intArray);

        int arraySumNegativeNumbers = countArray.getSumNegativeNumbArr(intArray);
        int arrayQuantityEvenNumb = countArray.getQuantityEvenNumb(intArray);
        int arrayQuantityNegativeNumb = countArray.getQuantityOddNumb(intArray);
        countArray.getlowestNumberWithIndex(intArray);
        countArray.getHighestNumberWithIndex(intArray);
        double arrayAverNumb = countArray.averNumb(intArray);

        countArray.printResults(arraySumNegativeNumbers, arrayQuantityEvenNumb, arrayQuantityNegativeNumb, arrayAverNumb);
    }
}

class CountArray {
    Random random = new Random();

    private int  userNumbSizeArr;
    private int  userNumbOriginRange;
    private int  userNumbBoundRange;
    private int minElem;
    private int minIndex;
    private int maxElem;
    private int maxIndex;

    public void setUserNumbSizeArr(int userNumbSizeArr) {
        this.userNumbSizeArr = userNumbSizeArr;
    }
    public void setUserNumbOriginRange(int userNumbOriginRange) {
        this.userNumbOriginRange = userNumbOriginRange;
    }
    public void setUserNumbBoundRange(int userNumbBoundRange) {
        this.userNumbBoundRange = userNumbBoundRange;
    }

    public int getMinElem() {
        return minElem;
    }
    public int getMinIndex() {
        return minIndex;
    }
    public int getMaxElem() {
        return maxElem;
    }
    public int getMaxIndex() {
        return maxIndex;
    }


    public int[] createArr() {
        int[] arr = new int[userNumbSizeArr];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(userNumbOriginRange, userNumbBoundRange);
        }
        return arr;
    }


    public void printArr(int[] intarray) {
        System.out.print("Array elements:[");
        for (int i = 0;i < intarray.length; i++) {
            if (i == 0) {
                System.out.print(intarray[i]);
            } else {
                System.out.print(", " + intarray[i]);
            }
        }
        System.out.println("]");
    }


    public int getSumNegativeNumbArr(int[] intArray) {
        int sumNegativeNumbers = 0;
        for (int j : intArray) if (j < 0) sumNegativeNumbers += j;
        return sumNegativeNumbers;
    }


    public int getQuantityEvenNumb(int [] intArray){
        int quantityEvenNumbers = 0;
        for (int j : intArray) if (j % 2 == 0) quantityEvenNumbers++;
        return quantityEvenNumbers;
    }


    public int getQuantityOddNumb(int [] intArray) {
        int sumOddNumbers = 0;
        for (int j : intArray) if (j % 2 != 0) sumOddNumbers++;
        return sumOddNumbers;
    }


    public void getlowestNumberWithIndex(int [] intArray) {
        minElem = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (minElem > intArray[i]) {
                minElem = intArray[i];
                minIndex = i;
            }
        }
    }


    public void getHighestNumberWithIndex(int [] intArray) {
        maxElem = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (maxElem < intArray[i]) {
                maxElem = intArray[i];
                maxIndex = i;
            }
        }
    }


    public double averNumb(int [] intArray) {
        double  sumNumbers = 0;
        int indexNumb = 0;
        boolean presentNegativeNumberVariable = true;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 0) {
                presentNegativeNumberVariable = false;
                for (int j = i; j < intArray.length; j++) {
                    indexNumb++;
                    sumNumbers += intArray[j];
                }
                break;
            }
        }
        if (presentNegativeNumberVariable) System.out.println("No negative numbers!");
        return sumNumbers / indexNumb;
    }


    public void  printUserNumberSizeArr() {
        System.out.print("Enter the array size: ");
    }
    public void  printUserNumbOriginRange() {
        System.out.print("Enter the range of numbers: \norigin: ");
    }
    public void  printUserNumbBoundRange() {
        System.out.print("bound: ");
    }
    public void printResults(int arraySumNegativeNumbers, int arrayQuantityEvenNumb, int arrayQuantityNegativeNumb, double getAverNumbers) {
        System.out.println("Sum of negative numbers: " + arraySumNegativeNumbers);
        System.out.println("Quantity of even numbers: " + arrayQuantityEvenNumb);
        System.out.println("Quantity of odd numbers: " + arrayQuantityNegativeNumb);
        System.out.println("Lowest numbers: " + getMinElem() + " (with an index " + getMinIndex() + ")");
        System.out.println("Highest number: " + getMaxElem() + " (with an index " + getMaxIndex() + ")");
        System.out.printf("Average numbers after first negative number: %.2f ", getAverNumbers);
    }
}































