# 📄 **PRD — Product Requirements Document**

## **Produto: Roda Mais**

**Versão:** 1.0.0

**Responsável:** Marcos Anjos

**Data:** Dezembro/2025

**Disciplina:** Computação Móvel — UTFPR Pato Branco

---

## 1. Visão Geral

### 1.1. Descrição do Produto

O **Roda Mais** é um aplicativo móvel Android desenvolvido em Kotlin que permite aos usuários **calcular, comparar e tomar decisões rápidas sobre qual combustível compensa mais** (Gasolina, Álcool ou Diesel), com base no preço por litro e consumo do veículo.

O aplicativo oferece uma **experiência simples, rápida e confiável**, ajudando o usuário a economizar no abastecimento através de cálculos precisos de custo por quilômetro rodado.

De acordo com o escopo definido pela instituição, o aplicativo contém **três telas principais**:

- **Tela Principal (MainActivity)**: Preenchimento dos dados de consumo e preço para dois combustíveis
- **Tela de Seleção (SelectFuelActivity)**: Escolha do tipo de combustível (Gasolina, Álcool ou Diesel)
- **Tela de Resultados (ResultActivity)**: Exibição da comparação e recomendação final

---

## 2. Objetivos do Produto

- Permitir a **tomada de decisão rápida** sobre qual combustível é mais vantajoso
- Calcular o **custo por quilômetro rodado** para cada combustível
- Gerar **economia financeira ao usuário** através de recomendações baseadas em dados
- Aplicar na prática os conceitos de **computação móvel** e desenvolvimento Android
- Fornecer **comparação detalhada** entre dois combustíveis com economia em reais e percentual

---

## 3. Público-Alvo (Personas)

- Usuários que possuem:
    - Carro flex
    - Moto flex
    - Ônibus
    - Caminhão
- Qualquer pessoa que utilize **veículo que aceite diferentes tipos de combustível**
- Motoristas que desejam **otimizar seus gastos** com combustível

---

## 4. Problema que o Produto Resolve

### Situação Atual do Usuário

- Processo de cálculo manual complexo
- Muitas vezes o usuário **não faz a conta por preguiça ou falta de tempo**
- Decisão baseada apenas em preço, sem considerar consumo real do veículo
- Dificuldade em comparar múltiplos tipos de combustível simultaneamente
- Falta de informação sobre economia real em reais e percentual

### Solução Proposta pelo Roda Mais

- **Automação do cálculo** de custo por km
- **Resultado confiável** baseado em dados reais
- **Interface simples e objetiva** com tema minimalista
- **Decisão baseada em dados reais** de consumo e preço
- **Comparação visual** entre dois combustíveis
- **Recomendação clara** com economia calculada

---

## 5. Escopo do Produto

### ✅ Dentro do Escopo

- **Tela Principal (MainActivity)**:
    - Campos para inserir consumo (km/L) de dois combustíveis
    - Campos para inserir preço por litro (R$) de dois combustíveis
    - Botões para selecionar o tipo de cada combustível
    - Botão para calcular
    - Validação de campos com feedback visual

- **Tela de Seleção (SelectFuelActivity)**:
    - Seleção entre Gasolina, Álcool ou Diesel
    - Interface com cards clicáveis
    - Botão para voltar

- **Tela de Resultados (ResultActivity)**:
    - Exibição detalhada dos dados de cada combustível
    - Cálculo e exibição do custo por km
    - Recomendação do combustível mais econômico
    - Exibição da economia em reais e percentual
    - Botão para voltar (com reset automático dos campos)

- **Funcionalidades Técnicas**:
    - Cálculo automático do melhor combustível
    - Validação de dados de entrada
    - Tema visual minimalista (preto e amarelo)
    - Material Design 3
    - Reset automático de campos ao voltar

### ❌ Fora do Escopo

- Cadastro de usuários
- Login/Autenticação
- Dashboard ou histórico
- Persistência de dados (banco de dados)
- Exportação de informações
- Integração com APIs de preços
- Múltiplos veículos
- Histórico de cálculos anteriores

---

## 6. Funcionalidades Principais

### 6.1. Funcionalidade Central

