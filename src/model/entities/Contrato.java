package model.entities;

import java.util.Date;

public class Contrato {
	private Integer numero;
	private Date data;
	private Double valor;
	private Integer qtdeParcelas;
	
	private Parcela parcela;
	
	public Contrato() {
	}

	public Contrato(Integer numero, Date data, Double valor, Integer qtdeParcelas) {
		this.numero = numero;
		this.data = data;
		this.valor = valor;
		this.qtdeParcelas = qtdeParcelas;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
}
