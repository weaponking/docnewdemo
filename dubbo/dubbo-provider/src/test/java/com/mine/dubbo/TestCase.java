package com.mine.dubbo;

import com.mine.dubbo.config.ProviderConfiguration;
import com.mine.dubbo.service.ProviderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weapon
 * @date 2020/3/29 11:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProviderConfiguration.class})
public class TestCase {

    @Autowired
    ProviderService providerService;

    @Test
    public void test() {
        Assert.assertEquals(providerService==null, false);
        System.out.println(providerService.test());
    }

}
