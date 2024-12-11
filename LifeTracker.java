public class LifeTracker {
    // Private data members
    private String name;
    private int age;
    private double weight; // in kg
    private double height; // in feet
    private String[] goals;
    private int goalsCount;
    private String[] dailyTasks;
    private int dailyTasksCount;

    // Constructor
    public LifeTracker(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height; // height in feet
        this.goals = new String[10]; // Initial capacity of 10
        this.dailyTasks = new String[10]; // Initial capacity of 10
        this.goalsCount = 0;
        this.dailyTasksCount = 0;
    }

    // Public getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    // Public methods to manage goals
    public void addGoal(String goal) {
        if (goalsCount < goals.length) {
            goals[goalsCount++] = goal;
        } else {
            String[] newGoals = new String[goals.length * 2];
            System.arraycopy(goals, 0, newGoals, 0, goals.length);
            goals = newGoals;
            goals[goalsCount++] = goal;
        }
    }

    public void removeGoal(String goal) {
        for (int i = 0; i < goalsCount; i++) {
            if (goals[i].equals(goal)) {
                System.arraycopy(goals, i + 1, goals, i, goalsCount - i - 1);
                goalsCount--;
                break;
            }
        }
    }

    public String[] getGoals() {
        String[] result = new String[goalsCount];
        System.arraycopy(goals, 0, result, 0, goalsCount);
        return result;
    }

    // Public methods to manage daily tasks
    public void addDailyTask(String task) {
        if (dailyTasksCount < dailyTasks.length) {
            dailyTasks[dailyTasksCount++] = task;
        } else {
            String[] newTasks = new String[dailyTasks.length * 2];
            System.arraycopy(dailyTasks, 0, newTasks, 0, dailyTasks.length);
            dailyTasks = newTasks;
            dailyTasks[dailyTasksCount++] = task;
        }
    }

    public void removeDailyTask(String task) {
        for (int i = 0; i < dailyTasksCount; i++) {
            if (dailyTasks[i].equals(task)) {
                System.arraycopy(dailyTasks, i + 1, dailyTasks, i, dailyTasksCount - i - 1);
                dailyTasksCount--;
                break;
            }
        }
    }

    public String[] getDailyTasks() {
        String[] result = new String[dailyTasksCount];
        System.arraycopy(dailyTasks, 0, result, 0, dailyTasksCount);
        return result;
    }

    // Public utility method
    public double calculateBMI() {
        double heightInMeters = height * 0.3048; 
        return weight / (heightInMeters * heightInMeters);
    }

    // Public method to display all information
    public void displayLifeInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " ft");
        System.out.println("BMI: " + String.format("%.2f", calculateBMI()));
        System.out.print("Goals: ");
        for (int i = 0; i < goalsCount; i++) {
            System.out.print(goals[i]);
            if (i < goalsCount - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.print("Daily Tasks: ");
        for (int i = 0; i < dailyTasksCount; i++) {
            System.out.print(dailyTasks[i]);
            if (i < dailyTasksCount - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LifeTracker tracker = new LifeTracker("Aditya", 18, 80.0, 5.9);

        tracker.displayLifeInfo();

        tracker.addGoal("Lose weight");
        tracker.addGoal("Read 12 books this year");
        tracker.addGoal("Run a marathon");

        tracker.addDailyTask("Exercise for 30 minutes");
        tracker.addDailyTask("Drink 2 liters of water");
        tracker.addDailyTask("Meditate for 10 minutes");

        System.out.println("\nAfter adding goals and daily tasks:");
        tracker.displayLifeInfo();

        tracker.removeGoal("Read 12 books this year");

        tracker.removeDailyTask("Meditate for 10 minutes");

        System.out.println("\nAfter removing a goal and a daily task:");
        tracker.displayLifeInfo();
    }
}
