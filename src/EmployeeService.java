public class EmployeeService {
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    // вывод на экран информации о сотрудниках
    public void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            Employee currentEmployee = employees[i];
            System.out.print("id - " + currentEmployee.getId());
            System.out.print(", name - " + currentEmployee.getName());
            System.out.print(", age - " + currentEmployee.getAge());
            System.out.print(", gender - " + currentEmployee.getGender());
            System.out.print(", salary - " + currentEmployee.getSalary());
            System.out.println("");
        }
    }

    private void swap(Employee[] array, int index) {
        Employee tmp = array[index];
        array[index] = array[index - 1];
        array[index - 1] = tmp;
    }

    // возвращает количество денег необходимое для выплаты зарплат для всех
    // сотрудников в этом месяце
    double calculateSalaryAndBonus() {
        double salarySum = 0;
        for (Employee employee : employees) {
            double totalSalary = employee.getTotalMonthSalary();
            salarySum = salarySum + totalSalary;
        }

        return salarySum;
    }

    // возвращает сотрудника по заданному id
    public Employee getById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    };

    // возвращает сотрудника по заданному имени
    public Employee[] getByName(String name) {
        int newArraySize = 0;
        for (int i = 0; i < employees.length; i++) {
            if (name.equals(employees[i].getName())) {
                newArraySize++;
            }
        }

        Employee[] employeesArray = new Employee[newArraySize];

        if (newArraySize == 0) {
            return employeesArray;
        } else {

            int newArrayCounter = 0;

            for (int i = 0; i < employees.length; i++) {
                if (name.equals(employees[i].getName())) {
                    employeesArray[newArrayCounter] = employees[i];
                    newArrayCounter++;
                }
            }

            return employeesArray;
        }
    }

    // возвращают отсортированный массив с сотрудниками по имени
    public Employee[] sortByName(Employee[] employees) {
        Employee[] sortedEmployees = employees;
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < sortedEmployees.length; i++) {
                if (sortedEmployees[i].getName().compareTo(sortedEmployees[i - 1].getName()) < 0) {
                    swap(sortedEmployees, i);
                    needIteration = true;
                }
            }
        }

        return sortedEmployees;
    }

    // возвращают отсортированный массив с сотрудниками по имени и зп
    public Employee[] sortByNameAndSalary(Employee[] employees) {
        Employee[] sortedEmployees = employees;
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < sortedEmployees.length; i++) {
                if (sortedEmployees[i].getName().compareTo(sortedEmployees[i - 1].getName()) < 0) {
                    swap(sortedEmployees, i);
                    needIteration = true;
                } else if (sortedEmployees[i].getName().compareTo(sortedEmployees[i - 1].getName()) == 0) {
                    if (sortedEmployees[i].getSalary() < sortedEmployees[i - 1].getSalary()) {
                        swap(sortedEmployees, i);
                        needIteration = true;
                    }
                }
            }
        }

        return sortedEmployees;
    }

    // находит сотрудника по id, и подменяет информацию о нем на новую. Старую
    // версию сотрудника метод возвращает.
    public Employee edit(Employee editedEmployee) {

        int index = -1;
        Employee oldEmploye;

        for (int i = 0; i < employees.length; i++) {
            if (editedEmployee.getId() == employees[i].getId()) {
                index = i;
            }
        }

        if (index != -1) {
            oldEmploye = employees[index];
            employees[index] = editedEmployee;
            return oldEmploye;
        } else {
            return null;
        }

    }

    // находит сотрудника по id, и удаляет его из массива. Возвращает ссылку на
    // удаленного сотрудника
    public Employee remove(long id) {
        Employee[] newEmployeesArray = new Employee[employees.length - 1];
        Employee removedEmployee = null;
        int counter = 0;

        for (Employee employee : employees) {
            if (employee.getId() != id) {
                newEmployeesArray[counter] = employee;
                counter++;
            } else {
                removedEmployee = employee;
            }
        }

        employees = newEmployeesArray;
        return removedEmployee;
    }

    // Добавляет нового сотрудника. Массив увеличивается на 1.
    public void add(Employee newEmployee){
        Employee[] newEmployeesArray = new Employee[employees.length  + 1];

        for (int i = 0; i < newEmployeesArray.length-1; i++) {
            newEmployeesArray[i] = employees[i];
        }
        newEmployeesArray[newEmployeesArray.length-1] = newEmployee;
        employees = newEmployeesArray;
    }
}