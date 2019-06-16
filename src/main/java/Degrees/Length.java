package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class Length implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        return 2 * Math.pow(0.5, firstTypeSummary.getSummarizers().getListOfSummarizers().size());
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<>();

        double res = 2 * Math.pow(0.5, firstTypeSummary.getSummarizers().getListOfSummarizers().size());

        result.add(res);
        result.add(res);

        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        return 2 * Math.pow(0.5, secondTypeSummary.getSummarizers().getListOfSummarizers().size() + 1);
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<>();

        double res = 2 * Math.pow(0.5, secondTypeSummary.getSummarizers().getListOfSummarizers().size() + 1);

        result.add(res);
        result.add(res);

        return result;
    }
}
