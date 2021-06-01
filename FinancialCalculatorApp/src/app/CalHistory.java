package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javafx.scene.control.ScrollPane.ScrollBarPolicy.AS_NEEDED;

public class CalHistory {
    public static void display(String collectionName){
        Stage calStage = new Stage();
        calStage.initModality(Modality.APPLICATION_MODAL);
        calStage.setTitle("History");
        calStage.setMinWidth(350);
        calStage.setMinHeight(600);

        // Creating labels
        Label lblHeader = new Label("History");
        lblHeader.setId("header");

        // Getting the history from the database and setting them into the label
        Label lblHistory = History.displayHistory(collectionName);;

        lblHeader.setLayoutX(100);
        lblHistory.setLayoutX(10);
        lblHistory.setLayoutY(100);

        // Creating back button
        Image loadImgBack = new Image("images/back-icon.png");
        ImageView imgBack = new ImageView(loadImgBack);
        imgBack.setFitHeight(50);
        imgBack.setFitWidth(50);
        Button back = new Button("",imgBack);
        back.setId("btnBack");

        // Adding action event to back button
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calStage.close();
            }
        });

        // Creating anchor pane and adding nodes
        AnchorPane anchorPane = new AnchorPane(lblHeader,lblHistory,back);
        anchorPane.setId("anchPane");

        // Adding anchor pane inside scroll pane
        ScrollPane scPane = new ScrollPane(anchorPane);
        scPane.setFitToHeight(true);
        scPane.setFitToWidth(true);
        scPane.pannableProperty().set(true);
        scPane.vbarPolicyProperty().setValue(AS_NEEDED);
        scPane.hbarPolicyProperty().setValue(AS_NEEDED);

        // Setting the scroll pane as scene
        Scene scene = new Scene(scPane, 500, 600);
        scene.getStylesheets().add("css/history.css");
        calStage.setScene(scene);
        calStage.showAndWait();
    }
}
