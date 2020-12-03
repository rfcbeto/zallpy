package com.roberto.iosys.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.roberto.iosys.vo.FileVO;
import com.roberto.iosys.vo.ItemVO;

@Service
public class ReadFileService {
	public static final String HOMEPATH = System.getProperty("user.home");
	public static final String INPUT = HOMEPATH + "/data/in";
	public static final String OUTPUT = HOMEPATH + "/data/out";
	
	
	public List<FileVO> readFile() throws IOException {
		Stream<Path> pathfiles = uploadFiles();
		
		List<List<FileVO>> files = pathfiles.map(p -> p.toString())
		 .filter(p -> p.endsWith(".dat"))
		 .map(p -> readFile(p))
		 .collect(Collectors.toList());
		
		return files.get(0); 
	}
	
	/*
	 * Método responsável por recuperar todos os arquivos da pasta com extensão .dat 
	 */
	private Stream<Path> uploadFiles() throws IOException {
		Stream<Path> paths = Files.walk(Path.of(INPUT), 2);
		return paths;
	}
	
	private List<FileVO> readFile(String pathFile) {
		List<FileVO> listFileVO = new ArrayList<>(); 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(pathFile)));
			while(br.ready()){
				listFileVO.add(createFileVO(br.readLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return listFileVO;
	}
	
	/*
	 * Monta o objeto fileVO pelo tipo.
	 */
	private FileVO createFileVO(String line) {
		FileVO fileVO = new FileVO();
		String[] arrayFileVO = line.split("ç");
		
		switch (arrayFileVO[0]) {
		
			case "001":
				createSalesman(fileVO, arrayFileVO);
				break;
				
			case "002":
				createCustomer(fileVO, arrayFileVO);
				break;
				
			case "003":
				createSales(fileVO, arrayFileVO);
				break;
		}
				
		return fileVO;
	}

	private void createSales(FileVO fileVO, String[] arrayFileVO) {
		fileVO.setCode(arrayFileVO[0]);
		fileVO.setIdSale(Long.valueOf(arrayFileVO[1]));
		fileVO.setItemVO(createItemVO(arrayFileVO[2]));
		fileVO.setTotalSales(sumItensVO(fileVO.getItemVO()));
		fileVO.setAverageSale(average(fileVO));
		fileVO.setSellersName(arrayFileVO[3]);
	}

	private Double average(FileVO fileVO) {
		return fileVO.getTotalSales()/fileVO.getItemVO().size();
	}

	private Double sumItensVO(List<ItemVO> listItemVO) {
		Double totalSales = 0.0;
		for (ItemVO itemVO : listItemVO) {
			totalSales += itemVO.getPrice() * itemVO.getItemQuantity();
		}
		
		return totalSales;
	}

	private void createCustomer(FileVO fileVO, String[] arrayFileVO) {
		fileVO.setCode(arrayFileVO[0]);
		fileVO.setCnpj(arrayFileVO[1]);
		fileVO.setName(arrayFileVO[2]);
		fileVO.setBusinessArea(arrayFileVO[3]);
	}

	private void createSalesman(FileVO fileVO, String[] arrayFileVO) {
		fileVO.setCode(arrayFileVO[0]);
		fileVO.setCpf(arrayFileVO[1]);
		fileVO.setName(arrayFileVO[2]);
		fileVO.setSalary(Double.valueOf(arrayFileVO[3]));
	}

	private List<ItemVO> createItemVO(String item) {
		List<ItemVO> listItemVO = new ArrayList<>();
		item = item.replaceAll("[\\[\\]\\(\\)]", "");
		String[] itens = item.split(",");

		for (int i = 0; i < itens.length; i++) {
			ItemVO itemVO = new ItemVO();
			String[] splitItem = itens[i].split("-");
			itemVO.setId(Long.valueOf(splitItem[0]));
			itemVO.setItemQuantity(Integer.valueOf(splitItem[1]));
			itemVO.setPrice(Double.valueOf(splitItem[2]));
			listItemVO.add(itemVO);
		}
		return listItemVO;
	}
	
}
