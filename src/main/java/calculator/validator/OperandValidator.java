package calculator.validator;

public class OperandValidator {

    public void validatePositiveNumber(String number) {
        try {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("구분자는 연속될 수 없습니다.");
            }
            int num = Integer.parseInt(number);
            if (num <= 0) {
                throw new IllegalArgumentException("피연산자는 양의 정수만 허용됩니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자는 양의 정수만 허용됩니다.");
        }
    }
}
