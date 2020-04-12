package com.mine.dubbo.service.impl;

import com.mine.dubbo.service.ProviderService;
import org.apache.dubbo.config.annotation.Service;
import java.util.UUID;

/**
 * @author weapon
 * @date 2020/3/29 11:14
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String test() {
        return UUID.randomUUID().toString();
    }

}
