package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig2 implements ApplicationRunner{

	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationArguments args > ");
		
		for (String s : args.getSourceArgs()) {
			System.out.print(" "+s);
		}
		
		System.out.println();
	}

}
