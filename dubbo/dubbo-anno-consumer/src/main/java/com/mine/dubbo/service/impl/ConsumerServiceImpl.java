package com.mine.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mine.dubbo.service.ConsumerService;
import com.mine.dubbo.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @author weapon
 * @date 2020/3/29 12:12
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Reference
    ProviderService providerService;

    @Override
    public void test() {
        System.out.println("anno-consumer-".concat(providerService.test()));
    }
}
