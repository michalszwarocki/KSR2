package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class QualifierCount implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        return 0;
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<Double>(){
            {
                add(0.0);
                add(0.0);
            }
        };

        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        return 2 * Math.pow(0.5, 1);
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<Double>(){
            {
                add(2 * Math.pow(0.5, 1));
                add(2 * Math.pow(0.5, 1));
            }
        };

        return result;
    }
}
