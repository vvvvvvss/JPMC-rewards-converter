import java.util.Scanner;
class RewardValue {
    private static final double CASH_TO_MILES_RATE = 0.1; // Example rate: $1 = 0.1 miles
    private double cashValue;

    public RewardValue(double cashValue) {
        this.cashValue = cashValue;
    }

    public double getMilesValue() {
        return cashValue * CASH_TO_MILES_RATE;
    }
}
public class RewardsConverter {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Please enter a cash value to convert to airline miles: ");
        var input_value = scanner.nextLine();
        double cashValue;
        try {
            cashValue = Double.parseDouble(input_value);
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse input value as a double, exiting");
            return;
        }
        System.out.println("converting $" + input_value + " to miles");
        var rewardsValue = new RewardValue(cashValue);
        System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
    }

}