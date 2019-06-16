package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class QuantificationImprecision implements IDegree {

    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double width = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getWidth();
        if(firstTypeSummary.getQuantifier().getVariableName().equals("względny"))
            return 1 - width;
        else
            return 1 - width/firstTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size();

    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<>();
        double width = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getWidth();

        if(firstTypeSummary.getQuantifier().getVariableName().equals("względny"))
        {
            result.add(1 - width);
            result.add(1 - width);
        }
        else
        {
            result.add(1 - width/firstTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size());
            result.add(1 - width/firstTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size());
        }

        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double width = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getWidth();
        if(secondTypeSummary.getQuantifier().getVariableName().equals("względny"))
            return 1 - width;
        else
            return 1 - width/secondTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size();
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<>();
        double width = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getWidth();

        if(secondTypeSummary.getQuantifier().getVariableName().equals("względny"))
        {
            result.add(1 - width);
            result.add(1 - width);
        }
        else
        {
            result.add(1 - width/secondTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size());
            result.add(1 - width/secondTypeSummary.getQuantifier().getFuzzySet().getMembershipDegrees().size());
        }

        return result;
    }
}