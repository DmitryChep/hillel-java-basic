package app;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CountArray countArray = new CountArray();
        Scanner scanner = new Scanner(System.in);

        int[] intArray = countArray.createArr();
        countArray.printInitialArr();
        countArray.printArrLoop(intArray);

        int[] intArrayInsertionSort = countArray.getInsertionSortArray(intArray);
        countArray.printArrLoop(intArrayInsertionSort);

        countArray.printUserNumberToSearchArr();
        int userNumbTarget = scanner.nextInt();

        int userBinarySearchResult = countArray.getbinarySearchArr(intArray, userNumbTarget);
        countArray.printUserNumberToSearchArrResults(userNumbTarget, userBinarySearchResult);

    }
}


class CountArray {
    Random random = new Random();

    public int[] createArr() {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 100);
        }
        return arr;
    }


    public void  printArrLoop(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                System.out.print(intArray[i]);
            } else {
                System.out.print(", " + intArray[i]);
            }
        }
        System.out.println("]");
    }


    public int[] getInsertionSortArray(int[] intArrey) {
        System.out.print("Sorted view of the array: [");
        int arrLength = intArrey.length;
        for (int i = 1; i < arrLength; i++) {
            int current = intArrey[i];
            int j = i - 1;
            while (j >= 0 && intArrey[j] >= current) {
                intArrey[j + 1] = intArrey[j];
                j--;
            }
            intArrey[j + 1] = current;
        }
        return intArrey;
    }


    public int getbinarySearchArr(int[] intArray, int userNumbTarget) {
        int left = 0;
        int right = intArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intArray[mid] == userNumbTarget) {
                return mid; // Повертаємо індекс, якщо знайдено
            } else if (intArray[mid] < userNumbTarget) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Повертаємо -1, якщо не знайдено
    }


    public void printInitialArr() {
        System.out.print("Initial view of the array: [");
    }
    public void  printUserNumberToSearchArr() {
        System.out.print("Enter a number to searching in the array: ");
    }
    public void  printUserNumberToSearchArrResults(int userNumbTarget, int userBinarySearchResult ) {
        if (userBinarySearchResult == -1){
            System.out.println("There is no such number.");
        } else {
            System.out.print("Index of number " + userNumbTarget + " in a sorted array is: " + userBinarySearchResult + ".");
        }
    }
}































