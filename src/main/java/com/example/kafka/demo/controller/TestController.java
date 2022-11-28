package com.example.kafka.demo.controller;

import com.example.kafka.demo.producer.KfProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类描述:
 *
 * @author Wang Jinglei
 * @date 2022/11/25 18:26
 * @modifier Wang Jinglei
 * @date 2022/11/25 18:26
 * @Version V1.0
 */
@RestController
@RequestMapping("kafka/demo")
public class TestController {

    @Autowired
    private KfProducer kfProducer;

    @PostMapping("/produce")
    public String send(@RequestBody List<String> content) {

        kfProducer.submitList(content);

        return "发送结束";
    }
}
