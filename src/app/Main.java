package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        ScanUserInput scanUser = new ScanUserInput();
        Print print = new Print();

        Employee employee = new Employee("Robert John Downey Jr","actor",
                "robertDownTheRiver59@gmail.com", "+12124262342", 59);
        print.printEmployee(employee.getFullName(),employee.getPosition(), employee.getEmail(),
                employee.getPhoneNumber(),employee.getAge());

        print.printUserRequest(1);
        String userValueCommand = scanUser.getUserStringTestCommand();
        car.setUserValueTestCommand(userValueCommand);
        if (userValueCommand.equalsIgnoreCase("Yes")) {
            print.printUserRequest(2);
            String userValueElectricity = scanner.nextLine();
            car.setUserValueTestElectricity(userValueElectricity);

            print.printUserRequest(3);
            String userValeueFuel = scanner.nextLine();
            car.setUserValueTestFuel(userValeueFuel);

            print.printEngineStart(car.start());
            print.printErrors(car.isElectricityTestErrorFlag(), car.isFuelFlagErrorTest());
        } else if(userValueCommand.equalsIgnoreCase("No")){
            System.out.println("Engine is not running.");
        }
    }
}


class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int age;

    public String getFullName() {
        return fullName;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getAge() {
        return age;
    }

    public Employee(String fullName, String position, String email, String phoneNumber, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}


class Car {
    private String userValueTestCommand;
    private String userValueTestElectricity;
    private boolean electricityFlagErrorTest = true;
    private String userValueTestFuel;
    private boolean fuelFlagErrorTest = true;

    public void setUserValueTestCommand(String userValueTestCommand) {
        this.userValueTestCommand = userValueTestCommand;
    }
    public void setUserValueTestElectricity(String userValueTestElectricity) {
        this.userValueTestElectricity = userValueTestElectricity;
    }
    public void setUserValueTestFuel(String userValueTestFuel) {
        this.userValueTestFuel = userValueTestFuel;
    }

    public boolean isElectricityTestErrorFlag() {
        return electricityFlagErrorTest;
    }
    public boolean isFuelFlagErrorTest() {
        return fuelFlagErrorTest;
    }

    private boolean startCommand() {
        return userValueTestCommand.equalsIgnoreCase("Yes");
    }
    // check if the electricity is switched on and toggle the flag(electricityTestErrorFlag) if there is an error
    private boolean startElectricity() {
        boolean valueStartElectricity = false;
        if (userValueTestElectricity.equalsIgnoreCase("On")){
            valueStartElectricity = true;
        }else electricityFlagErrorTest = false;
        return valueStartElectricity;
    }
    // check if the fuel system is switched on and toggle the flag(fuelTestErrorFlag) if there is an error
    private boolean startFuelSystem() {
        boolean valueStartFuelSystem = false;
        if (userValueTestFuel.equalsIgnoreCase("On")){
            valueStartFuelSystem = true;
        }else fuelFlagErrorTest = false;
        return valueStartFuelSystem;
    }
    // check that all systems are enabled and the startup command is running
    public boolean start() {
        boolean startElectricityValue = startElectricity();
        boolean startStartFuelSystemValue = startFuelSystem();
        return startCommand() && startElectricityValue && startStartFuelSystemValue;
    }
}


class Print {
    public void printEmployee(String fullName, String position, String email, String phoneNumber, int age) {
        System.out.printf("Full name: %s\nPosition: %s\nEmail: %s\nPhone number: %s\nAge: %d\n",
                fullName, position,email,phoneNumber, age );
    }

    public void printUserRequest(int step) {
        switch (step) {
            case 1:
                System.out.print("Do you want to start the engine? Yes/No: ");
                break;
            case 2:
                System.out.print("Turn on the electricity system On/Off: ");
                break;
            case 3:
                System.out.print("Turn on the fuel system On/Off: ");
                break;
        }
    }

    public void printEngineStart(boolean start) {
        if (start) {
            System.out.println("Engine successfully started.");
        } else {
            System.out.print("Engine start error: ");
        }
    }

    public void printErrors(boolean electricityTestErrorFlag , boolean fuelTestErrorFlag) {
        if (!electricityTestErrorFlag) System.out.print("Electricity is off!");
        if (!electricityTestErrorFlag && !fuelTestErrorFlag) System.out.print(", ");
        if (!fuelTestErrorFlag) System.out.println("Fuel system is off!");
    }
}


class ScanUserInput {
    Scanner scanner = new Scanner(System.in);

    private String userValueTestCommand;

    public String getUserStringTestCommand(){
        for (int i = 0; i < 5; i++) {
            userValueTestCommand = scanner.nextLine();
            if (userValueTestCommand.equalsIgnoreCase("Yes")){
                return userValueTestCommand;
            }else if(userValueTestCommand.equalsIgnoreCase("No")){
                return userValueTestCommand;
            }
            System.out.print("Incorrect input. Enter Yes/No: ");
        }
        System.out.println("Error");
        return userValueTestCommand;
    }
}


