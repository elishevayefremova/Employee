import java.util.Random;

public class EmployeeFactory {
    Random random = new Random();

    private static String employeeMaleNames[] = {"Kolya", "Roman", "Denis", "Matvey", "Sergey", "Oleg", "Vladimir", "Ivan", "Andrey", "Oleg", "Artem", "Mark", "Rodion"};
    private static String employeeFamaleNames[] = {"Kseniya", "Kate", "Daria", "Veronika", "Mary", "Sasha", "Nastya", "Nadya", "Sveta", "Natasha", "Viktoria", "Julia", "Marina"};

    // генерирует случайным образом заданое количество сотрудников
    Employee[] generateEmployees(int size) {
        Employee[] newEmployeesArray = new Employee[size];
        for (int i = 0; i<newEmployeesArray.length; i++) {

            int employeeType = random.nextInt(3);

            long id = i;
            String name = "";
            int age = random.nextInt(40) + 18;
            
            boolean gender = random.nextBoolean();

            double salary = random.nextDouble() * 5000;
            String genderName = null;
            
            if (gender){
                genderName = "woman";
                name = employeeFamaleNames[random.nextInt(employeeFamaleNames.length)];
            } else {
                genderName = "man";
                name = employeeMaleNames[random.nextInt(employeeMaleNames.length)];
            }
            
    
            if (employeeType == 0){
                newEmployeesArray[i] = new ManagerEmployee(id, name, age, genderName, salary);
            } else if (employeeType == 1){
                int workedDays =  random.nextInt(22);
                newEmployeesArray[i] = new DesignerEmployee(id, name, age, genderName, salary, workedDays);
            } else if (employeeType == 2){
                int fixedBugs = random.nextInt(50);
                newEmployeesArray[i] = new DeveloperEmployee(id, name, age, genderName, salary, fixedBugs);
            }
        }

        return newEmployeesArray;
    };

}
