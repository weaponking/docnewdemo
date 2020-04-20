package com.mine.docdemo.spi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ServiceLoader;

/**
 * @author weapon
 * @date 2020/4/20 18:03
 */
@Slf4j
public class TestCase {

    @Test
    public void test() {

        ServiceLoader<SpiService> spiLoader = ServiceLoader.load(SpiService.class);
        for(SpiService spiService : spiLoader) {
            spiService.testSpi();
        }

    }
}
