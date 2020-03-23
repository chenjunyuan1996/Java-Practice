package inheritance;

/**
 * This program demonstrates inheritance.
 * @version 1.0
 * @author copy by Chen
 */


public class ManagerTest {
    public static void main(String[] args) {
        // constructor
        var staff = new Employee[3];

        var boss = new Manager("Junyuan Chen", 80000,1999, 12, 31);
        boss.setBonus(5000);

        // fill the staff array with Manager and Employee objects
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1998, 5, 25);
        staff[2] = new Employee("Evan Leeeeee", 40000, 2000, 3, 15);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
    }

}
