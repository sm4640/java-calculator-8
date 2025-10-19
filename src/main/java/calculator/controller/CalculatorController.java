package calculator.controller;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = calculatorService.caculate(input);
        System.out.println("결과 : " + result);
    }
}
