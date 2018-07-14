package com.javaFxSpringBoot.JavaFxSpringBoot.ActiveMQ;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AvtiveMQDemo {

	public static void main(String[] args) {

		String serverPath = "tcp://localhost:61616";
		
		SpringApplication.run(AvtiveMQDemo.class, args);

		ActiveMQRoute activeMqRoutes = new ActiveMQRoute();
		
		ApacheCamelService camelService = new ApacheCamelService(serverPath,activeMqRoutes,5000 );
		camelService.startCamelContex();

	}
}