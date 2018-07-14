package com.javaFxSpringBoot.JavaFxSpringBoot.ActiveMQ;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelContextClass {

	private CamelContext ctx;
	private ConnectionFactory connectionFactory;
	private String activeMQServerPath;

	// Create Context
	public CamelContextClass() {
		//ctx = new DefaultCamelContext();
	}

	
	public void  createCamelContext() {

		if (ctx == null) {
			ctx = new DefaultCamelContext();
		} else {
			System.out.println("Context already created");
		}
	}

	public void configureComponent(String serverPath) {

		connectionFactory = new ActiveMQConnectionFactory(serverPath);
		ctx.addComponent("jms", JmsComponent.jmsComponent(connectionFactory));
	}

	// getContext

	public CamelContext getCtx() {
		return ctx;
	}

	// setRoute
	public void addRoute(RouteBuilder routes) {
		try {
			ctx.addRoutes(routes);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// private void start context

	public void startContext() {
		try {
			ctx.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Thread sleep
	public void camelwait(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	// close context
	public void closeContext() {
		try {
			ctx.stop();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getActiveMQServerPath() {
		return activeMQServerPath;
	}

	public void setActiveMQServerPath(String activeMQServerPath) {
		this.activeMQServerPath = activeMQServerPath;
	}

}
