package Variables;

import Sets.Type2FuzzySet;

public abstract class Type2LinguisticVariable {

    protected String variableName;
    protected String variableValue;
    protected Type2FuzzySet type2FuzzySet;

    public Type2FuzzySet getType2FuzzySet() {
        return type2FuzzySet;
    }

    public void setType2FuzzySet(Type2FuzzySet type2FuzzySet) {
        this.type2FuzzySet = type2FuzzySet;
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