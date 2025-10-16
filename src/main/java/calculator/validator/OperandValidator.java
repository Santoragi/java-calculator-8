package calculator.validator;

public class OperandValidator {

    public void validatePositiveNumber(int input){
        if(input <= 0) {
            throw new IllegalArgumentException("양수가 아닌 숫자는 수식에 포함될 수 없습니다.");
        }
    }
}
