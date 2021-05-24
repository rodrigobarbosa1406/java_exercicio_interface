package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.services.ContratoService;
import model.services.PaypalTaxaService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("ENTRE COM OS DADOS DO CONTRATO");
			System.out.println();
			
			System.out.print("Número: ");
			int numero = sc.nextInt();
			
			System.out.print("Data (dd/MM/yyyy): ");
			Date data = sdf.parse(sc.next());
			sc.nextLine();
			
			System.out.print("Valor do contrato: ");
			double valor = sc.nextDouble();
			
			System.out.print("Número de parcelas: ");
			int qtdeParcelas = sc.nextInt();
			
			System.out.println();
			
			Contrato contrato = new Contrato(numero, data, valor, qtdeParcelas);
			
			ContratoService contratoService = new ContratoService(new PaypalTaxaService());
			contratoService.processarContrato(contrato);
			
			System.out.println("PARCELAS:");
			System.out.println(contrato.toString());
		} catch (ParseException e) {
			System.out.println("Data inválida: " + e.getMessage());
		}
		catch (RuntimeException e){
			System.out.println("Erro...");
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}