package br.dev.rodrigocury.io.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.dev.rodrigocury.modelo.Cliente;
import br.dev.rodrigocury.modelo.Conta;
import br.dev.rodrigocury.modelo.ContaCorrente;
import br.dev.rodrigocury.modelo.ContaPoupanca;

public class TesteLeituraCSV {

	public static void main(String[] args) {
		solucaoDaAula();
		
		minhaSolucao();
	}

	private static void solucaoDaAula() {

		try (Scanner scanner = new Scanner(new File("contas.csv"));) {

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();

				try (Scanner linhaScanner = new Scanner(linha);) {

					linhaScanner.useDelimiter(",");
					linhaScanner.useLocale(Locale.US);

					String tipoConta = linhaScanner.next();
					int agencia = linhaScanner.nextInt();
					int numero = linhaScanner.nextInt();
					String nome = linhaScanner.next();
					double saldo = linhaScanner.nextDouble();

					String valorFormatado = String.format(Locale.US, "%s - %04d-%08d %s : $%.2f", tipoConta, agencia,
							numero, nome, saldo);

					System.out.println(valorFormatado);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}

	}

	private static void minhaSolucao() {
		try (Scanner scanner = new Scanner(new File("contas.csv"));) {
			String linha = scanner.hasNextLine() ? scanner.nextLine() : null;

			List<List<String>> ls = new ArrayList<List<String>>();

			while (linha != null) {

				List<String> lineLS = Arrays.asList(linha.split(","));

				ls.add(lineLS);

				if (scanner.hasNextLine())
					linha = scanner.nextLine();
				else
					linha = null;

			}

			ArrayList<Conta> contas = new ArrayList<Conta>();

			for (List<String> list : ls) {

				try {

					Conta conta = null;

					String tipoConta = list.get(0);
					int agencia = Integer.parseInt(list.get(1));
					int numero = Integer.parseInt(list.get(2));
					String nomeTitular = list.get(3);
					double saldo = Double.parseDouble(list.get(4));

					if (tipoConta.equals("CC")) {
						conta = new ContaCorrente(agencia, numero);
					} else if (tipoConta.equals("CP")) {
						conta = new ContaPoupanca(agencia, numero);
					} else {
						continue;
					}

					Cliente cliente = new Cliente();
					cliente.setNome(nomeTitular);

					conta.setTitular(cliente);
					conta.deposita(saldo);

					contas.add(conta);

				} catch (Exception e) {
					System.out.println(e);
					continue;
				}
			}

			contas.forEach((conta) -> System.out.println(conta));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
