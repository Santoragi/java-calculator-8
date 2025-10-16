package calculator.handler;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler{

    @Override
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //TODO: 입력값 검증 로직 구현

        return input;
    }
}
