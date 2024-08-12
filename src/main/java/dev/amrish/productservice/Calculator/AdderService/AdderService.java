package dev.amrish.productservice.Calculator.AdderService;

import org.springframework.stereotype.Service;

@Service
public class AdderService {



    public int addTwoNumber(int a, int b){

        System.out.println("Adding two number");
        int result = a + b;
        System.out.println("Completed....twoadder");

        return result;
    }
}
