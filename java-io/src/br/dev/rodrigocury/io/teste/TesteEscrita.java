package br.dev.rodrigocury.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {

		printStream();

//		fileWriter();

//		writerTry();
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
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("txt.txt")))) {
			bw.write("Bixin é brabo");
			bw.newLine();
			bw.write("Cehlokinho Bixo");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void writeList() {
		PrintWriter out = null;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		try {
			System.out.println("Entering" + " try statement");

			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < list.size(); i++) {
				out.println("Value at: " + i + " = " + list.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());

		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}

	private static void fileWriter() throws IOException {
		File f = new File("txt3.txt");
		System.out.println(File.pathSeparator);
		System.out.println(File.separatorChar);

		f.createNewFile();
		try (FileWriter fw = new FileWriter(f);) {

			fw.write("Teste");
			fw.write(System.lineSeparator());
			fw.write("Teste");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printStream() throws IOException {

		try (
				PrintStream ps = new PrintStream("txt.txt");
				PrintWriter pw = new PrintWriter("txt1.txt");
			) {
			ps.println("Linha1");
			ps.println("Linha2");
			ps.println("Linha3");
			ps.println("Linha4");
			pw.println("Linha1");
			pw.println("Linha2");
			pw.println("Linha3");
			pw.println("Linha4");

		} catch (IOException e) {

		}

	}

}
