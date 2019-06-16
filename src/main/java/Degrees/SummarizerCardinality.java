package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;
import Variables.SimpleSummarizer;
import Variables.Type2SimpleSummarizer;

import java.util.ArrayList;
import java.util.List;

public class SummarizerCardinality implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double r = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

        return 1 - r/m;
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> degrees = new ArrayList<>();

        double rLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).sum();
        double rUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).sum();
        double mLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).count();
        double mUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).count();

        double res = Math.min(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);
        double res2 = Math.max(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);

        degrees.add(1 - res2);
        degrees.add(1- res);

        return degrees;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double result = 1.0;
        for(SimpleSummarizer summarizer : secondTypeSummary.getSummarizers().getListOfSummarizers())
        {
            double r = secondTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a).sum();
            double m = secondTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a).count();

            result *= r/m;
        }

        double r = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

        result *= r/m;

        result = Math.pow(result, 1/(secondTypeSummary.getSummarizers().getListOfSummarizers().size()+1));

        return 1 - result;
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<Double>(){
            {
                add(1.0);
                add(1.0);
            }
        };

        for(Type2SimpleSummarizer summarizer : secondTypeSummary.getSummarizers().getListOfSummarizers())
        {
            double rLower = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(0)).sum();
            double rUpper = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(1)).sum();
            double mLower = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(0)).count();
            double mUpper = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(1)).count();

            double res = Math.min(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);
            double res2 = Math.max(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);

            result.set(0, result.get(0)*res2);
            result.set(1, result.get(1)*res);
        }

        double rLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).sum();
        double rUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).sum();
        double mLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).count();
        double mUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).count();

        double res = Math.min(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);
        double res2 = Math.max(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);

        result.set(0, result.get(0)*res2);
        result.set(1, result.get(1)*res);


        result.set(0, Math.pow(result.get(0), 1.0/(secondTypeSummary.getSummarizers().getListOfSummarizers().size()+1)));
        result.set(1, Math.pow(result.get(1), 1.0/(secondTypeSummary.getSummarizers().getListOfSummarizers().size()+1)));


        result.set(0, 1 - result.get(0));
        result.set(1, 1 - result.get(1));

        return result;
    }
}
