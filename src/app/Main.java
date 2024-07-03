package app;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        PercentCalcul percentCalcul = new PercentCalcul();
        Scanner scanner = new Scanner(System.in);

        percentCalcul.printRegInc();
        percentCalcul.setIncome(scanner.nextDouble());
        percentCalcul.printPercent(percentCalcul);
    }
}
class PercentCalcul {

    private double income;

    public void setIncome(double income) {
        this.income = income;
    }

    private int percentCalc() {
            double result  = (income > 0 && income <= 10000) ? income *= 2.5 / 100 :
                             (income > 10000 && income <= 25000) ? income *= 4.3 / 100 :
                             (income > 25000) ? income *= 6.7 / 100 : 0;
            result = Math.round(result);

        return (int) result;
    }

    public void printRegInc() {
        System.out.print("Enter amount of income: ");
    }

    public void printPercent(PercentCalcul percentCalcul) {
        System.out.println("The tax is: " + percentCalcul.percentCalc() + " %");
    }
}
