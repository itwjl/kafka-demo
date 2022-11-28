package com.example.kafka.demo.producer;



import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * kafka生产者
 *
 * @author yangxunwu
 */
@Slf4j
@Component
public class KfProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void submitList(List<String> msg) {
        log.info("kafka 待推送数据 {} 条", msg.size());

        List<List<String>> partition = Lists.partition(msg, 10);
        for (List<String> item : partition) {
            send("temp", item.toString());
        }

    }

    private void send(String topic, String msg) {
        log.info("kafka 发送 " + topic + " 消息长度 " + msg.length());
        kafkaTemplate.send(topic, msg);
    }
}
