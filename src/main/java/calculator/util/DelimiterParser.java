package calculator.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DelimiterParser {
    // 구분자 시작,끝 패턴 생성하기
    public static Pattern createDelimiterPattern (
            String startDelimiter,
            String endDelimiter) throws IllegalArgumentException {

        String regex = Pattern.quote(startDelimiter) + "(.*?)" + Pattern.quote(endDelimiter);

        Pattern pattern;
        try {
            pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Invalid delimiter pattern syntax.", e);
        }

        return pattern;
    }
    // 대상에서 패턴 찾기
    public static String getRawSeparator(Pattern pattern, String input){
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    // 추출된 문자들을 split에 사용할 정규 표현식 [a|b|c] 형태로 변환
    public static String createSeparatorRegex(
            List<String> defaultSeparators,
            String rawSeparator){

        StringBuilder regexBuilder = new StringBuilder("[");

        for (String defaultSeparator: defaultSeparators){
            regexBuilder.append(Pattern.quote(defaultSeparator)).append("|");
        }

        if (rawSeparator != null) {
            for (char c : rawSeparator.toCharArray()) {
                regexBuilder.append(Pattern.quote(String.valueOf(c))).append("|");
            }
        }

        // 마지막 '|' 제거 및 ']' 닫기
        if (regexBuilder.length() > 1) {
            regexBuilder.setLength(regexBuilder.length() - 1);
        }
        regexBuilder.append("]");

        return regexBuilder.toString();
    }
}
