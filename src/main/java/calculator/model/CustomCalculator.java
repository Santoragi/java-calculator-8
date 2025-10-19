package calculator.model;

import calculator.config.CalculatorConfig;
import calculator.handler.InputHandler;
import calculator.handler.OutputHandler;
import calculator.validator.OperandValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomCalculator implements Calculator{

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private OperandValidator operandValidator = new OperandValidator();
    private String formula;
    private Set<String> separators = new HashSet<>(CalculatorConfig.DEFAULT_SEPARATORS);

    public CustomCalculator(InputHandler inputHandler, OutputHandler outputHandler){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void run() {

        setFormula(inputHandler.getInput());
        addCustomSeparator();
        calculate();
    }

    private void addCustomSeparator(){

        if(formula.startsWith(CalculatorConfig.CUSTOM_SEPARATOR_START)){
            int index = formula.lastIndexOf(CalculatorConfig.CUSTOM_SEPARATOR_END);
            if(index != -1){
                for(int i = CalculatorConfig.CUSTOM_SEPARATOR_START.length(); i < index; i++){
                    String customOperator = formula.substring(i, i + 1);
                    separators.add(customOperator);
                }
            }

            formula = formula.substring(index + CalculatorConfig.CUSTOM_SEPARATOR_END.length());
        }
    }

    private void calculate(){

        List<Integer> operands = new ArrayList<>();

        String regex = separators.stream()
                .map(Pattern::quote)
                .reduce((a, b) -> a + "|" + b)
                .orElse("");
        String[] numbers = formula.split(regex);
        for(String number : numbers){
            operandValidator.validatePositiveNumber(number);
            operands.add(Integer.parseInt(number));
        }

        int result = 0;
        for(int o : operands){
            result += o;
        }

        outputHandler.print(result);
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
