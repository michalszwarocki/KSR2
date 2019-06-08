import Exceptions.IncorrectMembershipFunctionParameters;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TriangularMembershipFunction;

public class Main {
    public static void main(String[] args)
    {
        try {
            MembershipFunction m = new TriangularMembershipFunction(3, 6, 8);
            System.out.println(m.countMembershipDegree(7));
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }
    }
}
