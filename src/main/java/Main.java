import Degrees.*;
import Exceptions.IncorrectMembershipFunctionParameters;
import GUI.WindowMain;
import LinguisticSummaries.Type1IntervalSummary;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2IntervalSummary;
import LinguisticSummaries.Type2Summary;
import MembershipFunctions.CharacteristicFunction;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TrapezoidMembershipFuncton;
import MembershipFunctions.TriangularMembershipFunction;
import Sets.ClassicSet;
import Sets.FuzzySet;
import Sets.Set;

import java.util.*;

import Data.*;
import Sets.Type2FuzzySet;
import Variables.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        /*
        try {
            Spaces spaces = new Spaces();
            MembershipFunction shotPower1 = new TriangularMembershipFunction(35, 55, 70);
            MembershipFunction crossing2 = new TriangularMembershipFunction(30, 70, 96);
            MembershipFunction age1 = new TriangularMembershipFunction(16, 17, 19);
            MembershipFunction dribbling1 = new TriangularMembershipFunction(35, 55, 70);
            MembershipFunction dribbling2 = new TriangularMembershipFunction(25, 50, 75);
            MembershipFunction quant = new TriangularMembershipFunction(0.53, 0.68, 0.83);

            FuzzySet s = new FuzzySet(spaces.getListOfCrossings(), shotPower1);
            FuzzySet s2 = new FuzzySet(spaces.getListOfDribbling(), dribbling1);
            FuzzySet s22 = new FuzzySet(spaces.getListOfDribbling(), age1);
            FuzzySet s3 = new FuzzySet(spaces.getListOfCrossings(), quant);
            SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                    "shotPower", s);
            SimpleSummarizer sum11 = new SimpleSummarizer("sumaryzator prosty",
                    "dribbling", s2);
            SimpleSummarizer sum111 = new SimpleSummarizer("sumaryzator prosty",
                    "age", s22);
            Qualifier sum2 = new Qualifier("sumaryzator prosty",
                    "umiarkowany drybling", s2);

            List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>(){
                {
                    add(sum1);
                }
            };

            List<String> conj = new ArrayList<String>(){
                {
//                    add("i");
                }
            };

            ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                    "umiarkowany strzał", listof, conj);

            Quantifier quantifier = new Quantifier("względny", "Większość", s3);
            List<IDegree> degrees = new ArrayList<IDegree>()
            {
                {
//                    add(new DegreeOfTruth());
//                    add(new DegreeOfImprecision());
//                    add(new DegreeOfCovering());
//                    add(new DegreeOfAppropriateness());
//                    add(new Length());
//                    add(new QuantificationImprecision());
//                    add(new QuantificationCardinality());
//                    add(new SummarizerCardinality());
//                    add(new QualifierImprecision());
//                    add(new QualifierCardinality());
                    add(new QualifierCount());
                }
            };
            Type2Summary summary = new Type2Summary(quantifier, "piłkarzy", sum2 ,"ma", complexSummarizer, degrees);

            Type1Summary summary1 = new Type1Summary(quantifier, "piłkarzy", "ma", complexSummarizer, degrees);

            System.out.println(summary1.composeLinguisticSummary());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

*/

//        WindowMain.main(args);



///*


        try {
            Spaces spaces = new Spaces();
            MembershipFunction crossing1 = new TriangularMembershipFunction(5, 25, 35);
            MembershipFunction crossing2 = new TriangularMembershipFunction(0, 25, 40);
            MembershipFunction age1 = new TriangularMembershipFunction(16, 17, 19);
            MembershipFunction dribbling1 = new TriangularMembershipFunction(40, 55, 65);
            MembershipFunction dribbling2 = new TriangularMembershipFunction(35, 55, 70);
            MembershipFunction quant = new TriangularMembershipFunction(0.09, 0.16, 0.26);

            Type2FuzzySet s = new Type2FuzzySet(spaces.getListOfCrossings(), crossing1, crossing2);
            Type2FuzzySet s2 = new Type2FuzzySet(spaces.getListOfDribbling(), dribbling1, dribbling2);
            FuzzySet s3 = new FuzzySet(spaces.getListOfCrossings(), quant);
            Type2SimpleSummarizer sum1 = new Type2SimpleSummarizer("sumaryzator prosty",
                    "crossing", s);
            Type2Qualifier sum2 = new Type2Qualifier("sumaryzator prosty",
                    "dribbling", s2);

            List<Type2SimpleSummarizer> listof = new ArrayList<Type2SimpleSummarizer>(){
                {
                    add(sum1);
                }
            };

            List<String> conj = new ArrayList<String>(){
                {
//                    add("i");
                }
            };

            Type2ComplexSummarizer complexSummarizer = new Type2ComplexSummarizer("sumaryzator złożony",
                    "dobry crossing i średni dribbling", listof, conj);

            Quantifier quantifier = new Quantifier("względny", "Około połowa", s3);
            List<IDegree> degrees = new ArrayList<IDegree>()
            {
                {
//                    add(new DegreeOfTruth());
//                    add(new DegreeOfImprecision());
//                    add(new DegreeOfCovering());
//                    add(new DegreeOfAppropriateness());
//                    add(new Length());
//                    add(new QuantificationImprecision());
//                    add(new QuantificationCardinality());
//                    add(new SummarizerCardinality());
//                    add(new QualifierImprecision());
//                    add(new QualifierCardinality());
                    add(new QualifierCount());
                }
            };
            Type2IntervalSummary summary = new Type2IntervalSummary(quantifier, "piłkarzy", sum2, "ma", complexSummarizer, degrees);

            System.out.println(summary.composeLinguisticSummary());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

//        */


    }
}
