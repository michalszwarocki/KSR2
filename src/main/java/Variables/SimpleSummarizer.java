package Variables;

import Sets.FuzzySet;

public class SimpleSummarizer extends LinguisticVariable {

    public SimpleSummarizer(String variableName, String variableValue, FuzzySet fuzzySet) {
        this.variableName = variableName;
        this.variableValue = variableValue;
        this.fuzzySet = fuzzySet;
    }
}