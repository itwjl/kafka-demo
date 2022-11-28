package com.example.kafka.demo.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KfConsumer {

    /**
     * @description 接收录音录音信息
     * @author liuwy
     * @dateTime 2019/12/24 13:56
     **/
    @KafkaListener(topics = "temp", containerFactory = "kafkaListenerContainerFactory")
    public void receive(List<ConsumerRecord<String, String>> recordList) {
        recordList.forEach(record -> {
            String value = record.value();
            System.out.println("value = " + value);
        });
    }

}
