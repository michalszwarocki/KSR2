package Variables;

import Sets.FuzzySet;

public class LinguisticVariable {

    private String variableName;
    private String variableValue;
    private FuzzySet fuzzySet;

    public LinguisticVariable(String variableName, String variableValue, FuzzySet fuzzySet){
        this.variableValue = variableValue;
        this.variableName = variableName;
        this.fuzzySet = fuzzySet;
    }

    public FuzzySet getFuzzySet() {
        return fuzzySet;
    }

    public void setFuzzySet(FuzzySet fuzzySet) {
        this.fuzzySet = fuzzySet;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }
}
