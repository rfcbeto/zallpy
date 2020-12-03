package com.roberto.iosys.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputFileVO implements Serializable{

	private static final long serialVersionUID = -5014033799657182852L;

	@JsonProperty("total_clientes")
	private Integer totalCustomers;
	
	@JsonProperty("total_vendedores")
	private Integer totalSellers;
	
	@JsonProperty("maior_venda")
	private Long biggestSale;
	
	@JsonProperty("nome_pior_vendedor")
	private String worstSeller;
	
	@JsonProperty("mensagem")
	private String messasge;

	public Integer getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(Integer totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public Integer getTotalSellers() {
		return totalSellers;
	}
	public void setTotalSellers(Integer totalSellers) {
		this.totalSellers = totalSellers;
	}
	public Long getBiggestSale() {
		return biggestSale;
	}
	public void setBiggestSale(Long biggestSale) {
		this.biggestSale = biggestSale;
	}
	public String getWorstSeller() {
		return worstSeller;
	}
	public void setWorstSeller(String worstSeller) {
		this.worstSeller = worstSeller;
	}
	public String getMessasge() {
		return messasge;
	}
	public void setMessasge(String messasge) {
		this.messasge = messasge;
	}
	@Override
	public String toString() {
		return "total_clientes = " 			+ totalCustomers + 
				"\ntotal_vendedores = " 	+ totalSellers   + 
				"\nmaior_venda = "  		+ biggestSale    + 
				"\nnome_pior_vendedor = "  + worstSeller;
	}
	
	
}
