package com.mine.docdemo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weapon
 * @date 2020/4/3 09:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KafkaConfig.class})

public class KafkaTest {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    public void test() {
        kafkaProducer.send(new ProducerRecord<String, String>("test2", "val41"));
    }

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    public void test1() {
        kafkaTemplate.send("test2", "val46");
    }
}
