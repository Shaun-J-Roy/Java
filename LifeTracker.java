import LifeTrackerApp.*;

import java.util.Scanner;

public class LifeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();
        scanner.nextLine();

        LifeTrack tracker = new LifeTrack(name, age, weight, height);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Activity");
            System.out.println("2. Remove an Activity");
            System.out.println("3. View Life Info");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter activity description: ");
                    String activity = scanner.nextLine();
                    System.out.print("Is this a goal? (yes/no): ");
                    boolean isGoal = scanner.nextLine().equalsIgnoreCase("yes");

                    if (isGoal) {
                        tracker = tracker.plus(new GoalActivity(activity));
                    } else {
                        tracker = tracker.plus(new TaskActivity(activity));
                    }
                    System.out.println("Activity added successfully.");
                    break;

                case 2:
                    System.out.print("Enter activity description to remove: ");
                    String activityToRemove = scanner.nextLine();
                    tracker.removeActivity(activityToRemove);
                    System.out.println("Activity removed successfully.");
                    break;

                case 3:
                    System.out.println("\nLife Info:");
                    tracker.displayLifeInfo();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    continue;
            }
        }
    }
}
