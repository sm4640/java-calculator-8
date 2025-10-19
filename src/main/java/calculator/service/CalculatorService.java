package calculator.service;

import java.util.List;

public class CalculatorService {
    // 구분자로 split 및 전체 흐름 로직 완성
    public int caculate(String input){
        return 0;
    }

    // 만들어진 숫자들 더하기
    private int sumNumbers(List<Integer> numberList){
        if (numberList.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (int number : numberList) {
            sum += number;
        }

        return sum;
    }
}
