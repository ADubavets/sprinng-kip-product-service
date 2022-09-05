package com.example.sprinngkipproductservice.Service;

import com.example.sprinngkipproductservice.Model.Warehouse;
import com.example.sprinngkipproductservice.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteById(long id) {
        warehouseRepository.deleteById(id);
    }

    public Optional<Warehouse> userFindById(Long id) {
        return warehouseRepository.findById(id);
    }


}
