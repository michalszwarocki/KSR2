package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class DegreeOfCovering implements IDegree{

    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double r = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();
        double m = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

        return r/m;
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> degrees = new ArrayList<>();

        double rLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
        double rUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();
        double mLower = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).count();
        double mUpper = firstTypeSummary.getSummarizers().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).count();

        degrees.add(rLower/mLower);
        degrees.add(rUpper/mUpper);

        return degrees;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double r = secondTypeSummary.getSummarizers().getFuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getFuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).filter(p -> p > 0).count();

        return r/m;
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> degrees = new ArrayList<>();

        double rLower = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet())
                .getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
        double rUpper = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet())
                .getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();
        double mLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).filter(p -> p > 0).count();
        double mUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).filter(p -> p > 0).count();

        degrees.add(rLower/mLower);
        degrees.add(rUpper/mUpper);

        return degrees;
    }
}
