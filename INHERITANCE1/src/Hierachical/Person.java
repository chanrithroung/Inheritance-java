package Hierachical;
import java.util.Scanner;
public class Person {
    protected String id;
    protected String name;
    protected String gender;
    protected String dob;
    
    public Person() {
    }

    public Person(String id, String name, String gender, String dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
    
    public void input(String pos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter "+pos+" id : "); id = scanner.nextLine();
        System.out.print("Enter "+pos+" name : "); name = scanner.nextLine();
        System.out.print("Enter "+pos+" gender : "); gender = scanner.nextLine();
        System.out.print("Enter "+pos+" date of birth : "); dob = scanner.nextLine();
    }
    public void output() {
        System.out.printf("%-10s%-20s%-15s%-22s",id, name, gender, dob);
    }
    public static void header() {
        System.out.printf("%-10s%-20s%-15s%-22s", "#Id", "Name", "Gender", "Date of Birth");
    }
    
    /// @assesser
    public String getID() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    
    // @setter
    public void setID(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDob(String dob) { this.dob = dob; }
}