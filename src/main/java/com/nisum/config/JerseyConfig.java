package com.nisum.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nisum.controller.EmployeeController;

@Component
@ApplicationPath("/spring-app")
public class JerseyConfig extends ResourceConfig {
	private static Logger logger=LoggerFactory.getLogger(JerseyConfig.class);
	public JerseyConfig() {
		logger.info("BEGIN :: JerseyConfig :: JerseyConfig");
		register(EmployeeController.class);
	}
}
