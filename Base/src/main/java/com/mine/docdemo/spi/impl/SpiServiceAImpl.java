package com.mine.docdemo.spi.impl;

import com.mine.docdemo.spi.SpiService;

/**
 * @author weapon
 * @date 2020/4/20 18:01
 */
public class SpiServiceAImpl implements SpiService {

    @Override
    public String testSpi() {
        String result = "SpiServiceAImpl testSpi";
        System.out.println(result);
        return result;
    }

}
