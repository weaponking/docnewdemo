package com.mine.docdemo.kafka.agent;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author weapon
 * @date 2020/4/14 14:31
 */
@Component
public class Agent {

    private final Random random = new Random();

    @Data
    private static class IndexData {
        //指标
        private String indexCode;
        //采集时间
        private Date collectionTime;
        //单位
        private String unit;
        //数据类型
        private String dataType;
        //数据
        private String data;
    }

    public String mockData(String code, String unit, String dataType) {
        IndexData indexData = new IndexData();
        indexData.setIndexCode(code);
        indexData.setData(String.valueOf(random.nextInt(100)+1));
        indexData.setDataType(dataType);
        indexData.setUnit(unit);
        indexData.setCollectionTime(new Date());
        return JSON.toJSONString(indexData);
    }


}
