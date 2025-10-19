package calculator.handler;

import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    InputValidator inputValidator = new InputValidator();

    @Override
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        inputValidator.validateInputFormat(input);

        return input;
    }
}
