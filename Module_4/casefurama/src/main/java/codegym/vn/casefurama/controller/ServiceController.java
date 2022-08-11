package codegym.vn.casefurama.controller;

import codegym.vn.casefurama.entity.ServiceDAO.RentType;
import codegym.vn.casefurama.entity.ServiceDAO.Service;
import codegym.vn.casefurama.entity.ServiceDAO.ServiceType;
import codegym.vn.casefurama.service.ServiceDaoService;
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
@RequestMapping(value = "/service")
public class ServiceController {


    @Autowired
    ServiceDaoService service;


    @GetMapping("/list")
    public String listService(Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Service> services = service.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("services", services);

        int numbers = services.getNumber();
        int totalItems = services.getNumberOfElements();
        int totalPages = services.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "service/list";
    }


    @GetMapping("/create")
    public String formCreate(Model model){

        List<RentType> rentTypeList = service.findAllRentTypes();
        List<ServiceType> typeList = service.findAllServiceTypes();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("service", new Service());

        return "service/create";
    }


    @PostMapping("/create")
    public String formCreate(@Valid @ModelAttribute(value = "service") Service serviceR, BindingResult bindingResult , Model model){

        if(bindingResult.hasErrors()){
            List<RentType> rentTypeList = service.findAllRentTypes();
            List<ServiceType> typeList = service.findAllServiceTypes();
            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("typeList", typeList);
            model.addAttribute("service", serviceR);

            return "service/create";
        }

        service.save(serviceR);
        return "redirect:/service/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam String idUpdate, Model model){

        int id = Integer.parseInt(idUpdate);
        Service serviceR = service.findById(id);

        List<RentType> rentTypeList = service.findAllRentTypes();
        List<ServiceType> typeList = service.findAllServiceTypes();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("service", serviceR);
        return "service/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String idDelete, Model model){
        int id = Integer.parseInt(idDelete);

        service.delete(id);
        return "redirect:/service/list";

    }
}
