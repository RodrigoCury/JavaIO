package br.dev.rodrigocury.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		
		newFile();
		
//		// Fluxo de entrada com Arquivo
//		
//		FileInputStream fis = new FileInputStream("txt.txt");
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);

//		
//		String linha = br.readLine();
//		
//		while (linha != null) {
//			System.out.println(linha);
//			linha = br.readLine();
//		}
//		
//		br.close();
	}
	
	private static void newFile() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("txt.txt")))){
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
