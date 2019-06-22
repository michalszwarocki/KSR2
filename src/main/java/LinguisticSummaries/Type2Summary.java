package LinguisticSummaries;

import Degrees.IDegree;
import Variables.ComplexSummarizer;
import Variables.Qualifier;
import Variables.Quantifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Type2Summary {

    //Q P of Ql verb S[T]
    private Quantifier quantifier;
    private String subject;
    private Qualifier qualifier;
    private String verb;
    private ComplexSummarizer summarizers;
    private List<IDegree> degrees;

    public double getFinalDegree() {
        return finalDegree;
    }

    private double finalDegree;

    public Type2Summary(Quantifier quantifier, String subject, Qualifier qualifier,
                        String verb, ComplexSummarizer summarizers, List<IDegree> degrees){
        this.quantifier = quantifier;
        this.subject = subject;
        this.qualifier = qualifier;
        this.verb = verb;
        this.summarizers = summarizers;
        this.degrees = degrees;

        this.finalDegree = calculateFinalDegree(this);
    }

    public double calculateFinalDegree(Type2Summary summary){
        double sum = 0.0;

        for (IDegree degree : degrees)
        {
            sum += degree.calculateDegree(summary);
        }

        sum /= degrees.size();

        return sum;
    }

    public String composeLinguisticSummary(){
        String summary = quantifier.getVariableValue() + " " + subject + " mających " + qualifier.getVariableValue()
                + " " + verb + " " + summarizers.getVariableValue() + " [" + finalDegree + "]";

        return summary;
    }
}