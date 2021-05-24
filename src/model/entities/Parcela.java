package model.entities;

import java.util.Date;

public class Parcela {
	private Date vencimento;
	private Integer numeroParcela;
	private Double valorParcela;
	private Double valorTaxa;

	public Parcela() {
	}

	public Parcela(Date vencimento, Integer numeroParcela, Double valorParcela, Double valorTaxa) {
		this.vencimento = vencimento;
		this.numeroParcela = numeroParcela;
		this.valorParcela = valorParcela;
		this.valorTaxa = valorTaxa;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(Double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}
	
	public Double getValorTotal() {
		return valorParcela + valorTaxa;
	}
}