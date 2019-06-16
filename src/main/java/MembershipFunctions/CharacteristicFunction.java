package MembershipFunctions;

import Exceptions.IncorrectMembershipFunctionParameters;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;

@Getter
@Setter
public class CharacteristicFunction implements MembershipFunction{

    private double a;
    private double b;
    private ComplexInterface membershipFunction;
    private MembershipFunction anotherFunction;

    public CharacteristicFunction(double a, double b) throws IncorrectMembershipFunctionParameters {
        if (!(a < b))
            throw new IncorrectMembershipFunctionParameters("Złe parametry (a < b)");

        this.a = a;
        this.b = b;
        this.membershipFunction = this::countMembership;
    }

    @Override
    public ComplexInterface getFunction() {
        return membershipFunction;
    }

    @Override
    public double getWidth() {
        return b - a;
    }

    @Override
    public double getMin() {
        return a;
    }

    @Override
    public double getMax() {
        return b;
    }

    @Override
    public void setFunctionAsStandardComplement()
    {
        this.membershipFunction = this::countStandardComplementMembership;
    }

    @Override
    public double countMembership(double x){
        if(x >= a && x <= b)
            return 1;
        else
            return 0;
    }

    @Override
    public double countStandardComplementMembership(double x){
        return 1 - countMembership(x);
    }

    @Override
    public double countStandardUnionMembership(double x){
        return Math.max(countMembership(x), anotherFunction.countMembership(x));
    }

    @Override
    public void setFunctionAsStandardUnion(MembershipFunction another)
    {
        this.anotherFunction = another;
        this.membershipFunction = this::countStandardUnionMembership;
    }

    @Override
    public double countStandardIntersectionMembership(double x) {
        return Math.min(countMembership(x), anotherFunction.countMembership(x));
    }

    @Override
    public void setFunctionAsStandardIntersection(MembershipFunction another) {
        this.anotherFunction = another;
        this.membershipFunction = this::countStandardIntersectionMembership;
    }

    @Override
    public double countAlgebraicUnionMembership(double x) {
        return countMembership(x) + anotherFunction.countMembership(x) - countMembership(x) * anotherFunction.countMembership(x);
    }

    @Override
    public void setFunctionAsAlgebraicUnion(MembershipFunction another) {
        this.anotherFunction = another;
        this.membershipFunction = this::countAlgebraicUnionMembership;
    }

    @Override
    public double countAlgebraicIntersectionMembership(double x) {
        return countMembership(x) * anotherFunction.countMembership(x);
    }

    @Override
    public void setFunctionAsAlgebraicIntersection(MembershipFunction another) {
        this.anotherFunction = another;
        this.membershipFunction = this::countAlgebraicIntersectionMembership;
    }
}
