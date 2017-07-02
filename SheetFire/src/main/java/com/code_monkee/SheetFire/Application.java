package com.code_monkee.SheetFire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.code_monkee.psolib.PsoContext;

//@SpringBootApplication
public class Application  {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired static PsoContext psoCtx;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		psoCtx = ctx.getBean(PsoContext.class);
	}

	@Bean
	PsoContext psoCtx() {
		return new PsoContext();
	}
}
