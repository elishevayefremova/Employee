public class Test {
    public static void main(String[] args){

        EmployeeFactory employeefactory = new EmployeeFactory();

        Employee[] mainEmployees = employeefactory.generateEmployees(10);

        EmployeeService employeeService = new EmployeeService(mainEmployees);

       
        
        System.out.println("=========== Employe Service =============");
        employeeService.printEmployees();
        
        System.out.println("количество денег необходимое для выплаты зарплат для всех сотрудников в этом месяце");
        System.out.println("we need " + employeeService.calculateSalaryAndBonus() + "$ this month");
        System.out.println("");

        System.out.println("возвращает сотрудника по заданному id");
        System.out.println(employeeService.getById(2).toString());
        System.out.println("");

        System.out.println("возвращает сотрудника по заданному имени");
        Employee[] olegi = employeeService.getByName("Oleg");
        for( Employee oleg : olegi ){
            System.out.println(oleg);
        }
        System.out.println("");

        System.out.println("возвращают отсортированный массив с сотрудниками по имени");
        Employee[] sortedArrayByName = employeeService.sortByNameAndSalary(mainEmployees);
        EmployeeService newEmployeeServiceByName = new EmployeeService(sortedArrayByName);
        newEmployeeServiceByName.printEmployees();
        System.out.println("");

        System.out.println("возвращают отсортированный массив с сотрудниками по имени и зп");
        Employee[] sortedArrayByNameAndSalary = employeeService.sortByNameAndSalary(mainEmployees);
        EmployeeService newEmployeeServiceByNameAndSalary = new EmployeeService(sortedArrayByNameAndSalary);
        newEmployeeServiceByNameAndSalary.printEmployees();
        System.out.println("");

        System.out.println("Находит сотрудника по id, и подменяет информацию о нем на новую. Старую версию сотрудника метод возвращает.");
        Employee newEmployee = new Employee(7, "John", 18, "man", 1700.25);
        Employee editedEmployee = employeeService.edit(newEmployee);
        if (editedEmployee != null){
            System.out.println(editedEmployee.toString());
        }

        System.out.println("находит сотрудника по id, и удаляет его из массива. Возвращает ссылку на него");
        Employee removedEmployee = employeeService.remove(7);
        if (removedEmployee != null){
            System.out.println(removedEmployee);
        }
        System.out.println();

        System.out.println(" Добавляет нового сотрудника. Массив увеличивается на 1.");
        Employee newWorker = new Employee(11, "Ignat", 29, "man", 1000.0);
        employeeService.add(newWorker);
        employeeService.printEmployees();
    }
        
}