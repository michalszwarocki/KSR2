package LinguisticSummaries;

import Degrees.IDegree;
import Variables.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Type2IntervalSummary {

    //Q P of Ql verb S[T]
    private Quantifier quantifier;
    private String subject;
    private Type2Qualifier qualifier;
    private String verb;
    private Type2ComplexSummarizer summarizers;
    private List<IDegree> degrees;
    private List<Double> finalDegree;

    public Type2IntervalSummary(Quantifier quantifier, String subject, Type2Qualifier qualifier,
                                String verb, Type2ComplexSummarizer summarizers, List<IDegree> degrees){
        this.quantifier = quantifier;
        this.subject = subject;
        this.qualifier = qualifier;
        this.verb = verb;
        this.summarizers = summarizers;
        this.degrees = degrees;

        this.finalDegree = calculateFinalDegree(this);
    }

    public List<Double> calculateFinalDegree(Type2IntervalSummary summary){
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
        String summary = quantifier.getVariableValue() + " " + subject + " będących " + qualifier.getVariableValue()
                + " " + verb + " " + summarizers.getVariableValue() + " [" + finalDegree.get(0) +", " +
                finalDegree.get(1) + "]";

        return summary;
    }
}