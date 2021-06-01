package app;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Help {
    public static void display() {
        Stage calStage = new Stage();
        calStage.initModality(Modality.APPLICATION_MODAL);
        calStage.setTitle("History");
        calStage.setMinWidth(850);
        calStage.setMinHeight(300);

        String strSavings = "\n  Inorder to find find the value of a certain field," +
                " you have to keep that field empty and fill all the remaining\n" +
                "  fields with relevant values.\n\n" +
                "  Here are the parameters that you can find by using this calculator,\n" +
                "\t# Principal\n" +
                "\t# Period\n" +
                "\t# Monthly Payment\n" +
                "\t# Future Value\n\n" +
                "  Note - In any case of following incorrect instructions, there is guidance by alert messages within the calculator.";

        String strFixedDeposit = "\n  Inorder to find find the value of a certain field," +
                " you have to keep that field empty and fill all the remaining\n" +
                "  fields with relevant values.\n\n" +
                "  Here are the parameters that you can find by using this calculator,\n" +
                "\t# Principal\n" +
                "\t# Period\n" +
                "\t# Interest rate\n" +
                "\t# Future Value\n\n" +
                "  Note - In any case of following incorrect instructions, there is guidance by alert messages within the calculator.";

        String strLoan = "\n  Inorder to find find the value of a certain field," +
                " you have to keep that field empty and fill all the remaining\n" +
                "  fields with relevant values.\n\n" +
                "  Here are the parameters that you can find by using this calculator,\n" +
                "\t# Principal\n" +
                "\t# Period\n" +
                "\t# Monthly pay\n\n" +
                "  Note - In any case of following incorrect instructions, there is guidance by alert messages within the calculator.";

        String strMortgage = "\n  Inorder to find find the value of a certain field," +
                " you have to keep that field empty and fill all the remaining\n" +
                "  fields with relevant values.\n\n" +
                "  Here are the parameters that you can find by using this calculator,\n" +
                "\t# Home principal\n" +
                "\t# Period\n" +
                "\t# Monthly pay\n\n" +
                "  Note - In any case of following incorrect instructions, there is guidance by alert messages within the calculator.";

        // Creating labels and adding content
        Label lblSavings = new Label(strSavings);
        Label lblFixedDeposit = new Label(strFixedDeposit);
        Label lblLoan = new Label(strLoan);
        Label lblMortgage = new Label(strMortgage);

        TabPane tabPane = new TabPane();

        // Creating tabs
        Tab tabSavings = new Tab("Savings");
        Tab tabFixedDeposit = new Tab("Fixed Deposit");
        Tab tabLoan = new Tab("Loan");
        Tab tabMortgage = new Tab("Mortgage");

        // Setting content to the tabs
        tabSavings.setContent(lblSavings);
        tabFixedDeposit.setContent(lblFixedDeposit);
        tabLoan.setContent(lblLoan);
        tabMortgage.setContent(lblMortgage);

        // Disabling the closing ability of all tabs
        tabFixedDeposit.setClosable(false);
        tabSavings.setClosable(false);
        tabLoan.setClosable(false);
        tabMortgage.setClosable(false);

        // Adding the tabs to the tab pane
        tabPane.getTabs().add(tabFixedDeposit);
        tabPane.getTabs().add(tabSavings);
        tabPane.getTabs().add(tabLoan);
        tabPane.getTabs().add(tabMortgage);

        // Setting the anchor pane as scene
        Scene scene = new Scene(tabPane, 850, 300);
        scene.getStylesheets().add("css/help.css");
        calStage.setResizable(false);
        calStage.setScene(scene);
        calStage.showAndWait();
    }
}
