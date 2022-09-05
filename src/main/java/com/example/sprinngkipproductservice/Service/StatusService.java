package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Status;
import com.example.sprinngkipproductservice.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}
