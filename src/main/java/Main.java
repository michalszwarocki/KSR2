import Exceptions.IncorrectMembershipFunctionParameters;
import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TriangularMembershipFunction;
import Sets.ClassicSet;
import Sets.FuzzySet;
import Sets.Set;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        try {
            MembershipFunction m = new CharacteristicFunction(3, 5);
            MembershipFunction m2 = new CharacteristicFunction(2, 4);
            List<Double> xValues = new ArrayList<Double>(){
                {
                    add(3.5);
                    add(4.5);
                    add(7.0);
                }
            };

            List<Double> xValues2 = new ArrayList<Double>(){
                {
                    add(3.5);
                    add(4.5);
                    add(2.0);
                }
            };

            ClassicSet s = new ClassicSet(xValues, m);
            ClassicSet s2 = new ClassicSet(xValues2, m2);
            ClassicSet com = s.getStandardUnion(s2);
            System.out.println(s.getMembershipDegrees());
            System.out.println(s2.getMembershipDegrees());
            System.out.println(com.getMembershipDegrees());
            System.out.println(s.getAlgebraicUnion(s2).getMembershipDegrees());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }
    }
}
