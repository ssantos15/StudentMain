
/**
 * Write a description of class Department here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Department
{
    private static final double GROUP_SIZE = 28.0;
    public static final double COST_CREDIT = 110.0;
    public static final int NUM_CREDITS = 5;
    private int totalCSC110, totalCSC142, totalCSC143, totalStudents;
    private double totalBalance;
    Department() {
        this(0,0,0,0.0);
    }
    Department(int totalStud110, int totalStud142, int totalStud143, double totalBalance) {
        if(totalStud110 < 0 || totalStud142 < 0 || totalStud143 < 0) {
            throw new IllegalArgumentException("Total students in any department cannot be less than zero");
        }
        totalCSC110 = totalStud110;
        totalCSC142 = totalStud142;
        totalCSC143 = totalStud143;
        totalStudents = totalCSC110 + totalCSC142 + totalCSC143;
        this.totalBalance = totalBalance;
    }
    public int getTotalCSC110 () {
        return totalCSC110;
    }
    public int getTotalCSC142 () {
        return totalCSC142;
    }
    public int getTotalCSC143 () {
        return totalCSC143;
    }
    public int getTotalStudents() {
        return totalStudents;
    }
    public double getTotalBalance() {
        return totalBalance;
    }
    public int getTotalGr110() {
        return (int)Math.ceil(totalCSC110 / GROUP_SIZE);
    }
    public int getTotalGr142() {
        return (int)Math.ceil(totalCSC142 / GROUP_SIZE);
    }
    public int getTotalGr143() {
        return (int)Math.ceil(totalCSC143 / GROUP_SIZE);
    }
    @Override
    public String toString() {
        String str = "Total students in CSC110: " + getTotalCSC110() + " in " + getTotalGr110() + " groups " + "\n";
        str+= "Total students in CSC142: " + getTotalCSC142() + " in " + getTotalGr142() + " groups " + "\n";
        str+= "Total students in CSC143: " + getTotalCSC143() + " in " + getTotalGr143() + " groups " + "\n";
        str += "Total Students in the department: " + getTotalStudents() + "\n";
        str += "Total Balance: " + String.format("$%.2f", getTotalBalance()) + "\n";
        return str;
    }
    // method to add a Student to the department
  
    public void addStudent(Student newStudent) {
        //register to CSC110
        if(newStudent.getCSC110() && !newStudent.getCSC142() && !newStudent.getCSC143()) {
            ++totalCSC110;
            ++totalStudents;
        }
        //register to CSC142
        if(newStudent.getCSC142() && !newStudent.getCSC110() && !newStudent.getCSC143()) {
            ++totalCSC142;
            ++totalStudents;
        }
        //register to CSC143
        if(newStudent.getCSC143() && !newStudent.getCSC110() && !newStudent.getCSC142()) {
            ++totalCSC143;
            ++totalStudents;
        }
        totalBalance = totalStudents * NUM_CREDITS * COST_CREDIT;
    }
    public static void test() {
        Student testStudent = new Student("Steve", "Santos", "150817");
        Student testStudent2 = new Student("Jeff", "Bezos", "950629671", false, true, false);
        Department testDepartment = new Department();
        if(testDepartment.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment.getTotalCSC110());
        if(testDepartment.getTotalCSC142() != 0) System.out.println("CSC142 should be 0, but was " + testDepartment.getTotalCSC142());
        if(testDepartment.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment.getTotalCSC143());
        if(testDepartment.getTotalStudents() != 0) System.out.println("Total Students should be 0, but was " + testDepartment.getTotalStudents());
        if(testDepartment.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment.getTotalGr110());
        if(testDepartment.getTotalGr142() != 0) System.out.println("TotalGr142 Students should be 0, but was " + testDepartment.getTotalGr142());
        if(testDepartment.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment.getTotalGr143());
        if(testDepartment.getTotalBalance() != 0.0) System.out.println("Balance should be $0.00, but was " + String.format("$%.2f", testDepartment.getTotalBalance()));
        testDepartment.addStudent(testStudent);
        if(testDepartment.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment.getTotalCSC110());
        if(testDepartment.getTotalCSC142() != 0) System.out.println("CSC142 should be 0, but was " + testDepartment.getTotalCSC142());
        if(testDepartment.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment.getTotalCSC143());
        if(testDepartment.getTotalStudents() != 0) System.out.println("Total Students should be 0, but was " + testDepartment.getTotalStudents());
        if(testDepartment.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment.getTotalGr110());
        if(testDepartment.getTotalGr142() != 0) System.out.println("TotalGr142 Students should be 0, but was " + testDepartment.getTotalGr142());
        if(testDepartment.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment.getTotalGr143());
        if(testDepartment.getTotalBalance() != 0.0) System.out.println("Balance should be $0.00, but was " + String.format("$%.2f", testDepartment.getTotalBalance()));
        testDepartment.addStudent(testStudent2);
        if(testDepartment.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment.getTotalCSC110());
        if(testDepartment.getTotalCSC142() != 1) System.out.println("CSC142 should be 1, but was " + testDepartment.getTotalCSC142());
        if(testDepartment.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment.getTotalCSC143());
        if(testDepartment.getTotalStudents() != 1) System.out.println("Total Students should be 1, but was " + testDepartment.getTotalStudents());
        if(testDepartment.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment.getTotalGr110());
        if(testDepartment.getTotalGr142() != 1) System.out.println("TotalGr142 Students should be 1, but was " + testDepartment.getTotalGr142());
        if(testDepartment.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment.getTotalGr143());
        if(testDepartment.getTotalBalance() != 550.0) System.out.println("Balance should be $550.00, but was " + String.format("$%.2f", testDepartment.getTotalBalance()));
        Department testDepartment2 = new Department(0, 1, 0, 550.0);
        if(testDepartment2.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment2.getTotalCSC110());
        if(testDepartment2.getTotalCSC142() != 1) System.out.println("CSC142 should be 1, but was " + testDepartment2.getTotalCSC142());
        if(testDepartment2.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment2.getTotalCSC143());
        if(testDepartment2.getTotalStudents() != 1) System.out.println("Total Students should be 1, but was " + testDepartment2.getTotalStudents());
        if(testDepartment2.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment2.getTotalGr110());
        if(testDepartment2.getTotalGr142() != 1) System.out.println("TotalGr142 Students should be 1, but was " + testDepartment2.getTotalGr142());
        if(testDepartment2.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment2.getTotalGr143());
        if(testDepartment2.getTotalBalance() != 550.0) System.out.println("Balance should be $550.00, but was " + String.format("$%.2f", testDepartment2.getTotalBalance()));
        testDepartment2.addStudent(testStudent);
        if(testDepartment2.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment2.getTotalCSC110());
        if(testDepartment2.getTotalCSC142() != 1) System.out.println("CSC142 should be 1, but was " + testDepartment2.getTotalCSC142());
        if(testDepartment2.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment2.getTotalCSC143());
        if(testDepartment2.getTotalStudents() != 1) System.out.println("Total Students should be 1, but was " + testDepartment2.getTotalStudents());
        if(testDepartment2.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment2.getTotalGr110());
        if(testDepartment2.getTotalGr142() != 1) System.out.println("TotalGr142 Students should be 1, but was " + testDepartment2.getTotalGr142());
        if(testDepartment2.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment2.getTotalGr143());
        if(testDepartment2.getTotalBalance() != 550.0) System.out.println("Balance should be $550.00, but was " + String.format("$%.2f", testDepartment2.getTotalBalance()));
        testDepartment2.addStudent(testStudent2);
        if(testDepartment2.getTotalCSC110() != 0) System.out.println("CSC110 should be 0, but was " + testDepartment2.getTotalCSC110());
        if(testDepartment2.getTotalCSC142() != 2) System.out.println("CSC142 should be 2, but was " + testDepartment2.getTotalCSC142());
        if(testDepartment2.getTotalCSC143() != 0) System.out.println("CSC143 should be 0, but was " + testDepartment2.getTotalCSC143());
        if(testDepartment2.getTotalStudents() != 2) System.out.println("Total Students should be 2, but was " + testDepartment2.getTotalStudents());
        if(testDepartment2.getTotalGr110() != 0) System.out.println("TotalGr110 should be 0, but was " + testDepartment2.getTotalGr110());
        if(testDepartment2.getTotalGr142() != 1) System.out.println("TotalGr142 Students should be 1, but was " + testDepartment2.getTotalGr142());
        if(testDepartment2.getTotalGr143() != 0) System.out.println("TotalGr143 Students should be 0, but was " + testDepartment2.getTotalGr143());
        if(testDepartment2.getTotalBalance() != 1100.0) System.out.println("Balance should be $1100.00, but was " + String.format("$%.2f", testDepartment2.getTotalBalance()));
    }
}

