package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class QualifierCardinality implements IDegree {
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
        double r = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

        return 1 - r/m;
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> degrees = new ArrayList<>();

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

        degrees.add(1 - res2);
        degrees.add(1- res);

        return degrees;
    }
}
