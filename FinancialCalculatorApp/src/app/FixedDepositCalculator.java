package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FixedDepositCalculator {
    public static void display(){
        Stage calStage = new Stage();
        calStage.setTitle("Fixed Deposit Calculator");
        calStage.setMinWidth(1200);
        calStage.setMinHeight(700);
        // Creating a grid pane
        GridPane autoLoan = new GridPane();
        autoLoan.setVgap(15);
        autoLoan.setHgap(15);

        // Creating labels
        Label lblHeader = new Label("Fixed Deposit Calculator");
        lblHeader.setId("header");

        Label lblPrincipalLeft = new Label("Principal");
        Label lblPeriodLeft = new Label("Period");
        Label lblInterestRateLeft = new Label("Interest Rate");
        Label lblFutureValueLeft = new Label("Future Value");


        Label lblPrincipalRight = new Label("Principal");
        Label lblPeriodRight = new Label("Period");
        Label lblInterestRateRight = new Label("Interest Rate");
        Label lblFutureValueRight = new Label("Future Value");

        Label lblError = new Label();
        lblError.setId("lblError");

        Label lblAnswerPrincipal = new Label("\t\t");
        Label lblAnswerPeriod = new Label("\t\t");
        Label lblAnswerInterestRate = new Label("\t\t");
        Label lblAnswerFutureValue = new Label("\t\t");

        // Creating text fields
        TextField txtPrincipal = new TextField();
        txtPrincipal.setPromptText("$");

        TextField txtPeriod = new TextField();
        txtPeriod.setPromptText("In months");

        TextField txtInterestRate = new TextField();
        txtInterestRate.setPromptText("%");

        TextField txtFutureValue = new TextField();
        txtFutureValue.setPromptText("$");

        // Creating back button
        Image loadImgBack = new Image("images/back-icon.png");
        ImageView imgBack = new ImageView(loadImgBack);
        imgBack.setFitHeight(50);
        imgBack.setFitWidth(50);
        Button back = new Button("",imgBack);
        back.setId("btnBack");

        // Creating calculate button
        Button calculate = new Button("Calculate");
        calculate.setId("btnCalculate");

        // Creating history button
        Button history = new Button("history");
        history.setId("btnHistory");

        // Inserting calculate and history buttons to a VBox
        VBox btnVBox = new VBox();
        btnVBox.getChildren().addAll(calculate, history);
        btnVBox.setAlignment(Pos.CENTER);
        btnVBox.setSpacing(20);

        // Adding event handlers to buttons
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calStage.close();
            }
        });

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField[] textFields = {txtPrincipal, txtPeriod, txtInterestRate, txtFutureValue};
                double[] values = Validate.validateInputsForFixedDeposit(textFields);
                String[] strValues = new String[values.length];
                switch ((int)values[values.length-2]) {
                    case 0:
                        lblError.setText("");
                        strValues = Calculate.calculateForFixedDeposit(values);

                        String []historyKeys = {lblPrincipalRight.getText(),lblPeriodRight.getText(),lblInterestRateRight.getText(),lblFutureValueRight.getText()};
                        History.addToHistory(historyKeys, strValues, "FixedDeposit");
                        break;
                    case 1:
                        lblError.setText("Please enter only valid inputs");
                        break;
                    case 2:
                        lblError.setText("Lack of sufficient data");
                        break;
                    case 3 :
                        lblError.setText("Please enter only positive values");
                        break;
                    case 4 :
                        lblError.setText("Cannot set Down Payment as empty");
                        break;
                    case 5:
                        lblError.setText("Cannot set Interest Rate as empty");
                        break;
                    case 6:
                        lblError.setText("Keep the field empty that you want to find");

                }
                lblAnswerPrincipal.setStyle("-fx-font-size: 20px");
                lblAnswerPeriod.setStyle("-fx-font-size: 20px");
                lblAnswerInterestRate.setStyle("-fx-font-size: 20px");
                lblAnswerFutureValue.setStyle("-fx-font-size: 20px");

                lblPrincipalRight.setStyle("-fx-font-size: 20px");
                lblPeriodRight.setStyle("-fx-font-size: 20px");
                lblInterestRateRight.setStyle("-fx-font-size: 20px");
                lblFutureValueRight.setStyle("-fx-font-size: 20px");

                switch ((int)values[values.length-1]) {
                    case 0:
                        lblPrincipalRight.setStyle("-fx-font-size: 30px");
                        lblAnswerPrincipal.setStyle("-fx-font-size: 30px");
                        break;
                    case 1:
                        lblPeriodRight.setStyle("-fx-font-size: 30px");
                        lblAnswerPeriod.setStyle("-fx-font-size: 30px");
                        break;
                    case 2:
                        lblInterestRateRight.setStyle("-fx-font-size: 30px");
                        lblAnswerInterestRate.setStyle("-fx-font-size: 30px");
                        break;
                    case 3:
                        lblFutureValueRight.setStyle("-fx-font-size: 30px");
                        lblAnswerFutureValue.setStyle("-fx-font-size: 30px");
                }

                lblAnswerPrincipal.setText(strValues[0]);
                lblAnswerPeriod.setText(strValues[1]);
                lblAnswerInterestRate.setText(strValues[2]);
                lblAnswerFutureValue.setText(strValues[3]);

            }
        });

        history.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CalHistory.display("FixedDeposit");
            }
        });

        // Populating buttons to grid pane
        GridPane.setConstraints(back,0,0);
        GridPane.setConstraints(btnVBox,6,10);

        // Populating labels and text fields to grid pane
        GridPane.setConstraints(lblHeader,1,0,2,1);
        GridPane.setConstraints(lblPrincipalLeft,1,2);
        GridPane.setConstraints(lblPeriodLeft,1,3);
        GridPane.setConstraints(lblInterestRateLeft,1,4);
        GridPane.setConstraints(lblFutureValueLeft,1,5);

        GridPane.setConstraints(txtPrincipal,2,2);
        GridPane.setConstraints(txtPeriod,2,3);
        GridPane.setConstraints(txtInterestRate,2,4);
        GridPane.setConstraints(txtFutureValue,2,5);

        GridPane.setConstraints(lblPrincipalRight,6,2);
        GridPane.setConstraints(lblPeriodRight,6,3);
        GridPane.setConstraints(lblInterestRateRight,6,4);
        GridPane.setConstraints(lblFutureValueRight,6,5);

        GridPane.setConstraints(lblError,6,9,2,1);

        GridPane.setConstraints(lblAnswerPrincipal,7,2);
        GridPane.setConstraints(lblAnswerPeriod,7,3);
        GridPane.setConstraints(lblAnswerInterestRate,7,4);
        GridPane.setConstraints(lblAnswerFutureValue,7,5);

        //Adding the keyboard
        GridPane keyboard = Keyboard.display();
        GridPane.setConstraints(keyboard,1,10,3,1);

        // Adding event listeners to text fields. So when a text field is selected by the user, virtual keyboard can detect the selected field.
        txtPrincipal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.currentTxtField = txtPrincipal;
                Keyboard.typeInTxtField();
            }
        });


        txtPeriod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.currentTxtField = txtPeriod;
                Keyboard.typeInTxtField();
            }
        });

        txtInterestRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.currentTxtField = txtInterestRate;
                Keyboard.typeInTxtField();
            }
        });

        txtFutureValue.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.currentTxtField = txtFutureValue;
                Keyboard.typeInTxtField();
            }
        });

        // Adding properties to the grid pane
        autoLoan.getChildren().addAll(back, btnVBox, lblHeader, lblPrincipalLeft, lblPeriodLeft, lblInterestRateLeft, lblFutureValueLeft);
        autoLoan.getChildren().addAll(txtPrincipal, txtPeriod, txtInterestRate, txtFutureValue);
        autoLoan.getChildren().addAll(lblPrincipalRight, lblPeriodRight, lblInterestRateRight, lblFutureValueRight, lblError);
        autoLoan.getChildren().addAll(lblAnswerPrincipal, lblAnswerPeriod, lblAnswerInterestRate, lblAnswerFutureValue);
        autoLoan.getChildren().add(keyboard);

        // Setting the grid pane as scene
        Scene scene = new Scene(autoLoan, 1200, 700);
        scene.getStylesheets().add("css/calculator.css");
        calStage.setScene(scene);
        calStage.show();
    }
}
