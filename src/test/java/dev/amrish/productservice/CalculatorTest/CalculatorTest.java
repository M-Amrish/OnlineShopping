//package dev.amrish.productservice.CalculatorTest;
//
//import dev.amrish.productservice.Calculator.AdderService.AdderService;
//import dev.amrish.productservice.Calculator.Contoller.CalculatorController;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class CalculatorTest {
//     @MockBean
//     private AdderService adderService;
//
//     @Autowired
//     CalculatorController calculatorController;
//
//
//    @Test
//    public void test(){
//
//        when(adderService.addTwoNumber(10,5)).thenReturn(15);
//
//
//        int a=10, b=5;
//
//        int exceptedResult = 15;
//
//        int result = calculatorController.add(a,b);
//
//        Assertions.assertEquals(exceptedResult,result);
//
//
//    }
//}
