package com.mine.docdemo.kafka.agent;

import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author weapon
 * @date 2020/4/14 15:02
 */
public class AgentTask implements Runnable {

    private Agent agent;

    public AgentTask(Agent agent) {
        this.agent = agent;
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    public AgentTask(Agent agent, KafkaTemplate<String, String> kafkaTemplate) {
        this.agent = agent;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run() {
        String jsonData = agent.mockData("CPU", "%", "number");
        kafkaTemplate.send("index_topic", jsonData);
    }
}
