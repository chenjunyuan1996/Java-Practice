import java.util.*;

/**
 * This program demonstrates object construction.
 */


public class ConstructorTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects.
        // Employee3[] staff = new Employee3[3];
        var staff = new Employee3[3];

        staff[0] = new Employee3("Harry", 40000);
        staff[1] = new Employee3(60000);
        staff[2] = new Employee3();

        // print out information about all Employee objects
        for (Employee3 e : staff)
            System.out.println("name=" + e.getName() + ", id=" + e.getID() + ", salary=" + e.getSalary());
    }
}

class Employee3 {
    private static int nextID;

    private int id;
    private String name = " "; // instance field initialization
    private double salary;

    //static initialization block
    static {
        var generator = new Random(); // 类的首字母大写，要记住
        // set nextID to a random number between 0 to 9999
        nextID = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextID;
        nextID++;
    }

    // three overloaded constructors
    public Employee3(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee3(double s) {
        // calls the Employee3(String, double) constructor
        this("Employee #", s); // this调用上一个同名的结构
    }

    // the default constructor
    public Employee3() {
        // name initialized to "" -- see above
        // salary not explicitly set -- initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getID() {
        return id;
    }
}
