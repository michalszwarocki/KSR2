package MembershipFunctions;

import Exceptions.IncorrectMembershipFunctionParameters;

public class TriangularMembershipFunction implements MembershipFunction {

    private double a;
    private double b;
    private double c;

    public TriangularMembershipFunction(double a, double b, double c)
            throws IncorrectMembershipFunctionParameters {

        if (!(a < b && b < c))
            throw new IncorrectMembershipFunctionParameters("Złe parametry (a < b < c");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double countMembershipDegree(double x){

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
}