package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Role;
import com.example.sprinngkipproductservice.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}