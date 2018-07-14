package com.javaFxSpringBoot.JavaFxSpringBoot.ActiveMQ;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRoute extends RouteBuilder {

	
	public void configure() throws Exception {
		//Sends to Davanagere queue
				from("file:C:/JAVA/ACTIVE_MQ/DavanagereSender")
				   .split().tokenize("\n").to("jms:queue:DavanagereQueue");
				
				//Sends to Bangalore queue
				from("file:C:/JAVA/ACTIVE_MQ/BangaloreSender")
				   .split().tokenize("\n").to("jms:queue:BangaloreQueue");
				
				//Sends to Sydney queue
				from("file:C:/JAVA/ACTIVE_MQ/SydneySender")
				   .split().tokenize("\n").to("jms:queue:SydneyQueue");
				
				//Recives data from Davanagere Queue
				from("jms:queue:DavanagereQueue")
				   .to("log:?level=INFO&showBody=true")
				   	 .process(new MessageReciever());
				
				//Recives data from Bangalore Queue
				from("jms:queue:BangaloreQueue")
				   .to("log:?level=INFO&showBody=true")
				   	 .process(new MessageReciever());
				
				//Recives data from Sydney Queue
				from("jms:queue:SydneyQueue")
				   .to("log:?level=INFO&showBody=true")
				   	 .process(new MessageReciever());
		
	}

}
