package Variables;

import Sets.FuzzySet;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Quantifier extends LinguisticVariable{

    public Quantifier(String variableName, String variableValue, FuzzySet fuzzySet) {
        this.variableName = variableName;
        this.variableValue = variableValue;
        this.fuzzySet = fuzzySet;
    }
}
