package Sets;

import MembershipFunctions.CharacteristicFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ClassicSet extends Set{

    private List<Double> xValues;
    private List<Double> membershipDegrees;
    private CharacteristicFunction membershipFunction;

    public ClassicSet(List<Double> xValues, CharacteristicFunction membershipFunction){
        this.xValues = xValues;
        this.membershipFunction = membershipFunction;
        this.membershipDegrees = calculateAllMembershipDegrees(xValues,membershipFunction);
    }

    public List<Double> calculateAllMembershipDegrees(List<Double> xValues, CharacteristicFunction membershipFunction){
        List<Double> degrees = new ArrayList<Double>();

        for (double xValue : xValues) {
            double degree = membershipFunction.countMembershipDegree(xValue);
            degrees.add(degree);
        }

        return degrees;
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

    public boolean isEmpty() {
        for(double degree : membershipDegrees){
            if (degree != 0)
                return false;
        }

        return true;
    }

    public boolean isNormal() {
        if (getHeight() == 1)
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