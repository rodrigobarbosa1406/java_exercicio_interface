package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoService {
	public static final Double juroSimples = 0.01;
	
	private TaxaService taxaService;

	public ContratoService(TaxaService taxaService) {
		this.taxaService = taxaService;
	}
	
	public void processarContrato(Contrato contrato) {
		List<Parcela> parcelas = new ArrayList<>();
		
		for (int i=1; i<=contrato.getQtdeParcelas(); i++) {
			Date vencimento;
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(contrato.getData());
			calendario.add(Calendar.MONTH, i);
			vencimento = calendario.getTime();
			
			double valor = contrato.getValor() / contrato.getQtdeParcelas();
			valor += (valor * juroSimples) * i;
			
			double taxa = taxaService.taxa(valor);
			
			parcelas.add(new Parcela(vencimento, i, valor, taxa));
		}
		
		contrato.setParcela(parcelas);
	}
}
