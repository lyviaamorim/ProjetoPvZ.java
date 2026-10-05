# Consumo da API Plants vs Zombies

Aplicação Java com Maven que consome a [PvZ 2 API](https://pvz-2-api.vercel.app), uma API REST pública com dados do jogo *Plants vs Zombies 2*. O usuário informa o nome de uma planta ou de um zumbi (ou pede a lista de nomes) e o programa mostra no console as informações devolvidas pela API.

## Tecnologias

| Tecnologia | Uso no projeto |
|---|---|
| Java 21 | Linguagem do projeto |
| Maven | Gerenciamento do projeto e das dependências |
| Apache HttpClient 4.5.14 | Requisições HTTP GET à API |
| Gson 2.14.0 | Conversão do JSON em objetos Java |
| Swing (`JOptionPane`) | Caixas de diálogo para entrada de dados |

## Endpoints utilizados

A API é gratuita, não exige autenticação e aceita apenas `GET`.

| Endpoint | O que devolve |
|---|---|
| `/api/plants` | Lista com o nome de todas as plantas |
| `/api/plants/{nome}` | Dados de uma planta |
| `/api/zombies` | Lista com o nome de todos os zumbis |
| `/api/zombies/{nome}` | Dados de um zumbi |

## Estrutura do projeto

```
src/main/java/br/com/fiap/
├── Main.java                  # menu geral
├── api/
│   ├── Planta.java            # modelo
│   └── Zumbi.java             # modelo
├── services/
│   ├── PlantaService.java     # HttpClient + Gson
│   └── ZumbiService.java      # HttpClient + Gson
└── main/
    ├── TestePlanta.java
    ├── TesteListaPlantas.java
    ├── TesteZumbi.java
    └── TesteListaZumbis.java
```

- **api**: classes de modelo que guardam os dados de uma planta ou de um zumbi.
- **services**: montam a URL, executam o GET e usam o Gson para converter a resposta.
- **main**: classes de teste que pedem a entrada, chamam o service e imprimem o resultado.

## Como executar

1. Tenha o **JDK 21** (ou superior) instalado.
2. Clone o repositório:
   ```
   git clone https://github.com/lyviaamorim/ProjetoPvZ.java.git
   ```
3. Abra a pasta no IntelliJ IDEA (**File > Open**) e aguarde o Maven baixar as dependências.
4. Execute a classe `br.com.fiap.Main`.

O menu oferece estas opções:

```
PLANTS VS ZOMBIES
1 - Buscar planta por nome
2 - Listar nomes das plantas
3 - Buscar zumbi por nome
4 - Listar nomes dos zumbis
0 - Sair
```

Digite os nomes em inglês, por exemplo `aloe`, `peashooter` ou `basic zombie`. Se não souber o nome exato, use as opções 2 e 4 para ver a lista.

### Exemplo de saída

Busca da planta `aloe`:

```
Planta
nome='Aloe'
custo de sol='75'
recarga='20 seconds'
resistência='Normal'
família='Reinforce-mint'
imagem='/assets/plants/Aloe.png'
```

## Detalhes de implementação

- **Chaves com espaço ou maiúscula** (como `Sun cost`): ligadas aos atributos Java com `@SerializedName` do Gson.
- **Nomes com espaço** (como `basic zombie`): codificados com `URLEncoder` para formar a URL corretamente (`basic%20zombie`).
- **Nome inexistente**: a API responde com status diferente de 200, então o service devolve `null` e o programa avisa que não encontrou.
- **Entrada vazia ou cancelada**: o service devolve `null` sem chamar a API.
- **Campos ausentes ou extras no JSON**: o Gson deixa `null` nos que faltam e ignora os que a classe não tem.
- **Recursos fechados automaticamente**: o client e a response ficam em um `try-with-resources`.
- **Uso justo da API**: é feita uma única requisição por consulta.

## Observações

- A imagem de cada item vem apenas como caminho. A URL completa é `https://pvz-2-api.vercel.app` + caminho.
- Projeto desenvolvido para fins acadêmicos.
