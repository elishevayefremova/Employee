public class DesignerEmployee extends Employee{

    private int workedDays;
    private double rate = 4.5;

    public DesignerEmployee(long id, String name, int age, String gender, double salary, int workerdDays){
        super(id, name, age, gender, salary);
        this.setWorkedDays(workerdDays);
    }

    // get functions
    public int getWorkedDays(){
        return workedDays;
    }

    public double getRate(){
        return rate;
    }

    @Override
    public double getTotalMonthSalary(){
        double totalMonthSalary = this.getSalary() + (double) workedDays * rate;
        return totalMonthSalary;

    }

    // set functions
    public void setWorkedDays(int workedDays){
        this.workedDays = workedDays;
    }
    
    public void setRate(double rate){
        this.rate = rate;
    }



    

    
}
