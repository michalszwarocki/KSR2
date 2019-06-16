package Sets;

import MembershipFunctions.MembershipFunction;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Type2FuzzySet {

    private List<Double> xValues;
    private List<List<Double>> membershipDegrees;
    private MembershipFunction lowerMembershipFunction;
    private MembershipFunction upperMembershipFunction;

    public Type2FuzzySet(List<Double> xValues, MembershipFunction lowerMembershipFunction,
                         MembershipFunction upperMembershipFunction){
        this.xValues = xValues;
        this.lowerMembershipFunction = lowerMembershipFunction;
        this.upperMembershipFunction = upperMembershipFunction;
        this.membershipDegrees = calculateAllMembershipDegrees(xValues, lowerMembershipFunction, upperMembershipFunction);
    }

    public List<Double> calculateMembershipDegree(double xValue)
    {
        List<Double> degrees = new ArrayList<>();

        degrees.add(lowerMembershipFunction.getFunction().countMembershipDegree(xValue));
        degrees.add(upperMembershipFunction.getFunction().countMembershipDegree(xValue));

        return degrees;
    }

    public List<List<Double>> calculateAllMembershipDegrees(List<Double> xValues, MembershipFunction lowerMembershipFunction,
                                                            MembershipFunction upperMembershipFunction){
        List<List<Double>> degrees = new ArrayList<>();

        for (double xValue : xValues) {
            List<Double> intervalDegrees = new ArrayList<>();
            intervalDegrees.add(lowerMembershipFunction.getFunction().countMembershipDegree(xValue));
            intervalDegrees.add(upperMembershipFunction.getFunction().countMembershipDegree(xValue));

            degrees.add(intervalDegrees);
        }

        return degrees;
    }

    public boolean isEmpty(){
        for(List<Double> degrees : membershipDegrees){
            for(double degree : degrees)
            {
                if (degree != 0)
                    return false;
            }
        }

        return true;
    }

    public boolean isNormal(){
        List<Double> upperResults = new ArrayList<>();
        List<Double> lowerResults = new ArrayList<>();
        for(List<Double> degrees : membershipDegrees)
        {
            lowerResults.add(degrees.get(0));
            upperResults.add(degrees.get(1));
        }
        if (Collections.max(upperResults) == 1 && Collections.max(lowerResults) == 1)
            return true;

        return false;
    }

    public List<List<Double>> getSupport(){
        List<List<Double>> supportsValues = new ArrayList<>();
        List<Double> lowerSupportsValues = new ArrayList<>();
        List<Double> upperSupportsValues = new ArrayList<>();

        for(int i = 0; i < membershipDegrees.size(); i++)
        {
            if(membershipDegrees.get(i).get(0) > 0)
            {
                lowerSupportsValues.add(xValues.get(i));
            }

            if(membershipDegrees.get(i).get(1) > 0)
            {
                upperSupportsValues.add(xValues.get(i));
            }
        }

        supportsValues.add(lowerSupportsValues);
        supportsValues.add(upperSupportsValues);

        return supportsValues;
    }

    public Type2FuzzySet getStandardComplement(){
        MembershipFunction lowerMembershipFunction = this.upperMembershipFunction;
        MembershipFunction upperMembershipFunction = this.lowerMembershipFunction;
        lowerMembershipFunction.setFunctionAsStandardComplement();
        upperMembershipFunction.setFunctionAsStandardComplement();
        Type2FuzzySet complement = new Type2FuzzySet(xValues, lowerMembershipFunction, upperMembershipFunction);
        return complement;
    }

    public Type2FuzzySet getStandardUnion(Type2FuzzySet another){
        MembershipFunction lowerMembershipFunction = this.lowerMembershipFunction;
        MembershipFunction upperMembershipFunction = this.upperMembershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        lowerMembershipFunction.setFunctionAsStandardUnion(another.lowerMembershipFunction);
        upperMembershipFunction.setFunctionAsStandardUnion(another.upperMembershipFunction);
        Type2FuzzySet union = new Type2FuzzySet(unionValues, lowerMembershipFunction, upperMembershipFunction);
        return union;
    }

    public Type2FuzzySet getStandardIntersection(Type2FuzzySet another){
        MembershipFunction lowerMembershipFunction = this.lowerMembershipFunction;
        MembershipFunction upperMembershipFunction = this.upperMembershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        lowerMembershipFunction.setFunctionAsStandardIntersection(another.lowerMembershipFunction);
        upperMembershipFunction.setFunctionAsStandardIntersection(another.upperMembershipFunction);
        Type2FuzzySet intersection = new Type2FuzzySet(unionValues, lowerMembershipFunction, upperMembershipFunction);
        return intersection;
    }

    public Type2FuzzySet getAlgebraicUnion(Type2FuzzySet another){
        MembershipFunction lowerMembershipFunction = this.lowerMembershipFunction;
        MembershipFunction upperMembershipFunction = this.upperMembershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        lowerMembershipFunction.setFunctionAsAlgebraicUnion(another.lowerMembershipFunction);
        upperMembershipFunction.setFunctionAsAlgebraicUnion(another.upperMembershipFunction);
        Type2FuzzySet union = new Type2FuzzySet(unionValues, lowerMembershipFunction, upperMembershipFunction);
        return union;
    }

    public Type2FuzzySet getAlgebraicIntersection(Type2FuzzySet another){
        MembershipFunction lowerMembershipFunction = this.lowerMembershipFunction;
        MembershipFunction upperMembershipFunction = this.upperMembershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        lowerMembershipFunction.setFunctionAsAlgebraicIntersection(another.lowerMembershipFunction);
        upperMembershipFunction.setFunctionAsAlgebraicIntersection(another.upperMembershipFunction);
        Type2FuzzySet intersection = new Type2FuzzySet(unionValues, lowerMembershipFunction, upperMembershipFunction);
        return intersection;
    }
}
