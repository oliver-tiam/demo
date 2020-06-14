package com.backend.exam.service.impl;

import com.backend.exam.dto.EmployeeDTO;
import com.backend.exam.entity.Employee;
import com.backend.exam.repository.EmployeeRepository;
import com.backend.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> listAll() {

        List<Employee> employeeList = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOList = employeeList.stream()
                .map(
                        employee -> {
                            Long empId = employee.getId();
                            String firstName = employee.getFirstName();
                            String middleName = employee.getMiddleName();
                            String lastName = employee.getLastName();
                            LocalDate birthDate = employee.getBirthDate();
                            LocalDate dateHired = employee.getDateHired();

                            EmployeeDTO employeeDTO = new EmployeeDTO();
                            employeeDTO.setEmpId(empId);
                            employeeDTO.setEmployeeName(this.getFullName(firstName, middleName, lastName));
                            employeeDTO.setAge(this.calculateEmployeeAge(birthDate));
                            employeeDTO.setYearsOfService(this.getYearsOfService(dateHired));
                            return employeeDTO;
                        }
                ).collect(Collectors.toList());
        return employeeDTOList;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    private String getFullName(String firstName, String middleName, String lastName) {
        firstName = firstName!=null?firstName:"";
        middleName = middleName!=null?middleName:"";
        lastName = lastName!=null?lastName:"";

        return (firstName + " " + middleName + " " + lastName).trim();
    }

    private int calculateEmployeeAge(LocalDate birthDate) {

        LocalDate currentDate =  LocalDate.now();

        return Period.between(birthDate, currentDate).getYears();
    }

    private String getYearsOfService(LocalDate dateHired) {

        LocalDate currentDate = LocalDate.now();

        LocalDate hiringDate = LocalDate.of(dateHired.getYear(), dateHired.getMonth(), dateHired.getDayOfMonth());
        LocalDate presentDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());

        Period period = Period.between(hiringDate, presentDate);

        int yr = period.getYears();
        int mo = period.getMonths();
        int days = period.getDays();
        String value = "";

        if (yr < 1) {
            if (mo < 1) {
                if (days > 1) {
                    value = String.valueOf(days) + "d";
                }
                value = String.valueOf(mo) + "m";
            }
        } else if (yr > 0) {
            if (mo > 0) {
                value = String.valueOf(yr) + "y " + mo + "m";
            } else {
                value = String.valueOf(yr) + "y";
            }
        }

        return value;
    }
}
