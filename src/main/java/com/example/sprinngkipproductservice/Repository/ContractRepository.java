package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("select u from Contract u where u.number=:contract")
    Contract getByContractNumber(String contract);

}
