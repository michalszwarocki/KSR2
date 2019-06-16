package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.List;

public interface IDegree {

    double calculateDegree (Type1Summary firstTypeSummary);

    List<Double> calculateDegree (Type1IntervalSummary firstTypeSummary);

    double calculateDegree (Type2Summary secondTypeSummary);

    List<Double> calculateDegree (Type2IntervalSummary secondTypeSummary);
}
