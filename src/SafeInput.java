import java.util.Scanner;

public class SafeInput {
    private static Scanner in = new Scanner(System.in);

    public static String getRegExString(String prompt, String regEx) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = in.nextLine();
        } while (!input.matches(regEx));
        return input;
    }

    public static String getNonZeroLenString(String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = in.nextLine().trim();
        } while (input.length() == 0);
        return input;
    }

    public static boolean getYNConfirm(String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = in.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }

    public static int getRangedInt(String prompt, int low, int high) {
        int num = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt + " ");
            if (in.hasNextInt()) {
                num = in.nextInt();
                if (num >= low && num <= high) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                in.next(); // Clear invalid input
            }
        }
        return num;
    }
}