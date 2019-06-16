package LinguisticSummaries;

import Degrees.IDegree;
import Variables.ComplexSummarizer;
import Variables.Quantifier;
import Variables.Type2ComplexSummarizer;
import Variables.Type2Quantifier;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Type1IntervalSummary {

    //Q P verb S[T]
    private Quantifier quantifier;
    private String subject;
    private String verb;
    private Type2ComplexSummarizer summarizers;
    private List<IDegree> degrees;
    private List<Double> finalDegree;

    public Type1IntervalSummary(Quantifier quantifier, String subject, String verb,
                                Type2ComplexSummarizer summarizers, List<IDegree> degrees){

        this.quantifier = quantifier;
        this.subject = subject;
        this.verb = verb;
        this.summarizers = summarizers;
        this.degrees = degrees;

        this.finalDegree = calculateFinalDegree(this);
    }

    public List<Double> calculateFinalDegree(Type1IntervalSummary summary){
        List<Double> sum = new ArrayList<>();
        double sumLower = 0.0;
        double sumUpper = 0.0;

        for (IDegree degree : degrees)
        {
            sumLower += degree.calculateDegree(summary).get(0);
            sumUpper += degree.calculateDegree(summary).get(1);
        }

        sumLower /= degrees.size();
        sumUpper /= degrees.size();

        sum.add(sumLower);
        sum.add(sumUpper);

        return sum;
    }

    public String composeLinguisticSummary(){
        String summary = quantifier.getVariableValue() + " " + subject + " " + verb + " " +
                summarizers.getVariableValue() + " [" + finalDegree.get(0) +", " + finalDegree.get(1) + "]";

        return summary;
    }
}
