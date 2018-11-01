
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String firstName, lastName, id;
    private double balance;
    private boolean CSC110, CSC142, CSC143;
    
    Student(String firstName, String lastName, String id) {
        this(firstName, lastName, id, false, false, false);
    }
    Student(String firstName, String lastName, String id, boolean csc110, boolean csc142, boolean csc143) {
        setFirstName(firstName);
        setLastName(lastName);
        setID(id);
        setCSC110(csc110);
        setCSC142(csc142);
        setCSC143(csc143);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getID() {
        return id;
    }
    public boolean getCSC110() {
        return CSC110;
    }
    public boolean getCSC142() {
        return CSC142;
    }
    public boolean getCSC143() {
        return CSC143;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        String chosenClass = "CSC110";
        if(CSC142) chosenClass = "CSC142";
        if(CSC143) chosenClass = "CSC143";
        String str = "The Name: " + firstName + " " + lastName + "\n";
        str += "ID: " + id + "\n";
        str += "The chosen class: " + chosenClass + "\n";
        str += "Credits: " + Department.NUM_CREDITS + "\n";
        str += "Credit Price: " + Department.COST_CREDIT + "\n";
        str += "The Balance: " + String.format("$%.2f", getBalance()) + "\n";
        return str;
    }
    public void setFirstName(String firstName) {
        if(firstName.equals(" ")) {
            throw new IllegalArgumentException("Firstname cannot be blank");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if(lastName.equals(" ")) {
            throw new IllegalArgumentException("lastname cannot be blank");
        }
        this.lastName = lastName;
    }
    public void setID(String id) {
        if(id.equals(" ")) {
            throw new IllegalArgumentException("ID cannot be blank");
        } else if (!id.matches("[0-9]{5,}")) {
            throw new IllegalArgumentException("ID is invalid, format must be like \"12345\"");
        }
        this.id = id;
    }
    public void setCSC110(boolean csc110) {
        if(csc110 && (CSC142 || CSC143)) {
            throw new IllegalArgumentException("Student cannot choose more than 1 class");
        }
        this.CSC110 = csc110;
        if(CSC110) balance = Department.COST_CREDIT * Department.NUM_CREDITS;
    }
    public void setCSC142(boolean csc142) {
        if(csc142 && (CSC110 || CSC143)) {
            throw new IllegalArgumentException("Student cannot choose more than 1 class");
        }
        this.CSC142 = csc142;
        if(CSC142) balance = Department.COST_CREDIT * Department.NUM_CREDITS;
    }
    public void setCSC143(boolean csc143) {
        if(csc143 && (CSC110 || CSC142)) {
            throw new IllegalArgumentException("Student cannot choose more than 1 class");
        }
        this.CSC143 = csc143;
        if(CSC143) balance = Department.COST_CREDIT * Department.NUM_CREDITS;
    }
    public static void test() {
        Student testStudent = new Student("Steve", "Santos", "150817");
        if(testStudent.getFirstName() != "Steve") System.out.println("ID should be Steve, but was " + testStudent.getFirstName());
        if(testStudent.getLastName() != "Santos") System.out.println("ID should be Santos, but was " + testStudent.getLastName());
        if(testStudent.getID() != "150817") System.out.println("ID should be 150817, but was " + testStudent.getID());
        if(testStudent.getCSC110()) System.out.println("CSC110 should be false, but was " + testStudent.getCSC110());
        if(testStudent.getCSC142()) System.out.println("CSC142 should be false, but was " + testStudent.getCSC142());
        if(testStudent.getCSC143()) System.out.println("CSC143 should be false, but was " + testStudent.getCSC143());
        if(testStudent.getBalance() != 0.0) System.out.println("Balance should be $0.00, but was " + String.format("$%.2f", testStudent.getBalance()));
        Student testStudent2 = new Student("Jeff", "Bezos", "950629671", false, true, false);
        if(testStudent2.getFirstName() != "Jeff") System.out.println("ID should be Jeff, but was " + testStudent.getFirstName());
        if(testStudent2.getLastName() != "Bezos") System.out.println("ID should be Bezos, but was " + testStudent.getLastName());
        if(testStudent2.getID() != "950629671") System.out.println("ID should be 950629671, but was " + testStudent.getID());
        if(testStudent2.getCSC110()) System.out.println("CSC110 should be false, but was " + testStudent.getCSC110());
        if(!testStudent2.getCSC142()) System.out.println("CSC142 should be true, but was " + testStudent.getCSC142());
        if(testStudent2.getCSC143()) System.out.println("CSC143 should be false, but was " + testStudent.getCSC143());
        if(testStudent2.getBalance() != 550.0) System.out.println("Balance should be $550.00, but was " + String.format("$%.2f", testStudent.getBalance()));
        //Student testStudent3 = new Student("Anthony", "ChewBezos", "950629671", true, true, false); //should throw an exception and it does
    }
}
