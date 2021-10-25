public class Employee {

    private long id;
    private String name = "";
    private int age;
    private double salary;
    private String gender;

    Employee(long id, String name, int age, String gender, double salary) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setSalary(salary);
    }


    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public double getSalary(){
        return this.salary;
    }

    public double getTotalMonthSalary(){
        return this.salary;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "id - " + id +
                ", name - " + name +
                ", age - " + age +
                ", gender - " + gender + 
                ", salary - " + salary;
    }

   

}