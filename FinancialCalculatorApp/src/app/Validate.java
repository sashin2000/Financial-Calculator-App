package app;

import javafx.scene.control.TextField;

public class Validate {

    public static double[] validateInputsForLoan(TextField[] textFields){
        // The array inputsForAutoLoan is two indexes more than the size size of textFields array
        // inputsForAutoLoan.length-1 is for storing the one and only empty field
        // inputsForAutoLoan.length-2 is for storing the error code
        double[] inputsForAutoLoan = new double[textFields.length+2];
        int emptyFieldCount = 0;
        int calculatingField = -1;

        try {
            // Checks whether the fields of down payment and interest rate are empty
            if (textFields[1].getText().equals("")) {
                System.out.println("Cannot set Down Payment as empty");
                inputsForAutoLoan[inputsForAutoLoan.length-2] = 4;
                return  inputsForAutoLoan;
            }

            if (textFields[3].getText().equals("")) {
                System.out.println("Cannot set Interest Rate as empty");
                inputsForAutoLoan[inputsForAutoLoan.length-2] = 5;
                return  inputsForAutoLoan;
            }

            // Checks how many empty text fields are there
            for (int i = 0; i < textFields.length; i++) {
                if(textFields[i].getText().equals("")){
                    calculatingField = i;
                    emptyFieldCount++;
                }
            }

            if (emptyFieldCount == 0) {
                System.out.println("Keep the field empty that you want to find..");
                inputsForAutoLoan[inputsForAutoLoan.length-2] = 6;
                return inputsForAutoLoan;
            }else if(emptyFieldCount == 1) {
                inputsForAutoLoan[inputsForAutoLoan.length-1] = calculatingField;
            }else{
                System.out.println("Lack of sufficient data");
                inputsForAutoLoan[inputsForAutoLoan.length-2] = 2;
                return inputsForAutoLoan;
            }

            // Checks whether the user has entered double values(integer values are accepted as well) or negative values
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForAutoLoan[inputsForAutoLoan.length-1] ) {
                    continue;
                }
                if (Double.parseDouble(textFields[i].getText()) < 0) {
                    System.out.println("Please enter only positive values");
                    inputsForAutoLoan[inputsForAutoLoan.length-2] = 3;
                    return inputsForAutoLoan;
                }
            }

