package calculator;

import calculator.handler.ConsoleInputHandler;
import calculator.handler.ConsoleOutputHandler;
import calculator.handler.InputHandler;
import calculator.handler.OutputHandler;
import calculator.model.Calculator;
import calculator.model.CustomCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: InputHandler, Calculator, Validator
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        Calculator calculator = new CustomCalculator(inputHandler, outputHandler);
        calculator.run();

    }
}
