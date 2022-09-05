package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("select u from Customer u where u.firm=:firm")
    Customer getCustomerByName(@Param("firm") String firm);

}
