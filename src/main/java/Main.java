import Exceptions.IncorrectMembershipFunctionParameters;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TriangularMembershipFunction;

import Data.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        try {
            MembershipFunction m = new TriangularMembershipFunction(3, 6, 8);
            System.out.println(m.countMembershipDegree(7));
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

        DatabaseConnector databaseConnector = new DatabaseConnector();
        DataReader dataReader = new DataReader(databaseConnector);
        List<Player> listofPlayers = new ArrayList<>();
        dataReader.readData(listofPlayers);
    }
}
