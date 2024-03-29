package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class DegreeOfTruth implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double r = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = firstTypeSummary.getSummarizers().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

        if(firstTypeSummary.getQuantifier().getVariableName().equals("względny"))
            return firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(r/m);
        else
            return firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(r);
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

        if(firstTypeSummary.getQuantifier().getVariableName().equals("względny"))
        {
            degrees.add(firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(rLower/mLower));
            degrees.add(firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(rUpper/mUpper));
        }
        else
        {
            degrees.add(firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(rLower));
            degrees.add(firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(rUpper));
        }

        return degrees;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double r = secondTypeSummary.getSummarizers().getFuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getFuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();

        return secondTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(r/m);
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> degrees = new ArrayList<>();

        double rLower = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet())
                .getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).sum();
        double rUpper = secondTypeSummary.getSummarizers().getType2FuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getType2FuzzySet())
                .getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).sum();
        double mLower = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(0)).sum();
        double mUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).sum();
        double res = Math.min(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);
        double res2 = Math.max(Math.min(Math.min(rLower/mLower, rLower/mUpper), rUpper/mLower), rUpper/mUpper);

        degrees.add(secondTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(res));
        degrees.add(secondTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(res2));

        return degrees;
    }
}
