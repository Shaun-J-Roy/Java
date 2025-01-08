import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getGreeting() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }
}

class Activity {
    private String description;

    public Activity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class GoalActivity extends Activity {
    public GoalActivity(String description) {
        super(description);
    }
}

class TaskActivity extends Activity {
    public TaskActivity(String description) {
        super(description);
    }
}


public class LifeTracker extends Person {
    private double weight;
    private double height;
    private Activity[] goals;
    private int goalsCount;
    private Activity[] dailyTasks;
    private int dailyTasksCount;

    public LifeTracker(String name, int age, double weight, double height) {
        super(name, age);  // Call the superclass constructor
        this.weight = weight;
        this.height = height;
        this.goals = new Activity[10];
        this.dailyTasks = new Activity[10];
        this.goalsCount = 0;
        this.dailyTasksCount = 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void addGoal(Activity goal) {
        if (goalsCount < goals.length) {
            goals[goalsCount++] = goal;
        } else {
            Activity[] newGoals = new Activity[goals.length * 2];
            System.arraycopy(goals, 0, newGoals, 0, goals.length);
            goals = newGoals;
            goals[goalsCount++] = goal;
        }
    }

    public void removeGoal(String goalDescription) {
        for (int i = 0; i < goalsCount; i++) {
            if (goals[i].getDescription().equals(goalDescription)) {
                System.arraycopy(goals, i + 1, goals, i, goalsCount - i - 1);
                goalsCount--;
                break;
            }
        }
    }

    public Activity[] getGoals() {
        Activity[] result = new Activity[goalsCount];
        System.arraycopy(goals, 0, result, 0, goalsCount);
        return result;
    }

    public void addDailyTask(Activity task) {
        if (dailyTasksCount < dailyTasks.length) {
            dailyTasks[dailyTasksCount++] = task;
        } else {
            Activity[] newTasks = new Activity[dailyTasks.length * 2];
            System.arraycopy(dailyTasks, 0, newTasks, 0, dailyTasks.length);
            dailyTasks = newTasks;
            dailyTasks[dailyTasksCount++] = task;
        }
    }

    public void removeDailyTask(String taskDescription) {
        for (int i = 0; i < dailyTasksCount; i++) {
            if (dailyTasks[i].getDescription().equals(taskDescription)) {
                System.arraycopy(dailyTasks, i + 1, dailyTasks, i, dailyTasksCount - i - 1);
                dailyTasksCount--;
                break;
            }
        }
    }

    public Activity[] getDailyTasks() {
        Activity[] result = new Activity[dailyTasksCount];
        System.arraycopy(dailyTasks, 0, result, 0, dailyTasksCount);
        return result;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public void displayLifeInfo() {
        System.out.println(super.getGreeting());  // Using the final method from the superclass
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + String.format("%.2f", calculateBMI()));
        System.out.print("Goals: ");
        for (int i = 0; i < goalsCount; i++) {
            System.out.print(goals[i].getDescription());
            if (i < goalsCount - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Daily Tasks: ");
        for (int i = 0; i < dailyTasksCount; i++) {
            System.out.print(dailyTasks[i].getDescription());
            if (i < dailyTasksCount - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public LifeTracker plus(Activity activity) {
        if (activity instanceof GoalActivity) {
            addGoal(activity);
        } else if (activity instanceof TaskActivity) {
            addDailyTask(activity);
        }
        return this;
    }

    public void removeActivity(String activityDescription) {
        removeGoal(activityDescription);
        removeDailyTask(activityDescription);
    }


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
        scanner.nextLine(); // Consume newline

        LifeTracker tracker = new LifeTracker(name, age, weight, height);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Activity");
            System.out.println("2. Remove an Activity");
            System.out.println("3. View Life Info");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter activity description: ");
                    String activity = scanner.nextLine();
                    System.out.print("Is this a goal? (yes/no): ");
                    boolean isGoal = scanner.nextLine().equalsIgnoreCase("yes");

                    // Demonstrating operator overloading
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

