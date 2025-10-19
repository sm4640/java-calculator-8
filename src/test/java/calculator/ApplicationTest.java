package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_검사_및_적용() {
        assertSimpleTest(() -> {
            run("//;\\n10;20");
            assertThat(output()).contains("결과 : 30");
        });
    }


    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자가_아닌_문자_포함시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_및_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//|\\n10,20:30|40");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Test
    void 커스텀_구분자_및_빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("//|\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자만_있는_경우() {
        assertSimpleTest(() -> {
            run(",");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
