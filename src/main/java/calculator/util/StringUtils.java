package calculator.util;

import java.util.regex.Pattern;

// 문자열 관련 유틸
public class StringUtils {
    // 숫자인지 확인
    public static boolean checkNumber(String str) throws IllegalArgumentException{
        if (str == null || str.isEmpty()) {
            return true;
        }

        if (!Pattern.matches("^[0-9]+$", str)) {
            // 0~9 숫자가 아닐 경우 발생하는 예외를 IllegalArgumentException으로 전달
            throw new IllegalArgumentException(
                    "This string is not a number. Only 0-9 are allowed");
        }
        return true;
    }
}
