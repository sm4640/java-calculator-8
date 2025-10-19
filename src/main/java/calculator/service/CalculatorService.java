package calculator.service;

import calculator.util.DelimiterParser;
import calculator.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {
    // 구분자로 split 및 전체 흐름 로직 완성
    public int caculate(String input){
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> defaultSeparators = List.of(":", ",");
        String start = "//";
        String end = "\\n";

        Pattern delimiterPattern = DelimiterParser.createDelimiterPattern(start, end);

        String rawSeparator = DelimiterParser.getRawSeparator(delimiterPattern, input);

        String separatorRegex = DelimiterParser.createSeparatorRegex(defaultSeparators, rawSeparator);

        String inputBody = (rawSeparator != null)
                ? input.substring(input.indexOf(end) + end.length())
                : input;

        String[] parts = (inputBody == null || separatorRegex.isEmpty())
                ? new String[]{inputBody}
                : inputBody.split(separatorRegex + "+");

        List<Integer> partsOfInteger = new ArrayList<>();

        for (String part : parts) {

            StringUtils.checkNumber(part);
            partsOfInteger.add(StringUtils.convertToInteger(part));
        }

        return sumNumbers(partsOfInteger);
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
