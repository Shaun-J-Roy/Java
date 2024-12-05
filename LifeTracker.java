import java.util.ArrayList;
import java.util.List;

public class LifeTracker {
    // Private data members
    private String name;
    private int age;
    private double weight;
    private double height;
    private List<String> goals;
    private List<String> dailyTasks;

    // Constructor
    public LifeTracker(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goals = new ArrayList<>();
        this.dailyTasks = new ArrayList<>();
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
        goals.add(goal);
    }

    public void removeGoal(String goal) {
        goals.remove(goal);
    }

    public List<String> getGoals() {
        return new ArrayList<>(goals);
    }

    // Public methods to manage daily tasks
    public void addDailyTask(String task) {
        dailyTasks.add(task);
    }

    public void removeDailyTask(String task) {
        dailyTasks.remove(task);
    }

    public List<String> getDailyTasks() {
        return new ArrayList<>(dailyTasks);
    }

    // Public utility method
    public double calculateBMI() {
        return weight / (height * height);
    }

    // Public method to display all information
    public void displayLifeInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + String.format("%.2f", calculateBMI()));
        System.out.println("Goals: " + goals);
        System.out.println("Daily Tasks: " + dailyTasks);
        
    }
}
