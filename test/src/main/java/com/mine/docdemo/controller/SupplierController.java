package com.mine.docdemo.controller;

import com.mine.docdemo.common.DataResult;
import com.mine.docdemo.entity.Supplier;
import com.mine.docdemo.service.SupllierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weapon
 * @date 2020/5/7 14:21
 */
@RestController
public class SupplierController {

    @Autowired
    private SupllierService supllierService;

    @GetMapping("/query")
    public DataResult<Supplier> querySupplierById(Long id) {
        DataResult<Supplier> dataResult = new DataResult<>();
        dataResult.setData(supllierService.querySupplierById(id));
        dataResult.setCode("SUCCESS");
        return dataResult;
    }
}
