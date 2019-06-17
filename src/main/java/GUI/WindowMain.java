package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class WindowMain extends Application {

    private Group root = new Group();
    private ListView<String> listOfLabels = new ListView<String>();
    private CheckBox age = new CheckBox();
    private CheckBox wage = new CheckBox();
    private CheckBox weight = new CheckBox();
    private CheckBox finishing = new CheckBox();
    private CheckBox dribbling = new CheckBox();
    private CheckBox crossing = new CheckBox();
    private CheckBox reactions = new CheckBox();
    private CheckBox shotPower = new CheckBox();
    private CheckBox jumping = new CheckBox();
    private CheckBox interceptions = new CheckBox();
    private Label chooseLabel = new Label();
    private Label chooseT = new Label();
    private CheckBox T1 = new CheckBox();
    private CheckBox T2 = new CheckBox();
    private CheckBox T3 = new CheckBox();
    private CheckBox T4 = new CheckBox();
    private CheckBox T5 = new CheckBox();
    private CheckBox T6 = new CheckBox();
    private CheckBox T7 = new CheckBox();
    private CheckBox T8 = new CheckBox();
    private CheckBox T9 = new CheckBox();
    private CheckBox T10 = new CheckBox();
    private CheckBox T11 = new CheckBox();
    private Label chooseMembershipLabel = new Label();
    private ChoiceBox chooseMembership = new ChoiceBox();


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

        chooseLabel();
        chooseT();
        chooseMembership();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Komputerowe systemy rozpoznawania");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void chooseMembership() {
        chooseMembership.getItems().addAll("Funkcja trójkątna", "Funkcja prostokątna");
        chooseMembership.setLayoutX(320);
        chooseMembership.setLayoutY(50);
        chooseMembershipLabel.setText("Wybierz funkcję przynależności: ");
        chooseMembershipLabel.setLayoutX(320);
        chooseMembershipLabel.setLayoutY(20);
        root.getChildren().addAll(chooseMembership, chooseMembershipLabel);
    }

    private void chooseT() {
        chooseT.setText("Wybierz miary jakości :");
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
        chooseT.setLayoutY(20);
        chooseT.setLayoutX(170);
        T1.setLayoutX(170);
        T1.setLayoutY(50);
        T2.setLayoutX(170);
        T2.setLayoutY(80);
        T3.setLayoutX(170);
        T3.setLayoutY(110);
        T4.setLayoutX(170);
        T4.setLayoutY(140);
        T5.setLayoutX(170);
        T5.setLayoutY(170);
        T6.setLayoutX(170);
        T6.setLayoutY(200);
        T7.setLayoutX(170);
        T7.setLayoutY(230);
        T8.setLayoutX(170);
        T8.setLayoutY(260);
        T9.setLayoutX(170);
        T9.setLayoutY(290);
        T10.setLayoutX(170);
        T10.setLayoutY(320);
        T11.setLayoutX(170);
        T11.setLayoutY(350);
        root.getChildren().addAll(chooseT, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11);
    }

    private void chooseLabel(){
        chooseLabel.setText("Wybierz etykiety :");
        age.setText("Wiek");
        wage.setText("Pensja");
        weight.setText("Waga");
        crossing.setText("Dośrodkowania");
        finishing.setText("Kończenie akcji");
        dribbling.setText("Drybling");
        reactions.setText("Reakcja");
        shotPower.setText("Siła strzału");
        jumping.setText("Wyskok");
        interceptions.setText("Przechwyt");
        chooseLabel.setLayoutY(20);
        chooseLabel.setLayoutX(20);
        age.setLayoutX(20);
        age.setLayoutY(50);
        wage.setLayoutX(20);
        wage.setLayoutY(80);
        weight.setLayoutX(20);
        weight.setLayoutY(110);
        crossing.setLayoutX(20);
        crossing.setLayoutY(140);
        finishing.setLayoutX(20);
        finishing.setLayoutY(170);
        dribbling.setLayoutX(20);
        dribbling.setLayoutY(200);
        reactions.setLayoutX(20);
        reactions.setLayoutY(230);
        shotPower.setLayoutX(20);
        shotPower.setLayoutY(260);
        jumping.setLayoutX(20);
        jumping.setLayoutY(290);
        interceptions.setLayoutX(20);
        interceptions.setLayoutY(320);
        root.getChildren().addAll(age, chooseLabel, wage, weight, crossing, finishing, dribbling, reactions,
                shotPower, jumping, interceptions);
    }

}
