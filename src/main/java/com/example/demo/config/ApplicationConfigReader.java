package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigReader {
	
	@Value("${demo.exchange.name}")
	private String app1Exchange;
	
	@Value("${demo.queue.name}")
	private String app1Queue;
	
	@Value("${demo.dead.exchange.name}")
	private String app1DeadExchange;
	
	@Value("${demo.dead.queue.name}")
	private String app1DeadQueue;
	
	@Value("${demo.routing.key}")
	private String app1RoutingKey;
	
	@Value("${demo.dead.routing.key}")
	private String app1DeadRoutingKey;
	
	public String getApp1Exchange() {
		return app1Exchange;
	}
	public void setApp1Exchange(String app1Exchange) {
		this.app1Exchange = app1Exchange;
	}
	public String getApp1Queue() {
		return app1Queue;
	}
	public void setApp1Queue(String app1Queue) {
		this.app1Queue = app1Queue;
	}
	public String getApp1RoutingKey() {
		return app1RoutingKey;
	}
	public void setApp1RoutingKey(String app1RoutingKey) {
		this.app1RoutingKey = app1RoutingKey;
	}
	public String getApp1DeadQueue() {
		return app1DeadQueue;
	}
	public void setApp1DeadQueue(String app1DeadQueue) {
		this.app1DeadQueue = app1DeadQueue;
	}
	public String getApp1DeadExchange() {
		return app1DeadExchange;
	}
	public void setApp1DeadExchange(String app1DeadExchange) {
		this.app1DeadExchange = app1DeadExchange;
	}
	public String getApp1DeadRoutingKey() {
		return app1DeadRoutingKey;
	}
	public void setApp1DeadRoutingKey(String app1DeadRoutingKey) {
		this.app1DeadRoutingKey = app1DeadRoutingKey;
	}
}
