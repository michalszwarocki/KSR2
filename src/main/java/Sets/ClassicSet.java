package Sets;

import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ClassicSet extends Set{

    public ClassicSet(List<Double> xValues, MembershipFunction membershipFunction){
        super(xValues, membershipFunction);
    }

    public ClassicSet getStandardComplement(){
        MembershipFunction characteristicFunction = this.membershipFunction;
        characteristicFunction.setFunctionAsStandardComplement();
        ClassicSet complement = new ClassicSet(xValues, characteristicFunction);
        return complement;
    }

    public ClassicSet getStandardUnion(ClassicSet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsStandardUnion(another.membershipFunction);
        ClassicSet union = new ClassicSet(unionValues, characteristicFunction);
        return union;
    }

    public ClassicSet getStandardIntersection(ClassicSet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsStandardIntersection(another.membershipFunction);
        ClassicSet intersection = new ClassicSet(unionValues, characteristicFunction);
        return intersection;
    }

    public ClassicSet getAlgebraicUnion(ClassicSet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsAlgebraicUnion(another.membershipFunction);
        ClassicSet union = new ClassicSet(unionValues, characteristicFunction);
        return union;
    }

    public ClassicSet getAlgebraicIntersection(ClassicSet another){
        MembershipFunction characteristicFunction = this.membershipFunction;
        List<Double> unionValues = new ArrayList<>(xValues);
        List<Double> uniqueValues = new ArrayList<>(another.xValues);
        uniqueValues.removeAll(xValues);
        unionValues.addAll(uniqueValues);
        characteristicFunction.setFunctionAsAlgebraicIntersection(another.membershipFunction);
        ClassicSet intersection = new ClassicSet(unionValues, characteristicFunction);
        return intersection;
    }

}