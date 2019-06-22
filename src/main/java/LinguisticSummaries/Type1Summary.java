package LinguisticSummaries;

import Degrees.IDegree;
import Variables.ComplexSummarizer;
import Variables.Quantifier;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Type1Summary {

    //Q P verb S[T]
    private Quantifier quantifier;
    private String subject;
    private String verb;
    private ComplexSummarizer summarizers;
    private List<IDegree> degrees;

    public double getFinalDegree() {
        return finalDegree;
    }

    private double finalDegree;

    public Type1Summary(Quantifier quantifier, String subject, String verb, ComplexSummarizer summarizers, List<IDegree> degrees){
        this.quantifier = quantifier;
        this.subject = subject;
        this.verb = verb;
        this.summarizers = summarizers;
        this.degrees = degrees;

        this.finalDegree = calculateFinalDegree(this);
    }

    public double calculateFinalDegree(Type1Summary summary){
        double sum = 0.0;

        for (IDegree degree : degrees)
        {
            sum += degree.calculateDegree(summary);
        }

        sum /= degrees.size();

        return sum;
    }

    public String composeLinguisticSummary(){
        String summary = quantifier.getVariableValue() + " " + subject + " " + verb + " " +
                summarizers.getVariableValue() + " [" + finalDegree + "]";

        return summary;
    }
}
