package Variables;

import Sets.FuzzySet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComplexSummarizer extends LinguisticVariable{
    private List<SimpleSummarizer> listOfSummarizers;
    private List<String> conjunctions;

    public ComplexSummarizer(String summarizerName, String summarizerValue,
                             List<SimpleSummarizer> listOfSummarizers, List<String> conjunctions){

        this.variableName = summarizerName;
        this.variableValue = summarizerValue;
        this.listOfSummarizers = listOfSummarizers;
        this.conjunctions = conjunctions;
        this.fuzzySet = makeOneSetFromMultiple(listOfSummarizers, conjunctions);

    }

    private FuzzySet makeOneSetFromMultiple(List<SimpleSummarizer> listOfSummarizers,
                                            List<String> conjunctions)
    {
        FuzzySet fuzzySet = listOfSummarizers.get(0).getFuzzySet();
        for (int i=0; i < conjunctions.size(); i++){
            if(conjunctions.get(i).equals("i")){
                fuzzySet = fuzzySet.tNorm(listOfSummarizers.get(i+1).getFuzzySet());
            }
            else{
                fuzzySet = fuzzySet.getStandardUnion(listOfSummarizers.get(i+1).getFuzzySet());
            }
        }
        return fuzzySet;
    }

}

