package com.javaFxSpringBoot.JavaFxSpringBoot.ActiveMQ;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MessageReciever implements Processor {

	
	public void process(Exchange exchange) throws Exception {	
		String body = exchange.getIn().getBody().toString();
		System.out.println("Data recieved : " + body);
	}

}
