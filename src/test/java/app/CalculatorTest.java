package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private CalculatorExecutor calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorExecutor();
        calculator.setOperandLeft(10);
        calculator.setOperandRight(5);
    }

    @Test
    public void testAddition() throws DivisionZero, InvalidOperator {
        calculator.setOperator("+");
        assertEquals(15, calculator.calculate());
    }

    @Test
    public void testSubtraction() throws DivisionZero, InvalidOperator {
        calculator.setOperator("-");
        assertEquals(5, calculator.calculate());
    }

    @Test
    public void testMultiplication() throws DivisionZero, InvalidOperator {
        calculator.setOperator("*");
        assertEquals(50, calculator.calculate());
    }

    @Test
    public void testDivision() throws DivisionZero, InvalidOperator {
        calculator.setOperator("/");
        assertEquals(2, calculator.calculate());
    }

    @Test
    public void testDivisionException() throws InvalidOperator {
        calculator.setOperator("");
        assertThrows(InvalidOperator.class, () -> calculator.calculate());
    }

    @Test
    public void testDivisionException1() throws DivisionZero {
        calculator.setOperator("/");
        calculator.setOperandRight(0);
        assertThrows(DivisionZero.class, () -> calculator.calculate());
    }
}