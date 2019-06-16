package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;
import Variables.SimpleSummarizer;
import Variables.Type2SimpleSummarizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DegreeOfImprecision implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double result = 0.0;
        double positive = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();
        result = 1 - positive/firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().size();

        return result;
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<Double>(){
            {
                add(1.0);
                add(1.0);
            }
        };

        double positiveLow = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream().mapToDouble(a -> a.get(0))
                    .filter(p -> p > 0).count();

        double positiveUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream().mapToDouble(a -> a.get(1))
                    .filter(p -> p > 0).count();

        result.set(0, result.get(0) * positiveLow/firstTypeSummary.getSummarizers()
                    .getType2FuzzySet().getMembershipDegrees().size());
        result.set(1, result.get(1) * positiveUpper/firstTypeSummary.getSummarizers()
                    .getType2FuzzySet().getMembershipDegrees().size());

        double res = result.get(0) * result.get(1);

        res = Math.pow(res, 1.0/2.0);
        res = 1 - res;

        result.set(0, 1-res);
        result.set(1, 1-res);

        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double result = 0.0;
        double positive = secondTypeSummary.getSummarizers().getFuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getFuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();
        result = 1 - positive/secondTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().size();

        return result;
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<Double>(){
            {
                add(1.0);
                add(1.0);
            }
        };

        double positiveLow = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();

        double positiveUpper = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();

        result.set(0, result.get(0) * positiveLow/secondTypeSummary.getSummarizers()
                .getType2FuzzySet().getMembershipDegrees().size());
        result.set(1, result.get(1) * positiveUpper/secondTypeSummary.getSummarizers()
                .getType2FuzzySet().getMembershipDegrees().size());

        double res = result.get(0) * result.get(1);

        res = Math.pow(res, 1.0/2.0);
        res = 1 - res;

        result.set(0, 1-res);
        result.set(1, 1-res);

        return result;
    }
}
