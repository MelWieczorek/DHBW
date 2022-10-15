package Semester2.excursion.junit;

//imports of JUnit classes/ methods/... needed for test cases
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.AfterEach;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

@DisplayName("Calculator Test Class")

//example for UnitTests
//always remember F.I.R.S.T. - principle
class calculatorTest {
calculator testCalc;
    @BeforeEach
    void setUp() {
        testCalc = new calculator();
    }

    @AfterEach
    void tearDown() {
        testCalc = null;
    }


        @Test
        @DisplayName("adding two numbers")
        void add() {
            double result = testCalc.add(10, 10);
            double expected = 20;
            assertEquals(expected, result);
        }

    @Test
    @DisplayName("subtract two numbers")
    void  sub(){
        double result = testCalc.sub(10,5);
        double expected = 5;
        assertEquals(expected, result);
    }
    //parameterized Test for multiple test cases
    @ParameterizedTest(name = "{0}-{1}={2}")
    //CSVSource gives multiple testcases for param. tests --> here: "numA,numB,exp","..."
    @CsvSource({ "10,5,5", "20.0,5.0,15.0"})
    void  parameterizedSub(double numberA, double numberB, double expected){
        double result = testCalc.sub(numberA, numberB);
        assertEquals(expected, result);
    }

    @Test
    void mult(){
        double result = testCalc.mult(10,10);
        assertEquals(100.0, result);
    }
}