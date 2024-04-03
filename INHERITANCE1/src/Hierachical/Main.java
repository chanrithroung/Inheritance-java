package Hierachical;
import java.util.Scanner;
public class Main {

    // Student Menue
    public static void StudentMenue() {
        System.out.println("=====================================================\n1.Input Student\n2.Output Students\n3.Search Student\n4.Update Student\n5.Delete Student\n6.Insert Student\n7.Sort Student\n=======================================================\n");
    }

    public static void StudentProcess() {
        Scanner scanner = new Scanner(System.in);
        Students stu[] = new Students[0];
        Students.n = 0;
        int op;
        do {
            StudentMenue();
            System.out.print("Please select one option : ");
            op = scanner.nextInt();
            switch (op) {
                case 1: {
                    System.out.print("How many Student you want to add? : ");
                    Students.n = scanner.nextInt();
                    stu = new Students[Students.n];
                    Process.inputStudent(stu, Students.n);
                }break;
                case 2: {
                    if (Students.n > 0) {
                        Process.outputStudenst(stu, Students.n);
                    } else {
                        System.out.println("Sorry student list are empty");
                    }
                } break;
                case 3:{
                    System.out.println("Enter Student Id for Search : "); scanner.nextLine(); String searchId = scanner.nextLine();
                    int index = Process.searchStudent(stu, Students.n, searchId);
                    if(index > -1) {
                        Students.headerStu();
                        stu[index].output();
                    } else System.out.println("Sorry, student id ("+searchId+"), doesn't exits in student list");
                } break;
                case 4:{
                    Process.updateStudent(stu, Students.n);
                }break;
                case 5:{
                    System.out.print("Enter student id for delete : "); 
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    stu = Process.deleteStudent(stu, Students.n, id);
                    System.out.println("student delete successfully.");
                }break;
                
                case 6: {
                   stu = Process.insertStudent(stu);
                }break; 
                
                case 7:{
                    System.out.println("enter (a) for sort by ascending order.\nenter (d) for sort descending order.");                     
                    scanner.nextLine(); char sortMethod = scanner.nextLine().charAt(0);
                    switch(sortMethod) {
                        case 'a' :
                            Process.sortStu(stu, Process::ascCompare);
                        break;
                        case 'd' : 
                            Process.sortStu(stu, Process::dscCompare);
                        break;
                        default:
                            System.out.println("Invalid method sort....");
                        break;
                    }
                }break;
                default : System.out.println("You Seleced invalid method...."); break;
            }
        } while (op != 8);
    }

    public static void menueEmp() {
        System.out.println("=====================================================\n1.Input Employee\n2.Output Employee\n3.Search Meployee\n4.Update Employee\n5.Delete Employee\n6.Insert Employee\n7.Sort Employee\n=======================================================\n");
    }
    
     public static void searchEmp(Employee[] emp) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee id for search : "); String sid = scanner.nextLine();
        int index = Process.searchEmp(emp, sid);
        if(index > -1) {
            Employee.headerEmp();
            emp[index].output();
        }else
            System.out.println(sid+" not much any student id...");
    }
     
    public static void EmployeeProcess() {
        Scanner scanner = new Scanner(System.in);
        int op;
        Employee emp[] = new Employee[0];
        do {
            menueEmp();
            System.out.print(">>> Please select one option : "); op = scanner.nextInt();
            switch(op) {
                // input n employee
                case 1:{
                   System.out.print("How many employee would you like to enter?:");
                    Employee.n = scanner.nextInt();
                    emp = new Employee[Employee.n];
                    Process.inputEmp(emp);
                }break;
                // output n employee
                case 2: {
                    if(Employee.n <= 0) {
                        System.out.println("You never enter any employee...");
                    }else {
                         Process.outputEmployee(emp);
                    }
                }break;
                case 3:{
                    searchEmp(emp);
                }break;
                case 4:{
                    Process.updateEmp(emp);
                }break;
                case 5: {
                    emp = Process.deleteEmp(emp);
                }break;
                case 6 : {
                    emp = Process.insertEmployee(emp);
                }break;
                case 7: {
                    System.out.print("Sort employee by amount.\nEnter a for ascending and d for descending : ");
                    scanner.nextLine();char sortMethod = scanner.nextLine().charAt(0);
                    switch(sortMethod) {
                        case 'a': {
                            Process.sortEmp(emp, Process::ascCompare);
                        }break;
                         case 'd': {
                            Process.sortEmp(emp, Process::dscCompare);
                        }break;
                    }
                    Process.outputEmployee(emp);
                }break;
            }
        }while(op != 8);
}
    
    
    public static void DocterMenue() {
        System.out.println("=====================================================\n1.Input Docter\n2.Output Docter\n3.Search Docter\n4.Update docter\n5.Delete Docter\n6.Insert Docter\n7.Sort Docter\n=======================================================\n");
    }
    
    public static void DocterProcess() {
        Scanner scanner = new Scanner(System.in);
        Docter doc[] = new Docter[0];
        int op;
        do{
            DocterMenue();
            System.out.print("Select one case for process : "); op = scanner.nextInt();
            switch(op) {
                case 1 :{
                    System.out.print("How many docter you want to enter? : "); Docter.n = scanner.nextInt();
                    doc = new Docter[Docter.n];
                    Process.InputDocter(doc);
                }break;
                case 2:{
                    Process.outputDoc(doc);
                }break;
                case 3:{
                    System.out.println("Enter docter id for search : "); scanner.nextLine(); String sid= scanner.nextLine();
                    int index = Process.searchDoc(doc, sid);
                    if(index > -1) {
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }else {
                        System.out.println("The id of Docter you want to search doesn't exits in docter list.");
                    }
                }break;
                case 4:{
                    Process.updateDoc(doc);
                }break;
                case 5 :{
                    doc = Process.deleteDoc(doc);
                }break;
                case 6 :{
                    doc = Process.insertDoc(doc);
                }break;
                case 7:{
                    char sortMethod; 
                    System.out.println("enter a for sort ascending order and d for sort descending order.");
                    System.out.print("Enter here : "); scanner.nextLine(); sortMethod = scanner.nextLine().charAt(0);
                    switch(sortMethod) {
                        case 'a' : {
                            Process.sortDoc(doc, Process::ascCompare);
                        }break;
                        case 'd' : {
                            Process.sortDoc(doc, Process::dscCompare);
                        }break;
                        default : System.out.println("Invalid sort method..."); break;
                    }
                }break;
                case 8:{
                    System.out.println("You exited Docter...");
                }break;
                default : System.out.println("You enterd the invalid method...."); break;
            }
        }while(op != 8);
    }
    
    public static void mainMenu() {
        System.out.println("===================================");
        System.out.println("[1].Student");
        System.out.println("[2].Employee");
        System.out.println("[3].Docter");
        System.out.println("[4].Exit");
        System.out.println("===================================");
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int menu_num;
        do {
            mainMenu();
            System.out.print("select one option : "); menu_num = scanner.nextInt();
            switch(menu_num) {
                case 1:{
                    StudentProcess();
                }break;
                case 2:{
                    EmployeeProcess();
                }break;
                case 3:{
                    DocterProcess();
                }break;
                case 4:{
                    System.out.println("You are exited the program.");
                }break;
                default : System.out.println("You selected invalid menue.");break;
            }
        }while(menu_num != 4);
    } 
}