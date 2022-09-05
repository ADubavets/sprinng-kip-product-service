package com.example.sprinngkipproductservice.Controller;

import com.example.sprinngkipproductservice.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping(value = "/warehouse")
    public String listUsers(Model model) {
        model.addAttribute("product", warehouseService.findAll());
        return "warehouse";
    }
}
