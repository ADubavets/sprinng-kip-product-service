package com.example.sprinngkipproductservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sprinngkipproductservice.Controller.ContractController;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "contracts")
public class Contract {
    @PostMapping(value="/save_contract")
    public String saveContract(ContractController contractController, BindingResult result, HttpServletResponse response) {
        
    
        if (result.hasErrors()) {return "redirect:/add_contract-error";}
    
        if (contractController.contractService.getByContractNumber(getNumber()) != null) {
    
            return "redirect:/add_contract-error";}
        else {
            //Передать id в заголовке ответа
            Contract newContract = contractController.contractService.save(this);
            long id = newContract.getId();
            
            response.addHeader("id", String.valueOf(id));
            
            return "redirect:/sales";
        }
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cipher;
    private String number;
    private Date contract_date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer firm;

    private int term;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    private Date startdate;
    private Date finishdate;
    private String note;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    private CalendarWork calendar;


}
