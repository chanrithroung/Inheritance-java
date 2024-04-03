package Hierachical;
import java.util.Scanner;
public class Students extends Person {
   private int score1, score2, score3, total;
   private double average;
   private char grade;
   // n number of students
   public static int n;
    private int findTotal() { return score1 + score2 + score3; }
    private double findAverage() { return total / 3; }
    private char findGrade() { return average >= 95 ? 'A' : average >= 85 ? 'B' : average >= 75 ? 'C' : average >= 65 ? 'D' : average >= 50 ? 'E' : 'F'; }
    public Students() { super("null", "null", "null", "null"); score1 = 0; score2 = 0; score3 = 0; total = findTotal(); average = findAverage(); grade = findGrade(); }
    public Students(int score1, int score2, int score3, String id, String name, String gender, String dob) {
        super(id, name, gender, dob);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.total = findTotal();
        this.average = findAverage();
        this.grade = findGrade();
    }
    
    // @accesser
    public int getScore1() { return score1; }
    public int getScore2() { return score2; }
    public int getScore3() { return score3; }
    public double getAverage() { return this.average; }
    
    // @setter 
    public void setScore1(int score1) { this.score1 = score1; } 
    public void setScore2(int score2) { this.score2 = score2; } 
    public void setScore3(int score3) { this.score3 = score3; } 
    
    
    public void input() {
        Scanner scanner =  new Scanner(System.in);
        super.input("student");
        System.out.print("Enter score C    : "); score1 = scanner.nextInt();
        System.out.print("Enter score C++  : "); score2 = scanner.nextInt();
        System.out.print("Enter score Java : "); score3 = scanner.nextInt();
        total = findTotal();
        average = findAverage();
        grade = findGrade();
    }
    
    public void output() {
        super.output();
        System.out.printf("%-20d%-20d%-20d%-10d%-12.2f%c\n", score1, score2, score3, total, average, grade);
    }
    
    public static void headerStu(){
        Person.header();
        System.out.printf("%-20s%-20s%-20s%-10s%-12s%s\n", "C programming", "C++ programming", "Java Programming", "Total", "Average", "Grade");
    }
     
}