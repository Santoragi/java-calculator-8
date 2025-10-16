package calculator.model;

import calculator.handler.InputHandler;

public class CustomCalculator implements Calculator{

    private final InputHandler inputHandler;
    private String formula;

    public CustomCalculator(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    @Override
    public void run() {
        setFormula(inputHandler.getInput());

        //TODO: 계산 로직 구현
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
