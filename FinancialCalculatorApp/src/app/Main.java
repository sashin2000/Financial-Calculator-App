package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Financial Calculator");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(820);

        Label header = new Label();
        header.setText("Financial Calculator");

        Button fixedDeposit = new Button();
        fixedDeposit.setText("Fixed Deposit");

        Button savings = new Button();
        savings.setText("Savings");

        Button loan = new Button();
        loan.setText("Loan");

        Button mortgage = new Button();
        mortgage.setText("Mortgage");

        Button help = new Button();
        help.setText("Help");

        Button exit = new Button();
        exit.setText("Exit");

        // Load the image
        Image mainPageImage = new Image("/images/main_page_image.png");
        
        // Adding the loaded image to ImageView
        ImageView imgMain = new ImageView();
        imgMain.setImage(mainPageImage);
        imgMain.setStyle("-fx-opacity: 0.6");
        imgMain.setFitWidth(400);       // Resizing the image width to 500
        imgMain.setPreserveRatio(true); // Preserving the image ratio

        VBox calculators = new VBox();
        calculators.getChildren().addAll(fixedDeposit, savings, loan, mortgage, help, exit);

        // Populate the elements to the relevant cells of the grid
        GridPane grid = new GridPane();

        GridPane.setConstraints(header,1,0);
        GridPane.setConstraints(calculators,0,0,1,4);
        GridPane.setConstraints(imgMain,1,1,1,3);

        // Set grid to the center of the window
        grid.setAlignment(Pos.CENTER);

        // Aligning header and imgMain to center of their cells
        GridPane.setHalignment(header, HPos.CENTER);
        GridPane.setHalignment(imgMain, HPos.CENTER);
        GridPane.setMargin(imgMain,new Insets(50));

        // Adding the elements to the object grid
        grid.getChildren().addAll(header,calculators,imgMain);

        Scene scene = new Scene(grid, 800, 500);
        scene.getStylesheets().add("/css/main.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        // This inner class handles the event of fixed deposit button
        fixedDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FixedDepositCalculator.display();
            }
        });

        // This inner class handles the event of savings button
        savings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SavingsCalculator.display();
            }
        });

        // This inner class handles the event of loan button
        loan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AutoLoanCalculator.display();
            }
        });

        // This inner class handles the event of mortgage button
        mortgage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MortgageCalculator.display();
            }
        });

        // This inner class handles the event of help button
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help.display();
            }
        });

        // This inner class handles the event of exit button
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeProgram();
            }
        });

        //
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                closeProgram();
            }
        });
    }

    private void closeProgram(){
        boolean answer = ExitConfirmBox.display();
        if (answer) {
            window.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
