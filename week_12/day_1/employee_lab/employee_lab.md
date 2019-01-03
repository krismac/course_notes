# Inheritance Lab.

Your task is to model and create a system to store information for employees of a large development company.
You should use TDD, inheritance, packages and abstract classes for this.

#### Create an abstract `Employee` parent class in a package called staff.
- `Employee` will have a name, NI number and salary.
- Create Getters for all properties.
- Add a method named `raiseSalary` with takes in a parameter of type double to increment the salary.
- Add a method called `payBonus` which returns 1% of the employees salary.
- Don't worry about testing just now until you create the subclasses.

#### Create a subclass of `Employee` called `Manager` in a package called management.
- Create a class for Manager.
- Add a property to store the department name in a property called `deptName`.
- Create a constructor that includes all the parameters needed for `Employee` and `deptName`.
- Add a getter method for `deptName`.
- Test all methods including `raiseSalary` and `payBonus`

#### Create subclasses of `Employee`: `Developer` and `DatabaseAdmin` in a package called techStaff.
Create 2 new classes for `Developer` and `DatabaseAdmin`.
- These should take in the same parameters as `Employee` and pass them to `Employee` constructor.
- Again test all methods for both classes.

#### Create a subclass of `Manager` called `Director` in the management package.
- Add a private property to store a double value `budget`.
- Create a constructor for `Director` that includes the parameters needed for `Manager` and the `budget` parameter.
- Create a getter method for this property.
- Test all methods.


## Extensions

### Prevent unwanted values

- Prevent a negative value for the `raiseSalary` method.
- Allow the user to change the Employees name and prevent a null value from being entered.
- Override the `payBonus` in director to return 2% of their salary.
