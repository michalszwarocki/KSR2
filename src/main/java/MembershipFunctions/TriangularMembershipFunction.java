package MembershipFunctions;

import Exceptions.IncorrectMembershipFunctionParameters;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TriangularMembershipFunction implements MembershipFunction {

    private double a;
    private double b;
    private double c;
    private ComplexInterface membershipFunction;
    private MembershipFunction anotherFunction;

    public TriangularMembershipFunction(double a, double b, double c)
            throws IncorrectMembershipFunctionParameters {

        if (!(a < b && b < c))
            throw new IncorrectMembershipFunctionParameters("Złe parametry (a < b < c");

        this.a = a;
        this.b = b;
        this.c = c;

        membershipFunction = this::countMembership;
    }

    @Override
    public ComplexInterface getFunction() {
        return membershipFunction;
    }

    @Override
    public double getWidth() {
        return c - a;
    }

    @Override
    public double getMin() {
        return a;
    }

    @Override
    public double getMax() {
        return c;
    }

    @Override
    public double countMembership(double x){

        if (x < a || x > c)
            return 0;
        else
        {
            if(x >= a && x <= b)
                return (x-a)/(b-a);
            else
                return (c-x)/(c-b);
        }
    }

    @Override
    public double countStandardComplementMembership(double x) {
        return 1 - countMembership(x);
    }

    @Override
    public void setFunctionAsStandardComplement() {
        this.membershipFunction = this::countStandardComplementMembership;
    }

    @Override
    public double countStandardUnionMembership(double x) {
        return Math.max(countMembership(x), anotherFunction.countMembership(x));
    }

    @Override
    public void setFunctionAsStandardUnion(MembershipFunction another) {
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