package MembershipFunctions;

import Exceptions.IncorrectMembershipFunctionParameters;

public class CharacteristicFunction {

    private double a;
    private double b;

    public CharacteristicFunction(double a, double b) throws IncorrectMembershipFunctionParameters {
        if (!(a < b))
            throw new IncorrectMembershipFunctionParameters("Złe parametry (a < b)");

        this.a = a;
        this.b = b;
    }

    public double countMembershipDegree(double x){
        if(x < a && x > b)
            return 0;
        else
            return 1;
    }
}
