package calculator.util;

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
}
