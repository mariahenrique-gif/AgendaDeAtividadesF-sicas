package br.ufpb.dcx.MH.agenda;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface Agenda {
    boolean cadastraAtividade(String nome, int dia, int mes, String tipo, String dificuldade, double quilometragem, int duracaoMinutos);
    Collection<Atividade> pesquisaAtividadesPorData(int dia, int mes);
    Collection<Atividade> pesquisaAtividadesPorTipo(String tipo);
    void removeAtividade(String codigo) throws AtividadeInexistenteException;
    List<String> listarAtividades();
    String totalHorasPorMes(int mes);
    String totalQuilometrosPorMes(int mes);
    void salvarDados() throws IOException;
    void recuperarDados() throws IOException;
}