1. **Inserção dos Dados**:
    - Consumo do combustível 1 (km/L)
    - Preço do combustível 1 (R$/L)
    - Consumo do combustível 2 (km/L)
    - Preço do combustível 2 (R$/L)

2. **Seleção do Tipo de Combustível**:
    - Seleção do tipo para cada um dos dois combustíveis
    - Opções: Gasolina, Álcool ou Diesel

3. **Cálculo Automático**:
    - Cálculo do custo por quilômetro para cada combustível
    - Fórmula: `Custo/km = Preço por litro / Consumo (km/L)`
    - Comparação entre os dois valores

4. **Exibição dos Resultados**:
    - Dados detalhados de cada combustível
    - Custo por km de cada um
    - Recomendação final:
        - "Gasolina é mais econômico!" ou
        - "Álcool é mais econômico!" ou
        - "Diesel é mais econômico!"
    - Economia em reais por km
    - Percentual de economia

5. **Reset Automático**:
    - Limpeza de todos os campos ao voltar da tela de resultados
    - Reabilitação de campos e botões

---

## 7. Fluxo do Usuário

1. Usuário acessa o aplicativo (Tela Principal)
2. Clica no botão de seleção do **Combustível 1**
3. App abre a **Tela de Seleção de Combustível**
4. Usuário escolhe o tipo (Gasolina, Álcool ou Diesel)
5. Sistema retorna para a Tela Principal com o tipo selecionado
6. Usuário repete o processo para o **Combustível 2**
7. Usuário preenche os campos de consumo e preço para ambos os combustíveis
8. Usuário clica no botão **Calcular**
9. Sistema valida os dados
10. Se válidos, abre a **Tela de Resultados**
11. Tela de Resultados exibe:
    - Comparação detalhada
    - Custo por km de cada combustível
    - Recomendação do mais econômico
    - Economia calculada
12. Usuário clica em **Voltar**
13. Sistema retorna à Tela Principal e **reseta todos os campos**

---

## 8. Requisitos Funcionais (RF)

| Código | Descrição | Status |
| --- | --- | --- |
| RF-01 | O sistema deve permitir inserir consumo (km/L) do combustível 1 | ✅ Implementado |
| RF-02 | O sistema deve permitir inserir consumo (km/L) do combustível 2 | ✅ Implementado |
| RF-03 | O sistema deve permitir inserir preço por litro (R$) do combustível 1 | ✅ Implementado |
| RF-04 | O sistema deve permitir inserir preço por litro (R$) do combustível 2 | ✅ Implementado |
| RF-05 | O sistema deve permitir selecionar o tipo do combustível 1 (Gasolina, Álcool ou Diesel) | ✅ Implementado |
| RF-06 | O sistema deve permitir selecionar o tipo do combustível 2 (Gasolina, Álcool ou Diesel) | ✅ Implementado |
| RF-07 | O sistema deve calcular automaticamente o custo por km de cada combustível | ✅ Implementado |
| RF-08 | O sistema deve comparar os custos e identificar qual é mais econômico | ✅ Implementado |
| RF-09 | O sistema deve exibir os resultados detalhados ao usuário | ✅ Implementado |
| RF-10 | O sistema deve exibir a recomendação do combustível mais econômico | ✅ Implementado |
| RF-11 | O sistema deve exibir a economia em reais e percentual | ✅ Implementado |
| RF-12 | O sistema deve validar os campos antes de calcular | ✅ Implementado |
| RF-13 | O sistema deve exibir mensagens de erro para campos inválidos | ✅ Implementado |
| RF-14 | O sistema deve resetar todos os campos ao voltar da tela de resultados | ✅ Implementado |
| RF-15 | O sistema deve possuir três telas conforme especificação | ✅ Implementado |
| RF-16 | O sistema deve possuir nome, tema e ícone | ✅ Implementado |

---

## 9. Requisitos Não Funcionais (RNF)

