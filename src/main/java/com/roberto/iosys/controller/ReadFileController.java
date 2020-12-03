package com.roberto.iosys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.iosys.service.ReadFileService;
import com.roberto.iosys.vo.FileVO;


@RestController
@RequestMapping("/readingfile")
public class ReadFileController {

	@Autowired
	private ReadFileService service;
	
	@GetMapping(value="/file", produces = {"application/json"})
	public ResponseEntity<List<FileVO>> uploadFile(){
		
		List<FileVO> filesVO = new ArrayList<>();
		try {
			filesVO = service.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<FileVO>>(filesVO, HttpStatus.OK);
	} 
	
}
