package LifeTrackerApp;

public class LifeTrack extends Person {
    private double weight;
    private double height;
    private Activity[] goals;
    private int goalsCount;
    private Activity[] dailyTasks;
    private int dailyTasksCount;

    public LifeTrack(String name, int age, double weight, double height) {
        super(name, age);
        this.weight = weight;
        this.height = height;
        this.goals = new Activity[10];
        this.dailyTasks = new Activity[10];
        this.goalsCount = 0;
        this.dailyTasksCount = 0;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public void addGoal(Activity goal) {
        if (goalsCount < goals.length) {
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

    public void addDailyTask(Activity task) {
        if (dailyTasksCount < dailyTasks.length) {
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

    public void displayLifeInfo() {
        System.out.println(super.getGreeting());
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + String.format("%.2f", calculateBMI()));

        // Display Goals
        System.out.println("\nGoals:");
        if (goalsCount == 0) {
            System.out.println("No goals set.");
        } else {
            for (int i = 0; i < goalsCount; i++) {
                System.out.println("- " + goals[i].getDescription());
            }
        }

        // Display Daily Tasks
        System.out.println("\nDaily Tasks:");
        if (dailyTasksCount == 0) {
            System.out.println("No daily tasks recorded.");
        } else {
            for (int i = 0; i < dailyTasksCount; i++) {
                System.out.println("- " + dailyTasks[i].getDescription());
            }
        }
    }


    public LifeTrack plus(Activity activity) {
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
}
