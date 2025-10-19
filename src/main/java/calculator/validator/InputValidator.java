package calculator.validator;

import calculator.config.CalculatorConfig;

public class InputValidator {

    /**
     * 요구하는 형식과 사용자의 입력 형식이 올바른지 검증 - "//" 으로 시작한다면 "\n"이 존재하는지 확인 - 커스텀 구분자에 숫자가 포함되지 않는지 확인 - 커스텀 구분자를 제외한 수식이 숫자로
     * 시작하는지 확인
     */
    public void validateInputFormat(String input) {
        if (input.startsWith(CalculatorConfig.CUSTOM_SEPARATOR_START)) {
            int index = input.lastIndexOf(CalculatorConfig.CUSTOM_SEPARATOR_END);
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자는 //과 \\n 사이에 있어야합니다.");
            } else {
                for (int i = CalculatorConfig.CUSTOM_SEPARATOR_START.length(); i < index; i++) {
                    if (Character.isDigit(input.charAt(i))) {
                        throw new IllegalArgumentException("숫자는 커스텀 구분자로 지정할 수 없습니다.");
                    }
                }
            }
            if (!Character.isDigit(input.charAt(index + CalculatorConfig.CUSTOM_SEPARATOR_END.length()))) {
                throw new IllegalArgumentException("커스텀 구분자를 제외한 수식은 숫자로 시작해야합니다.");
            }
        } else {
            if (!input.matches("[0-9].*")) {
                throw new IllegalArgumentException("커스텀 구분자를 제외한 수식은 숫자로 시작해야합니다.");
            }
        }
    }

}
