package inheritance1;
import java.util.Scanner;
public class Person {
    public int id;
    public String name;
    public char gender;
    
    public void input(String position) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter "+position+" id : "); id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter "+position+" name : "); name = scanner.nextLine();
        System.out.print("Enter "+position+" gender : "); gender = scanner.nextLine().charAt(0);
    }
    
    public static void header() {
        System.out.printf("%-15s%-20s%-10s", "ID", "Name", "Gender");
    }
    
    public void output() {
        System.out.printf("%-15d%-20s%-10c", id, name, gender);
    }
}





