package Degrees;

import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;

import java.util.ArrayList;
import java.util.List;

public class QuantificationCardinality implements IDegree {
    @Override
    public double calculateDegree(Type1Summary firstTypeSummary) {
        double min = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMin();
        double max = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMax();
        double N = 50;
        double sum = 0.0;

        Linspace counter=new Linspace(min, max, N);
        while(counter.hasNext()) {
            sum +=firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(counter.getNextFloat());
        }

        return 1 - sum/N;
    }

    @Override
    public List<Double> calculateDegree(Type1IntervalSummary firstTypeSummary) {
        List<Double> result = new ArrayList<>();

        double min = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMin();
        double max = firstTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMax();
        double N = 50;
        double sum = 0.0;

        Linspace counter=new Linspace(min, max, N);
        while(counter.hasNext()) {
            sum +=firstTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(counter.getNextFloat());
        }

        result.add(1 - sum/N);
        result.add(1 - sum/N);

        return result;
    }

    @Override
    public double calculateDegree(Type2Summary secondTypeSummary) {
        double min = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMin();
        double max = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMax();
        double N = 50;
        double sum = 0.0;

        Linspace counter=new Linspace(min, max, N);
        while(counter.hasNext()) {
            sum +=secondTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(counter.getNextFloat());
        }

        return 1 - sum/N;
    }

    @Override
    public List<Double> calculateDegree(Type2IntervalSummary secondTypeSummary) {
        List<Double> result = new ArrayList<>();

        double min = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMin();
        double max = secondTypeSummary.getQuantifier().getFuzzySet().getMembershipFunction().getMax();
        double N = 50;
        double sum = 0.0;

        Linspace counter=new Linspace(min, max, N);
        while(counter.hasNext()) {
            sum +=secondTypeSummary.getQuantifier().getFuzzySet().calculateMembershipDegree(counter.getNextFloat());
        }

        result.add(1 - sum/N);
        result.add(1 - sum/N);

        return result;
    }

    private class Linspace {
        private double current;
        private final double end;
        private final double step;
        public Linspace(double start, double end, double totalCount) {
            this.current=start;
            this.end=end;
            this.step=(end - start) / totalCount;
        }
        public boolean hasNext() {
            return current < (end + step/2); //MAY stop floating point error
        }
        public double getNextFloat() {
            current+=step;
            return current;
        }
    }
}
