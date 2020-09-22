package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ApplicationConfigReader;
import com.example.demo.model.MessageSender;
import com.example.demo.model.SmsRequest;
import com.example.demo.util.ApplicationConstant;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private final RabbitTemplate rabbitTemplate;
    private ApplicationConfigReader applicationConfig;
    private MessageSender messageSender;

    @Autowired
    public Controller(final RabbitTemplate rabbitTemplate) {
    	this.rabbitTemplate = rabbitTemplate;
    }
    
    public ApplicationConfigReader getApplicationConfig() {
    	return applicationConfig;
    }
    
    @Autowired
    public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
    	this.applicationConfig = applicationConfig;
    }
    
    public MessageSender getMessageSender() {
    	return messageSender;
    }
    
    @Autowired
    public void setMessageSender(MessageSender messageSender) {
    	this.messageSender = messageSender;
    }
    
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody SmsRequest smsRequest) {
    String exchange = getApplicationConfig().getApp1Exchange();
    String routingKey = getApplicationConfig().getApp1RoutingKey();
    /* Sending to Message Queue */
    try {
    	messageSender.sendMessage(rabbitTemplate, exchange, routingKey, smsRequest);
    	return new ResponseEntity<String>(ApplicationConstant.IN_QUEUE, HttpStatus.OK);
    } catch (Exception ex) {
    	log.error("Exception occurred while sending message to the queue. Exception= {}", ex);
    	return new ResponseEntity<String>(ApplicationConstant.MESSAGE_QUEUE_SEND_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
