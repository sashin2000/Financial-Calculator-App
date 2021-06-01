package app;

import java.text.NumberFormat;

public class Calculate {

    private static double principal;
    private static double period;
    private static double monthlyPay;
    private static double futureValue;
    private static double interestRate;

    public static String[] calculateForLoan(double[] values){
        String[] strValues = new String[values.length];

        double txtPrincipal= values[0];
        double txtDownPayment = values[1];
        double txtPeriod= values[2];
        double txtInterestRate = values[3];
        double txtMonthlyPay = values[4];

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        double finalPrincipalAmount = txtPrincipal - txtDownPayment;

        // values.length-1 index consist of the value that has given to relevant empty field, that has to be calculated
        switch ((int)values[values.length-1]) {
            case 0:
                System.out.println("Find Principal");
                principal = calcPrincipal(txtMonthlyPay, txtInterestRate, txtPeriod, txtDownPayment);
                strValues[0] = currencyFormat.format(principal);

                strValues[1] = currencyFormat.format(txtDownPayment);

                strValues[2] = txtPeriod + " months";

                strValues[3] = txtInterestRate + " %";

                strValues[4] = currencyFormat.format(txtMonthlyPay);

                futureValue = txtMonthlyPay * txtPeriod;
                strValues[5] = currencyFormat.format(futureValue);
                break;

            case 2:
                System.out.println("Find Period");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = currencyFormat.format(txtDownPayment);

                period = calcPeriod(txtMonthlyPay, finalPrincipalAmount);
                strValues[2] = roundToTwoFloatingPoints(period) + " months";

                strValues[3] = txtInterestRate + " %";

                strValues[4] = currencyFormat.format(txtMonthlyPay);

                futureValue = txtMonthlyPay * period;
                strValues[5] = currencyFormat.format(futureValue);
                break;

            case 4:
                System.out.println("Find Monthly Pay");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = currencyFormat.format(txtDownPayment);

                strValues[2] = txtPeriod + " months";

                strValues[3] = txtInterestRate + " %";

                monthlyPay = calcMonthlyPay(finalPrincipalAmount, txtInterestRate, txtPeriod);
                strValues[4] = currencyFormat.format(monthlyPay);

                futureValue = monthlyPay * txtPeriod;
                strValues[5] = currencyFormat.format(futureValue);
        }
        return strValues;
    }

    public static String[] calculateForSavings(double[] values) {
        String[] strValues = new String[values.length];

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        double txtPrincipal= values[0];
        double txtPeriod= values[1];
        double txtInterestRate = values[2];
        double txtMonthlyPay = values[3];
        double txtFutureValue = values[4];

        // values.length-1 index consist of the value that has given to relevant empty field, that has to be calculated
        switch ((int)values[values.length-1]) {
            case 0:
                System.out.println("Find Principal");

                principal = calcPrincipalForSavings(txtInterestRate, txtPeriod, txtMonthlyPay, txtFutureValue);
                strValues[0] = currencyFormat.format(principal);

                strValues[1] = txtPeriod + " months";

                strValues[2] = txtInterestRate + " %";

                strValues[3] = currencyFormat.format(txtMonthlyPay);

                strValues[4] = currencyFormat.format(txtFutureValue);

                break;
            case 1:
                System.out.println("Find Period");

                strValues[0] = currencyFormat.format(txtPrincipal);

                period = calcPeriodForSavings(txtPrincipal, txtInterestRate, txtMonthlyPay, txtFutureValue);
                strValues[1] = roundToTwoFloatingPoints(period) + " months";

                strValues[2] = txtInterestRate + " %";

                strValues[3] = currencyFormat.format(txtMonthlyPay);

                strValues[4] = currencyFormat.format(txtFutureValue);

                break;

            case 3:
                System.out.println("Find Monthly Pay");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = txtPeriod + " months";

                strValues[2] = txtInterestRate + " %";

                monthlyPay = calcMonthlyPayForSavings(txtPrincipal, txtPeriod, txtInterestRate, txtFutureValue);
                strValues[3] = currencyFormat.format(monthlyPay);

                strValues[4] = currencyFormat.format(txtFutureValue);

                break;
            case 4:
                System.out.println("Find Future Value");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = txtPeriod + " months";

                strValues[2] = txtInterestRate + " %";

                strValues[3] = currencyFormat.format(txtMonthlyPay);

                futureValue = calcFutureValueForSavings(txtPrincipal, txtPeriod, txtInterestRate, txtMonthlyPay);
                strValues[4] = currencyFormat.format(futureValue);

                break;
        }
        return strValues;
    }

