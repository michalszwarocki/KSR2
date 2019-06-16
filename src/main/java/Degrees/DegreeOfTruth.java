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
            degrees.add(firstTypeSummary.getQuantifier().getType2FuzzySet().getLowerMembershipFunction()
                    .getFunction().countMembershipDegree(rLower/mLower));
            degrees.add(firstTypeSummary.getQuantifier().getType2FuzzySet().getUpperMembershipFunction()
                    .getFunction().countMembershipDegree(rUpper/mUpper));
        }
        else
        {
            degrees.add(firstTypeSummary.getQuantifier().getType2FuzzySet().getLowerMembershipFunction()
                    .getFunction().countMembershipDegree(rLower));
            degrees.add(firstTypeSummary.getQuantifier().getType2FuzzySet().getUpperMembershipFunction()
                    .getFunction().countMembershipDegree(rUpper));
        }

        return degrees;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double r = secondTypeSummary.getSummarizers().getFuzzySet()
                .tNorm(secondTypeSummary.getQualifier().getFuzzySet()).getMembershipDegrees().stream()
                .mapToDouble(a -> a).sum();
        double m = secondTypeSummary.getQualifier().getFuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a).count();

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
                .mapToDouble(a -> a.get(0)).count();
        double mUpper = secondTypeSummary.getQualifier().getType2FuzzySet().getMembershipDegrees().stream()
                .mapToDouble(a -> a.get(1)).count();

        degrees.add(secondTypeSummary.getQuantifier().getType2FuzzySet().getLowerMembershipFunction()
                    .getFunction().countMembershipDegree(rLower/mLower));
        degrees.add(secondTypeSummary.getQuantifier().getType2FuzzySet().getUpperMembershipFunction()
                    .getFunction().countMembershipDegree(rUpper/mUpper));

        return degrees;
    }
}
