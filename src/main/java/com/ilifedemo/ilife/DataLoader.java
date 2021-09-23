package com.ilifedemo.ilife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class DataLoader implements CommandLineRunner { 

	private final DashRepository repository;

	@Autowired 
	public DataLoader(DashRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.repository.save(new Dash());
	}
}