package com.example.sprinngkipproductservice.Repository;

import com.example.sprinngkipproductservice.Model.CalendarWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<CalendarWork,Long> {
}
