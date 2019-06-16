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

    public FuzzySet(List<Double> xValues, MembershipFunction membershipFunction){
        super(xValues, membershipFunction);
    }

    public double getHeight(){
        return Collections.max(membershipDegrees);
    }

    public List<Double> getCore(){
        List<Double> coreValues = new ArrayList<Double>();
        for(int i=0; i<membershipDegrees.size(); i++)
        {
            if(membershipDegrees.get(i) == 1)
            {
                coreValues.add(xValues.get(i));
            }
        }

        return coreValues;
    }

    public List<Double> getSupport(){
        List<Double> supportValues = new ArrayList<Double>();
        for(int i=0; i<membershipDegrees.size(); i++)
        {
            if(membershipDegrees.get(i) > 0)
            {
                supportValues.add(xValues.get(i));
            }
        }

        return supportValues;
    }

    public List<Double> getAlfaSection(double alfa){
        List<Double> alfaSectionValues = new ArrayList<Double>();
        for(int i=0; i<membershipDegrees.size(); i++)
        {
            if(membershipDegrees.get(i) >= alfa)
            {
                alfaSectionValues.add(xValues.get(i));
            }
        }

        return alfaSectionValues;
    }

    public FuzzySet getStandardComplement(){
        MembershipFunction membershipFunction = this.membershipFunction;
        membershipFunction.setFunctionAsStandardComplement();
        FuzzySet complement = new FuzzySet(xValues, membershipFunction);
        return complement;
    }

    public FuzzySet getStandardUnion(FuzzySet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsStandardUnion(another.membershipFunction);
        FuzzySet union = new FuzzySet(unionValues, characteristicFunction);
        return union;
    }

    public FuzzySet getStandardIntersection(FuzzySet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsStandardIntersection(another.membershipFunction);
        FuzzySet intersection = new FuzzySet(unionValues, characteristicFunction);
        return intersection;
    }

    public FuzzySet getAlgebraicUnion(FuzzySet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsAlgebraicUnion(another.membershipFunction);
        FuzzySet union = new FuzzySet(unionValues, characteristicFunction);
        return union;
    }

    public FuzzySet getAlgebraicIntersection(FuzzySet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsAlgebraicIntersection(another.membershipFunction);
        FuzzySet intersection = new FuzzySet(unionValues, characteristicFunction);
        return intersection;
    }

    public FuzzySet tNorm(FuzzySet another){
        FuzzySet tNormFuzzySet = this;
        List<Double> tNormValues = new ArrayList<>();
        for( int i = 0; i < this.membershipDegrees.size(); i++)
        {
            tNormValues.add(Math.min(this.membershipDegrees.get(i), another.membershipDegrees.get(i)));
        }

        tNormFuzzySet.setMembershipDegrees(tNormValues);

        return tNormFuzzySet;
    }

}
