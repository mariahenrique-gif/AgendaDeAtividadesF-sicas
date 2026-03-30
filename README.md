# AgendaDeAtividadesFísicas

## Descrição
Aplicação em Java para cadastro e gerenciamento de atividades físicas ou treinos.  
Permite registrar atividades com informações como nome, tipo, dificuldade, quilometragem e duração.
Foi pensado em como organizar uma agenda para pessoas interessadas em esport e exercicios de todos os tipos.

## Estrutura da Classe `Atividade`
A classe possui os seguintes atributos:
- `codigo`: código único gerado automaticamente para cada atividade.
- `nome`: nome da atividade (ex.: Corrida matinal, Natação).
- `dia`: dia da atividade.
- `mes`: mês da atividade.
- `tipo`: categoria da atividade (Corrida, Caminhada, Trilha, Cardio, Força, Alongamento).
- `dificuldade`: nível de dificuldade.
- `quilometragem`: distância percorrida (quando aplicável).
- `duracaoMinutos`: tempo de duração em minutos.

## Construtores
- **Construtor padrão**: inicializa os atributos com valores default caso não sejam informados.
- **Construtor completo**: permite criar uma atividade com dados fornecidos pelo usuário, aplicando valores padrão se algum campo vier vazio.

## Funcionalidades
- Cadastro de novas atividades.
- Listagem de atividades registradas.
- Pesquisa por data ou tipo.
- Remoção de atividades.
- Cálculo de totais (horas e quilômetros).
- Salvamento e recuperação de dados em arquivo.

## Como executar
1. Abra o projeto no IntelliJ IDEA ou outra IDE compatível.
2. Compile e execute a classe principal (`AgendaGUIV3`).
3. Utilize a interface gráfica para cadastrar, pesquisar e gerenciar atividades.

## Observações
- O campo `codigo` é gerado automaticamente pelo sistema, não precisa ser informado pelo usuário.
- Se algum campo não for preenchido, o sistema atribui valores padrão como *“Atividade não informada”* ou *“Tipo não informado”*.
