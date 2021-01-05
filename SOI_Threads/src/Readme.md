# Exercícios Threads

1. Fazer uma aplicação que rode 5 Threads que
cada uma delas imprima no console o seu
número.<br/>
[Resolução](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Threads/src/threadId)

2. Fazer uma aplicação que insira números
aleatórios em uma matriz 3 x 5 e tenha 3
Threads, onde cada Thread calcula a soma dos
valores de cada linha, imprimindo a identificação
da linha e o resultado da soma.<br/>
[Resolução](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Threads/src/somaVetor)

3. Fazer uma aplicação de uma corrida de sapos, com 5
Threads, cada Thread controlando 1 sapo. Deve haver um
tamanho máximo para cada pulo do sapo (em metros) e a
distância máxima para que os sapos percorram. A cada salto,
um sapo pode dar uma salto de 0 até o tamanho máximo do
salto (valor aleatório). Após dar um salto, a Thread, para cada
sapo, deve mostrar no console, qual foi o tamanho do salto e
quanto o sapo percorreu. Assim que o sapo percorrer a
distância máxima, a Thread deve apresentar que o sapo
chegou e qual sua colocação.<br/>
[Resolução](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Threads/src/corridaSapos)

4. Utilizando o Java SWING, criar uma tela, semelhante à
tela abaixo, para criar uma corrida de carros, tipo drag race.
A aplicação deve ter a distância que os carros devem correr e
a velocidade máxima dos carros. Os carros (Jlabel) devem, a
cada 100 mS, dar uma arrancada de velocidade que pode estar
entre 0 e a velocidade máxima (definida aleatoriamente).
Assim que o primeiro carro chegar, o JTextField Vencedor
deve receber o nome deste e o JTextField Perdedor receberá
o nome do outro carro. Assim que a corrida se inicia, o botão
Correr deve sumir.<br/>
![Corrida de carros](https://github.com/andreluis-git/SistemasOperacionaisI/blob/main/readmeImages/corridacarros.PNG)<br/>
[Resolução](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Threads/src/corridaCarros)

5. Fazer, com o Java SWING, uma aplicação de
caça-níquel, conforme figura abaixo. O caça níquel
tem 3 JTextFields, independentes, que giram,
aleatoriamente, de 1 a 150 vezes e apresentará um
número de 1 a 7. Quando iniciado, o botão Jogar
deve desaparecer.<br/>
![Caça niquel](https://github.com/andreluis-git/SistemasOperacionaisI/blob/main/readmeImages/Cacaniquel.PNG)<br/>
[Resolução](https://github.com/andreluis-git/SistemasOperacionaisI/tree/main/SOI_Threads/src/cacaNiquel)
