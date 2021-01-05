package com.example.projectb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectBApplication {

	public static void main(String[] args) {
		
	
		
		ApplicationContext app_context=SpringApplication.run(ProjectBApplication.class, args);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(true) {
			String line="";
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line.equals("/shutdown"))break;
		}
		SpringApplication.exit(app_context, () -> 0);
		
	}

}
