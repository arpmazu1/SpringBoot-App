package com.stackroute.muzixapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//main Spring boot Application
@SpringBootApplication
public class MuzixAppApplication implements CommandLineRunner {


		protected final Log logger = LogFactory.getLog(getClass());


	@Override
	public void run(String... args) throws Exception {
		logger.info("Application Started !!");

	}
		public static void main(String[] args) {
		SpringApplication.run(MuzixAppApplication.class, args);
	}



}
