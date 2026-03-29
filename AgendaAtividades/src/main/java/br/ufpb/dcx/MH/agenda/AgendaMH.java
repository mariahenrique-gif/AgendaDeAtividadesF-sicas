package br.ufpb.dcx.MH.agenda;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AgendaMH implements Agenda {

    private HashMap<String, Atividade> atividades;
    private GravadorDeDados gravador;
    private int contadorCodigo = 1;

    public AgendaMH(){
        this.atividades = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraAtividade(String nome, int dia, int mes, String tipo, String dificuldade, double quilometragem, int duracaoMinutos) {
        String codigo = "ATV" + contadorCodigo++;
        Atividade a = new Atividade(codigo, nome, dia, mes, tipo, dificuldade, quilometragem, duracaoMinutos);
        this.atividades.put(codigo, a);
        return true;
    }

    @Override
    public Collection<Atividade> pesquisaAtividadesPorData(int dia, int mes) {
        return atividades.values().stream()
                .filter(a -> a.getDia() == dia && a.getMes() == mes)
                .toList();
    }

    @Override
    public Collection<Atividade> pesquisaAtividadesPorTipo(String tipo) {
        return atividades.values().stream()
                .filter(a -> a.getTipo().equalsIgnoreCase(tipo))
                .toList();
    }

    @Override
    public void removeAtividade(String codigo) throws AtividadeInexistenteException {
        if (this.atividades.containsKey(codigo)){
            this.atividades.remove(codigo);
        } else {
            throw new AtividadeInexistenteException("Não existe atividade com o código "+codigo);
        }
    }

    @Override
    public List<String> listarAtividades() {
        return atividades.values().stream()
                .map(Atividade::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String totalHorasPorMes(int mes) {
        int minutosTotais = atividades.values().stream()
                .filter(a -> a.getMes() == mes)
                .mapToInt(Atividade::getDuracaoMinutos)
                .sum();
        double horas = minutosTotais / 60.0;
        return "Total de atividades em " + mes + ": " + horas + " horas";
    }

    @Override
    public String totalQuilometrosPorMes(int mes) {
        double kmTotais = atividades.values().stream()
                .filter(a -> a.getMes() == mes &&
                        (a.getTipo().equalsIgnoreCase("Corrida") ||
                                a.getTipo().equalsIgnoreCase("Caminhada") ||
                                a.getTipo().equalsIgnoreCase("Trilha")))
                .mapToDouble(Atividade::getQuilometragem)
                .sum();
        return "Total de atividades em " + mes + ": " + kmTotais + " km";
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarAtividades(this.atividades);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.atividades = this.gravador.recuperarAtividades();
    }
}
