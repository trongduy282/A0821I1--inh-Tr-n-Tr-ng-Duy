package codegym.vn.casefurama.controller;


import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import codegym.vn.casefurama.entity.CustomerDAO.CustomerType;
import codegym.vn.casefurama.service.CustomerService;
import codegym.vn.casefurama.service.CustomerTypeService;
import codegym.vn.casefurama.valid.CustomerValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList (){
        return "home";
    }

    @GetMapping("/customer/list")
    public String listCustomer( Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Customer> customers = customerService.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("customers",customers );

        List<CustomerType>  customerTypes = customerTypeService.getAll();
        model.addAttribute("customerTypes", customerTypes);

        int numbers = customers.getNumber();
        int totalItems = customers.getNumberOfElements();
        int totalPages = customers.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "customer/list";
    }

    @GetMapping("customer/create")
        private String createCustomer(Model model){

            List<CustomerType>  customerTypes = customerTypeService.getAll();
            model.addAttribute("customerTypes", customerTypes);
            model.addAttribute("customer", new Customer());
        return "customer/create";
        }


    @PostMapping("customer/create")
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult , Model model){

        CustomerValid valid = new CustomerValid();
        valid.validate(customer, bindingResult);
        if( bindingResult.hasErrors()){
            List<CustomerType>  customerTypes = customerTypeService.getAll();
            model.addAttribute("customer", customer );
            model.addAttribute("customerTypes", customerTypes);
            return "customer/create";
        }

        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer( @RequestParam String idDelete, Model model){

        Customer customer = customerService.findById(idDelete);
        customerService.delete(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/update")
    private String updateForm( @RequestParam String idUpdate, Model model){

        Customer customer = customerService.findById(idUpdate);
        List<CustomerType>  customerTypes = customerTypeService.getAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @GetMapping("customer/search")
    public String search( @RequestParam(defaultValue = "", required = false) String nameSearch,
                          @RequestParam(defaultValue = "", required = false) String genderSearch,
                          @RequestParam(defaultValue = "", required = false) String typeSearch,
                          @RequestParam(value = "page") Optional<Integer> page, Model model){

        int currentPage = page.orElse(1);
        int pageSize =  5;
        Page<Customer> customers = customerService.searchCustomer( nameSearch,typeSearch, genderSearch  ,PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("customers",customers );

        List<CustomerType>  customerTypes = customerTypeService.getAll();
        model.addAttribute("customerTypes", customerTypes);

        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("typeSearch", ( !typeSearch.equals("") ) ? Integer.parseInt(typeSearch) : typeSearch );

        int numbers = customers.getNumber();
        int totalItems = customers.getNumberOfElements();
        int totalPages = customers.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "customer/list";
    }






}
