package br.dev.rodrigocury.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {
		
		newFile();
		
//		// Fluxo de entrada com Arquivo
//		
//		FileInputStream fis = new FileInputStream("txt.txt");
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);
//		
//		FileOutputStream fos = new FileOutputStream("txt2.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
//		
//		
//		String linha = br.readLine();
//		
//		while (linha != null) {
//			bw.write(linha);
//			linha = br.readLine();
//		}
//		
//		br.close();
//		bw.close();
	}
	
	private static void newFile() {
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("txt.txt")));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("txt2.txt")));
			)
		{
			String linha = br.readLine();
			
			while (linha != null) {
				bw.write(linha);
				bw.newLine();
				linha = br.readLine();
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
