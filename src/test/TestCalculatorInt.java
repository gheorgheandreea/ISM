package test;
import org.junit.jupiter.api.*;
import ro.ulbs.paradigme.lab6.Ex2.NewIntCalculator;

public class TestCalculatorInt {
    private NewIntCalculator calculator;
    private NewIntCalculator calculator1;
    @BeforeEach
    public void setUp() {
        calculator = new NewIntCalculator(10);
        calculator1 = new NewIntCalculator(-8);
    }
    @Test
    public void testAddPositive(){
        calculator.add(5);
        Assertions.assertEquals(15, calculator.result());
    }
    @Test
    public void testAddNegatives(){
        calculator.add(-5);
        calculator1.add(-5);
        Assertions.assertEquals(5, calculator.result());
        Assertions.assertEquals(-13, calculator1.result());
    }
    @Test
    public void testSubtractPositives(){
        calculator.subtract(3);
        Assertions.assertEquals(7, calculator.result());
    }
    @Test
    public void testSubtractNegatives(){
        calculator.subtract(-3);
        calculator1.subtract(-6);
        Assertions.assertEquals(13, calculator.result());
        Assertions.assertEquals(-2, calculator1.result());
        calculator1.subtract(-10);
        Assertions.assertEquals(8, calculator1.result());
    }
    @Test
    public void testMultiplyPositives() {
        calculator.multiply(3);
        Assertions.assertEquals(30, calculator.result());
    }
    @Test
    public void testMultiplyNegatives() {
        calculator.multiply(-3);
        calculator1.multiply(-5);
        Assertions.assertEquals(-30, calculator.result());
        Assertions.assertEquals(40, calculator1.result());
    }
    @Test
    public void testMultiplyBy0() {
        calculator.multiply(0);
        calculator1.multiply(0);
        Assertions.assertEquals(0, calculator.result());
        Assertions.assertEquals(0, calculator1.result());
    }
    @Test
    public void testDividePositives() {
        calculator.divide(2);
        Assertions.assertEquals(5, calculator.result());
    }
    @Test
    public void testDivideNegatives() {
        calculator.divide(-2);
        calculator1.divide(-4);
        Assertions.assertEquals(2, calculator1.result());
        Assertions.assertEquals(-5, calculator.result());
    }
    @Test
    public void testDivideBy0(){
        Assertions.assertThrows(ArithmeticException.class, () -> {calculator.divide(0);});
    }
}
