package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Contract;
import com.example.sprinngkipproductservice.Repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(long id) {
        contractRepository.deleteById(id);
    }

    public Optional<Contract> contractFindById(Long id) {
        return contractRepository.findById(id);
    }

    public int countContract(){
        int i = (int) contractRepository.count();
        return i;
    }

    public Contract getByContractNumber(String contractNumber) {
        return contractRepository.getByContractNumber(contractNumber);
    }
    public Page<Contract> getPaginatedSales(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

}
