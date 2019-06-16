import Degrees.DegreeOfTruth;
import Degrees.IDegree;
import Exceptions.IncorrectMembershipFunctionParameters;
import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TrapezoidMembershipFuncton;
import MembershipFunctions.TriangularMembershipFunction;
import Sets.ClassicSet;
import Sets.FuzzySet;
import Sets.Set;

import java.util.ArrayList;
import java.util.List;

import Data.*;
import Sets.Type2FuzzySet;
import Variables.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        try {
            MembershipFunction wysoki1 = new TriangularMembershipFunction(3, 7, 8);
            MembershipFunction wysoki2 = new TriangularMembershipFunction(2, 7, 9);
            MembershipFunction chory1 = new TriangularMembershipFunction(1.1, 2.5, 7.0);
            MembershipFunction chory2 = new TriangularMembershipFunction(1.0, 2.5, 8.0);
            MembershipFunction quant = new TriangularMembershipFunction(0.1, 0.5, 0.9);
            MembershipFunction quant2 = new TriangularMembershipFunction(0.01, 0.5, 0.99);
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

            List<Double> xValues2 = new ArrayList<Double>(){
                {
                    add(2.5);
                    add(1.5);
                    add(2.3);
                    add(4.2);
                    add(1.2);
                    add(5.5);
                    add(3.2);
                }
            };

            Type2FuzzySet s = new Type2FuzzySet(xValues, wysoki1, wysoki2);
            Type2FuzzySet s2 = new Type2FuzzySet(xValues2, chory1, chory2);
            Type2FuzzySet s3 = new Type2FuzzySet(xValues, quant, quant2);
            Type2SimpleSummarizer sum1 = new Type2SimpleSummarizer("sumaryzator prosty",
                    "wysoki", s);
            Type2SimpleSummarizer sum2 = new Type2SimpleSummarizer("sumaryzator prosty",
                    "chory", s2);

            List<Type2SimpleSummarizer> listof = new ArrayList<Type2SimpleSummarizer>(){
                {
                    add(sum1);
                    add(sum2);
                }
            };

            List<String> conj = new ArrayList<String>(){
                {
                    add("i");
                }
            };

            Type2ComplexSummarizer complexSummarizer = new Type2ComplexSummarizer("sumaryzator złożony",
                    "wysoki lub chory", listof, conj);

            Type2Quantifier quantifier = new Type2Quantifier("względny", "Około połowa", s3);
            List<IDegree> degrees = new ArrayList<IDegree>()
            {
                {
                    add(new DegreeOfTruth());
                }
            };
            Type1IntervalSummary summary = new Type1IntervalSummary(quantifier, "osób", "jest", complexSummarizer, degrees);

            System.out.println(summary.composeLinguisticSummary());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

        DatabaseConnector databaseConnector = new DatabaseConnector();
        DataReader dataReader = new DataReader(databaseConnector);
        List<Player> listofPlayers = new ArrayList<>();
        dataReader.readData(listofPlayers);

    }
}
