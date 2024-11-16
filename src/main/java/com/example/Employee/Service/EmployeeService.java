package com.example.Employee.Service;

import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
   public EmployeeRepository employeeRepository;

    //Method to calculate net Salary
    public double calculateNetSalary(Employee employee){
        double grossSalary = employee.getBaseSalary() + employee.getAllowance() + employee.getBonuses();
        double totalDeduction = employee.getTax() + employee.getSocialSecurity() + employee.getInsurance();
        return grossSalary - totalDeduction;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id)  {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}

