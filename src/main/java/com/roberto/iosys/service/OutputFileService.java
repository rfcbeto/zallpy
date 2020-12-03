package com.roberto.iosys.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.iosys.vo.FileVO;
import com.roberto.iosys.vo.OutputFileVO;

@Service
public class OutputFileService {
	public static final String HOMEPATH = System.getProperty("user.home");
	public static final String INPUT = HOMEPATH + "/data/in";
	public static final String OUTPUT = HOMEPATH + "/data/out/";
	
	
	@Autowired
	private ReadFileService service;
	
	private List<FileVO> listFileVO;
	
	public OutputFileVO generateOutputFileVO() throws IOException {
		OutputFileVO outputFileVO = new OutputFileVO();
		listFileVO = loadFileMemory();
		Integer totalCustomers = countCustomers();
		Integer totalSellers = countSellers();
		Long biggestSale = biggestSale();
		String worstSeller = worstSeller();
		
		outputFileVO.setTotalCustomers(totalCustomers);
		outputFileVO.setTotalSellers(totalSellers);
		outputFileVO.setBiggestSale(biggestSale);
		outputFileVO.setWorstSeller(worstSeller);
		
		saveReport(outputFileVO);
		return outputFileVO;
	}

	private void saveReport(OutputFileVO outputFileVO) {
		Path path = Paths.get(OUTPUT+"report-sellers.done.dat");
		
		try {
			
			FileOutputStream fos = new FileOutputStream(path.toFile());
			PrintWriter writer = new PrintWriter(fos);
			writer.print(outputFileVO);
			writer.close();
			outputFileVO.setMessasge("Seu relatório foi salvo em: " + path.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	private Integer countCustomers() {
		List<FileVO> customers = getListFileVO().stream().filter(p -> p.getCode().equals("001")).collect(Collectors.toList());
		return customers.size();
	}

	private Integer countSellers() {
		List<FileVO> sellers = getListFileVO().stream().filter(p -> p.getCode().equals("002")).collect(Collectors.toList());
		return sellers.size();
	}
	
	private String worstSeller() {
		Optional<FileVO> sellers = getListFileVO().stream().filter(p -> p.getCode().equals("003")).min(Comparator.comparingDouble(FileVO::getAverageSale));
		return sellers.get().getSellersName();
	}
	
	private Long biggestSale() {
		Optional<FileVO> sellers = getListFileVO().stream().filter(p -> p.getCode().equals("003")).max(Comparator.comparingDouble(FileVO::getTotalSales));
		return sellers.get().getIdSale();
	}
	
	
	private List<FileVO> loadFileMemory() throws IOException {
		return service.readFile();
	}

	public List<FileVO> getListFileVO() {
		return listFileVO;
	}

	public void setListFileVO(List<FileVO> listFileVO) {
		this.listFileVO = listFileVO;
	}
}
