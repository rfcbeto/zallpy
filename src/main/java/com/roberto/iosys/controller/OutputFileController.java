package com.roberto.iosys.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.iosys.service.OutputFileService;
import com.roberto.iosys.vo.OutputFileVO;

@RestController
@RequestMapping("/outputfile")
public class OutputFileController {

	@Autowired
	private OutputFileService service;
	
	@GetMapping(value="/report", produces = {"application/json"})
	public ResponseEntity<OutputFileVO> outputFile(){
		OutputFileVO outputFileVO = new OutputFileVO();
		try {
			outputFileVO = service.generateOutputFileVO();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<OutputFileVO>(outputFileVO, HttpStatus.OK);
	}
}
