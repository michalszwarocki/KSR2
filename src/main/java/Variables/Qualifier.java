package Variables;

import Sets.FuzzySet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Qualifier extends LinguisticVariable {

    public Qualifier(String variableName, String variableValue, FuzzySet fuzzySet) {
        this.variableName = variableName;
        this.variableValue = variableValue;
        this.fuzzySet = fuzzySet;
    }
}
