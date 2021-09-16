package br.dev.rodrigocury.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class TesteEncoding {

	public static void main(String[] args) {
		String string = "C";
		print(string);

		String s = "À";
		print(s);

	}

	private static void print(String c) {
		print(c, 0);
	}

	private static void print(String c, int i) {
		List<String> aStrings = Arrays.asList(StandardCharsets.ISO_8859_1.displayName(),
				StandardCharsets.US_ASCII.displayName(), StandardCharsets.UTF_16.displayName(),
				StandardCharsets.UTF_16BE.displayName(), StandardCharsets.UTF_16LE.displayName(),
				StandardCharsets.UTF_8.displayName(), "ASCII", "windows-1252");

		aStrings.forEach(string -> {
			byte[] bytes;
			try {
				bytes = c.getBytes(string);

				String s = new String(bytes, string);

				System.out.println(String.format("%s at: %03d - é %s com %d Byte%s usando %s", c, c.codePointAt(i), s,
						bytes.length, bytes.length > 1 ? "s" : " ", string));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println(string + "Não é suportada");
			}

		});

	}

}
