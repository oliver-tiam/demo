package com.backend.exam.controller;

import com.backend.exam.dto.EmployeeDTO;
import com.backend.exam.entity.Employee;
import com.backend.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String homePage(Model model) {
        List<EmployeeDTO> listEmployees = employeeService.listAll();
        model.addAttribute("listEmployees", listEmployees);

        return "index";
    }

    @RequestMapping("/new")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("title", "Create New Employee");

        return "employee_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("employee_form");

        Employee employee = employeeService.get(id);
        mav.addObject("employee", employee);
        mav.addObject("title", "Edit Employee Record");

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);

        return "redirect:/";
    }

    @RequestMapping("/view/{id}")
    public ModelAndView viewEmployee(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("employee_form");

        Employee employee = employeeService.get(id);
        mav.addObject("employee", employee);
        mav.addObject("title", "View Employee Record");

        return mav;
    }
}
