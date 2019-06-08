package MembershipFunctions;

import Exceptions.IncorrectMembershipFunctionParameters;

public class TrapezoidMembershipFuncton implements MembershipFunction {

    private double a;
    private double b;
    private double c;
    private double d;

    public TrapezoidMembershipFuncton(double a, double b, double c, double d)
            throws IncorrectMembershipFunctionParameters {

        if (!(a <= b && b < c && c <= d))
            throw new IncorrectMembershipFunctionParameters("Złe parametry (a <= b < c <= d");

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double countMembershipDegree(double x){

        if (x < a || x > d)
            return 0;
        else
        {
            if(x >= a && x <= b)
                if(a==b)
                    return 1;
                else
                    return (x-a)/(b-a);
            else if (x > b && x <= c)
                return 1;
            else
                if(d==c)
                    return 1;
                else
                    return (d-x)/(d-c);
        }
    }
}
