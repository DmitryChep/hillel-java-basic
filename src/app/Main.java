package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdviserForDays adviseForDay = new AdviserForDays();
        Printer.printRequestDay();
        ScannerDay scannerDay = new ScannerDay();
        try {
            adviseForDay.advise(Day.valueOf(scannerDay.getUserDay().toUpperCase()));

        } catch (IllegalArgumentException exception){
            System.out.println("Incorrect day entry");
        }
    }
}

@FunctionalInterface
interface Adviser {
    void advise(Day day);
}

class AdviserForDays implements Adviser {
    @Override
    public void advise(Day day) {
        switch (day) {
            case MONDAY, TUESDAY, WENSEDAY, THURSDAY -> System.out.println("Focus on one task at a time!");
            case FRIDAY -> System.out.println("Happy Friday!");
            case SUTURDAY, SUNDAY -> System.out.println("Go to the cinema with your family of friends.");
        }
    }
}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WENSEDAY, THURSDAY , FRIDAY, SUTURDAY
}

class ScannerDay {
    Scanner scanner = new Scanner(System.in);
    private String userDay = scanner.nextLine();

    public String getUserDay() {
        return userDay;
    }
}

class Printer {
    public static void printRequestDay() {
        System.out.println("Enter the day: ");
    }
}





