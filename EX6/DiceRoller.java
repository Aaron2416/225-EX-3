import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    private static final int[] VALID_DICE = {4, 6, 8, 10, 12, 20, 100};
    private static final int MAX_DICE = 10;
    private static final int MIN_TARGET = 5;
    private static final int MAX_TARGET = 30;

    public static void main(String[] args) {
        int dieType = getValidDieType();
        int numDice = getNumDice();
        int target = getValidTarget();

        int totalRoll = 0;
        int numOnes = 0;
        int numOpenEnds = 0;

        Random random = new Random();

        for (int i = 0; i < numDice; i++) {
            int roll = random.nextInt(dieType) + 1;
            if (roll == 1) {
                numOnes++;
            } else if (roll == dieType) {
                numOpenEnds++;
                i--;
                numDice++;
            }
            totalRoll += roll;
        }

        if (numOnes > numDice / 2) {
            System.out.println("Bust!!! Over 50% of the dice rolled 1.");
        } else {
            System.out.println("Total roll: " + totalRoll);
            System.out.println("Number of ones: " + numOnes);
            System.out.println("Number of open ends: " + numOpenEnds);
        }
    }

    private static int getValidDieType() {
        Scanner scanner = new Scanner(System.in);
        int dieType;
        do {
            System.out.print("Enter a valid die type (4, 6, 8, 10, 12, 20, or 100): ");
            dieType = scanner.nextInt();
        } while (!isValidDieType(dieType));
        return dieType;
    }

    private static boolean isValidDieType(int dieType) {
        for (int valid : VALID_DICE) {
            if (dieType == valid) {
                return true;
            }
        }
        return false;
    }

    private static int getNumDice() {
        Scanner scanner = new Scanner(System.in);
        int numDice;
        do {
            System.out.print("Enter the number of dice (maximum " + MAX_DICE + "): ");
            numDice = scanner.nextInt();
        } while (numDice <= 0 || numDice > MAX_DICE);
        return numDice;
    }

    private static int getValidTarget() {
        Scanner scanner = new Scanner(System.in);
        int target;
        do {
            System.out.print("Enter a valid target number (" + MIN_TARGET + " to " + MAX_TARGET + "): ");
            target = scanner.nextInt();
        } while (target < MIN_TARGET || target > MAX_TARGET);
        return target;
    }
}

