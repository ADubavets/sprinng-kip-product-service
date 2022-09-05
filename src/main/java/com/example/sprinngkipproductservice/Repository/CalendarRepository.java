package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.CalendarWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarWork,Long> {
}
