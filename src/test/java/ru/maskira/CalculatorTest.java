package ru.maskira;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    public static final double delta = 0.001;

    @Test
    void GetResult_IntAdd() {
        Calculator calculator = new Calculator("2+2");
        assertEquals(4, calculator.getResult().doubleValue(), delta);
    }

    @Test
    void GetResult_IntAddMulBrackets() {
        Calculator calculator = new Calculator("(2+2)*2");
        assertEquals(8, calculator.getResult().doubleValue(), delta);

        calculator = new Calculator("2*(2+2)");
        assertEquals(8, calculator.getResult().doubleValue(), delta);

        calculator = new Calculator("2*(2+2)*2");
        assertEquals(16, calculator.getResult().doubleValue(), delta);
    }

    @Test
    void GetResult_IntAddSubMulDivBrackets() {
        Calculator calculator = new Calculator("((2+2*2)-3/6)");
        assertEquals(5.5, calculator.getResult().doubleValue(), delta);
    }

    @Test
    void GetResult_BracketsCheck() {
        Calculator calculator = new Calculator("((2+2*2)-3/6");
        assertEquals(null, calculator.getResult());

        calculator = new Calculator("((2+2*2))-3/6)");
        assertEquals(null, calculator.getResult());
    }

}