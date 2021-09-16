package br.dev.rodrigocury.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		
		writerTry();
//		
//		// Fluxo de entrada com Arquivo
//		
//		OutputStream fos = new FileOutputStream("txt.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
//		
//		bw.write("Bixin é brabo\n");
//		bw.newLine();
//		bw.write("Cehloko Bixo");
//		
//		bw.close();
	}
	
	private static void writerTry() {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("txt.txt")))){
			bw.write("Bixin é brabo\n");
			bw.newLine();
			bw.write("Cehlokinho Bixo");
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
