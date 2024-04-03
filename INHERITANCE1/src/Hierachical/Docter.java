package Hierachical;
import java.util.Scanner;
public class Docter extends Person {
    protected String major;
    protected int experience;
    protected String contact;
    protected double salary;
    protected static int n;
    public Docter() {
    }

    public Docter(String major, int experience, String contact, double salary, String id, String name, String gender, String dob) {
        super(id, name, gender, dob);
        this.major = major;
        this.experience = experience;
        this.contact = contact;
        this.salary = salary;
    }

    public String getMajor() {
        return major;
    }

    public int getExperience() {
        return experience;
    }

    public String getContact() {
        return contact;
    }

    public double getSalary() {
        return salary;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void inputDoc() {
        Scanner scanner = new Scanner(System.in);
        super.input("doctor");
        System.out.print("Enter doctor major : "); this.major = scanner.nextLine();
        System.out.print("Enter doctor experience : "); this.experience = scanner.nextInt(); scanner.nextLine(); 
        System.out.print("Enter doctor contact :"); this.contact = scanner.nextLine();
        System.out.print("Enter doctor salary : "); this.salary = scanner.nextDouble();
    }
    
    public static void headerDoc() {
        Person.header();
        System.out.printf("%-15s%-12s%-20s%-12s\n", "Major", "Experience", "Contact", "Salary");
    }
    
    public void outputDoc() {
        super.output();
        System.out.printf("%-15s%-12d%-20s%-12.2f\n", this.major, this.experience, this.contact, this.salary);
    }
}