    public static String[] calculateForFixedDeposit(double[] values) {
        String[] strValues = new String[values.length];

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        double txtPrincipal= values[0];
        double txtPeriod= values[1];
        double txtInterestRate = values[2];
        double txtFutureValue = values[3];

        // values.length-1 index consist of the value that has given to relevant empty field, that has to be calculated
        switch ((int)values[values.length-1]) {
            case 0:
                System.out.println("Find Principal");

                principal = calcPrincipalForFixedDeposit(txtFutureValue, txtInterestRate, txtPeriod);
                strValues[0] = currencyFormat.format(principal);

                strValues[1] = txtPeriod + " months";

                strValues[2] = txtInterestRate + " %";

                strValues[3] = currencyFormat.format(txtFutureValue);

                break;
            case 1:
                System.out.println("Find Period");

                strValues[0] = currencyFormat.format(txtPrincipal);

                period = calcPeriodForFixedDeposit(txtFutureValue, txtInterestRate, txtPrincipal);
                strValues[1] = period + " months";

                strValues[2] = txtInterestRate + " %";

                strValues[3] = currencyFormat.format(txtFutureValue);

                break;
            case 2:
                System.out.println("Find Interest Rate");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = txtPeriod + " months";

                interestRate = calcInterestRateForFixedDeposit(txtFutureValue, txtPeriod, txtPrincipal );
                strValues[2] = interestRate + " %";

                strValues[3] = currencyFormat.format(txtFutureValue);

                break;
            case 3:
                System.out.println("Find Future Value");

                strValues[0] = currencyFormat.format(txtPrincipal);

                strValues[1] = txtPeriod + " months";

                strValues[2] = txtInterestRate + " %";

                futureValue = calcFutureValueForFixedDeposit(txtInterestRate, txtPeriod, txtPrincipal);
                strValues[3] = currencyFormat.format(futureValue);

                break;
        }
        return strValues;
    }

    private static double roundToTwoFloatingPoints(double value){
        double roundedValue = Math.round(value*100)/100.0;
        return roundedValue;
    }

    // Calculation Methods for loan

    private static double calcMonthlyPay(double finalPrincipalAmount, double interestRate, double loanPeriod){
        final double v = Math.pow(1 + ((interestRate / 100.0) / 12.0), loanPeriod);
        double monthlyPay = (finalPrincipalAmount * ((interestRate/100.0)/12) * v) / (v -1);
        //System.out.println("(" + finalPrincipalAmount + " * " + ((interestRate/100.0)/12.0) + " * " + v +")" + "/" + (v-1));
        return monthlyPay;
    }

    private static double calcPrincipal(double monthlyPay, double interestRate, double loanPeriod, double downPayment){
        final double v = Math.pow(1 + ((interestRate / 100.0) / 12.0), loanPeriod);
        double principal = (monthlyPay * (v-1)) / (((interestRate/100.0)/12) * v);
        return principal + downPayment;
    }

    private static double calcPeriod(double monthlyPay, double principal){
        double period = principal/monthlyPay;
        return period;
    }

/*    private static double calcPeriod(double futureValue, double principal, double interestRate){
        double tempPeriod = 0.01;
        double monthlyPay = calcMonthlyPay(principal,interestRate,tempPeriod);
        double futValue = monthlyPay * tempPeriod;
        while (futureValue > futValue){
            tempPeriod += 0.01;
            monthlyPay = calcMonthlyPay(principal,interestRate,tempPeriod);
            futValue = monthlyPay * tempPeriod;
        }
        return tempPeriod;
    }*/

    // Calculation Methods for fixed deposit

    private static double calcPrincipalForFixedDeposit(double futureValue, double interestRate, double loanPeriod){
        double principal = futureValue / Math.pow((1+ interestRate/12),loanPeriod);
        return principal;
    }

    private static double calcInterestRateForFixedDeposit(double futureValue, double loanPeriod, double principal){
        double interestRate = 12 * (Math.pow(futureValue/principal,1/loanPeriod)-1);
        return roundToTwoFloatingPoints(interestRate);
    }

    private static double calcFutureValueForFixedDeposit(double interestRate, double loanPeriod, double principal){
        double futureValue  = principal * Math.pow((1+ interestRate/12),loanPeriod) ;
        return futureValue;
    }

    private static double calcPeriodForFixedDeposit(double futureValue, double interestRate, double principal){
        double period = Math.log(futureValue/principal) / Math.log(1 + interestRate / 12);
        return  roundToTwoFloatingPoints(period);
    }

    // Calculation Methods for savings

    private static double calcPrincipalForSavings(double interestRate, double period, double monthlyPay, double futureValue){
        double principal = (futureValue - (monthlyPay * (Math.pow(1+interestRate/12,period) - 1)/(interestRate/12))) / Math.pow((1 + interestRate/12),period);
        return principal;
    }

    private static double calcPeriodForSavings(double principal, double interestRate, double monthlyPay, double futureValue){
        double period = Math.log((futureValue * interestRate/12 + monthlyPay)/ (principal * interestRate/12 + monthlyPay)) / Math.log(1 + interestRate/12);
        return period;
    }
    private static double calcMonthlyPayForSavings(double principal, double period, double interestRate, double futureValue){
        double monthlyPay = (futureValue - (principal * Math.pow((1 + interestRate/12),period))) / ((Math.pow(1+interestRate/12,period) - 1)/(interestRate/12));
        return monthlyPay;
    }

    private static double calcFutureValueForSavings(double principal, double period, double interestRate, double monthlyPay){
        double futureValue  = (monthlyPay * (Math.pow(1+interestRate/12,period) - 1)/(interestRate/12)) + (principal * Math.pow((1 + interestRate/12),period)) ;
        return futureValue;
    }
}

/**
 * { totalLoanAmount * ((interestRate/100.0)/12) * (1 + Math.pow(((interestRate/100.0)/12),12*30)) } / { [1 + Math.pow(((interestRate/100.0)/12),12*30)]-1}
 */