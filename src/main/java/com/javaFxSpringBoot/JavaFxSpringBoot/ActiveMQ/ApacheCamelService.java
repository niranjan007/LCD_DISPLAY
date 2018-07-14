package com.javaFxSpringBoot.JavaFxSpringBoot.ActiveMQ;

import org.apache.camel.builder.RouteBuilder;

public class ApacheCamelService {

	private String serverPath;
	private RouteBuilder route;
	private long sleepTime;

	public ApacheCamelService(String serverPath, RouteBuilder route, long sleepTime) {
		super();
		this.serverPath = serverPath;
		this.route = route;
		this.sleepTime = sleepTime;
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public RouteBuilder getRoute() {
		return route;
	}

	public void setRoute(RouteBuilder route) {
		this.route = route;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

	public void startCamelContex() {

		CamelContextClass camelContext = new CamelContextClass();

		// Create context
		camelContext.createCamelContext();

		// configure jms component
		camelContext.configureComponent(serverPath);

		// Add routes
		camelContext.addRoute(route);

		// Start context
		camelContext.startContext();

		// Context wait
		camelContext.camelwait(sleepTime);

		// stop context
		camelContext.closeContext();
	}

}
