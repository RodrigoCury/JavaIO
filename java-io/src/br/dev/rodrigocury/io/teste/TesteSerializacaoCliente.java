package br.dev.rodrigocury.io.teste;

import br.dev.rodrigocury.modelo.Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoCliente {
    private static String arquivo = "cliente.bin";

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Rodrigo", "111222333-12", "Dev");
//        serializa(cliente);
        desserializa();
    }

    private static void serializa(Object o){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(o);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void desserializa(){
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            Cliente cliente = (Cliente) ois.readObject();
            System.out.println(cliente);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
