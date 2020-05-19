package com.mine.docdemo.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.mine.docdemo.entity.Supplier;
import com.mine.docdemo.mapper.SupplierMapper;
import com.mine.docdemo.service.SupllierService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weapon
 * @date 2020/5/7 14:24
 */
@Service
public class SupllierServiceImpl implements SupllierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Supplier querySupplierById(Long id) {
        Supplier supplier = supplierMapper.selectByPrimaryKey(id);
        return supplier;
    }

    @Override
    public void insert(Supplier supplier) {
        supplierMapper.insert(supplier);
        HintManager.getInstance().setMasterRouteOnly();
        System.out.println(JSON.toJSONString(supplierMapper.selectByPrimaryKey(supplier.getId())));
        System.out.println(supplier.getId());
        System.out.println(JSON.toJSONString(supplier));
    }
}
