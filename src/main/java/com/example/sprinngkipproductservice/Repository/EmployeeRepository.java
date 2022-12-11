package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select u from Employee u where u.name=:name")
    Employee getEmployeeByName(@Param("name") String name);

    @Query("select u from Employee u where u.firm=:firm")
    Employee searchEmployeeByFirm(@Param("firm") String firm);
}