| Código | Descrição | Status |
| --- | --- | --- |
| RNF-01 | Interface simples e intuitiva | ✅ Implementado |
| RNF-02 | Tempo de resposta imediato | ✅ Implementado |
| RNF-03 | Aplicativo deve rodar em Android (mínimo SDK 24) | ✅ Implementado |
| RNF-04 | Aplicativo deve ser visualmente agradável (tema preto e amarelo) | ✅ Implementado |
| RNF-05 | Código organizado e bem estruturado | ✅ Implementado |
| RNF-06 | Uso de Material Design 3 | ✅ Implementado |
| RNF-07 | Validação de dados com feedback visual | ✅ Implementado |
| RNF-08 | Navegação fluida entre telas | ✅ Implementado |
| RNF-09 | Responsividade para diferentes tamanhos de tela | ✅ Implementado |

---

## 10. Regras Obrigatórias do Cliente (UTFPR)

- ✅ O aplicativo deve identificar qual combustível é mais rentável
- ✅ O aplicativo deve ter **três telas principais**:
    - Tela 1: Preenchimento dos dados (MainActivity)
    - Tela 2: Escolha do combustível (SelectFuelActivity)
    - Tela 3: Exibição dos resultados (ResultActivity)
- ✅ O aplicativo deve ter nome, tema e ícone
- ✅ O aplicativo contém recursos visuais (Material Design 3)
- ✅ O aplicativo possui validação de dados

---

## 11. Stack Tecnológica (Implementada)

- **Plataforma:** Android
- **Linguagem:** Kotlin
- **IDE:** Android Studio
- **UI Framework:** Material Design 3
- **Layout:** ConstraintLayout, LinearLayout
- **Componentes:** MaterialCardView, TextInputLayout, MaterialButton
- **Mínimo SDK:** 24 (Android 7.0)
- **Target SDK:** 36
- **Persistência:** Nenhuma (versão atual)
- **Versionamento:** Git + GitHub
- **Arquitetura:** Activities (padrão Android)

---

## 12. Métricas de Sucesso (KPIs)

- ✅ App funcionando sem erros críticos
- ✅ Usuário consegue calcular corretamente
- ✅ Resultado confiável e preciso
- ✅ Interface intuitiva e agradável
- ✅ Cumprimento total das regras da disciplina
- ✅ Validação de dados funcionando corretamente
- ✅ Reset automático implementado
- ✅ Navegação entre telas fluida

---

## 13. Critérios de Aceite

- ✅ O usuário consegue inserir os valores de consumo e preço
- ✅ O usuário consegue selecionar o tipo de combustível para ambos
- ✅ O sistema valida os dados antes de calcular
- ✅ O sistema calcula automaticamente o custo por km
- ✅ O sistema recomenda corretamente o combustível mais econômico
- ✅ O sistema exibe economia em reais e percentual
- ✅ O app possui nome, tema e ícone
- ✅ O app possui três telas principais funcionais
- ✅ O sistema reseta os campos ao voltar da tela de resultados
- ✅ A interface é responsiva e visualmente agradável

---

## 14. Design e Interface

### 14.1. Tema Visual

- **Fundo Principal:** Preto (#000000)
- **Cards:** Preto suave (#1A1A1A)
- **Cor Primária:** Amarelo (#FFC107)
- **Texto Principal:** Amarelo sobre fundo preto
- **Bordas:** Amarelo (2dp) em todos os cards
- **Estilo:** Minimalista e moderno

### 14.2. Componentes Visuais

- Cards com bordas amarelas e cantos arredondados (16dp)
- Campos de entrada com Material Design 3
- Botões estilizados com cor primária
- Feedback visual para erros de validação
- Snackbar para mensagens gerais

---

## 15. Cálculo Implementado

### 15.1. Fórmula

```
Custo por km = Preço por litro (R$) / Consumo (km/L)
```

### 15.2. Comparação

O sistema compara os dois custos por km e identifica:
- Qual combustível tem menor custo por km
- Diferença em reais por km
- Percentual de economia: `(Diferença / Maior custo) × 100`

---

✅ **Status do PRD:**

➡️ **COMPLETO, VALIDADO E IMPLEMENTADO**

---

**Versão do Documento:** 1.0.0  
**Última Atualização:** Dezembro/2025  
**Próxima Revisão:** Conforme necessidade