            // If all the inputs are valid, enter all the values into an array for future calculations
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForAutoLoan[inputsForAutoLoan.length-1] ) {
                    inputsForAutoLoan[i] = -1;
                    continue;
                }
                inputsForAutoLoan[i] = Double.parseDouble(textFields[i].getText());
            }
            inputsForAutoLoan[inputsForAutoLoan.length-2] = 0;
            inputsForAutoLoan[inputsForAutoLoan.length-1] = calculatingField;

        }catch (NumberFormatException e){

            System.out.println("Please enter only valid inputs");
            inputsForAutoLoan[inputsForAutoLoan.length-2] = 1;

        }
        return inputsForAutoLoan;
    }

    public static double[] validateInputsForFixedDeposit(TextField[] textFields){
        // The array inputsForAutoLoan is two indexes more than the size size of textFields array
        // inputsForAutoLoan.length-1 is for storing the one and only empty field
        // inputsForAutoLoan.length-2 is for storing the error code
        double[] inputsForSavings = new double[textFields.length+2];
        int emptyFieldCount = 0;
        int calculatingField = -1;
        try {

            // Checks how many empty text fields are there
            for (int i = 0; i < textFields.length; i++) {
                if(textFields[i].getText().equals("")){
                    calculatingField = i;
                    emptyFieldCount++;
                }
            }

            for (int i = 0; i < textFields.length; i++) {
                if (emptyFieldCount == 0) {
                    System.out.println("Keep the field empty that you want to find");
                    inputsForSavings[inputsForSavings.length-2] = 6;
                    return inputsForSavings;

                }else if (emptyFieldCount == 1) {

                    inputsForSavings[inputsForSavings.length-1] = calculatingField;

                }else{
                    System.out.println("Lack of sufficient data");
                    inputsForSavings[inputsForSavings.length-2] = 2;
                    return inputsForSavings;
                }
            }

            // Checks whether the user has entered double values(integer values are accepted as well) or negative values
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForSavings[inputsForSavings.length-1] ) {
                    continue;
                }
                if (Double.parseDouble(textFields[i].getText()) < 0) {
                    System.out.println("Please enter only positive values");
                    inputsForSavings[inputsForSavings.length-2] = 3;
                    return inputsForSavings;
                }
            }

            // If all the inputs are valid, enter all the values into an array for future calculations
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForSavings[inputsForSavings.length-1] ) {
                    inputsForSavings[i] = -1;
                    continue;
                }
                inputsForSavings[i] = Double.parseDouble(textFields[i].getText());
            }
            inputsForSavings[inputsForSavings.length-2] = 0;
            inputsForSavings[inputsForSavings.length-1] = calculatingField;

        }catch (NumberFormatException e){

            System.out.println("Please enter only valid inputs");
            inputsForSavings[inputsForSavings.length-2] = 1;

        }
        return inputsForSavings;
    }

    public static double[] validateInputsForSavings(TextField[] textFields){
        // The array inputsForAutoLoan is two indexes more than the size size of textFields array
        // inputsForAutoLoan.length-1 is for storing the one and only empty field
        // inputsForAutoLoan.length-2 is for storing the error code
        double[] inputsForAutoLoan = new double[textFields.length+2];
        int emptyFieldCount = 0;
        int calculatingField = -1;
        try {

            // Checks whether the field of interest rate is empty
            if (textFields[2].getText().equals("")) {
                System.out.println("Cannot set Interest Rate as empty");
                inputsForAutoLoan[inputsForAutoLoan.length-2] = 5;
                return inputsForAutoLoan;
            }

            // Checks how many empty text fields are there
            for (int i = 0; i < textFields.length; i++) {
                if(textFields[i].getText().equals("")){
                    calculatingField = i;
                    emptyFieldCount++;
                }
            }

            for (int i = 0; i < textFields.length; i++) {
                if (emptyFieldCount == 0) {

                    System.out.println("Keep the field empty that you want to find.");
                    inputsForAutoLoan[inputsForAutoLoan.length-2] = 6;
                    return inputsForAutoLoan;

                }else if (emptyFieldCount == 1) {

                    inputsForAutoLoan[inputsForAutoLoan.length-1] = calculatingField;

                }else{
                    System.out.println("Lack of sufficient data");
                    inputsForAutoLoan[inputsForAutoLoan.length-2] = 2;
                    return inputsForAutoLoan;
                }
            }

            // Checks whether the user has entered double values(integer values are accepted as well) or negative values
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForAutoLoan[inputsForAutoLoan.length-1] ) {
                    continue;
                }
                if (Double.parseDouble(textFields[i].getText()) < 0) {
                    System.out.println("Please enter only positive values");
                    inputsForAutoLoan[inputsForAutoLoan.length-2] = 3;
                    return inputsForAutoLoan;
                }
            }

            // If all the inputs are valid, enter all the values into an array for future calculations
            for (int i = 0; i < textFields.length; i++) {
                if (i == inputsForAutoLoan[inputsForAutoLoan.length-1] ) {
                    inputsForAutoLoan[i] = -1;
                    continue;
                }
                inputsForAutoLoan[i] = Double.parseDouble(textFields[i].getText());
            }
            inputsForAutoLoan[inputsForAutoLoan.length-2] = 0;
            inputsForAutoLoan[inputsForAutoLoan.length-1] = calculatingField;

        }catch (NumberFormatException e){

            System.out.println("Please enter only valid inputs");
            inputsForAutoLoan[inputsForAutoLoan.length-2] = 1;

        }
        return inputsForAutoLoan;
    }
}