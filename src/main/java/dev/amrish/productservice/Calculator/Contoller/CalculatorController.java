package dev.amrish.productservice.Calculator.Contoller;

import dev.amrish.productservice.Calculator.AdderService.AdderService;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {

    private AdderService adderService;

    public CalculatorController(AdderService adderService){
        this.adderService = adderService;
    }


    public int add(int a, int b){
        System.out.println("Some Logic");

        int rlt = adderService.addTwoNumber(a, b);

        System.out.println("New logic added.... ");

        return rlt;

    }
}
