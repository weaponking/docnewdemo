package com.mine.docdemo.service.impl;

import com.mine.docdemo.entity.Supplier;
import com.mine.docdemo.mapper.SupplierMapper;
import com.mine.docdemo.service.SupllierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Objects;

/**
 * @author weapon
 * @date 2020/5/7 14:24
 */
@Service
public class SupllierServiceImpl implements SupllierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private RedisTemplate<String, Supplier> redisTemplate;

    private static final String PER_FIX = "suppier::";

    private static final String SUPPIER = "SUPPIERs";

    @Override
    public Supplier querySupplierById(Long id) {
        Supplier supplier = (Supplier) redisTemplate.opsForHash().get(SUPPIER, PER_FIX.concat(Long.toString(id)));
        if(Objects.isNull(supplier)) {
            supplier = supplierMapper.selectByPrimaryKey(id);
            redisTemplate.opsForHash().put(SUPPIER, PER_FIX.concat(Long.toString(id)), supplier);
        }
        return supplier;
    }
}
