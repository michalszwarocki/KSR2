package Variables;

import Sets.Type2FuzzySet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Type2ComplexSummarizer extends Type2LinguisticVariable{
    private List<Type2SimpleSummarizer> listOfSummarizers;
    private List<String> conjunctions;

    public Type2ComplexSummarizer(String summarizerName, String summarizerValue,
                                  List<Type2SimpleSummarizer> listOfSummarizers, List<String> conjunctions){

        this.variableName = summarizerName;
        this.variableValue = summarizerValue;
        this.listOfSummarizers = listOfSummarizers;
        this.conjunctions = conjunctions;
        this.type2FuzzySet = makeOneSetFromMultiple(listOfSummarizers, conjunctions);

    }

    private Type2FuzzySet makeOneSetFromMultiple(List<Type2SimpleSummarizer> listOfSummarizers,
                                                 List<String> conjunctions)
    {
        Type2FuzzySet fuzzySet = listOfSummarizers.get(0).getType2FuzzySet();
        for (int i=0; i < conjunctions.size(); i++){
            if(conjunctions.get(i).equals("i")){
                fuzzySet = fuzzySet.tNorm(listOfSummarizers.get(i+1).getType2FuzzySet());
            }
            else{
                fuzzySet = fuzzySet.getStandardUnion(listOfSummarizers.get(i+1).getType2FuzzySet());
            }
        }
        return fuzzySet;
    }

}

