package MembershipFunctions;

import java.util.function.Function;

public interface MembershipFunction {
    ComplexInterface getFunction();

    double countMembership(double x);

    double countStandardComplementMembership(double x);

    void setFunctionAsStandardComplement();

    double countStandardUnionMembership(double x);

    void setFunctionAsStandardUnion(MembershipFunction another);

    double countStandardIntersectionMembership(double x);

    void setFunctionAsStandardIntersection(MembershipFunction another);

    double countAlgebraicUnionMembership(double x);

    void setFunctionAsAlgebraicUnion(MembershipFunction another);

    double countAlgebraicIntersectionMembership(double x);

    void setFunctionAsAlgebraicIntersection(MembershipFunction another);
}