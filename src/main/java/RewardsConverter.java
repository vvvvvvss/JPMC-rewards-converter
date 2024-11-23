import java.util.Scanner;

class RewardValue {
    private static final double CASH_TO_MILES_RATE = 281.75;
    private static final double MILES_TO_CASH_RATE = 0.0035;
    private double cashValue;
    private double milesValue;


    public RewardValue(double cashValue, boolean isCash) {
        if (isCash) {
            this.cashValue = cashValue;
            this.milesValue = cashValue * CASH_TO_MILES_RATE;
        } else {
            this.milesValue = cashValue;
            this.cashValue = cashValue * MILES_TO_CASH_RATE;
        }
    }


    public double getMilesValue() {
        return milesValue;
    }


    public double getCashValue() {
        return cashValue;
    }
}

public class RewardsConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Enter: \n 1. To convert from cash to miles \n 2. To convert from miles to cash");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Please enter a cash value to convert to airline miles: ");
                String cashInput = scanner.nextLine();
                double cashValue;
                try {
                    cashValue = Double.parseDouble(cashInput);
                } catch (NumberFormatException exception) {
                    System.out.println("Could not parse input value as a double. Exiting...");
                    return;
                }
                RewardValue cashToMiles = new RewardValue(cashValue, true);
                System.out.println("$" + cashValue + " is worth " + cashToMiles.getMilesValue() + " miles.");
                break;

            case 2:
                System.out.print("Please enter a miles value to convert to cash: ");
                String milesInput = scanner.nextLine();
                double milesValue;
                try {
                    milesValue = Double.parseDouble(milesInput);
                } catch (NumberFormatException exception) {
                    System.out.println("Could not parse input value as a double. Exiting...");
                    return;
                }
                RewardValue milesToCash = new RewardValue(milesValue, false);
                System.out.println(milesValue + " miles is worth $" + milesToCash.getCashValue());
                break;

            default:
                System.out.println("Invalid option! Please enter 1 or 2.");
                break;
        }

        scanner.close();
    }
}
