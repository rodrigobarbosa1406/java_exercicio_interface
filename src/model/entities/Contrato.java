package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private Integer numero;
	private Date data;
	private Double valor;
	private Integer qtdeParcelas;
	
	private List<Parcela> parcelas = new ArrayList<>();
	
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

	public List<Parcela> getParcela() {
		return parcelas;
	}

	public void setParcela(List<Parcela> parcela) {
		this.parcelas = parcela;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		double valorTotal = 0.0;
		double jurosTotal = 0.0;
		double taxaTotal = 0.0;
		
		for (Parcela parcela : parcelas) {
			if (parcela.getNumeroParcela() < 10) {
				sb.append("0");
				sb.append(parcela.getNumeroParcela());
			} else {
				sb.append(parcela.getNumeroParcela());
			}
			
			sb.append(" - ");
			sb.append(sdf.format(parcela.getVencimento()));
			sb.append(" - ");
			sb.append(String.format("%.2f", parcela.getValorTotal()));
			sb.append(" (Valor principal: ");
			sb.append(String.format("%.2f", (double)(valor / qtdeParcelas)));
			sb.append(" + Juros: ");
			sb.append(String.format("%.2f", (double)(parcela.getValorParcela() - (valor / qtdeParcelas))));
			sb.append(" + Taxa: ");
			sb.append(String.format("%.2f", parcela.getValorTaxa()));
			sb.append(")");
			sb.append(";\n");
			
			valorTotal += parcela.getValorTotal();
			jurosTotal += (double)(parcela.getValorParcela() - (valor / qtdeParcelas));
			taxaTotal += parcela.getValorTaxa();
		}
		
		sb.append("\n");
		sb.append("VALOR TOTAL DO FINANCIAMENTO\n");
		sb.append(String.format("%.2f", valorTotal));
		sb.append(" (Valor principal: ");
		sb.append(String.format("%.2f", valor));
		sb.append(" + Juros: ");
		sb.append(String.format("%.2f", jurosTotal));
		sb.append(" + Taxa: ");
		sb.append(String.format("%.2f", taxaTotal));
		sb.append(")");
		
		return sb.toString();
	}
}
