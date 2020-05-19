package com.mine.docdemo.controller;

import com.mine.docdemo.entity.Supplier;
import com.mine.docdemo.service.SupllierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weapon
 * @date 20-5-7 19:48
 */
@RestController
public class SupplierController {

    @Autowired
    SupllierService supllierService;

    @GetMapping("/t")
    public Supplier query(Long id) {
        return supllierService.querySupplierById(id);
    }

    @GetMapping("/t1")
    public boolean insert() {
        Supplier supplier = new Supplier();
        supplier.setCode("tezst");
        supplier.setName("ssss");
        supllierService.insert(supplier);
        return true;
    }
}
