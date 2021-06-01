package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitConfirmBox {

    static boolean answer;

    public static boolean display(){

        Stage exitConfirmStage = new Stage();
        exitConfirmStage.setTitle("Exit");
        AnchorPane exit = new AnchorPane();
        exitConfirmStage.initModality(Modality.APPLICATION_MODAL);
        exitConfirmStage.setResizable(false);

        // Loading and adding image to ImageView
        Image exitImage = new Image("/images/exit-door-icon.png");
        ImageView exitImg = new ImageView(exitImage);

        // Resizing the image
        exitImg.setFitHeight(150);
        exitImg.setFitWidth(150);
        exitImg.setLayoutX(15);
        exitImg.setLayoutY(30);

        // Creating label
        Label lblExitMsg = new Label();
        lblExitMsg.setText("Do you really want to exit?");
        lblExitMsg.setLayoutX(180);
        lblExitMsg.setLayoutY(30);

        Button yes = new Button("Yes");
        yes.setLayoutX(200);
        yes.setLayoutY(100);
        yes.setMaxWidth(100);
        yes.setMaxHeight(55);

        Button no = new Button("No");
        no.setLayoutX(320);
        no.setLayoutY(100);
        no.setMaxWidth(100);
        no.setMaxHeight(55);

        // Adding event listeners to buttons
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = true;
                exitConfirmStage.close();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = false;
                exitConfirmStage.close();
            }
        });

        // Adding all nodes to anchor pane
        exit.getChildren().addAll(exitImg,lblExitMsg,yes,no);

        Scene scene = new Scene(exit, 450, 200);
        scene.getStylesheets().add("/css/exitConfirmBox.css");
        exitConfirmStage.setScene(scene);
        exitConfirmStage.showAndWait();

        return answer;
    }
}
