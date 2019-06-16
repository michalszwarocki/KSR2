package Variables;

import Sets.FuzzySet;

public abstract class LinguisticVariable {

    protected String variableName;
    protected String variableValue;
    protected FuzzySet fuzzySet;


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
