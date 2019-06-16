import Degrees.*;
import Exceptions.IncorrectMembershipFunctionParameters;
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
        try {
            Spaces spaces = new Spaces();
            MembershipFunction crossing1 = new TriangularMembershipFunction(40, 70, 90);
            MembershipFunction crossing2 = new TriangularMembershipFunction(30, 70, 96);
            MembershipFunction dribbling1 = new TriangularMembershipFunction(40, 50, 60);
            MembershipFunction dribbling2 = new TriangularMembershipFunction(25, 50, 75);
            MembershipFunction quant = new TriangularMembershipFunction(0.2, 0.5, 0.8);
            MembershipFunction quant2 = new TriangularMembershipFunction(0.2, 0.5, 0.8);

            FuzzySet s = new FuzzySet(spaces.getListOfCrossings(), crossing1);
            FuzzySet s2 = new FuzzySet(spaces.getListOfDribbling(), dribbling1);
            FuzzySet s3 = new FuzzySet(spaces.getListOfCrossings(), quant);
            SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                    "crossing", s);
            Qualifier sum2 = new Qualifier("sumaryzator prosty",
                    "dribbling", s2);

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
                    "dobry crossing i średni dribbling", listof, conj);

            Quantifier quantifier = new Quantifier("względny", "Około połowa", s3);
            List<IDegree> degrees = new ArrayList<IDegree>()
            {
                {
                    add(new DegreeOfAppropriateness());
                }
            };
            Type2Summary summary = new Type2Summary(quantifier, "piłkarzy", sum2 ,"ma", complexSummarizer, degrees);

            System.out.println(summary.composeLinguisticSummary());
        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
            incorrectMembershipFunctionParameters.printStackTrace();
        }

//        try {
//            Spaces spaces = new Spaces();
//            MembershipFunction crossing1 = new TriangularMembershipFunction(40, 70, 90);
//            MembershipFunction crossing2 = new TriangularMembershipFunction(30, 70, 96);
//            MembershipFunction dribbling1 = new TriangularMembershipFunction(40, 50, 60);
//            MembershipFunction dribbling2 = new TriangularMembershipFunction(25, 50, 75);
//            MembershipFunction quant = new TriangularMembershipFunction(0.2, 0.5, 0.8);
//            MembershipFunction quant2 = new TriangularMembershipFunction(0.15, 0.5, 0.85);
//
//            Type2FuzzySet s = new Type2FuzzySet(spaces.getListOfCrossings(), crossing1, crossing2);
//            Type2FuzzySet s2 = new Type2FuzzySet(spaces.getListOfDribbling(), dribbling1, dribbling2);
//            FuzzySet s3 = new FuzzySet(spaces.getListOfCrossings(), quant);
//            Type2SimpleSummarizer sum1 = new Type2SimpleSummarizer("sumaryzator prosty",
//                    "crossing", s);
//            Type2Qualifier sum2 = new Type2Qualifier("sumaryzator prosty",
//                    "dribbling", s2);
//
//            List<Type2SimpleSummarizer> listof = new ArrayList<Type2SimpleSummarizer>(){
//                {
//                    add(sum1);
//                }
//            };
//
//            List<String> conj = new ArrayList<String>(){
//                {
////                    add("i");
//                }
//            };
//
//            Type2ComplexSummarizer complexSummarizer = new Type2ComplexSummarizer("sumaryzator złożony",
//                    "dobry crossing i średni dribbling", listof, conj);
//
//            Quantifier quantifier = new Quantifier("względny", "Około połowa", s3);
//            List<IDegree> degrees = new ArrayList<IDegree>()
//            {
//                {
//                    add(new DegreeOfAppropriateness());
//                }
//            };
//            Type1IntervalSummary summary = new Type1IntervalSummary(quantifier, "piłkarzy", "ma", complexSummarizer, degrees);
//
//            System.out.println(summary.composeLinguisticSummary());
//        } catch (IncorrectMembershipFunctionParameters incorrectMembershipFunctionParameters) {
//            incorrectMembershipFunctionParameters.printStackTrace();
//        }
    }
}
