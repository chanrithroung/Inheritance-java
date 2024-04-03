package Hierachical;
import java.util.Scanner;
public class Process {
    /// @Students 
    public static void inputStudent(Students stu[], int n) {
        for(int i = 0 ; i < n; i++) {
            stu[i] = new Students();
            System.out.println("=============[ Student#"+(i+1)+"]=============");
            stu[i].input();
        }
    }

    public static void outputStudenst(Students  []stu, int n) {
        Students.headerStu();
        for(int i = 0; i < n; i++) {
           stu[i].output();
        }
    }
    
    public static int searchStudent(Students[] stu, int n, String sid) { // return the index of student if found else return -1
        int index  = -1;
        for(int i = 0 ; i < n; i++) {
            if(stu[i].getID().equalsIgnoreCase(sid)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public static void MenueUpdate() {
        System.out.println("Update list\n[1].Id\n[2].Name\n[3].Gender\n[4].Date of birth\n[5].Score1\n[6].Sore2\n[7].Score3 \n[8].One Record\n[9].Exit");
    }
    
    // @Update student
    // this method provide user to update student Data such as Id, name, gender, score1,  score3
    // and update by one record
    public static void updateStudent(Students[] stu, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of student you want to update : "); String sid = scanner.nextLine();
        int index = searchStudent(stu, n, sid);
        if(index > -1) {
            int op;
            do{
                System.out.println("=======[ You are updating Student "+(index+1)+" ]========");
                MenueUpdate();
                System.out.print("Select one option : "); op = scanner.nextInt();
                switch(op){
                    // @update student id
                    case 1 :{
                        boolean hasDuplicate;
                        String newId;
                        // @protect user enter the id already exit.
                        scanner.nextLine();
                        do{
                            hasDuplicate = false;
                            System.out.print("Enter new student id : ");  newId = scanner.nextLine();
                            for(int i = 0 ; i < n; i++) 
                                if(stu[i].getID().equalsIgnoreCase(newId)) hasDuplicate = true;
                            if(hasDuplicate) System.out.println(newId+" already has in students list. Please enter new Id");
                        }while(hasDuplicate);
                        stu[index].setID(newId);
                        System.out.println("Student id updated successfully.");
                    }break;
                    
                    // @update Student name
                    case 2:{
                        String newName;
                        System.out.print("Enter new student name : "); scanner.nextLine(); newName = scanner.nextLine();
                        stu[index].setName(newName);
                        System.out.println("Student name updated successfully.");
                    }break;
                    
                    //@update student gender
                    case 3:{
                        System.out.print("Entet new Studnet gender");
                        // Clear buffer
                        scanner.nextLine(); 
                        String newGender = scanner.nextLine();
                        stu[index].setGender(newGender);
                        System.out.println("Student gender upated successfully.");
                    }break;
                    // @update student DOB.
                    case 4: {
                        System.out.print("Enter new student date of birth : "); scanner.nextLine(); String newDob = scanner.nextLine();
                        stu[index].setDob(newDob);
                        System.out.println("Student Date of birth updated successfuly.");
                    }break;
                    case 5:{
                        System.out.print("Enter new  C programming score: "); int newScore1 = scanner.nextInt();
                        stu[index] = new Students(newScore1, stu[index].getScore2(), stu[index].getScore3(), stu[index].getID(), stu[index].getName(), stu[index].getGender(), stu[index].getDob());
                        System.out.println("C Progamming score updated successfully.");
                    }break;

                    // @update socre2
                    case 6: {
                        System.out.print("Enter new C++ programming score : "); int newScore2 = scanner.nextInt();
                        stu[index] = new Students(stu[index].getScore1(), newScore2, stu[index].getScore3(), stu[index].getID(), stu[index].getName(), stu[index].getGender(), stu[index].getDob());
                        System.out.println("C++ Score Updated successfully.");
                    }break;
                    // @update score3
                    case 7:{
                        System.out.println("Enter new Java Programming score : "); int newScore3 = scanner.nextInt();
                        stu[index] = new Students(stu[index].getScore1(), stu[index].getScore2(), newScore3, stu[index].getID(), stu[index].getName(), stu[index].getGender(), stu[index].getDob());
                        System.out.println("Java programming score updated  successfully.");
                    }break;
                    // @update one record.
                    case 8:{
                        System.out.println("==========[ Updating student "+(index+1)+" ]============");
                        stu[index].input();
                        System.out.println("Student data updated successfully.");
                    }break;
                    case 9:{
                        System.out.println("You are exited the updated.");
                    }break;
                    default:{
                        System.out.println("You selected invalid method for update...");
                    }break;
                }
        }while(op != 9);
        } else {
            System.out.println("ID you enterd doesn't exits in student id list.");
        }
    }
    
    // @Delete Student by id.
    // Thise function will return the list of student that doesn't eixts the student you want to delete
    public static Students []deleteStudent(Students stu[], int n, String id) {
        int index = searchStudent(stu, n, id);
        Students newStu[];
        if(index > -1) {
            newStu = new Students[n-1];
            int j = 0;
            for(int i = 0; i < n; i++) {
                if(i != index) {
                    newStu[j] = stu[i];
                    j++;
                }
            }
            // Increase number of students by one becuase we delete one students
            Students.n--;
            return newStu;
        }else{
            System.out.println(id+" doesn't exits in students list.");
            return stu;
        }
   }

// @Insert Student
    public static Students[] insertStudent(Students stu[]) {
        Scanner scanner = new Scanner(System.in);
        int pos;
        do {
            System.out.print("Enter psotion you want to insert (1->"+Students.n+") : ");pos = scanner.nextInt();
            if(pos > Students.n || pos < 0) System.out.println("You entered invalid pos : ");            
        }while(pos > Students.n || pos < 0);
        Students.n++;
        Students newStu[] = new Students[Students.n + 1];
        int j = 0;
        for(int i = 0 ; i < Students.n; i++) {
            newStu[i] = new Students();
            if(pos-1 == i) newStu[i].input();
            else {
                newStu[i]=stu[j];
                j++;
            }
        }
        return newStu;
    }

    
    // Ascending compare
    public static boolean ascCompare(double a, double b) {
        return a > b;
    }
    
    // Descending Compare
    public static boolean dscCompare(double a, double b) {
        return a < b;
    }
    
    // @swap the element in array.
    public static void swap(Students st[], int a, int b) {
        Students t = new Students();
        t=st[a];
        st[a] = st[b];
        st[b] = t;
    }
    
    public static void sortStu(Students st[], Compare cm) {
        for(int i = 0; i < Students.n - 1; i++) 
            for(int j = i+1; j < Students.n; j++) 
                if(cm.compre(st[i].getAverage(), st[j].getAverage())) swap(st, i, j);
    }
    
    interface Compare {
        boolean compre(double a, double b);
    }
    
    
    // @End Students
    // @Employee 
    public static void inputEmp(Employee emp[]) {
        for(int i = 0 ; i < Employee.n; i++) {
            System.out.println("=========[ Employee " + (i+1) + "]===========");
            emp[i]= new Employee();
            emp[i].inputEmployee();
        }
    }
    
    public static void outputEmployee(Employee emp[]) {
        Employee.headerEmp();
        for(int i = 0; i < Employee.n; i++) {
            emp[i].outputEmp();
        }
    }
    
    
    // search emplopyee by emp id
    public static int searchEmp(Employee[] emp, String sid) {
        int index = -1;
        for(int i = 0;  i < Employee.n; i++) {
           if(emp[i].getID().equalsIgnoreCase(sid)) index = i;
        }
        return index;
    }
    
    public static void updateEmpMenue() {
        System.out.println("Here are update metod allow you to update employee data....");
        String m = "[1].ID\n[2].NAME\n[3].GENDER\n[4].DATE OF BIRTH\n[5].Position\n[6].SALARY\n[7].BONUS\n[8].OVERTIME\n[9].RATE\n[10].EXIT";
        System.out.println(m);
    }
    
    
    // @Update employee
    public static void updateEmp(Employee emp[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee id for search and update : "); String sid = scanner.nextLine();
        
        int index = searchEmp(emp, sid);
        if(index > -1) { 
            int op;
            System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
            emp[index].output();
            do{
                updateEmpMenue();
                System.out.print("enter number of method for exercute update : "); op = scanner.nextInt();
                switch(op) {
                    case 1:{
                        System.out.print("Enter new employee id : "); scanner.nextLine(); String newID  = scanner.nextLine();
                        emp[index].setID(newID);
                        System.out.println("Employee id updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break; 
                    case 2:{
                        System.out.print("Enter new employee name : "); scanner.nextLine(); String newName  = scanner.nextLine();
                        emp[index].setName(newName);
                        System.out.println("Employee name updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 3:{
                        System.out.print("Enter new employee gender : "); scanner.nextLine(); String newGender  = scanner.nextLine();
                        emp[index].setGender(newGender);
                        System.out.println("Employee gender updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 4:{
                        System.out.print("Enter new employee date of birth : "); scanner.nextLine(); String newDob  = scanner.nextLine();
                        emp[index].setDob(newDob);
                        System.out.println("Employee date of birth updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 5:{
                        System.out.print("Enter new employee postion : "); scanner.nextLine(); String newPos = scanner.nextLine();
                        emp[index].setPostion(newPos);
                        System.out.println("Employee position updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 6:{
                        System.out.print("Enter employee new salary : "); double newSalary  = scanner.nextDouble();
                        emp[index] = new Employee(emp[index].getID(), emp[index].getName(), emp[index].getGender(), emp[index].getDob(), emp[index].getPostion(), newSalary, emp[index].getBonus(), emp[index].getOvertime(), emp[index].getRate());
                        System.out.println("Employee salary updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 7:{
                        System.out.print("Enter employee new Bonnus : "); double newBonus = scanner.nextDouble();
                        emp[index] = new Employee(emp[index].getID(), emp[index].getName(), emp[index].getGender(), emp[index].getDob(), emp[index].getPostion(), emp[index].getSalary(), newBonus, emp[index].getOvertime(), emp[index].getRate());
                        System.out.println("Employee bonus updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 8:{
                        System.out.print("Enter employee new overtime : "); int newOvertime = scanner.nextInt();
                        emp[index] = new Employee(emp[index].getID(), emp[index].getName(), emp[index].getGender(), emp[index].getDob(), emp[index].getPostion(), emp[index].getSalary(), emp[index].getBonus(), newOvertime, emp[index].getRate());
                        System.out.println("Employee overtime updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 9:{
                        System.out.print("Enter employee new Rate : "); double newRate = scanner.nextDouble();
                        emp[index] = new Employee(emp[index].getID(), emp[index].getName(), emp[index].getGender(), emp[index].getDob(), emp[index].getPostion(), emp[index].getSalary(), emp[index].getBonus(), emp[index].getOvertime(), newRate);
                        System.out.println("Employee rate updated successfully.");
                        System.out.println("\n===================================\n|| Data of Employee before update ||\n===================================");
                        Employee.headerEmp();
                        emp[index].outputEmp();
                        System.out.println("press enter for continue...");
                        scanner.nextLine();
                    }break;
                    case 10 : {
                        System.out.println("You exit the update....");
                    }break;
                    default : 
                        System.out.println("Invalid seleceted menue number....");
                        break;
                }
            }while(op!=10);
        }
    }
    
    
    // @Delete Employee
    public static Employee[] deleteEmp(Employee emp[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee id for search for delete : "); String sid = scanner.nextLine();
        Employee temp_emp[] = new Employee[Employee.n - 1];
        int index = searchEmp(emp, sid);
        int j = 0;
        if(index > -1) {
            for(int i = 0; i < Employee.n; i++) {
                if(i != index) {
                    temp_emp[j] = new Employee();
                    temp_emp[j++] = emp[i];
                }
            }
            Employee.n--;
        }else {
            System.out.println("This employee doesn't exits in students list....");
        }
        return temp_emp;
    }
    
    //@ Insert Student
    // This function will return the array of employee that has new emp object inserted.
    public static Employee[] insertEmployee(Employee[] emp) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available position on list for insert(1->"+(Employee.n)+").");
        int pos;
        Employee temp_emp[] = new Employee[Employee.n + 1];
        do {
            System.out.print("Enter position for insert : "); pos = scanner.nextInt();
            if(pos > Employee.n || pos < 1)
                System.out.println("Invalid position for insert.....");
            
        }while(pos > Employee.n || pos < 1);
        // decrease pos by one for match the array index.
        pos--;
        int j = 0;
        Employee.n++;
        for(int i = 0; i < Employee.n; i++) {
            temp_emp[i] = new Employee();
            if(i == pos) {
                System.out.println(">>>>>> Enter new employee for insert....");
                temp_emp[i].inputEmployee();
            }else{
                temp_emp[i] = emp[j];
                j++;
            }
        }
        return temp_emp;
    }
    
    //@ Swap employee
    public static void swapEmp(Employee emp[], int a, int b) {
        Employee t = new Employee();
        t = emp[a]; 
        emp[a] = emp[b];
        emp[b] = t;
    }
    
    public static void sortEmp(Employee emp[], Compare cmp) {
        for(int i = 0; i < Employee.n - 1; i++)
            for(int j = i+1; j < Employee.n; j++) 
                if(cmp.compre(emp[i].getAmount(), emp[j].getAmount())) swapEmp(emp, i, j);
    }
    
    
    /// Doctor
    public static void InputDocter(Docter doc[]) {
       
        for(int i = 0; i < Docter.n; i++) {
            doc[i] = new Docter();
            System.out.println("\n========[ Docter "+Docter.n+"]========");
            doc[i].inputDoc();
        }
    }
    
    // Output Docter
    public static void outputDoc(Docter doc[]) {
        Docter.headerDoc();
        for(int i = 0; i < Docter.n; i++) {
            doc[i].outputDoc();
        }
    }
    
    public static int searchDoc(Docter[] doc, String sid) {
        for(int i = 0 ; i < Docter.n; i++)
            if(doc[i].getID().equalsIgnoreCase(sid)) return i;
        return -1;
    }
    
    
    
    public static void updateDocMenu() {
        System.out.println("Update Docter menu list : \n=============\n[1].ID\n[2].NAME\n[3].GENDER\n[4].DATE OF BIRTH\n[5].MAJOR\n[6].EXPERIENCE\n[7].CONTACT\n[8].SALARY");
    }
    
    public static void updateDoc(Docter doc[]) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter docter id for update : "); String sid = scanner.nextLine();
        int index = searchDoc(doc, sid);
        if(index > -1) {
            System.out.println("You are updating:");
            Docter.headerDoc();
            doc[index].outputDoc();
            int op;
            do {
                updateDocMenu();
                System.out.print("Select one method for update : "); op = scanner.nextInt();
                
                switch(op) {
                    case 1 : {
                        System.out.print("Enter new docter id for update : "); scanner.nextLine(); String newId = scanner.nextLine();
                        doc[index].setID(newId);
                        System.out.println("Docter id has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 2 : {
                        System.out.print("Enter new docter name for update : "); scanner.nextLine(); String newName = scanner.nextLine();
                        doc[index].setName(newName);
                        System.out.println("Docter name has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 3 : {
                        System.out.print("Enter new docter gender for update : "); scanner.nextLine(); String newGender = scanner.nextLine();
                        doc[index].setGender(newGender);
                        System.out.println("Docter gender has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 4 : {
                        System.out.print("Enter new docter date of birth for update : "); scanner.nextLine(); String newDob = scanner.nextLine();
                        doc[index].setDob(newDob);
                        System.out.println("Docter date of birth has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 5 : {
                        System.out.print("Enter new docter major for update : "); scanner.nextLine(); String newMajor = scanner.nextLine();
                        doc[index].setMajor(newMajor);
                        System.out.println("Docter major has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 6 : {
                        System.out.print("Enter new docter id for update : ");  int newExperence = scanner.nextInt();
                        doc[index].setExperience(newExperence);
                        System.out.println("Docter experience has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 7 : {
                        System.out.print("Enter new docter contacet for update : "); scanner.nextLine(); String newContact = scanner.nextLine();
                        doc[index].setContact(newContact);
                        System.out.println("Docter contact has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 8 : {
                        System.out.print("Enter new docter salary for update : ");double newSalary = scanner.nextDouble();
                        doc[index].setSalary(newSalary);
                        System.out.println("Docter salary has been updated successfully.");
                        Docter.headerDoc();
                        doc[index].outputDoc();
                    }break;
                    case 9 : {
                        System.out.println("You are exited the update....");
                    }break;
                    default : {
                        System.out.println("You entered invalid menu");
                    }break;
                }
            }while(op!=9);
            
        } else {
            System.out.println("The docter id you want ot update doesn't exits in docter list.");
        }
    }
    
    
    //@delete docter
    public static Docter[] deleteDoc(Docter doc[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter docter id for find and delete : "); String del_id = scanner.nextLine();
        int index = searchDoc(doc, del_id);
        Docter temp_doc[];
        if(index > -1) {
            int j = 0;
            temp_doc = new Docter[Docter.n -1];
            for(int i = 0 ; i  < Docter.n; i++) {
                if(i != index) temp_doc[j++] = doc[i];
            }
            Docter.n--;
        }else {
            System.out.println("The id of docter you want to delete are not exit in docter list.");
            return doc;
        }
        return temp_doc;
    }
    
    
    // Insert Doc
    public static Docter[] insertDoc(Docter doc[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available position for update from (1 to "+Docter.n+") : ");
        int pos;
        do {
            System.out.print("Enter valid position for insert : "); pos = scanner.nextInt();
            if(pos > Docter.n || pos < 1) {
                 System.out.println("You entered invalid postion!\nPlease enter the valid postion...");
            }
        }while(pos > Docter.n || pos < 1);
        Docter.n++;
        pos--;
        Docter temp_doc[] = new Docter[Docter.n + 1];
        int j = 0;
        for(int i = 0 ; i < Docter.n; i++) {
            temp_doc[i] = new Docter();
            if(i == pos) {
                System.out.println("Let enter docter data for insert =>");
                temp_doc[i].inputDoc();
            }else {
                temp_doc[i] = doc[j++];
            }
        }
        return doc;
    }
    
    
    public static void swapdoc(Docter doc[], int a, int b) {
        Docter tempDoc = new Docter();
        tempDoc = doc[a];
        doc[a] = doc[b];
        doc[b] = tempDoc;
    }
    
    public static void sortDoc(Docter doc[], Compare cpm) {
        for(int i = 0; i < Docter.n -1; i++)
            for(int j = i+1; j < Docter.n; j++) 
                if( cpm.compre(doc[i].getSalary(), doc[j].getSalary())) swapdoc(doc, i, j);
    }
    
    
}