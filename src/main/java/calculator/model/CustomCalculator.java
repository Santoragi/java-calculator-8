package calculator.model;

import calculator.handler.InputHandler;
import calculator.validator.OperandValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomCalculator implements Calculator{

    private final InputHandler inputHandler;
    private OperandValidator operandValidator = new OperandValidator();
    private String formula;
    private Set<String> separators = new HashSet<>(List.of(",", ":"));

    public CustomCalculator(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    @Override
    public void run() {

        setFormula(inputHandler.getInput());
        addCustomOperator();
        calculate();
    }

    private void addCustomOperator(){

        if(formula.startsWith("//")){
            int index = formula.indexOf("\\n");
            if(index != -1){
                for(int i = 2; i < index; i++){
                    String customOperator = formula.substring(i, i + 1);
                    separators.add(customOperator);
                }
            }

            formula = formula.substring(index + 2);
        }
    }

    private void calculate(){

        List<Integer> operands = new ArrayList<>();

        String regex = "[" + separators + "]";
        String[] numbers = formula.split(regex);
        for(String number : numbers){
            if(!number.isEmpty()){
                int numberValue = Integer.parseInt(number);
                operandValidator.validatePositiveNumber(numberValue);
                operands.add(numberValue);
            }
        }

        int result = 0;
        for(int o : operands){
            result += o;
        }

        System.out.println("결과 : " + result);
    }

    public String getFormula(){
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
