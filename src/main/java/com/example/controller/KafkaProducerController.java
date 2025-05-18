package com.example.controller;

import com.example.config.ProducerConfiguration;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired(required = false)
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired(required = false)
    private ProducerConfiguration producerConfiguration;

    @GetMapping("/send/{message}")
    public void sendMessage(@PathVariable String message){
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(producerConfiguration.loadProducerConfigs());
        kafkaTemplate.send(new ProducerRecord<>("test-topic",message));
    }
}
