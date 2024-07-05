package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       SumNumbers sumNumb = new SumNumbers();
       Print print = new Print();
       Scanner scanner = new Scanner(System.in);

       print.printTextFrom();
       int scanNumb1 = scanner.nextInt();
       print.printTextTo();
       int scanNumb2 = scanner.nextInt();

       sumNumb.setFrom(scanNumb1);
       sumNumb.setTo(scanNumb2);
       sumNumb.сountSum();

       print.printSumNumb(sumNumb);
    }
}

class SumNumbers {
    private int  sum;
    private int  from;
    private int  to;

    public void setFrom(int from) {
           this.from = from;
    }
    public void setTo(int to) {
        this.to = to;
    }
    public int getSum() {
        return sum;
    }

    public void сountSum(){
        for(int i = from; i <= to; i++) {
            System.out.print(i + ")" + " Num is " + i + ", ");
            sum += i;
            System.out.println("sum is " + sum);
        }
    }
}

class Print {
    public void printTextFrom(){
        System.out.print("Enter range of numbers!" + "\n" + "From: ");
    }
    public void printTextTo(){
        System.out.print("To: " );
    }
    public void printSumNumb(SumNumbers sumNumb) {
        System.out.println("________________________");
        System.out.println("Sum of numbers is " + sumNumb.getSum());
    }
}

