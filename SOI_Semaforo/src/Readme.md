# Exercícios de Semáforos

1) 4 pessoas caminham, cada uma em um
corredor diferente. Os 4 corredores terminam
em uma única porta. Apenas 1 pessoa pode
cruzar a porta, por vez. Considere que cada
corredor tem 200m. e cada pessoa anda de 4 a
6 m/s. Cada pessoa leva de 1 a 2 segundos
para abrir e cruzar a porta. Faça uma
aplicação em java que simule essa situação.
[Link exercício](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Semaforo/src/corredores)

2) Fazer uma aplicação que gerencie a figura
abaixo:<br />  
![Cruzamento](https://github.com/andreluis-git/SistemasOperacionaisI/blob/main/readmeImages/cruzamento.PNG)<br />
Para tal, usar uma variável sentido,
que será alterado pela Thread que
controla cada carro com a
movimentação do carro. Quando a
Thread tiver a possibilidade de ser
executada, ela deve imprimir em
console o sentido que o carro está
passando. Só pode passar um carro
por vez no cruzamento. 
[Link exercício (saída em console)](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Semaforo/src/cruzamentoConsole), 
[Link exercício (saída em jFrame)](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Semaforo/src/cruzamentoComTela)

3) Você foi contratado para automatizar um treino de Fórmula 1.
As regras estabelecidas pela direção da provas são simples:
“No máximo 5 carros das 7 escuderias (14 carros no total)
presentes podem entrar na pista simultaneamente, mas apenas
um carro de cada equipe. O segundo carro deve ficar à espera,
caso um companheiro de equipe já esteja na pista. Cada piloto
deve dar 3 voltas na pista. O tempo de cada volta deverá ser
exibido e a volta mais rápida de cada piloto deve ser
armazenada para, ao final, exibir o grid de largada, ordenado
do menor tempo para o maior.” 
[Link exercício](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Semaforo/src/f1)

4) Um banco deve controlar Saques e Depósitos.
O sistema pode permitir um Saque e um Depósito
Simultâneos, mas nunca 2 Saques ou 2 Depósitos
Simultâneos.
Para calcular a transação (Saque ou Depósito), o método deve
receber o código da conta, o saldo da conta e o valor a ser
transacionado.
Deve-se montar um sistema que deve considerar que 20
transações simultâneas serão enviadas ao sistema
(aleatoriamente essas transações podem ser qualquer uma das
opções) e tratar todas as transações, de acordo com as regras
acima. 
[Link exercício](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Semaforo/src/banco)
