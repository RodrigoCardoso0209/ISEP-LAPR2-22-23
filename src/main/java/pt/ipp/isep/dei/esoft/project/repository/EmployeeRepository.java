package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public Employee getEmployeeByEmail(String employeeEmail){
        Employee employee = null;
        for(Employee e : employees){
            if(e.getEmail().equalsIgnoreCase(employeeEmail)){
                employee = e;
            }
        }
        if (employee == null){
            throw new IllegalArgumentException("Employee not found");
        }
        return employee;
    }

    public Optional<Employee> add(Employee employee){
        Optional<Employee> newEmployee = Optional.empty();
        boolean operationSuccess = false;

        if(validateEmployee(employee)){
            newEmployee = Optional.of(employee.clone());
            operationSuccess = employees.add(newEmployee.get());
        }

        if(!operationSuccess){
            newEmployee = Optional.empty();
        }
        return newEmployee;
    }

    private boolean validateEmployee(Employee employee){return !employees.contains(employee);}


}