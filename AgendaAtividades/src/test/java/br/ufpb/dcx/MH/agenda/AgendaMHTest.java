package br.ufpb.dcx.MH.agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaMHTest {

    private AgendaMH agenda;

    @BeforeEach
    public void setUp() {
        agenda = new AgendaMH();
        agenda.cadastraAtividade("Corrida matinal", 5, 3, "Corrida", "Moderada", 7.5, 45);
        agenda.cadastraAtividade("Caminhada na praia", 6, 3, "Caminhada", "Leve", 3.2, 60);
        agenda.cadastraAtividade("Yoga relaxante", 7, 3, "Alongamento", "Leve", 0, 30);
        agenda.cadastraAtividade("Musculação", 8, 4, "Força", "Intensa", 0, 90);
        agenda.cadastraAtividade("Trilha ecológica", 15, 4, "Trilha", "Moderada", 12.0, 120);
    }

    @Test
    public void testCadastroAtividade() {
        boolean cadastrou = agenda.cadastraAtividade("Pilates", 10, 4, "Alongamento", "Leve", 0, 50);
        assertTrue(cadastrou, "A atividade deveria ser cadastrada com sucesso");
    }

    @Test
    public void testPesquisaPorTipo() {
        Collection<Atividade> corridas = agenda.pesquisaAtividadesPorTipo("Corrida");
        assertEquals(1, corridas.size(), "Deveria haver 1 atividade do tipo Corrida");
    }

    @Test
    public void testPesquisaPorData() {
        Collection<Atividade> atividadesDia6 = agenda.pesquisaAtividadesPorData(6, 3);
        assertEquals(1, atividadesDia6.size(), "Deveria haver 1 atividade no dia 6/3");
    }

    @Test
    public void testTotalHorasPorMes() {
        String relatorioMar = agenda.totalHorasPorMes(3);
        assertTrue(relatorioMar.contains("horas"), "O relatório deve indicar horas");
    }

    @Test
    public void testTotalQuilometrosPorMes() {
        String relatorioAbr = agenda.totalQuilometrosPorMes(4);
        assertTrue(relatorioAbr.contains("km"), "O relatório deve indicar km");
    }

    @Test
    public void testRemoverAtividade() throws AtividadeInexistenteException {
        agenda.removeAtividade("ATV1"); // remove Corrida matinal
        List<String> lista = agenda.listarAtividades();
        assertFalse(lista.stream().anyMatch(a -> a.contains("ATV1")), "ATV1 não deveria mais estar na lista");
    }

    @Test
    public void testPersistencia() throws IOException {
        agenda.salvarDados();
        AgendaMH novaAgenda = new AgendaMH();
        novaAgenda.recuperarDados();
        assertFalse(novaAgenda.listarAtividades().isEmpty(), "Após recuperar, a lista não deve estar vazia");
    }
}