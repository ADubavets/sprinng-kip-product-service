package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.CalendarWork;
import com.example.sprinngkipproductservice.Repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public List<CalendarWork> findAll() {
        return calendarRepository.findAll();
    }

    public CalendarWork save(CalendarWork calendar) {
        return calendarRepository.save(calendar);
    }

    public Optional<CalendarWork> findById(Long id) {
        return calendarRepository.findById(id);
    }

    public void deleteById(Long id) {
        calendarRepository.deleteById(id);
    }
}
