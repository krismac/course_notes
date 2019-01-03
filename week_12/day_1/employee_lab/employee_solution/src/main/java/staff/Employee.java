package staff;

public abstract class Employee {

    String name;
    String niNumber;
    double salary;

    public Employee(String name, String niNumber, double salary) {
        this.name = name;
        this.niNumber = niNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        if (!name.equals(null)) {
            this.name = name;
        }
    }

    public void raiseSalary(double amount){
        if (amount >= 0) {
            this.salary += amount;
        }
    }

    public double payBonus(){
        return this.salary * 0.01;
    }



}
