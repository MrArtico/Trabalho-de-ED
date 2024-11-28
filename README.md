# Projeto de Estruturas de Dados e Algoritmos

Este projeto implementa várias estruturas de dados e algoritmos, incluindo Árvores Binárias, Árvores AVL, Vetores dinâmicos e algoritmos de ordenação como QuickSort e BubbleSort. Além disso, foram desenvolvidos testes de desempenho para medir a eficácia de cada estrutura e algoritmo com diferentes tipos de dados (ordenados, aleatórios e invertidos).

## Estruturas de Dados

O projeto inclui a implementação das seguintes estruturas de dados:

- **Árvore Binária**
- **Árvore AVL**
- **Vetor Dinâmico**

### 1. **Árvore Binária**

A árvore binária é uma estrutura de dados em que cada nó tem, no máximo, dois filhos. A árvore binária não precisa ser balanceada, e a inserção de novos elementos ocorre no primeiro lugar disponível.

**Métodos principais**:
- `inserir(int valor)`: Insere um valor na árvore.
- `buscar(int valor)`: Realiza a busca de um valor na árvore.

### 2. **Árvore AVL**

A árvore AVL é uma árvore binária de busca balanceada, onde a diferença de altura entre as subárvores de qualquer nó não pode ser maior do que 1. Isso garante uma performance eficiente de inserção e busca.

**Métodos principais**:
- `inserir(int valor)`: Insere um valor na árvore e balanceia a árvore se necessário.
- `buscar(int valor)`: Realiza a busca de um valor na árvore.

### 3. **Vetor Dinâmico**

O vetor dinâmico é uma estrutura de dados que cresce automaticamente quando novos elementos são inseridos. Ele permite o acesso rápido aos elementos pelo índice e realiza a busca sequencial e binária.

**Métodos principais**:
- `inserir(int valor)`: Insere um valor no vetor.
- `buscaSequencial(int valor)`: Realiza uma busca sequencial no vetor.
- `buscaBinaria(int valor)`: Realiza uma busca binária no vetor.

## Algoritmos

O projeto implementa os seguintes algoritmos:

- **Bubble Sort**: Um algoritmo simples de ordenação baseado em comparações sucessivas entre elementos adjacentes, trocando-os de lugar quando necessário.
- **QuickSort**: Um algoritmo eficiente de ordenação baseado no método de divisão e conquista.

## Testes de Desempenho

O projeto inclui classes de testes para medir o tempo de execução das operações de inserção e busca nas estruturas de dados, assim como a performance dos algoritmos de ordenação. As classes de testes geram dados em diferentes ordens (ordenados, aleatórios, invertidos) e calculam a média do tempo de execução para cada operação.

### Classes de Teste:

- **TestadorArvoreAVL**: Realiza testes de desempenho para a árvore AVL.
- **TestadorArvoreBinaria**: Realiza testes de desempenho para a árvore binária.
- **TestadorVetor**: Realiza testes de desempenho para o vetor dinâmico.

### Métodos Principais nos Testadores:

#### `TestadorArvoreAVL`

- **`testarArvoreAVL(int[] dados, String ordem)`**:
  - Testa o desempenho da árvore AVL com os dados fornecidos.
  - Mede o tempo médio de inserção e busca para diferentes ordens de dados.

- **`calcularMedia(Runnable teste)`**:
  - Calcula o tempo médio de execução de uma operação.
  - Executa o teste várias vezes e calcula a média do tempo de execução.

- **`gerarDados(int tamanho, String ordem)`**:
  - Gera dados em uma ordem específica ("ordenado", "invertido", "aleatorio"). E nos tamanhos 100, 1000, 10000.

#### `TestadorArvoreBinaria`

- **`testarArvoreBinaria(int[] dados, String ordem)`**:
  - Testa o desempenho da árvore binária com os dados fornecidos.
  - Mede o tempo de inserção e busca para diferentes ordens de dados.

- **`calcularMedia(Runnable teste)`**:
  - Calcula o tempo médio de execução de uma operação.
  - Executa o teste várias vezes e calcula a média do tempo de execução.

- **`gerarDados(int tamanho, String ordem)`**:
  - Gera dados em uma ordem específica ("ordenado", "invertido", "aleatorio").

#### `TestadorVetor`

- **`testarVetor(int[] dados, int tamanho, String ordem)`**:
  - Testa o desempenho do vetor dinâmico com os dados fornecidos.
  - Mede o tempo de inserção, ordenação (Bubble Sort e QuickSort) e buscas (sequenciais e binárias).

- **`calcularMedia(Runnable teste)`**:
  - Calcula o tempo médio de execução de uma operação.
  - Executa o teste 5 vezes e calcula a média do tempo de execução.

- **`gerarDados(int tamanho, String ordem)`**:
  - Gera dados em uma ordem específica ("ordenado", "reverso", "aleatorio") e nos tamanhos definidos.

## Cronômetro

A classe **`Cronometro`** é utilizada para medir o tempo de execução de operações em todas as classes de teste. Ela utiliza o `System.nanoTime()` para obter uma medição precisa em nanosegundos.

**Métodos principais**:
- **`iniciar()`**: Inicia o cronômetro.
- **`parar()`**: Para o cronômetro.
- **`getDuracaoMilissegundos()`**: Retorna o tempo de execução em milissegundos.

## Como Executar

Para executar os testes, basta rodar as classes de teste (`TestadorArvoreAVL`, `TestadorArvoreBinaria`, `TestadorVetor`) a partir do método `main` dentro deles.
Versão do Java: `21.0.4 (LTS).`
Data de lançamento: `16 de julho de 2024.`
Distribuição: `Eclipse Temurin (um dos builds mais usados e confiáveis de OpenJDK).`
Ambiente de execução:
- **`OpenJDK Runtime Environment com build 21.0.4+7-LTS.`
