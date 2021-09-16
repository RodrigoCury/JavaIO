package br.dev.rodrigocury.io.teste;

import br.dev.rodrigocury.modelo.ContaCorrente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoHeranca {
    private static String filaName = "herdado.bin";

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(123, 123);
        serializa(cc);
//        desserializa();
    }

    private static void serializa(Object o){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filaName))){
            oos.writeObject(o);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void desserializa(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filaName))){
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
