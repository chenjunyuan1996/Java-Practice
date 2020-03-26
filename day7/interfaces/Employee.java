package interfaces;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent) {
        salary *= (1 + byPercent / 100);
    }

    /**
     * Compares Employee by salary
     * @param other another Employee object
     * @return a negative value if this employee has a lower salary than otherObject,
     * 0 if the salaries are the same, a positive value otherwise
     */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}
