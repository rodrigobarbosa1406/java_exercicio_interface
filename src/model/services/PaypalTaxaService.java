package model.services;

public class PaypalTaxaService implements TaxaService {
	public static final Double percTaxa = 0.02;
	
	public double taxa(double valor) {
		valor = valor * percTaxa;
		
		return valor;
	}
}
