![Logo da Pós-Graduação](img/pos.png)
# 🚗 Roda Mais

Este é um projeto de aplicativo Android desenvolvido para a disciplina de Programação para Dispositivos Móveis da UTFPR.

- **Instituição:** Universidade Tecnológica Federal do Paraná (UTFPR)
- **Curso:** Especialização em Programação para Dispositivos Móveis
- **Disciplina:** PM-IV - ANDROID BÁSICO
- **Professor:** Prof. Robison Cris Brito

---

## 📝 Sobre o Projeto

O **Roda Mais** é um aplicativo desenvolvido em Kotlin que ajuda motoristas a tomar decisões inteligentes na hora de abastecer. O app calcula o custo por quilômetro rodado de diferentes combustíveis e recomenda qual oferece melhor economia.

## ✨ Funcionalidades

- **Comparação de Combustíveis**: Compare 2 tipos de combustível diferentes (Gasolina, Álcool ou Diesel)
- **Cálculo Automático**: Calcula automaticamente o custo por quilômetro rodado
- **Recomendação Inteligente**: Indica qual combustível é mais econômico com base nos dados informados
- **Interface Moderna**: Design minimalista com tema preto e amarelo
- **Validação de Dados**: Validação completa dos campos de entrada
- **Reset Automático**: Limpa todos os campos ao voltar da tela de resultados

## 📷 Screenshots

<p align="center">
  <img src="img/1.png" width="200" alt="Logo do App"/>
  <img src="img/2.png" width="200" alt="Tela Principal"/>
  <img src="img/3.png" width="200" alt="Formulário Preenchido"/>
</p>

<p align="center">
  <img src="img/4.png" width="200" alt="Seleção de Combustível"/>
  <img src="img/5.png" width="200" alt="Tela de Resultados"/>
</p>

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem:** Kotlin
- **Framework:** Android SDK
- **UI:** Material Design 3
- **Arquitetura:** Activities (padrão Android)
- **Mínimo SDK:** 24 (Android 7.0)
- **Target SDK:** 36

### Componentes de UI Utilizados

- `MaterialCardView` - Cards com bordas amarelas
- `TextInputLayout` e `TextInputEditText` - Campos de entrada com validação
- `MaterialButton` - Botões estilizados
- `ConstraintLayout` - Layout principal
- `ScrollView` - Para telas menores

### Funcionalidades Técnicas

- **Navegação entre Activities**: Uso de `Intent` e `startActivityForResult`
- **Validação de Dados**: Verificação de campos obrigatórios e valores numéricos
- **Feedback Visual**: Mensagens de erro nos campos e Snackbar para erros gerais
- **Cálculo Matemático**: Cálculo de custo por km rodado
- **Reset de Interface**: Limpeza automática de campos ao voltar da tela de resultados

## 📊 Cálculo Realizado

O aplicativo calcula o **custo por quilômetro** usando a fórmula:

```
Custo por km = Preço por litro / Consumo (km/L)
```

Em seguida, compara os dois valores e indica qual oferece menor custo por km rodado, mostrando:
- A diferença em reais por km
- O percentual de economia

## 🎨 Design

O aplicativo utiliza um tema minimalista com:
- **Fundo**: Preto (#000000)
- **Cards**: Preto suave (#1A1A1A)
- **Acentos**: Amarelo (#FFC107)
- **Texto**: Amarelo sobre fundo preto
- **Bordas**: Amarelo em todos os cards (2dp)

## 📱 Como Usar

1. **Selecione os Combustíveis**:
   - Clique no botão de seleção ao lado do campo "Consumo" para escolher o tipo de combustível (Gasolina, Álcool ou Diesel)
   - Repita o processo para o segundo combustível

2. **Informe os Dados**:
   - Digite o consumo em km/L de cada combustível
   - Digite o preço por litro de cada combustível

3. **Calcule**:
   - Clique no botão "Calcular"
   - O app irá calcular e mostrar qual combustível é mais econômico

4. **Veja os Resultados**:
   - A tela de resultados mostra:
     - Comparação detalhada dos dois combustíveis
     - Custo por quilômetro de cada um
     - Recomendação de qual é mais econômico
     - Economia em reais e percentual

## 📂 Estrutura do Projeto

```
RodaMais/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/bluestash/rodamais/
│   │   │   │   ├── MainActivity.kt          # Tela principal com formulário
│   │   │   │   ├── SelectFuelActivity.kt    # Tela de seleção de combustível
│   │   │   │   └── ResultActivity.kt        # Tela de resultados
│   │   │   ├── res/
│   │   │   │   ├── layout/                  # Layouts XML
│   │   │   │   ├── values/                  # Cores, temas, strings
│   │   │   │   └── drawable/                # Ícones e recursos visuais
│   │   │   └── AndroidManifest.xml
│   │   └── test/                            # Testes unitários
│   └── build.gradle.kts                     # Configuração do módulo
├── img/                                     # Screenshots do aplicativo
├── build.gradle.kts                          # Configuração do projeto
├── settings.gradle.kts                       # Configuração do Gradle
└── README.md                                 # Este arquivo
```

## 🚀 Como Instalar e Executar

### Pré-requisitos

- Android Studio Hedgehog ou superior
- JDK 11 ou superior
- Android SDK 24 ou superior
- Gradle 8.0 ou superior

### Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/RodaMais.git
   cd RodaMais
   ```

2. **Abra o projeto no Android Studio**
   - Abra o Android Studio
   - Selecione "Open an existing project"
   - Navegue até a pasta do projeto e selecione

3. **Sincronize o Gradle**
   - O Android Studio irá sincronizar automaticamente
   - Aguarde a conclusão da sincronização

4. **Execute o aplicativo**
   - Conecte um dispositivo Android ou inicie um emulador
   - Clique em "Run" ou pressione `Shift + F10`

---

Desenvolvido como projeto prático para consolidar os conhecimentos em desenvolvimento Android com Kotlin, Material Design 3 e arquitetura de Activities.
