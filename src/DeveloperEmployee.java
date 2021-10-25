import java.util.Random;

public class DeveloperEmployee extends Employee{

    private Random random = new Random();
    private int fixedBugs;
    private static double defaultBugRate = 1.75;

    public DeveloperEmployee(long id, String name, int age, String gender, double salary, int fixedBugs){
        super(id, name, age, gender, salary);
        this.setFixedBugs(fixedBugs);
    }

    // get functions
    public long getFixedBugs(){
        return fixedBugs;
    }

    public double getDefaultBugRate(){
        return defaultBugRate;
    }
    
    //set functions
    public void setFixedBugs(int fixedBugs){
        this.fixedBugs = fixedBugs;
    }

    public double getTotalMonthSalary(){
        double totalMonthSalary = (this.getSalary() + (double) fixedBugs * defaultBugRate) * (random.nextBoolean() ? 2 : 0);
        return totalMonthSalary;

    }
    
}
