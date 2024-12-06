import java.util.ArrayList;
import java.util.List;

public class LifeTracker {

    private String name;
    private int age;
    private double weight;
    private double height;
    private List<String> goals;
    private List<String> dailyTasks;

    public LifeTracker(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goals = new ArrayList<>();
        this.dailyTasks = new ArrayList<>();
    }

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

    public void addGoal(String goal) {
        goals.add(goal);
    }

    public void removeGoal(String goal) {
        goals.remove(goal);
    }

    public List<String> getGoals() {
        return new ArrayList<>(goals);
    }

    public void addDailyTask(String task) {
        dailyTasks.add(task);
    }

    public void removeDailyTask(String task) {
        dailyTasks.remove(task);
    }

    public List<String> getDailyTasks() {
        return new ArrayList<>(dailyTasks);
    }

    public double calculateBMI() {
        double height = height * 0.3048;
        return weight / (height * height);
    }

    public void displayLifeInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " ft");
        System.out.println("BMI: " + String.format("%.2f", calculateBMI()));
        System.out.println("Goals: " + goals);
        System.out.println("Daily Tasks: " + dailyTasks);
    }

    public static void main(String[] args) {
        LifeTracker tracker = new LifeTracker("Shaun", 18, 80, 5.11);

        tracker.addGoal("Learn a new language");
        tracker.addGoal("Exercise regularly");

        tracker.addDailyTask("Meditate for 10 minutes");
        tracker.addDailyTask("Read for 30 minutes");

        tracker.displayLifeInfo();
    }
}
