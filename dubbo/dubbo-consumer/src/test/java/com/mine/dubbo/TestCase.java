package com.mine.dubbo;

import com.mine.dubbo.config.ConsumerConfiguration;
import com.mine.dubbo.service.ConsumerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weapon
 * @date 2020/3/29 12:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConsumerConfiguration.class})
public class TestCase {

    @Autowired
    ConsumerService consumerService;

    @Test
    public void test() {
        Assert.assertEquals(consumerService==null, false);
        consumerService.test();
    }
}
