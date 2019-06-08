package Sets;

import MembershipFunctions.MembershipFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class FuzzySet extends Set {

    private List<Double> xValues;
    private List<Double> membershipDegrees;
    private MembershipFunction membershipFunction;

    public FuzzySet(List<Double> xValues, MembershipFunction membershipFunction){
        this.xValues = xValues;
        this.membershipFunction = membershipFunction;
        this.membershipDegrees = calculateAllMembershipDegrees(xValues,membershipFunction);
    }

    public List<Double> calculateAllMembershipDegrees(List<Double> xValues, MembershipFunction membershipFunction){
        List<Double> degrees = new ArrayList<Double>();

        for (double xValue : xValues) {
            double degree = membershipFunction.countMembershipDegree(xValue);
            degrees.add(degree);
        }

        return degrees;
    }

    public boolean isEmpty() {
        for(double degree : membershipDegrees){
            if (degree != 0)
                return false;
        }

        return true;
    }

    public boolean isNormal() {
        if (Collections.max(membershipDegrees) == 1)
            return true;

        return false;
    }

    public boolean isConvex() {
        return false;
    }

    public boolean isConcave() {
        return false;
    }
}
