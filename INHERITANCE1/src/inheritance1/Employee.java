package inheritance1;
import java.util.Scanner;
public class Employee extends Person{
    public double salary;
    
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input("employee");
        System.out.print("Enter employee salary : "); salary = scanner.nextDouble();
        
    }
    
    public void output() {
        super.output();
        System.out.printf("%-15.2f\n", salary);
        
    }    
    public static void header() {
        Person.header();
        System.out.printf("%-15s\n", "Salary");
    }
}



