package com.backend.exam.service;

import com.backend.exam.dto.EmployeeDTO;
import com.backend.exam.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface EmployeeService {

    public List<EmployeeDTO> listAll();
    public void save(Employee employee);
    public Employee get(Long id);
    public void delete(Long id);

}
