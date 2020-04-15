package com.mine.docdemo.kafka.agent;

import com.mine.docdemo.kafka.KafkaConfig;
import com.mine.docdemo.kafka.agent.config.ThreadConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weapon
 * @date 2020/4/14 14:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KafkaConfig.class, ThreadConfig.class})
public class TestCase {

    @Autowired
    private TaskExecutor threadPoolTaskExecutor;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void test() {
        taskRun();
    }

    private void taskRun() {

        Agent agent = new Agent();
        for(int i = 0;i<20;i++) {
            threadPoolTaskExecutor.execute(new AgentTask(agent, kafkaTemplate));
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskRun();
    }
}
