# Jogo da Velha em Java

Um jogo da velha implementado em Java com arquitetura moderna, utilizando padrões de projeto e boas práticas de desenvolvimento.

## Arquitetura

O projeto segue uma arquitetura em camadas:

- **Model**: Classes de domínio (Board, Cell, Player, GameState)
- **View**: Interface de usuário (ConsoleView)
- **Controller**: Controlador do jogo (GameController)
- **Service**: Lógica de negócio (GameService)
- **Strategy**: Implementação do padrão Strategy para diferentes níveis de IA

## Padrões de Projeto Utilizados

1. **MVC (Model-View-Controller)**: Separação de responsabilidades
2. **Strategy**: Para diferentes níveis de inteligência artificial
3. **Factory Method**: Criação de estratégias de IA
4. **Immutable Objects**: GameState é imutável
5. **Dependency Injection**: Injeção de dependências no controller

## Funcionalidades

- Jogo contra outro jogador
- Três níveis de dificuldade contra IA:
  - Fácil: Movimentos aleatórios
  - Médio: Tenta vencer ou bloquear
  - Difícil: Usa algoritmo Minimax
- Interface de linha de comando
- Validação de jogadas
- Detecção de vitória/empate

## Como Executar

### Requisitos
- Java 11 ou superior
- Maven

### Compilar e Executar
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.jogodavelha.Main"
```
### Autor
Marcelo Saorim

## Características Modernas Implementadas

1. **Imutabilidade**: `GameState` é imutável para evitar efeitos colaterais
2. **Injeção de Dependências**: Controller recebe Service e View
3. **Padrão Strategy**: Para diferentes níveis de IA
4. **Separação de Responsabilidades**: MVC bem definido
5. **Tratamento de Erros**: Validações e mensagens de erro
6. **Código Testável**: Baixo acoplamento facilita testes