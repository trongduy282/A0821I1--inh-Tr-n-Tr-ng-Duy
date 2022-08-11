package codegym.vn.casefurama.controller;


import codegym.vn.casefurama.entity.EmployeeDAO.Division;
import codegym.vn.casefurama.entity.EmployeeDAO.EducationDegree;
import codegym.vn.casefurama.entity.EmployeeDAO.Employee;
import codegym.vn.casefurama.entity.EmployeeDAO.Position;
import codegym.vn.casefurama.service.EmployeeDaoService;
import codegym.vn.casefurama.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeDaoService employeeDaoService;




    @GetMapping("/list")
    public String listEmployees( Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Employee> employees = employeeService.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("employees", employees);

        int numbers = employees.getNumber();
        int totalItems = employees.getNumberOfElements();
        int totalPages = employees.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "employee/list";
    }

    @GetMapping("/create")
    public String createEmployee(Model model){


        List<Division> divitions = employeeDaoService.findAllDivisions();
        List<Position> positions = employeeDaoService.findAllPositions();
        List<EducationDegree>educationDegrees = employeeDaoService.findAllEducationDegrees();
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("divitions", divitions);
        model.addAttribute("positions", positions);
        model.addAttribute("employee", new Employee());

        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute(value = "employee") Employee employee, BindingResult bindingResult, Model model){


        if( bindingResult.hasErrors()){
            List<Division> divitions = employeeDaoService.findAllDivisions();
            List<Position> positions = employeeDaoService.findAllPositions();
            List<EducationDegree>educationDegrees = employeeDaoService.findAllEducationDegrees();
            model.addAttribute("educationDegrees", educationDegrees);
            model.addAttribute("divitions", divitions);
            model.addAttribute("positions", positions);
            model.addAttribute("employee", employee);
            return "employee/create";
        }

        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam String idDelete){

        Employee employee = employeeService.findById(idDelete);
        employeeService.delete(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam String idUpdate, Model model){


        List<Division> divitions = employeeDaoService.findAllDivisions();
        List<Position> positions = employeeDaoService.findAllPositions();
        List<EducationDegree>educationDegrees = employeeDaoService.findAllEducationDegrees();
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("divitions", divitions);
        model.addAttribute("positions", positions);
        model.addAttribute("employee", employeeService.findById(idUpdate));

        return "employee/update";
    }




}
