package codegym.vn.casefurama.controller;


import codegym.vn.casefurama.entity.ContractDao.AttachService;
import codegym.vn.casefurama.entity.ContractDao.Contract;
import codegym.vn.casefurama.entity.ContractDao.ContractDetail;
import codegym.vn.casefurama.entity.CustomerDAO.Customer;
import codegym.vn.casefurama.entity.EmployeeDAO.Employee;
import codegym.vn.casefurama.entity.ServiceDAO.Service;
import codegym.vn.casefurama.service.*;
import codegym.vn.casefurama.valid.ContractValid;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceDaoService serviceDaoService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ContractDetailService contractDetailService;

    @Autowired
    AttachServiceService attachServiceService;


    @GetMapping("/list")
    public String listContract(Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Contract> contracts = contractService.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("contracts",contracts );


        int numbers = contracts.getNumber();
        int totalItems = contracts.getNumberOfElements();
        int totalPages = contracts.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "contract/list";
    }

    @GetMapping( "/create")
    public String formCreateContract( Model model){


        List<Customer> customers = customerService.getAll();
        List<Service> services = serviceDaoService.getAll();
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("services", services);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        model.addAttribute("contract", new Contract());

        return "contract/create";
    }


    @PostMapping("/create")
    public  String create(@Valid @ModelAttribute Contract contract, BindingResult bindingResult , Model model){

        ContractValid validation = new ContractValid();
        validation.validate(contract, bindingResult);
        if( bindingResult.hasErrors()){
            model.addAttribute("services", serviceDaoService.getAll());
            model.addAttribute("customers", customerService.getAll());
            model.addAttribute("employees", employeeService.getAll());
            model.addAttribute("contract",contract);
            return "contract/create";
        }

        contractService.save(contract);
        return "redirect:/contract/list";
    }


    @GetMapping("/update")
    public String update(  @RequestParam String idUpdate, Model model){

        Contract contract = contractService.findById( idUpdate);
        model.addAttribute("services", serviceDaoService.getAll());
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("contract",contract);
        return "contract/update";
    }


    @PostMapping("/update")
    public  String update(@Valid @ModelAttribute Contract contract, BindingResult bindingResult , Model model){

        ContractValid validation = new ContractValid();
        validation.validate(contract, bindingResult);
        if( bindingResult.hasErrors()){
            model.addAttribute("services", serviceDaoService.getAll());
            model.addAttribute("customers", customerService.getAll());
            model.addAttribute("employees", employeeService.getAll());
            model.addAttribute("contract",contract);
            return "contract/update";
        }

        contractService.save(contract);
        return "redirect:/contract/list";
    }


    @GetMapping("/detail")
    public String detailList(Model model,  @RequestParam String idDetail, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<ContractDetail> contractDetailList = contractDetailService.findByContract_IdContract( Integer.parseInt( idDetail), PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("contractDetailList",contractDetailList );


        Contract contract = contractService.findById( idDetail);
        model.addAttribute("contract",contract);
        model.addAttribute("idDetail",idDetail);

        int numbers = contractDetailList.getNumber();
        int totalItems = contractDetailList.getNumberOfElements();
        int totalPages = contractDetailList.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "contract/detail";
    }




    @PostMapping("/detail/delete")
    public String deleteDetail(@RequestParam String idDelete, Model model) {


        ContractDetail contractDetail = contractDetailService.findById(idDelete);
        int idContract = contractDetail.getContract().getIdContract();
//        redirectAttributes.addFlashAttribute("idDetail", String.valueOf( contractDetail.getContract().getIdContract()  ) );
        contractDetailService.delete(contractDetail);

        return "redirect:/contract/detail?idDetail=" + idContract;



    }

    @GetMapping("detail/create")
    public String createformDetail( @RequestParam(value = "idDetail") String idDetail, Model model){

        Contract contract = contractService.findById( idDetail);
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContract( contract );
        model.addAttribute("contractDetail", contractDetail);

        List<AttachService> attachments =  attachServiceService.getAll();
        model.addAttribute("attachments",  attachments);
        model.addAttribute("contract",  contract);
        return "contract/createDetail";
    }


    @GetMapping("detail/update")
    public String updateformDetail( @RequestParam(value = "idUpdate") String idUpdate, Model model){

        ContractDetail contractDetail = contractDetailService.findById( idUpdate );
        Contract contract = contractDetail.getContract();
        model.addAttribute("contractDetail", contractDetail);
        List<AttachService> attachments =  attachServiceService.getAll();
        model.addAttribute("attachments",  attachments);
        model.addAttribute("contract",  contract);
        return "contract/updateDetail";
    }


    @PostMapping("detail/create")
    public String createDetail( @ModelAttribute(value = "contractDetail") ContractDetail contractDetail , Model model){

        System.out.println(contractDetail);
        ContractDetail  x = contractDetailService.findContractDetailByAttachService_IdAttachServiceAndContract_IdContract(
                contractDetail.getAttachService().getIdAttachService(),
                contractDetail.getContract().getIdContract() );

        System.out.println(x);

        if(  x == null )
            contractDetailService.save(contractDetail);

        else{
                x.setQuantity( contractDetail.getQuantity() );
                contractDetailService.save(x);
        }

        return "redirect:/contract/detail?idDetail=" + contractDetail.getContract().getIdContract();
    }



    @PostMapping("detail/update")
    public String updateDetail( @ModelAttribute(value = "contractDetail") ContractDetail contractDetail , Model model){

        contractDetailService.save(contractDetail);
        return "redirect:/contract/detail?idDetail=" + contractDetail.getContract().getIdContract();
    }


//    @PostMapping("detail/deleteDetail")
//    public String updateDetele(  @RequestParam String idDetele , Model model){
//
//        ContractDetail contractDetail = contractDetailService.findById(idDetele);
//        int idContract = contractDetail.getContract().getIdContract();
//        System.out.println(idContract);
//        contractDetailService.delete(contractDetail);
//        return "redirect:/contract/detail?idDetail=" + idContract;
//    }






}
