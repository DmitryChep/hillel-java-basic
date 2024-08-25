package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try {
            ScannerUserInput scannerUserInput = new ScannerUserInput();
            CalculatorExecutor calculator = new CalculatorExecutor();
            Printer.printRequestForUser(1);
            scannerUserInput.setOperadLeft(scannerUserInput.getScannerInt().nextInt());
            calculator.setOperandLeft(scannerUserInput.getOperadLeft());
            Printer.printRequestForUser(2);
            scannerUserInput.setOperator(scannerUserInput.getScannerString().nextLine());
            calculator.setOperator(scannerUserInput.getOperator());
            Printer.printRequestForUser(3);
            scannerUserInput.setOperadRight(scannerUserInput.getScannerInt().nextInt());
            calculator.setOperandRight(scannerUserInput.getOperadRight());
            Printer.printRequestForUser(4);
            System.out.println(calculator.calculate());
            scannerUserInput.getScannerInt().close();
            scannerUserInput.getScannerString().close();
        } catch (InvalidOperator | DivisionZero InvalidOperatorDivisionZeroExeption){
            InvalidOperatorDivisionZeroExeption.printStackTrace();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid parameter.");
        } catch (ArithmeticException arithmeticException){
            System.out.println("Error.");
        } catch (NullPointerException nullPointerException) {
            System.out.println("Parameter is empty.");
        }
    }
}

class DivisionZero extends Exception {
    public DivisionZero() {
        super("Divide by zero error encountered.");
    }
}

class InvalidOperator extends Exception {
    public InvalidOperator() {
        super("Invalid operator");
    }
}

class CalculatorExecutor {
    private int operandLeft;
    private int operandRight;
    private String operator;


    public int getOperandLeft() {
        return operandLeft;
    }

    public void setOperandLeft(int operandLeft) {
        this.operandLeft = operandLeft;
    }

    public int getOperandRight() {
        return operandRight;
    }

    public void setOperandRight(int operandRight) {
        this.operandRight = operandRight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int calculate()
            throws DivisionZero, InvalidOperator {
        switch (operator) {
            case "+":
                return operandLeft + operandRight;
            case "-":
                return operandLeft - operandRight;
            case "*":
                return  operandLeft * operandRight;
            case "/":
                if (operandRight == 0){
                    throw new DivisionZero();
                }
                return operandLeft / operandRight;
            default:
                throw new InvalidOperator();
        }
    }
}

class Printer {
    public static void printRequestForUser(int step){
        switch (step){
            case 1 :
                System.out.print("Enter first operand: ");
                break;
            case 2 :
                System.out.print("Enter operator: ");
                break;
            case 3 :
                System.out.print("Enter second operand: ");
                break;
            case 4 :
                System.out.print("Result: ");
                break;
        }
    }
}

class ScannerUserInput {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);
    private int operadRight;
    private int operadLeft;
    private String operator;

    public Scanner getScannerString() {
        return scannerString;
    }

    public Scanner getScannerInt() {
        return scannerInt;
    }

    public int getOperadLeft() {
        return operadLeft;
    }

    public void setOperadLeft(int operadLeft) {
        this.operadLeft = operadLeft;
    }

    public int getOperadRight() {
        return operadRight;
    }

    public void setOperadRight(int operadRight) {
        this.operadRight = operadRight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
