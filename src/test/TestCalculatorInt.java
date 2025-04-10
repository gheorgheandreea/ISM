package test;
import org.junit.jupiter.api.*;
import ro.ulbs.paradigme.lab6.Ex1.IntCalculator;

public class TestCalculatorInt {
    private IntCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new IntCalculator(0);
    }
    @Test
    public void testAddPositive(){
        calculator.Add(5);
        Assertions.assertEquals(5, calculator.result());
    }
}
