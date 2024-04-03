package Hierachical;
import java.nio.file.Files;
import java.util.Scanner;

public class Employee extends Person {
    protected String position;
    protected double salary;
    protected double bonus;
    protected int overtime;
    protected double rate;
    protected double baseSalary;
    protected double tax;
    protected double amount;
    
    public static int n;
    
    public Employee() {
    }
    
    public double findTax() {
        return (this.baseSalary > 500) ? 5 : (this.baseSalary > 100) ? 10 : 15;
    }
    
    
    public double findBaseSalary() {
        return this.salary + this.bonus +(this.overtime * this.rate);
    }
    
    public double findAmount() {
        return this.baseSalary  - ((baseSalary * tax) / 100);
    }
    
    public Employee(String id, String name, String gender, String dob, String position, double salary, double bonus, int overtime, double rate) {
        super(id, name, gender, dob);
        this.position = position;
        this.salary   = salary;
        this.bonus = bonus;
        this.overtime = overtime;
        this.rate = rate;
        baseSalary = findBaseSalary();
        tax = findTax();
        amount = findAmount();
        
    }

    public void output() {
        super.output();
        System.out.printf("%-15s%-15f%-15s%-10d%-15f%-20f%-10f%-10f\n", this.position, this.salary, this.bonus, this.overtime, this.rate, this.baseSalary, this.baseSalary, this.tax, this.amount);
    }
    
    // @Override
    public static void header() {
        Person.header();
        System.out.printf("%-15s%-15s%-15s%-10s%-15s%-20s%-10s%-10s", "Postion", "Salary", "Bonus", "Rate", "BaseSalary", "Tax", "Amount");
    }
    
    // getter
    public String getPostion() { return this.position; }
    public double getSalary() { return this.salary; }
    public double getBonus() { return this.bonus; }
    public int getOvertime() { return this.overtime; }
    public double getRate() { return this.rate; } 
    public double getBaseSalary() { return this.baseSalary; }
    public double getTax() { return this.tax; }
    public double getAmount() { return this.amount; }
    
    
    // Setter
    public void setPostion(String position) { this.position = position; return; }
    public void setSalary(double salary) { this.salary = salary; return; }
    public void setBonus(double bonus) { this.bonus = bonus; return; }
    public void setOvertime(int overtime) { this.overtime = overtime; return; }
    public void setTax(double tax) { this.tax = tax; return; }
    
    
    public static String readData(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee "+s+" : ");
        String data = scanner.nextLine();
        return data;
    }
    public void inputEmployee() {
        Scanner scanner = new Scanner(System.in);
        super.input("employee");
        this.position = readData("postion");
        this.salary = Double.parseDouble(readData("salary")); 
        this.bonus = Double.parseDouble(readData("Bonus"));
        System.out.print("This employee has overtime? (yes/no) : ");String status = scanner.nextLine();
        if(status.equals("yes")) {            
            this.overtime = Integer.parseInt(readData("overtime"));
            this.rate  = Double.parseDouble(readData("rate"));
        }else {
            this.overtime = 0;
            this.rate = 0.00;
        }
        this.baseSalary = findBaseSalary();
        this.tax = findTax();
        this.amount = findAmount();
    }
    
    public void outputEmp(){
        super.output();
        System.out.printf("%-15s%-15.2f%-15.2f%-10d%-10.2f%-15.2f%-10.2f%-15.2f\n", this.position, this.salary, this.bonus, this.overtime, this.rate, this.baseSalary, this.tax, this.amount);    
    }
    public static void headerEmp() {
        Person.header();
        System.out.printf("%-15s%-15s%-15s%-10s%-10s%-15s%-10s%-15s\n", "Postion", "Salary" ,"Bonus", "Overtime", "Rate", "Basesalary", "Tax" ,"Amount");
    }
}
