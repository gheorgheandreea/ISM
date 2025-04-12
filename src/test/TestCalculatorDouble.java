package test;
import org.junit.jupiter.api.*;
import ro.ulbs.paradigme.lab6.Ex2.DoubleCalculator;


public class TestCalculatorDouble {
    private DoubleCalculator calculator;
    private DoubleCalculator calculator1;
    @BeforeEach
    public void setUp() {
        calculator = new DoubleCalculator(10.3);
        calculator1 = new DoubleCalculator(-8.6);
    }
    @Test
    public void testAddPositive(){
        calculator.add(5);
        Assertions.assertEquals(15.3, calculator.result());
        calculator.add(1.2);
        Assertions.assertEquals(16.5, calculator.result());
    }
    @Test
    public void testAddNegatives(){
        calculator.add(-5);
        calculator1.add(-5);
        Assertions.assertEquals(5.3,(double)calculator.result(), 1e-9);
        Assertions.assertEquals(-13.6, (double)calculator1.result(), 1e-9);
    }

    @Test
    public void testSubtractPositives(){
        calculator.subtract(3);
        Assertions.assertEquals(7.3, (double)calculator.result(),1e-9);
        calculator.subtract(3.3);
        Assertions.assertEquals(4,(double) calculator.result(),1e-9);
    }
    @Test
    public void testSubtractNegatives(){
        calculator.subtract(-3);
        calculator1.subtract(-6);
        Assertions.assertEquals(13.3,(double) calculator.result(),1e-9);
        Assertions.assertEquals(-2.6, (double)calculator1.result(),1e-9);
        calculator1.subtract(-10.6);
        Assertions.assertEquals(8, (double)calculator1.result(),1e-9);
    }
    @Test
    public void testMultiplyPositives() {
        calculator.multiply(3);
        Assertions.assertEquals(30.9,(double) calculator.result(),1e-9);
        calculator.multiply(1.1);
        Assertions.assertEquals(33.99,(double) calculator.result(),1e-9);
    }
    @Test
    public void testMultiplyNegatives() {
        calculator.multiply(-3);
        calculator1.multiply(-1.1);
        Assertions.assertEquals(-30.9,(double) calculator.result(),1e-9);
        Assertions.assertEquals(9.46,(double) calculator1.result(),1e-9);
    }
    @Test
    public void testMultiplyBy0() {
        calculator.multiply(0);
        calculator1.multiply(0.0);
        Assertions.assertEquals(0,(double) calculator.result(),1e-9);
        Assertions.assertEquals(0.0,(double) calculator.result(),1e-9);
    }
    @Test
    public void testDividePositives() {
        calculator.divide(2);
        Assertions.assertEquals(5.15,(double) calculator.result(),1e-9);
        calculator.divide(5.15);
        Assertions.assertEquals(1,(double) calculator.result(),1e-9);
    }
    @Test
    public void testDivideNegatives() {
        calculator.divide(-2);
        calculator1.divide(-2);
        Assertions.assertEquals(-5.15,(double) calculator.result(),1e-9);
        Assertions.assertEquals(4.3,(double) calculator1.result(),1e-9);
    }
    @Test
    public void testDivideBy0(){
        calculator.divide(0);
        Assertions.assertTrue(Double.isInfinite((double) calculator.result()));
    }
}
