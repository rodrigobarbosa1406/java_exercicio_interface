package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoService {
	private Integer numeroParcela;
	public static final Double juroSimples = 0.01;
	
	private TaxaService taxaService;

	public ContratoService(Integer numeroParcela, TaxaService taxaService) {
		this.numeroParcela = numeroParcela;
		this.taxaService = taxaService;
	}
	
	public void processarContrato(Contrato contrato) {
		Date vencimento = Date.from(null);
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(contrato.getData());
		calendario.add(Calendar.MONTH, numeroParcela);
		vencimento = calendario.getTime();
		
		double valor = contrato.getValor() / contrato.getQtdeParcelas();
		valor += (valor * juroSimples) * numeroParcela;
		
		double taxa = taxaService.taxa(valor);
		
		contrato.setParcela(new Parcela(vencimento, numeroParcela, valor, taxa));
	}
}
