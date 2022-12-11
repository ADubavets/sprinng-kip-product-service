package com.example.sprinngkipproductservice.Controller;

import com.example.sprinngkipproductservice.Model.Contract;
import com.example.sprinngkipproductservice.Service.CalendarService;
import com.example.sprinngkipproductservice.Service.ContractService;
import com.example.sprinngkipproductservice.Service.CustomerService;
import com.example.sprinngkipproductservice.Service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

@Controller
public class ContractController {
    public final ContractService contractService;
    private final CalendarService calendarService;
    private final CustomerService customerService;
    private final StatusService statusService;

    public ContractController(ContractService contractService,
                              CalendarService calendarService,
                              StatusService statusService,
                              CustomerService customerService) {
        this.contractService = contractService;
        this.calendarService = calendarService;
        this.statusService = statusService;
        this.customerService = customerService;
    }

    // Стартовая: продажи
    @GetMapping(value = "/sales")
    public String listContracts(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "sales";
    }

    //Ввод нового контракта
    @GetMapping(value = "/add_contract")
    public String addContract(Model model){

        String year = new SimpleDateFormat("yy").format(Calendar.getInstance().getTime());
        String month = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        int count = contractService.countContract() + 1;

        Contract contract = new Contract();
        contract.setCipher(year + month + new DecimalFormat("000").format(count));
        model.addAttribute("contract", contract);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("calendar", calendarService.findAll());
        model.addAttribute("status", statusService.findAll());
        return "add_contract";
    }

    @GetMapping(value ="/add_contract-error")
    public String addContractError(Model model) {
        model.addAttribute("contractError",true);
        return "add_contract";
    }

    @GetMapping(value = "/delete_cotract")
    public String deleteContract(@RequestParam(name="id")Long id) {contractService.deleteById(id);
        return "redirect:/sales";
    }

    @GetMapping(value = "/edit_contract")
    public String editContract(Model model, @RequestParam(name = "id") Long id) {
        Optional<Contract> contract = contractService.contractFindById(id);
        model.addAttribute("contract", contract);
        return "edit_contract";
    }

}
