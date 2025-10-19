package calculator.handler;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String OUTPUT_FORMAT = "결과 : ";

    @Override
    public void print(int num) {
        System.out.println(OUTPUT_FORMAT + num);
    }
}
