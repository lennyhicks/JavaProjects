package Zoo;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Employee extends Person {
    int empNum;
    String title;
    public Employee(String name, int age, String gender, int empNum, String title) {
        super(name, age, gender);
        this.empNum = empNum;
        this.title = title;
    }
    public Employee emp() {
try {
    debug("What is your persons name");
    name = input.nextLine();
    debug("What is the age?");
    age = input.nextInt();
    input.nextLine();
    debug("What is the gender?");
    debug("1.) Male");
    debug("2.) Female");
    int genderc = input.nextInt();
    input.nextLine();
    switch (genderc) {
        case 1:
            gender = "Male";
            break;
        case 2:
            gender = "Female";
            break;
        default:
            debug("Please try again");
            emp();
            break;
    }
    debug("What is the EmployeeNumber?");
    int empNum = input.nextInt();
    input.nextLine();
    debug("What is the Job Title?");
    String title = input.nextLine();
    Employee emp = new Employee(name, age, gender, empNum, title);
    return emp;
}catch (Exception e){
    debug("Please try again");
    emp();
    return null;
}
    }


    public void addEmployee(){
        Employee p = emp();
        employee.add(p);
        debug("Employee Created");
        listEmployee();
    }

    public void listEmployee(){
        for (int i = 0; i < employee.size(); i++){
            Employee e = employee.get(i);
            debug("[EMPLOYEE] Name: "+ e.name+" Age: "+ e.age+" Gender: "+e.gender+" Employee Number: "+ e.empNum+" Title: "+ e.title);

        }
    }
}
