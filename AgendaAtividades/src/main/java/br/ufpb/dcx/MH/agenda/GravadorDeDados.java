package br.ufpb.dcx.MH.agenda;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {

    private String arquivo = "atividades.dat";

    public void salvarAtividades(HashMap<String, Atividade> atividades) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(atividades);
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Atividade> recuperarAtividades() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (HashMap<String, Atividade>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar atividades", e);
        }
    }
}