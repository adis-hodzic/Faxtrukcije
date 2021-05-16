package com.amteam.requestmicroservice;


import com.amteam.requestmicroservice.Models.RequestServiceReceiver;
import com.amteam.requestmicroservice.entities.Instruction;
import com.amteam.requestmicroservice.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.time.OffsetDateTime;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;



import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class RequestmicroserviceApplication {

    static final String topicExchangeName1 = "nova-instrukcija";
    static final String queueName1 = "instrukcije";

    static final String topicExchangeName2 = "dodana-instrukcija-callback";
    static final String queueName2 = "instrukcije-callback";


    @Bean
    Queue queue1() {
        return new Queue(queueName1, false);
    }

    @Bean
    Queue queue2() {
        return new Queue(queueName2, false);
    }

    @Bean
    TopicExchange exchange1() {
        return new TopicExchange(topicExchangeName1);
    }

    @Bean
    TopicExchange exchange2() {
        return new TopicExchange(topicExchangeName2);
    }

    @Bean
    Binding binding1(Queue queue1, TopicExchange exchange1) {
        return BindingBuilder.bind(queue1).to(exchange1).with("request.management");
    }

    @Bean
    Binding binding2(Queue queue2, TopicExchange exchange2) {
        return BindingBuilder.bind(queue2).to(exchange2).with("management.request");
    }

   /*@Bean
    SimpleMessageListenerContainer container1(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName1);
        container.setMessageListener(listenerAdapter);
        return container;
    }*/

    @Bean
    SimpleMessageListenerContainer container2(ConnectionFactory connectionFactory,
                                              MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName2);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RequestServiceReceiver requestServiceReceiver) {
        return new MessageListenerAdapter(requestServiceReceiver, "receive");
    }


    private static final Logger logger = LoggerFactory.getLogger(RequestmicroserviceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RequestmicroserviceApplication.class, args);
    }

    @Bean
    public CommandLineRunner Inicijalizacija(InstrukcijaReposiotry instrukcijaReposiotry) {
        return (args -> {
            instrukcijaReposiotry.save(new Instruction(new Long(2), OffsetDateTime.now(), 1,  1L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(1), OffsetDateTime.now(), 2,  1L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 3,  1L, 2L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 2,  1L, 2L));
            instrukcijaReposiotry.save(new Instruction(new Long(2), OffsetDateTime.now(), 2,  1L, 3L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 2,  2L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 2,  2L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 1,  2L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(2), OffsetDateTime.now(), 2,  3L, 2L));
            instrukcijaReposiotry.save(new Instruction(new Long(1), OffsetDateTime.now(), 1,  3L, 2L));
            instrukcijaReposiotry.save(new Instruction(new Long(3), OffsetDateTime.now(), 2,  4L, 2L));
            instrukcijaReposiotry.save(new Instruction(new Long(1), OffsetDateTime.now(), 2,  5L, 1L));
            instrukcijaReposiotry.save(new Instruction(new Long(1), OffsetDateTime.now(), 2,  6L, 3L));


        });
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ObjectMapper mapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();
        return mapper;
    }
}

