package Sets;

import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public abstract class Set {

    protected List<Double> xValues;
    protected List<Double> membershipDegrees;
    protected MembershipFunction membershipFunction;

    protected Set(List<Double> xValues, MembershipFunction membershipFunction){
        this.xValues = xValues;
        this.membershipFunction = membershipFunction;
        this.membershipDegrees = calculateAllMembershipDegrees(xValues, membershipFunction);
    }

    public double calculateMembershipDegree(double xValue)
    {
        return membershipFunction.getFunction().countMembershipDegree(xValue);
    }

    public List<Double> calculateAllMembershipDegrees(List<Double> xValues, MembershipFunction membershipFunction){
        List<Double> degrees = new ArrayList<Double>();

        for (double xValue : xValues) {
            double degree = membershipFunction.getFunction().countMembershipDegree(xValue);
            degrees.add(degree);
        }

        return degrees;
    }

    public boolean isEmpty(){
        for(double degree : membershipDegrees){
            if (degree != 0)
                return false;
        }

        return true;
    }

    public boolean isNormal(){
        if (Collections.max(membershipDegrees) == 1)
            return true;

        return false;
    }

    public boolean isConvex(){
        return false;
    }

    public boolean isConcave(){
        return false;
    }

}
