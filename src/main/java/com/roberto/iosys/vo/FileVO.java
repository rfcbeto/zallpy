package com.roberto.iosys.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FileVO {

	@JsonProperty("codigo")
	private String code;
	
	private String cpf;
	private String cnpj;
	
	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("salario")
	private Double salary;
	
	@JsonProperty("area_negocio")
	private String businessArea;
	
	@JsonProperty("identificador_venda")
	private Long idSale;
	
	@JsonProperty("total_vendas")
	private Double totalSales;
	
	@JsonProperty("pior_venda")
	private Double averageSale;
	
	@JsonProperty("pior_vendedor")
	private String sellersName;
	
	private List<ItemVO> itemVO;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	public Long getIdSale() {
		return idSale;
	}
	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}
	public Double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;
	}
	public Double getAverageSale() {
		return averageSale;
	}
	public void setAverageSale(Double averageSale) {
		this.averageSale = averageSale;
	}
	public String getSellersName() {
		return sellersName;
	}
	public void setSellersName(String sellersName) {
		this.sellersName = sellersName;
	}
	public List<ItemVO> getItemVO() {
		return itemVO;
	}
	public void setItemVO(List<ItemVO> itemVO) {
		this.itemVO = itemVO;
	}
	
}
