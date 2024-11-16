package com.example.Employee.Controller;

import com.example.Employee.Service.EmployeeService;
import com.example.Employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/") //getting the list of all the employees
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}") // finding an employee by id
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/{id}") // creating an employee
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null){
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setBaseSalary(employeeDetails.getBaseSalary());
            employee.setAllowance(employeeDetails.getAllowance());
            employee.setBonuses(employeeDetails.getBonuses());
            employee.setInsurance(employeeDetails.getInsurance());
            employee.setBaseSalary(employeeDetails.getBaseSalary());
            employee.setPosition(employeeDetails.getPosition());
        }

        return employeeService.saveEmployee((employee));

    }

    @DeleteMapping("/{id}")
    private void  deleteById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

}