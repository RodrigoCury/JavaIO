package br.dev.rodrigocury.io.teste;

import java.io.*;

public class TesteSerializacao {

    public static void main(String[] args)  {
        desserializar();

    }

    @SuppressWarnings("unused")
    private static void serializar(){
        String nome = "Rodrigo Cury";

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("objeto.bin"))){
            os.writeObject(nome);
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    private static void desserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"))){
            String s = (String) ois.readObject();
            System.out.println(s);
        } catch (IOException | ClassNotFoundException e){
            e.getStackTrace();
        }
    }
}
