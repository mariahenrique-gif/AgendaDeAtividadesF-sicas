package br.ufpb.dcx.MH.agenda;

import java.io.Serializable;
import java.util.Objects;

public class Atividade implements Serializable {
    private String codigo;
    private String nome;// nome da atividade ex:correr na praia, nadar no mar.
    private int dia;
    private int mes;
    private String tipo;  //Tipo exato de Atividade. EX: Corrida, Caminhada, Trilha, Cardio, Força, Alongamento
    private String dificuldade;
    private double quilometragem; // usado apenas para atividades de distância
    private int duracaoMinutos;   // tempo de duração em minutos

    //construtor padrão
    public Atividade() {
        this.codigo = "0000";
        this.nome = "Atividade não informada";
        this.dia = 1;
        this.mes = 1;
        this.tipo = "Tipo não informado";
        this.dificuldade = "Não informada";
        this.quilometragem = 0.0;
        this.duracaoMinutos = 0;
    }


    public Atividade(String codigo, String nome, int dia, int mes, String tipo, String dificuldade, double quilometragem, int duracaoMinutos) {
        this.codigo = codigo;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.quilometragem = quilometragem;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getCodigo() {
        return codigo; }

    public String getNome() {
        return nome; }

    public int getDia() {
        return dia; }

    public int getMes() {
        return mes; }
    public String getTipo() {
        return tipo; }

    public String getDificuldade() {
        return dificuldade; }

    public double getQuilometragem() {
        return quilometragem; }

    public int getDuracaoMinutos() {
        return duracaoMinutos; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String toString() {
        String base = "Código: " + codigo +
                " | Tipo: " + tipo +
                " | Data: " + dia + "/" + mes +
                " | Duração: " + duracaoMinutos + " min";
        if (tipo.equalsIgnoreCase("Corrida") ||
                tipo.equalsIgnoreCase("Caminhada") ||
                tipo.equalsIgnoreCase("Trilha")) {
            base += " | Quilometragem: " + quilometragem + " km";
        }
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividade)) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(codigo, atividade.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}