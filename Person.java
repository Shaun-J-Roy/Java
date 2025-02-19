package LifeTrackerApp;

public class Person {
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
