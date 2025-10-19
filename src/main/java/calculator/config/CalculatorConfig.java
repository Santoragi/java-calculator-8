package calculator.config;

import java.util.Set;

public final class CalculatorConfig {

    private CalculatorConfig(){};

    public static final Set<String> DEFAULT_SEPARATORS = Set.of(",", ":");
    public static final String CUSTOM_SEPARATOR_START = "//";
    public static final String CUSTOM_SEPARATOR_END = "\\n";
}
