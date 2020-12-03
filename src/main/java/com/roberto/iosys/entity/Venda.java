package com.roberto.iosys.entity;

import java.util.List;

public class Venda {

	private Long id;
	private String codVenda;
	private Vendedor vendedor;
	private List<Cliente> itens;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(String codVenda) {
		this.codVenda = codVenda;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public List<Cliente> getItens() {
		return itens;
	}
	public void setItens(List<Cliente> itens) {
		this.itens = itens;
	}
	
}
