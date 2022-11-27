package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig1 implements CommandLineRunner{

	public void run(String... args) throws Exception {
		
		System.out.println("CommandLineRunner args > ");
		
		for (String s : args) {
			System.out.print(" "+s);
		}
		
		System.out.println();
	}

}
