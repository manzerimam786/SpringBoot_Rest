package com.example;

import com.example.config.ConsumerConfiguration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1"))
public class SpringBootRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
    }

    @Autowired
    public void checkFeatureBean(Optional<String> dataSource) {
        System.out.println("Bean present? " + dataSource.isPresent());
    }
/// //put  this code in sperate @Component class then it will work
//    @KafkaListener(topics = {"test-topic"}, groupId = "my-group")
//    public void consume(){
//        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(new ConsumerConfiguration().loadConsumerConfigs());
//        kafkaConsumer.subscribe(Arrays.asList("test-topic"));
//        ConsumerRecords<String, String> consumerRecord = kafkaConsumer.poll(1000);
//        for (ConsumerRecord record: consumerRecord){
//            System.out.println("consumed messages="+record.value());
//        }
//    }
}
