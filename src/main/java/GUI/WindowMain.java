package GUI;

import Data.Spaces;
import Degrees.*;
import LinguisticSummaries.Type1Summary;
import LinguisticSummaries.Type2Summary;
import MembershipFunctions.MembershipFunction;
import MembershipFunctions.TrapezoidMembershipFuncton;
import MembershipFunctions.TriangularMembershipFunction;
import Sets.FuzzySet;
import Variables.ComplexSummarizer;
import Variables.Qualifier;
import Variables.Quantifier;
import Variables.SimpleSummarizer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class WindowMain extends Application {

    private Group root = new Group();
    private ChoiceBox quantifier;
    private TextField players;
    private RadioButton summary1Type = new RadioButton();
    private RadioButton summary2Type = new RadioButton();
    private ToggleGroup summaryGroup = new ToggleGroup();
    private RadioButton membership1 = new RadioButton();
    private RadioButton membership2 = new RadioButton();
    private ToggleGroup membershipGroup  = new ToggleGroup();
    private ChoiceBox verb;
    private ChoiceBox verb2;
    private ChoiceBox chooseLabel;
    private ChoiceBox chooseLabel2;
    private ChoiceBox chooseLabel3;
    private ChoiceBox chooseLabel4;
    private ChoiceBox chooseLabelQualifier;
    private int numberOfLabels;
    private ChoiceBox summarizer;
    private ChoiceBox summarizer2;
    private ChoiceBox summarizer3;
    private ChoiceBox summarizer4;
    private ChoiceBox summarizerQualifier;
    private Button addSummarizer;
    private ChoiceBox conjunction;
    private ChoiceBox conjunction2;
    private ChoiceBox conjunction3;
    private Label result;
    private Button calculate;
    private CheckBox T1;
    private CheckBox T2;
    private CheckBox T3;
    private CheckBox T4;
    private CheckBox T5;
    private CheckBox T6;
    private CheckBox T7;
    private CheckBox T8;
    private CheckBox T9;
    private CheckBox T10;
    private CheckBox T11;
    private TextField chooseT;
    private TextField save;
    private TextField filename;
    private Button saveButton;
    private String textResult = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
        summary1Type.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(summary1Type.isSelected()){
                    removeSummary1();
                    readSummary1();
                }
                else if(summary2Type.isSelected()){
                    removeSummary1();
                    readSummary2();
                }
            }
        });
        chooseSummaryType();
        chooseMembershipFunction();

        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setTitle("Komputerowe systemy rozpoznawania");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showResult(int x, int y){
        result = new Label();
        result.setText("Wynik wynosi : ");
        result.setLayoutX(x);
        result.setLayoutY(y);
        root.getChildren().addAll(result);
    }

    public void removeSummary1(){
        root.getChildren().removeAll(quantifier, players, verb, chooseLabel, summarizer, addSummarizer,
                chooseLabel2, chooseLabel3, chooseLabel4, summarizer2, summarizer3, summarizer4,
                conjunction, conjunction2, conjunction3, result, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,
                verb2, summarizerQualifier, chooseLabelQualifier);
    }

    public void readSummary1(){
        chooseQuantifier();
        showPlayers();
        chooseVerb(210, 80);
        chooseLabels(400, 80);
        addSummarizers(210, 50);
        showResult(540, 84);
        showCalculate();
        showT();
        showSaveFile();
        numberOfLabels = 1;
    }

    public void readSummary2(){
        chooseLabelQualifier();
        chooseLabels(760, 80);
        chooseVerb(570, 80);
        addSummarizers(570, 50);
        chooseVerb2();
        showPlayers();
        chooseQuantifier();
        showResult(900, 84);
        showCalculate();
        showT();
        showSaveFile();
        numberOfLabels = 1;
    }

    private void showSaveFile(){
        save = new TextField();
        save.setText("Zapisz wynik do pliku :");
        save.setLayoutX(620);
        save.setLayoutY(250);
        save.setEditable(false);
        filename = new TextField();
        filename.setLayoutX(620);
        filename.setLayoutY(280);
        saveButton = new Button("Zapisz");
        saveButton.setLayoutX(620);
        saveButton.setLayoutY(310);
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!filename.getText().equals("") || !filename.getText().equals(null)){
                    try{
                        FileWriter fw = new FileWriter(filename.getText());
                        fw.write(textResult);
                        fw.close();
                    }catch (Exception ex){
                        //nothing to do
                    }
                }
            }
        });
        root.getChildren().addAll(save, filename, saveButton);
    }

    private void showT() {
        chooseT = new TextField("Wybierz miary jakości :");
        T1 = new CheckBox();
        T2 = new CheckBox();
        T3 = new CheckBox();
        T4 = new CheckBox();
        T5 = new CheckBox();
        T6 = new CheckBox();
        T7 = new CheckBox();
        T8 = new CheckBox();
        T9 = new CheckBox();
        T10 = new CheckBox();
        T11 = new CheckBox();
        T1.setText("T1");
        T2.setText("T2");
        T3.setText("T3");
        T4.setText("T4");
        T5.setText("T5");
        T6.setText("T6");
        T7.setText("T7");
        T8.setText("T8");
        T9.setText("T9");
        T10.setText("T10");
        T11.setText("T11");

        chooseT.setEditable(false);
        chooseT.setLayoutX(20);
        chooseT.setLayoutY(250);
        T1.setLayoutX(20);
        T1.setLayoutY(280);
        T2.setLayoutX(70);
        T2.setLayoutY(280);
        T3.setLayoutX(120);
        T3.setLayoutY(280);
        T4.setLayoutX(170);
        T4.setLayoutY(280);
        T5.setLayoutX(220);
        T5.setLayoutY(280);
        T6.setLayoutX(270);
        T6.setLayoutY(280);
        T7.setLayoutX(320);
        T7.setLayoutY(280);
        T8.setLayoutX(370);
        T8.setLayoutY(280);
        T9.setLayoutX(420);
        T9.setLayoutY(280);
        T10.setLayoutX(470);
        T10.setLayoutY(280);
        T11.setLayoutX(520);
        T11.setLayoutY(280);

        root.getChildren().addAll(chooseT, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11);
    }

    private void showCalculate() {
        calculate = new Button();
        calculate.setText("Oblicz");
        calculate.setLayoutX(20);
        calculate.setLayoutY(310);
        root.getChildren().addAll(calculate);
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Spaces spaces = new Spaces();
                    String variableName = "";
                    if(quantifier.getValue().toString().equals("Poniżej 5000") || quantifier.getValue().toString().equals("Powyżej 5000")){
                        variableName = "absolutny";
                    }
                    else{
                        variableName = "względny";
                    }
                    List<IDegree> degrees = saveDegrees();
                    textResult = "";
                    textResult += quantifier.getValue().toString() + " " + players.getText() + " ";
                    if(summary1Type.isSelected()){
                        textResult += verb.getValue().toString() + " " + summarizer.getValue().toString() + " " +
                        chooseLabel.getValue().toString();
                        if(membership1.isSelected()){
                            MembershipFunction quant = quantifierValue();
                            if(numberOfLabels == 1){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                List<String> conj = new ArrayList<String>();
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                            else if(numberOfLabels == 2){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                            else if(numberOfLabels == 3){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValue(summarizer3, chooseLabel3);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                            else if(numberOfLabels == 4){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValues4 = listFromSpaces(chooseLabel4, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValue(summarizer3, chooseLabel3);
                                MembershipFunction summ4 = summValue(summarizer4, chooseLabel4);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                FuzzySet fs4 = new FuzzySet(xValues4, summ4);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                SimpleSummarizer sum4 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel4.getValue().toString(), fs4);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                listof.add(sum4);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                conj.add(conjunction3.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += " " + conjunction3.getValue().toString();
                                textResult += " " + summarizer4.getValue().toString() + " " + chooseLabel4.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                        }
                        else if(membership2.isSelected()){
                            MembershipFunction quant = quantifierValueTrapez();
                            if(numberOfLabels == 1){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                List<String> conj = new ArrayList<String>();
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                            }
                            else if(numberOfLabels == 2){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                            else if(numberOfLabels == 3){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValueTrapez(summarizer3, chooseLabel3);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                            else if(numberOfLabels == 4){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValues4 = listFromSpaces(chooseLabel4, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValueTrapez(summarizer3, chooseLabel3);
                                MembershipFunction summ4 = summValueTrapez(summarizer4, chooseLabel4);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                FuzzySet fs4 = new FuzzySet(xValues4, summ4);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                SimpleSummarizer sum4 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel4.getValue().toString(), fs4);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                listof.add(sum4);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                conj.add(conjunction3.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type1Summary summary1 = new Type1Summary(quantifierResult, players.getText(), verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary1.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += " " + conjunction3.getValue().toString();
                                textResult += " " + summarizer4.getValue().toString() + " " + chooseLabel4.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary1.getFinalDegree();
                            }
                        }
                    }
                    else if(summary2Type.isSelected()){
                        textResult += verb2.getValue().toString() + " " + summarizerQualifier.getValue().toString() + " " + chooseLabelQualifier.getValue().toString() + " " +
                    verb.getValue().toString() + " " + summarizer.getValue().toString() + " " +
                                chooseLabel.getValue().toString();
                        if(membership1.isSelected()){
                            MembershipFunction quant = quantifierValue();
                            if(numberOfLabels == 1){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summQuali = summValue(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                List<String> conj = new ArrayList<String>();
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                            }
                            else if(numberOfLabels == 2){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                MembershipFunction summQuali = summValue(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                            else if(numberOfLabels == 3){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValue(summarizer3, chooseLabel3);
                                MembershipFunction summQuali = summValue(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                            else if(numberOfLabels == 4){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValues4 = listFromSpaces(chooseLabel4, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValue(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValue(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValue(summarizer3, chooseLabel3);
                                MembershipFunction summ4 = summValue(summarizer4, chooseLabel4);
                                MembershipFunction summQuali = summValue(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                FuzzySet fs4 = new FuzzySet(xValues4, summ4);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                SimpleSummarizer sum4 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel4.getValue().toString(), fs4);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                listof.add(sum4);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                conj.add(conjunction3.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += " " + conjunction3.getValue().toString();
                                textResult += " " + summarizer4.getValue().toString() + " " + chooseLabel4.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                        }
                        else if(membership2.isSelected()){
                            MembershipFunction quant = quantifierValueTrapez();
                            if(numberOfLabels == 1){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summQuali = summValueTrapez(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                List<String> conj = new ArrayList<String>();
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                            }
                            else if(numberOfLabels == 2){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                MembershipFunction summQuali = summValueTrapez(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                            else if(numberOfLabels == 3){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValueTrapez(summarizer3, chooseLabel3);
                                MembershipFunction summQuali = summValueTrapez(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                            else if(numberOfLabels == 4){
                                List<Double> xValues1 = listFromSpaces(chooseLabel, spaces);
                                List<Double> xValues2 = listFromSpaces(chooseLabel2, spaces);
                                List<Double> xValues3 = listFromSpaces(chooseLabel3, spaces);
                                List<Double> xValues4 = listFromSpaces(chooseLabel4, spaces);
                                List<Double> xValuesQuali = listFromSpaces(chooseLabelQualifier, spaces);
                                MembershipFunction summ = summValueTrapez(summarizer, chooseLabel);
                                MembershipFunction summ2 = summValueTrapez(summarizer2, chooseLabel2);
                                MembershipFunction summ3 = summValueTrapez(summarizer3, chooseLabel3);
                                MembershipFunction summ4 = summValueTrapez(summarizer4, chooseLabel4);
                                MembershipFunction summQuali = summValueTrapez(summarizerQualifier, chooseLabelQualifier);
                                FuzzySet fsQuali = new FuzzySet(xValuesQuali, summQuali);
                                Qualifier qualifi = new Qualifier("sumaryzator prosty", chooseLabelQualifier.getValue().toString()
                                        , fsQuali);
                                FuzzySet fs = new FuzzySet(xValues1, summ);
                                FuzzySet fs2 = new FuzzySet(xValues2, summ2);
                                FuzzySet fs3 = new FuzzySet(xValues3, summ3);
                                FuzzySet fs4 = new FuzzySet(xValues4, summ4);
                                SimpleSummarizer sum1 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel.getValue().toString(), fs);
                                SimpleSummarizer sum2 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel2.getValue().toString(), fs2);
                                SimpleSummarizer sum3 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel3.getValue().toString(), fs3);
                                SimpleSummarizer sum4 = new SimpleSummarizer("sumaryzator prosty",
                                        chooseLabel4.getValue().toString(), fs4);
                                List<SimpleSummarizer> listof = new ArrayList<SimpleSummarizer>();
                                listof.add(sum1);
                                listof.add(sum2);
                                listof.add(sum3);
                                listof.add(sum4);
                                List<String> conj = new ArrayList<String>();
                                conj.add(conjunction.getValue().toString());
                                conj.add(conjunction2.getValue().toString());
                                conj.add(conjunction3.getValue().toString());
                                ComplexSummarizer complexSummarizer = new ComplexSummarizer("sumaryzator złożony",
                                        "example", listof, conj);
                                FuzzySet fsq = new FuzzySet(xValues1, quant);
                                Quantifier quantifierResult = new Quantifier(variableName, quantifier.getValue().toString(), fsq);
                                Type2Summary summary2 = new Type2Summary(quantifierResult, players.getText(), qualifi, verb.getValue().toString(), complexSummarizer, degrees);
                                result.setText("Wynik wynosi : " + summary2.getFinalDegree());
                                textResult += " " + conjunction.getValue().toString();
                                textResult += " " + summarizer2.getValue().toString() + " " + chooseLabel2.getValue().toString();
                                textResult += " " + conjunction2.getValue().toString();
                                textResult += " " + summarizer3.getValue().toString() + " " + chooseLabel3.getValue().toString();
                                textResult += " " + conjunction3.getValue().toString();
                                textResult += " " + summarizer4.getValue().toString() + " " + chooseLabel4.getValue().toString();
                                textResult += ". Wynik wynosi : " + summary2.getFinalDegree();
                            }
                        }
                    }
                }catch (Exception e){
                    //nothing to do
                }
            }
        });
    }

    private List<IDegree> saveDegrees(){
        List<IDegree> list = new ArrayList<>();
        if(T1.isSelected()){
            list.add(new DegreeOfTruth());
        }
        else if(T2.isSelected()){
            list.add(new DegreeOfImprecision());
        }
        else if(T3.isSelected()){
            list.add(new DegreeOfCovering());
        }
        else if(T4.isSelected()){
            list.add(new DegreeOfAppropriateness());
        }
        else if(T5.isSelected()){
            list.add(new Length());
        }
        else if(T6.isSelected()){
            list.add(new QuantificationImprecision());
        }
        else if(T7.isSelected()){
            list.add(new QuantificationCardinality());
        }
        else if(T8.isSelected()){
            list.add(new SummarizerCardinality());
        }
        else if(T9.isSelected()){
            list.add(new QualifierImprecision());
        }
        else if(T10.isSelected()){
            list.add(new QualifierCardinality());
        }
        else if(T11.isSelected()){
            list.add(new QualifierCount());
        }

        return list;
    }

    private List<Double> listFromSpaces(ChoiceBox label, Spaces spaces){
        List<Double> list = new ArrayList<>();

        if(label.getValue().toString().equals("wiek")){
            list = spaces.getListOfAges();
        }
        else if(label.getValue().toString().equals("zarobki")){
            list = spaces.getListOfWages();
        }
        else if(label.getValue().toString().equals("wagę")){
            list = spaces.getListOfWeights();
        }
        else if(label.getValue().toString().equals("dośrodkowania")){
            list = spaces.getListOfCrossings();
        }
        else if(label.getValue().toString().equals("finalizowanie akcji")){
            list = spaces.getListOfFinishing();
        }
        else if(label.getValue().toString().equals("drybling")){
            list = spaces.getListOfDribbling();
        }
        else if(label.getValue().toString().equals("reakcję")){
            list = spaces.getListOfReactions();
        }
        else if(label.getValue().toString().equals("strzał")){
            list = spaces.getListOfShotPowers();
        }
        else if(label.getValue().toString().equals("wyskok")){
            list = spaces.getListOfJumpings();
        }
        else if(label.getValue().toString().equals("przechwyt")){
            list = spaces.getListOfInterceptions();
        }

        return list;
    }

    private MembershipFunction summValue(ChoiceBox summarizer, ChoiceBox label) throws Exception{
        MembershipFunction summ = null;

        if(label.getValue().toString().equals("wiek")){
            if(summarizer.getValue().toString().equals("perspektywiczny")){
                summ = new TriangularMembershipFunction(16,17,19);
            }
            else if(summarizer.getValue().toString().equals("młody")){
                summ = new TriangularMembershipFunction(18,20,22);
            }
            else if(summarizer.getValue().toString().equals("dorosły")){
                summ = new TriangularMembershipFunction(21,26,31);
            }
            else if(summarizer.getValue().toString().equals("doświadczony")){
                summ = new TriangularMembershipFunction(29,35,43);
            }
        }
        else if(label.getValue().toString().equals("zarobki")){
            if(summarizer.getValue().toString().equals("niskie")){
                summ = new TriangularMembershipFunction(0,5,10);
            }
            else if(summarizer.getValue().toString().equals("średnie")){
                summ = new TriangularMembershipFunction(8,23,50);
            }
            else if(summarizer.getValue().toString().equals("wysokie")){
                summ = new TriangularMembershipFunction(45,130,250);
            }
            else if(summarizer.getValue().toString().equals("bardzo wysokie")){
                summ = new TriangularMembershipFunction(220,450,580);
            }
        }
        else if(label.getValue().toString().equals("wagę")){
            if(summarizer.getValue().toString().equals("lekką")){
                summ = new TriangularMembershipFunction(100,130,150);
            }
            else if(summarizer.getValue().toString().equals("średnią")){
                summ = new TriangularMembershipFunction(140,170,200);
            }
            else if(summarizer.getValue().toString().equals("ciężką")){
                summ = new TriangularMembershipFunction(185, 220, 250);
            }
        }
        else if(label.getValue().toString().equals("dośrodkowania") || label.getValue().toString().equals("finalizowanie akcji")
        || label.getValue().toString().equals("drybling") || label.getValue().toString().equals("reakcję")
        || label.getValue().toString().equals("strzał") || label.getValue().toString().equals("wyskok")
        || label.getValue().toString().equals("przechwyt")){
            if(summarizer.getValue().toString().equals("słabe") || summarizer.getValue().toString().equals("słaby")
            || summarizer.getValue().toString().equals("słabą")){
                summ = new TriangularMembershipFunction(0, 25, 40);
            }
            else if(summarizer.getValue().toString().equals("umiarkowane") || summarizer.getValue().toString().equals("umiarkowany")
                    || summarizer.getValue().toString().equals("umiarkowaną")){
                summ = new TriangularMembershipFunction(35,55,70);
            }
            else if(summarizer.getValue().toString().equals("dobre") || summarizer.getValue().toString().equals("dobry")
                    || summarizer.getValue().toString().equals("dobrą")){
                summ = new TriangularMembershipFunction(65,80,100);
            }
        }

        return summ;
    }

    private MembershipFunction summValueTrapez(ChoiceBox summarizer, ChoiceBox label) throws Exception{
        MembershipFunction summ = null;

        if(label.getValue().toString().equals("wiek")){
            if(summarizer.getValue().toString().equals("perspektywiczny")){
                summ = new TrapezoidMembershipFuncton(16, 17, 18, 19);
            }
            else if(summarizer.getValue().toString().equals("młody")){
                summ = new TrapezoidMembershipFuncton(18,19,21,22);
            }
            else if(summarizer.getValue().toString().equals("dorosły")){
                summ = new TrapezoidMembershipFuncton(21,24,28,31);
            }
            else if(summarizer.getValue().toString().equals("doświadczony")){
                summ = new TrapezoidMembershipFuncton(29,32,37,43);
            }
        }
        else if(label.getValue().toString().equals("zarobki")){
            if(summarizer.getValue().toString().equals("niskie")){
                summ = new TrapezoidMembershipFuncton(0,2,7,10);
            }
            else if(summarizer.getValue().toString().equals("średnie")){
                summ = new TrapezoidMembershipFuncton(8,20,40,50);
            }
            else if(summarizer.getValue().toString().equals("wysokie")){
                summ = new TrapezoidMembershipFuncton(45,90,170,250);
            }
            else if(summarizer.getValue().toString().equals("bardzo wysokie")){
                summ = new TrapezoidMembershipFuncton(220,320,450, 580);
            }
        }
        else if(label.getValue().toString().equals("wagę")){
            if(summarizer.getValue().toString().equals("lekką")){
                summ = new TrapezoidMembershipFuncton(100,115,130,150);
            }
            else if(summarizer.getValue().toString().equals("średnią")){
                summ = new TrapezoidMembershipFuncton(140,160, 175, 200);
            }
            else if(summarizer.getValue().toString().equals("ciężką")){
                summ = new TrapezoidMembershipFuncton(185, 205, 220, 250);
            }
        }
        else if(label.getValue().toString().equals("dośrodkowania") || label.getValue().toString().equals("finalizowanie akcji")
                || label.getValue().toString().equals("drybling") || label.getValue().toString().equals("reakcję")
                || label.getValue().toString().equals("strzał") || label.getValue().toString().equals("wyskok")
                || label.getValue().toString().equals("przechwyt")){
            if(summarizer.getValue().toString().equals("słabe") || summarizer.getValue().toString().equals("słaby")
                    || summarizer.getValue().toString().equals("słabą")){
                summ = new TrapezoidMembershipFuncton(0,18,30, 40);
            }
            else if(summarizer.getValue().toString().equals("umiarkowane") || summarizer.getValue().toString().equals("umiarkowany")
                    || summarizer.getValue().toString().equals("umiarkowaną")){
                summ = new TrapezoidMembershipFuncton(35, 47, 59, 70);
            }
            else if(summarizer.getValue().toString().equals("dobre") || summarizer.getValue().toString().equals("dobry")
                    || summarizer.getValue().toString().equals("dobrą")){
                summ = new TrapezoidMembershipFuncton(65, 74, 89, 100);
            }
        }

        return summ;
    }

    private MembershipFunction quantifierValue() throws Exception{
        MembershipFunction quant = null;
        if(quantifier.getValue().toString().equals("Prawie żaden z")){
            quant = new TriangularMembershipFunction(0.0, 0.04, 0.08);
        }
        else if(quantifier.getValue().toString().equals("Niewiele")){
            quant = new TriangularMembershipFunction(0.09, 0.16, 0.26);
        }
        else if(quantifier.getValue().toString().equals("Prawie połowa")){
            quant = new TriangularMembershipFunction(0.24, 0.42, 0.49);
        }
        else if(quantifier.getValue().toString().equals("Około połowa")){
            quant = new TriangularMembershipFunction(0.47, 0.50, 0.54);
        }
        else if(quantifier.getValue().toString().equals("Większość")){
            quant = new TriangularMembershipFunction(0.53, 0.68, 0.83);
        }
        else if(quantifier.getValue().toString().equals("Prawie każdy z")){
            quant = new TriangularMembershipFunction(0.80, 0.92, 1.0);
        }
        else if(quantifier.getValue().toString().equals("Poniżej 5000")){
            quant = new TriangularMembershipFunction(0, 3000, 5000);
        }
        else if(quantifier.getValue().toString().equals("Powyżej 5000")){
            quant = new TriangularMembershipFunction(5000, 10000, 20000);
        }
        return quant;
    }

    private MembershipFunction quantifierValueTrapez() throws Exception{
        MembershipFunction quant = null;
        if(quantifier.getValue().toString().equals("Prawie żaden z")){
            quant = new TrapezoidMembershipFuncton(0, 0.02, 0.05, 0.08);
        }
        else if(quantifier.getValue().toString().equals("Niewiele")){
            quant = new TrapezoidMembershipFuncton(0.09, 0.15, 0.20, 0.26);
        }
        else if(quantifier.getValue().toString().equals("Prawie połowa")){
            quant = new TrapezoidMembershipFuncton(0.24, 0.35, 0.4, 0.49);
        }
        else if(quantifier.getValue().toString().equals("Około połowa")){
            quant = new TrapezoidMembershipFuncton(0.47, 0.49, 0.51, 0.54);
        }
        else if(quantifier.getValue().toString().equals("Większość")){
            quant = new TrapezoidMembershipFuncton(0.53, 0.6, 0.72, 0.83);
        }
        else if(quantifier.getValue().toString().equals("Prawie każdy z")){
            quant = new TrapezoidMembershipFuncton(0.8, 0.85, 0.92, 1.0);
        }
        else if(quantifier.getValue().toString().equals("Poniżej 5000")){
            quant = new TrapezoidMembershipFuncton(0, 3000, 4000, 5000);
        }
        else if(quantifier.getValue().toString().equals("Powyżej 5000")){
            quant = new TrapezoidMembershipFuncton(5000, 6000, 8000, 20000);
        }
        return quant;
    }

    private void addSummarizers(int x, int y) {
        addSummarizer = new Button();
        addSummarizer.setText("Dodaj sumaryzator");
        addSummarizer.setLayoutX(x);
        addSummarizer.setLayoutY(y);
        root.getChildren().addAll(addSummarizer);
        addSummarizer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(numberOfLabels == 1){
                    ++numberOfLabels;
                    chooseLabels2(x+190, y+60);
                    chooseConjunction1(x, y+60);
                }
                else if(numberOfLabels == 2){
                    ++numberOfLabels;
                    chooseLabels3(x+190, y+90);
                    chooseConjunction2(x, y+90);
                }
                else if(numberOfLabels == 3){
                    ++numberOfLabels;
                    chooseLabels4(x+190, y+120);
                    chooseConjunction3(x, y+120);
                }
            }
        });
    }

    private void chooseConjunction1(int x, int y){
        conjunction = new ChoiceBox();
        conjunction.getItems().addAll("i", "lub");
        conjunction.setLayoutX(x);
        conjunction.setLayoutY(y);
        root.getChildren().addAll(conjunction);
    }

    private void chooseConjunction2(int x, int y){
        conjunction2 = new ChoiceBox();
        conjunction2.getItems().addAll("i", "lub");
        conjunction2.setLayoutX(x);
        conjunction2.setLayoutY(y);
        root.getChildren().addAll(conjunction2);
    }

    private void chooseConjunction3(int x, int y){
        conjunction3 = new ChoiceBox();
        conjunction3.getItems().addAll("i", "lub");
        conjunction3.setLayoutX(x);
        conjunction3.setLayoutY(y);
        root.getChildren().addAll(conjunction3);
    }

    private void chooseLabels(int x, int y) {
        chooseLabel = new ChoiceBox();
        chooseLabel.getItems().addAll("wiek", "zarobki", "wagę", "dośrodkowania", "finalizowanie akcji", "drybling",
                "reakcję", "strzał", "wyskok", "przechwyt");
        chooseLabel.setLayoutX(x);
        chooseLabel.setLayoutY(y);
        root.getChildren().addAll(chooseLabel);
        chooseLabel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                root.getChildren().removeAll(summarizer);
                readSummarizer(chooseLabel.getValue().toString(), x -130, y);
            }
        });
    }

    private void chooseLabelQualifier() {
        chooseLabelQualifier = new ChoiceBox();
        chooseLabelQualifier.getItems().addAll("wiek", "zarobki", "wagę", "dośrodkowania", "finalizowanie akcji", "drybling",
                "reakcję", "strzał", "wyskok", "przechwyt");
        chooseLabelQualifier.setLayoutX(430);
        chooseLabelQualifier.setLayoutY(80);
        root.getChildren().addAll(chooseLabelQualifier);
        chooseLabelQualifier.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                root.getChildren().removeAll(summarizerQualifier);
                readSummarizerQualifier(chooseLabelQualifier.getValue().toString());
            }
        });
    }

    private void chooseLabels2(int x, int y) {
        chooseLabel2 = new ChoiceBox();
        chooseLabel2.getItems().addAll("wiek", "zarobki", "wagę", "dośrodkowania", "finalizowanie akcji", "drybling",
                "reakcję", "strzał", "wyskok", "przechwyt");
        chooseLabel2.setLayoutX(x);
        chooseLabel2.setLayoutY(y);
        root.getChildren().addAll(chooseLabel2);
        chooseLabel2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                root.getChildren().removeAll(summarizer2);
                readSummarizer2(chooseLabel2.getValue().toString(), x - 130, y);
            }
        });
    }

    private void chooseLabels3(int x, int y) {
        chooseLabel3 = new ChoiceBox();
        chooseLabel3.getItems().addAll("wiek", "zarobki", "wagę", "dośrodkowania", "finalizowanie akcji", "drybling",
                "reakcję", "strzał", "wyskok", "przechwyt");
        chooseLabel3.setLayoutX(x);
        chooseLabel3.setLayoutY(y);
        root.getChildren().addAll(chooseLabel3);
        chooseLabel3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                root.getChildren().removeAll(summarizer3);
                readSummarizer3(chooseLabel3.getValue().toString(), x-130, y);
            }
        });
    }

    private void chooseLabels4(int x, int y) {
        chooseLabel4 = new ChoiceBox();
        chooseLabel4.getItems().addAll("wiek", "zarobki", "wagę", "dośrodkowania", "finalizowanie akcji", "drybling",
                "reakcję", "strzał", "wyskok", "przechwyt");
        chooseLabel4.setLayoutX(x);
        chooseLabel4.setLayoutY(y);
        root.getChildren().addAll(chooseLabel4);
        chooseLabel4.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                root.getChildren().removeAll(summarizer4);
                readSummarizer4(chooseLabel4.getValue().toString(), x - 130, y);
            }
        });
    }

    public void readSummarizer(String label, int x, int y){
        summarizer = new ChoiceBox();
        if (label.equals("wiek")) {
            summarizer.getItems().addAll("perspektywiczny", "młody", "dorosły", "doświadczony");
        }
        else if(label.equals("zarobki")){
            summarizer.getItems().addAll("niskie", "średnie", "wysokie", "bardzo wysokie");
        }
        else if(label.equals("wagę")){
            summarizer.getItems().addAll("lekką", "średnią", "ciężką");
        }
        else if(label.equals("dośrodkowania") || label.equals("finalizowanie akcji")){
            summarizer.getItems().addAll("słabe", "umiarkowane", "dobre");
        }
        else if(label.equals("drybling") || label.equals("strzał") || label.equals("wyskok") || label.equals("przechwyt")){
            summarizer.getItems().addAll("słaby", "umiarkowany", "dobry");
        }
        else if(label.equals("reakcję")){
            summarizer.getItems().addAll("słabą", "umiarkowaną", "dobrą");
        }
        summarizer.setLayoutX(x);
        summarizer.setLayoutY(y);
        root.getChildren().addAll(summarizer);
    }

    public void readSummarizer2(String label, int x, int y){
        summarizer2 = new ChoiceBox();
        if (label.equals("wiek")) {
            summarizer2.getItems().addAll("perspektywiczny", "młody", "dorosły", "doświadczony");
        }
        else if(label.equals("zarobki")){
            summarizer2.getItems().addAll("niskie", "średnie", "wysokie", "bardzo wysokie");
        }
        else if(label.equals("wagę")){
            summarizer2.getItems().addAll("lekką", "średnią", "ciężką");
        }
        else if(label.equals("dośrodkowania") || label.equals("finalizowanie akcji")){
            summarizer2.getItems().addAll("słabe", "umiarkowane", "dobre");
        }
        else if(label.equals("drybling") || label.equals("strzał") || label.equals("wyskok") || label.equals("przechwyt")){
            summarizer2.getItems().addAll("słaby", "umiarkowany", "dobry");
        }
        else if(label.equals("reakcję")){
            summarizer2.getItems().addAll("słabą", "umiarkowaną", "dobrą");
        }
        summarizer2.setLayoutX(x);
        summarizer2.setLayoutY(y);
        root.getChildren().addAll(summarizer2);
    }

    public void readSummarizer3(String label, int x, int y){
        summarizer3 = new ChoiceBox();
        if (label.equals("wiek")) {
            summarizer3.getItems().addAll("perspektywiczny", "młody", "dorosły", "doświadczony");
        }
        else if(label.equals("zarobki")){
            summarizer3.getItems().addAll("niskie", "średnie", "wysokie", "bardzo wysokie");
        }
        else if(label.equals("wagę")){
            summarizer3.getItems().addAll("lekką", "średnią", "ciężką");
        }
        else if(label.equals("dośrodkowania") || label.equals("finalizowanie akcji")){
            summarizer3.getItems().addAll("słabe", "umiarkowane", "dobre");
        }
        else if(label.equals("drybling") || label.equals("strzał") || label.equals("wyskok") || label.equals("przechwyt")){
            summarizer3.getItems().addAll("słaby", "umiarkowany", "dobry");
        }
        else if(label.equals("reakcję")){
            summarizer3.getItems().addAll("słabą", "umiarkowaną", "dobrą");
        }
        summarizer3.setLayoutX(x);
        summarizer3.setLayoutY(y);
        root.getChildren().addAll(summarizer3);
    }

    public void readSummarizer4(String label, int x, int y){
        summarizer4 = new ChoiceBox();
        if (label.equals("wiek")) {
            summarizer4.getItems().addAll("perspektywiczny", "młody", "dorosły", "doświadczony");
        }
        else if(label.equals("zarobki")){
            summarizer4.getItems().addAll("niskie", "średnie", "wysokie", "bardzo wysokie");
        }
        else if(label.equals("wagę")){
            summarizer4.getItems().addAll("lekką", "średnią", "ciężką");
        }
        else if(label.equals("dośrodkowania") || label.equals("finalizowanie akcji")){
            summarizer4.getItems().addAll("słabe", "umiarkowane", "dobre");
        }
        else if(label.equals("drybling") || label.equals("strzał") || label.equals("wyskok") || label.equals("przechwyt")){
            summarizer4.getItems().addAll("słaby", "umiarkowany", "dobry");
        }
        else if(label.equals("reakcję")){
            summarizer4.getItems().addAll("słabą", "umiarkowaną", "dobrą");
        }
        summarizer4.setLayoutX(x);
        summarizer4.setLayoutY(y);
        root.getChildren().addAll(summarizer4);
    }

    public void readSummarizerQualifier(String label){
        summarizerQualifier = new ChoiceBox();
        if (label.equals("wiek")) {
            summarizerQualifier.getItems().addAll("perspektywiczny", "młody", "dorosły", "doświadczony");
        }
        else if(label.equals("zarobki")){
            summarizerQualifier.getItems().addAll("niskie", "średnie", "wysokie", "bardzo wysokie");
        }
        else if(label.equals("wagę")){
            summarizerQualifier.getItems().addAll("lekką", "średnią", "ciężką");
        }
        else if(label.equals("dośrodkowania") || label.equals("finalizowanie akcji")){
            summarizerQualifier.getItems().addAll("słabe", "umiarkowane", "dobre");
        }
        else if(label.equals("drybling") || label.equals("strzał") || label.equals("wyskok") || label.equals("przechwyt")){
            summarizerQualifier.getItems().addAll("słaby", "umiarkowany", "dobry");
        }
        else if(label.equals("reakcję")){
            summarizerQualifier.getItems().addAll("słabą", "umiarkowaną", "dobrą");
        }
        summarizerQualifier.setLayoutX(300);
        summarizerQualifier.setLayoutY(80);
        root.getChildren().addAll(summarizerQualifier);
    }

    private void chooseVerb(int x, int y) {
        verb = new ChoiceBox();
        verb.getItems().addAll("ma", "jest");
        verb.setLayoutX(x);
        verb.setLayoutY(y);
        root.getChildren().addAll(verb);
    }

    private void chooseVerb2() {
        verb2 = new ChoiceBox();
        verb2.getItems().addAll("mających", "będących");
        verb2.setLayoutX(210);
        verb2.setLayoutY(80);
        root.getChildren().addAll(verb2);
    }

    private void chooseSummaryType() {
        summary1Type.setText("Podsumowanie 1 typu");
        summary2Type.setText("Podsumowanie 2 typu");
        summary1Type.setToggleGroup(summaryGroup);
        summary2Type.setToggleGroup(summaryGroup);
        summary1Type.setLayoutX(20);
        summary1Type.setLayoutY(20);
        summary2Type.setLayoutX(170);
        summary2Type.setLayoutY(20);
        root.getChildren().addAll(summary1Type, summary2Type);
    }

    private void chooseMembershipFunction(){
        membership1.setText("Funkcje przynależności trójkątna");
        membership2.setText("Funkcje przynależności trapezoidalna");
        membership1.setToggleGroup(membershipGroup);
        membership2.setToggleGroup(membershipGroup);
        membership1.setLayoutX(320);
        membership1.setLayoutY(20);
        membership2.setLayoutX(520);
        membership2.setLayoutY(20);
        root.getChildren().addAll(membership1, membership2);
    }

    private void showPlayers() {
        players = new TextField();
        players.setEditable(false);
        players.setText("piłkarzy");
        players.setLayoutX(140);
        players.setLayoutY(80);
        players.setMaxWidth(60);
        root.getChildren().addAll(players);
    }

    private void chooseQuantifier() {
        quantifier = new ChoiceBox();
        quantifier.getItems().addAll("Prawie żaden z", "Niewiele", "Prawie połowa", "Około połowa",
                "Większość", "Prawie każdy z", "Poniżej 5000", "Powyżej 5000");
        quantifier.setLayoutX(20);
        quantifier.setLayoutY(80);
        root.getChildren().addAll(quantifier);
    }
}
