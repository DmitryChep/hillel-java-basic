package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        //1. square of number
        methods.printRequestsScanner(1);
        methods.setUserNumberInt(scanner.nextInt());
        methods.printResults(methods.getUserNumberInt());
        //2. volume of the cylinder
        methods.printRequestsScanner(2);
        methods.setUserNumberDoubleRadius(scanner.nextDouble());
        methods.printRequestsScanner(3);
        methods.setUserNumberDoubleHigh(scanner.nextDouble());
        methods.printResults(methods.getUserNumberDoubleRadius(), methods.getUserNumberDoubleHigh());
        //3. sum of int array numbers
        methods.printRequestsScanner(4);
        scanner.nextLine();
        methods.setUserNumbersArr(scanner.nextLine());
        int [] resultUserArr = methods.fillUserArr(methods.getUserNumbersArr());
        int resultSumArray = methods.getSumArray(resultUserArr);
        methods.printResults(resultUserArr, resultSumArray);
        //4. get revers string
        methods.printRequestsScanner(5);
        methods.setUserString(scanner.nextLine());
        String resultReversUserString = methods.getReversString(methods.getUserString());
        methods.printResults(resultReversUserString);
        //5. exponentiation
        methods.printRequestsScanner(6);
        methods.setUserNumberExponentiation(scanner.nextInt());
        methods.printRequestsScanner(7);
        methods.setUserNumberPower(scanner.nextInt());
        methods.printResultsExponentiation(methods.getUserNumberExponentiation(), methods.getUserNumberPower());
        //6. print text n quantity times
        methods.printRequestsScanner(8);
        scanner.nextLine();
        methods.setUserNumberQuantityText(scanner.nextInt());
        methods.printRequestsScanner(9);
        scanner.nextLine();
        methods.setUserText(scanner.nextLine());
        methods.printResults(methods.getUserNumberQuantityText(), methods.getUserText());
    }
}

class Methods{
    private int userNumberInt;
    private double userNumberDoubleRadius;
    private double userNumberDoubleHigh;
    private String userNumbersArr;
    private String userString;
    private int userNumberExponentiation;
    private int userNumberPower;
    private int userNumberQuantityText;
    private String userText;

    public void setUserNumberInt(int userNumberInt) {
        this.userNumberInt = userNumberInt;
    }
    public void setUserNumberDoubleRadius(double userNumberDoubleRadius) {
        this.userNumberDoubleRadius = userNumberDoubleRadius;
    }
    public void setUserNumberDoubleHigh(double userNumberDoubleHigh) {
        this.userNumberDoubleHigh = userNumberDoubleHigh;
    }
    public void setUserNumbersArr(String userNumbersArr) {
        this.userNumbersArr = userNumbersArr;
    }
    public void setUserString(String userString) {
        this.userString = userString;
    }
    public void setUserNumberExponentiation(int userNumberExponentiation) {
        this.userNumberExponentiation = userNumberExponentiation;
    }
    public void setUserNumberPower(int userNumberPower) {
        this.userNumberPower = userNumberPower;
    }
    public void setUserNumberQuantityText(int userNumberQuantityText) {
        this.userNumberQuantityText = userNumberQuantityText;
    }
    public void setUserText(String userText) {
        this.userText = userText;
    }

    public int getUserNumberInt() {
        return userNumberInt;
    }
    public double getUserNumberDoubleRadius() {
        return userNumberDoubleRadius;
    }
    public double getUserNumberDoubleHigh() {
        return userNumberDoubleHigh;
    }
    public String getUserNumbersArr() {
        return userNumbersArr;
    }
    public String getUserString() {
        return userString;
    }
    public int getUserNumberExponentiation() {
        return userNumberExponentiation;
    }
    public int getUserNumberPower() {
        return userNumberPower;
    }
    public int getUserNumberQuantityText() {
        return userNumberQuantityText;
    }
    public String getUserText() {
        return userText;
    }


    public int getSumArray(int[] array) {
        int sumElement = 0;
        for (int i = 0; i < array.length; i++) {
            sumElement += array[i];
        }
        return sumElement;
    }
    public int [] fillUserArr(String  userNumbers) {
        String [] stringArr = userNumbers.split(" ");
        int [] userArray = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            userArray[i] = Integer.parseInt(stringArr[i]);
        }
        return userArray ;
    }
    public String getReversString(String userString) {
        StringBuilder stringBuilder = new StringBuilder(userString);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public void printRequestsScanner(int step) {
        switch (step){
            case 1: System.out.print("1. Enter tne integer number: ");
                break;
            case 2: System.out.print("2. Enter the radius of the cylinder: ");
                break;
            case 3: System.out.print("\s\s\sEnter the high of the cylinder: ");
                break;
            case 4: System.out.print("3. Enter numbers: ");
                break;
            case 5: System.out.print("4. Enter string: ");
                break;
            case 6: System.out.print("5. Enter tne number for exponentiation: ");
                break;
            case 7: System.out.print("\s\s\sEnter the value of the power of a number: ");
                break;
            case 8: System.out.print("4. Enter integer number n: ");
                break;
            case 9: System.out.print("\s\s\sWrite text: ");
                break;
        }
    }
    //1. print result, square of number
    public void printResults(int userNumberInt) {
        System.out.printf("\s\s\sThe square of number %d is %2.0f. \n" ,userNumberInt , Math.pow(userNumberInt, 2 ));
    }
    //2. print result, volume of the cylinder
    public void printResults(double userRadius, double userHigh) {
        System.out.printf("\s\s\sThe volume of cylinder with radius %2.2f and high %2.2f is: %2.2f m3. \n",
                userRadius, userHigh, Math.PI * Math.pow(userRadius, 2) * userHigh );
    }
    //3. print result, sum of int array numbers
    public void printResults(int[] userArray, int resultSumArray) {
        System.out.print("\s\s\sArray of numbers:[");
        for (int i = 0; i < userArray.length; i++) {
            System.out.print(userArray[i]);
            if (i == userArray.length-1){
                break;
            }else{
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("\s\s\sSum all elements is: " + resultSumArray);
    }
    //4. print result, get revers string
    public void printResults(String resultReversUserString) {
        System.out.println("\s\s\sString in reverse: " + resultReversUserString);
    }
    //5. print result, exponentiation
    public void printResultsExponentiation(int userNumberExponentiation, int userNumberToPower) {
        System.out.printf("\s\s\sResult %d^%d is: %2.0f.\n" ,userNumberExponentiation, userNumberToPower,
                Math.pow(userNumberExponentiation, userNumberToPower));
    }
    //6. print result, print text n quantity times
    public void  printResults(int userNumberQuantityText, String userText ) {
        for (int i = 1; i <= userNumberQuantityText; i++) System.out.println("\t\t\t\s\s\s" + userText);
    }
}



