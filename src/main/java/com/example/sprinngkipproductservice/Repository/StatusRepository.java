package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
