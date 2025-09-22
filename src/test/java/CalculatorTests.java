import com.example.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    private Calculator calculator;
    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }
    @Test 
    @DisplayName("TEST TO Check multiplication of two integers normal ")
    void testMultiply(){
        int result = calculator.multiply(6,7);
        assertEquals(result,42);
    }
    @Test 
    @DisplayName("TEST TO Check multiplication of two integers one being 0")
    void testMultiplyZero(){
        int result = calculator.multiply(4,0);
        assertEquals(result,0);
    }
    @Test 
    @DisplayName("TEST TO Check multiplication of two integers with negative numbers")
    void testMultiplyNegatives(){
        int result = calculator.multiply(3,-8);
        assertEquals(result,-24);
    }
    @Test
    @DisplayName("test to check concat normal")
    void testConcat(){
        String result=calculator.concat("hola", " mundo");
        assertEquals(result, "hola mundo");
    }
    @Test
    @DisplayName("test to check concat normal with one null")
    void testConcatNull(){
        String result=calculator.concat("adiós", null);
        assertEquals(result, "empty");
    }
    @Test
    @DisplayName("test of sum with normal numbers")
    void testSum(){
        double result = calculator.sum(10, 10);
        assertEquals(result,20);
    }
    @Test
    @DisplayName("test of sum with negative numbers")
    void testSumNegatives(){
        double result = calculator.sum(35, -15);
        assertEquals(result,20);
    }
    @Test
    @DisplayName("test discount valid")
    void testDiscount(){
        double result=calculator.discount(850,20);
        assertEquals(result,680);
    }  
    @Test
    @DisplayName("test discount valid 100%")
    void testDiscountHundred(){
        double result=calculator.discount(850,100);
        assertEquals(result,0);
    }
    @Test
    @DisplayName("test discount valid 0%")
    void testDiscountZero(){
        double result=calculator.discount(850,0);
        assertEquals(result,850);
    }  
    @Test
    @DisplayName("test discount Invalid")
    void testDiscountInvalid(){
        Exception result=assertThrows(IllegalArgumentException.class, ()->calculator.discount(850,150));
        assertEquals(result.getMessage(),"Percentage must be between 0 and 100");
    }      
    @Test
    @DisplayName("calculate total list of normal imports")
    void testCalculateTotal(){
        List<Double> lista= List.of(1.0, 2.0, 3.0, 98.0, 99.0, 100.0);
        double result = calculator.calculateTotal(lista);
        assertEquals(result, 303.0);
    }   
    @Test
    @DisplayName("calculate total empty")
    void testCalculateTotalEmpty(){
        List<Double> lista=new ArrayList<>();
        double result = calculator.calculateTotal(lista);
        assertEquals(result, 0.0);
    }  


}
