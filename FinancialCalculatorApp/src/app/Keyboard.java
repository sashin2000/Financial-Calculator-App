package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Keyboard {
    static TextField currentTxtField;

    private static Image loadImgBackSpace = new Image("images/backspace-icon.png");
    private static ImageView imgBackSpace = new ImageView(loadImgBackSpace);

    // Creating keyboard buttons
    private static Button btnOne = new Button("1");
    private static Button btnTwo = new Button("2");
    private static Button btnThree = new Button("3");
    private static Button btnFour = new Button("4");
    private static Button btnFive = new Button("5");
    private static Button btnSix = new Button("6");
    private static Button btnSeven = new Button("7");
    private static Button btnEight = new Button("8");
    private static Button btnNine = new Button("9");
    private static Button btnZero = new Button("0");
    private static Button btnMinus = new Button("-");
    private static Button btnDot = new Button(".");
    private static Button btnBackSpace = new Button("",imgBackSpace);

    public static GridPane display(){
        GridPane keyboard = new GridPane();
        keyboard.setId("keyboard");

        imgBackSpace.setFitHeight(35);
        imgBackSpace.setFitWidth(40);

        btnMinus.setId("splitBtnMinus");
        btnDot.setId("splitBtnDot");

        // Populating keys in the grid pane
        GridPane.setConstraints(btnOne,0,0,2,1);
        GridPane.setConstraints(btnTwo,2,0);
        GridPane.setConstraints(btnThree,3,0);
        GridPane.setConstraints(btnFour,0,1,2,1);
        GridPane.setConstraints(btnFive,2,1);
        GridPane.setConstraints(btnSix,3,1);
        GridPane.setConstraints(btnSeven,0,2,2,1);
        GridPane.setConstraints(btnEight,2,2);
        GridPane.setConstraints(btnNine,3,2);
        GridPane.setConstraints(btnZero,2,3);
        GridPane.setConstraints(btnMinus,0,3);
        GridPane.setConstraints(btnDot,1,3);
        GridPane.setConstraints(btnBackSpace,3,3);

        keyboard.getChildren().addAll(btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnMinus, btnDot, btnBackSpace);

        return keyboard;
    }

    public static void typeInTxtField(){

        // Setting action events to keys

        btnZero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnZero.getText());
            }
        });

        btnOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnOne.getText());
            }
        });

        btnTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnTwo.getText());
            }
        });

        btnThree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnThree.getText());
            }
        });

        btnFour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnFour.getText());
            }
        });

        btnFive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnFive.getText());
            }
        });

        btnSix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnSix.getText());
            }
        });

        btnSeven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnSeven.getText());
            }
        });

        btnEight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnEight.getText());
            }
        });

        btnNine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnNine.getText());
            }
        });

        btnDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnDot.getText());
            }
        });

        btnMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTxtField.setText(currentTxtField.getText() + btnMinus.getText());
            }
        });

        btnBackSpace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!currentTxtField.getText().equals("")){
                    int lastIndexOfString = currentTxtField.getText().length()-1;

                    StringBuilder back = new StringBuilder(currentTxtField.getText());
                    back.deleteCharAt(lastIndexOfString);

                    String finalString = back.toString();
                    currentTxtField.setText(finalString);
                }

            }
        });


    }
}
