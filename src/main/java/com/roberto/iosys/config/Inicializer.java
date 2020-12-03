package com.roberto.iosys.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.iosys.service.ReadFileService;

@Service
public class Inicializer {
	
	@Autowired
	private ReadFileService readFileService;

	public static void main(String[] args) {
		Inicializer init = new Inicializer();
		init.readFile();
		
	}
	
	public void readFile() {
		try {
			readFileService.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
