package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;
import Variables.SimpleSummarizer;
import Variables.Type2SimpleSummarizer;

import java.util.ArrayList;
import java.util.List;

public class DegreeOfAppropriateness implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double r = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).sum();
        double m = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();

        DegreeOfCovering dOC = new DegreeOfCovering();
        return Math.abs(r/m - dOC.calculateDegree(firstTypeSummary));
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<>();

        double rLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).sum();
        double rUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).sum();
        double mLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
        double mUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();

        DegreeOfCovering dOC = new DegreeOfCovering();
        result.add(Math.abs(rLower/mLower - dOC.calculateDegree(firstTypeSummary).get(0)));
        result.add(Math.abs(rUpper/mUpper - dOC.calculateDegree(firstTypeSummary).get(1)));
        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double result = 1.0;
        for(SimpleSummarizer summarizer : secondTypeSummary.getSummarizers().getListOfSummarizers())
        {
            double r = summarizer.getFuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a).filter(p -> p > 0).sum();
            double m = summarizer.getFuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a).filter(p -> p > 0).count();

            result *= r/m;
        }

        double r = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).sum();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();

        result *= r/m;

        DegreeOfCovering dOC = new DegreeOfCovering();
        return Math.abs(r/m - dOC.calculateDegree(secondTypeSummary));
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
                    .mapToDouble(a -> a.get(0)).filter(p -> p > 0).sum();
            double rUpper = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(1)).filter(p -> p > 0).sum();
            double mLower = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
            double mUpper = secondTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                    .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();

            result.set(0, result.get(0)*rLower/mLower);
            result.set(1, result.get(1)*rUpper/mUpper);
        }

        double rLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).sum();
        double rUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).sum();
        double mLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
        double mUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();

        result.set(0, result.get(0)*rLower/mLower);
        result.set(1, result.get(1)*rUpper/mUpper);

        DegreeOfCovering dOC = new DegreeOfCovering();
        result.set(0, Math.abs(result.get(0) - dOC.calculateDegree(secondTypeSummary).get(0)));
        result.set(1, Math.abs(result.get(1) - dOC.calculateDegree(secondTypeSummary).get(1)));

        return result;
    }
}
