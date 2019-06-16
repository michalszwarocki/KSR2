import Exceptions.IncorrectMembershipFunctionParameters;
import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TriangularMembershipFunction;
import Sets.ClassicSet;
import Sets.FuzzySet;
import Sets.Set;

import java.util.ArrayList;
import java.util.List;

import Data.*;
import Sets.Type2FuzzySet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        try {
            MembershipFunction wysoki = new TriangularMembershipFunction(6, 7, 8);
            MembershipFunction niski = new TriangularMembershipFunction(2, 2.5, 3);
            List<Double> xValues = new ArrayList<Double>(){
                {
                    add(2.5);
                    add(3.5);
                    add(4.3);
                    add(5.2);
                    add(6.1);
                    add(7.3);
                    add(8.0);
                }
            };

            FuzzySet s = new FuzzySet(xValues, wysoki);
            FuzzySet s2 = new FuzzySet(xValues, niski);

            System.out.println(s.getMembershipDegrees());
            System.out.println(s.getStandardUnion(s2).getMembershipDegrees());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

        DatabaseConnector databaseConnector = new DatabaseConnector();
        DataReader dataReader = new DataReader(databaseConnector);
        List<Player> listofPlayers = new ArrayList<>();
        dataReader.readData(listofPlayers);

    }
}
