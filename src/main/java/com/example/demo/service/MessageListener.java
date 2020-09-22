package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.example.demo.model.SmsRequest;
import com.twilio.exception.ApiException;

@ConditionalOnExpression("${demo.enabled:false}")
@Component
public class MessageListener {
	
	private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
	
	@Autowired
	TwilioSmsSender twillioSmsSender;
    
    @RabbitListener(queues = "${demo.queue.name}")
	public void receiveMessageForApp1(final SmsRequest data) {
		log.info("Received message: {} from app1 queue.", data);
		try {
			log.info("Sending Message");
			twillioSmsSender.sendSms(data);
			log.info("Message sent successfully");
		} catch (ApiException ex) {
				log.info("Sending Failed...will retry again..!!");
				throw new RuntimeException();
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}
