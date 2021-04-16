# Icarros Interview

Este repositório tem como objetivo a implementação dos desafios propostos pelo processo seletivo da [Icarros](https://www.icarros.com.br/). Foi utilizado do Java 11 na execução de todos os desafios.

Os desafios foram subdivididos em duas pastas:
- challenges
- consuming-rest

## challenges/

Nessa pasta se encontra os cinco primeiros desafios propostos:
- Fizzing 'n buzzing
- Angry Marvin Birds
- Creepy hours
- We are the champions, my friend
- Venting the costs

##### Challenges de 1 a 4
Os métodos correspondentes a solução desses problemas foram implementados em  [Main.Java](https://github.com/witoriamanuely/icarros_interview/blob/master/challenges/src/br/com/icarros/Main.java). Basta executar em sua IDE de preferência.

##### Challenges 5
O arquivo .sql que possue a consulta pedida no desafio se encontra em [venting_the_costs.sql](https://github.com/witoriamanuely/icarros_interview/blob/master/challenges/venting_the_costs.sql).

## consuming-rest/
Nessa pasta se encontra o Consumer proposto no desafio 6.
Depedências necessárias: 
- ``` Maven ```
- ``` JDK11 ```

Para executá-lo é necessario entrar na pastar consuming-rest/ e executar no terminal:
``` 
$ mvn clean install -DskipTests
$ mvn spring-boot:run
```

Abaixo será descrito os endpoints, os métodos de retorno de cada um. O server de acesso é o localhost:8080. 
| endpoint | método de retorno | observação |
| ------ | ------ | -----|
| /api| findAll() | Esse método retorna todo o json da aplicação|
| /api/races | findAllRaces() | Esse método retorna todas as corridas|
| /api/races/results| findAllResults() | Esse método retorna todos os resultados de todas as corridas|
| /api/races/{round} | findRaceOfRound() | Esse método retorna as corridas pela rodada passada no endpoint, ex: round = 20|
| /api/races/{round}/results |findResultsOfRound() | Esse método retorna os resultados das corridas pela rodada, ex: round = 20|
| /api/races/name | findRaceNames() | Esse método retorna os nomes de todas as corridas|
| /api/races/drivers | findDrivers() | Esse método retorna todos os motoristas participantes de todas as corridas |


