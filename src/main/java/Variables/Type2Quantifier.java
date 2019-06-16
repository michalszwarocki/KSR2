package Variables;

import Sets.Type2FuzzySet;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Type2Quantifier extends Type2LinguisticVariable{

    public Type2Quantifier(String variableName, String variableValue, Type2FuzzySet type2FuzzySet) {
        this.variableName = variableName;
        this.variableValue = variableValue;
        this.type2FuzzySet = type2FuzzySet;
    }
}
