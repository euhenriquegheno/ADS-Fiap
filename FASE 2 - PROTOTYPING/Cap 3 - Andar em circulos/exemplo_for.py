#Vai printando a variavel contadora do numero 0 até o 100
for contadora in range(101):
  print(contadora)

#Vai printando a variavel x do numero 3 até o 9
for x in range(3, 10):
  print(x)

#Vai printando a variavel y do numero 0 até o 10 pulando de 2 em 2
for x in range(0, 11, 2):
  print(x)

#Todos numeros impares de 1 até 10000
for impar in range(1, 1001, 2):
  print(impar);

#
n = int(input("Informe o valor do qual deseja obter a tabuada>: "));

for tabuada in range(n, n * 10 + 1, n):
  print(tabuada)


#variável que servirá para receber a opção do usuário
op = -1
#enquanto o usuário não digitar a opção de saída
while op!=4:
    #exibição das opções do menu
    print("SUPER PROGRAMA MARAVILHOSO")
    print("1 - Rodar código 1")
    print("2 - Rodar código 2")
    print("3 - Rodar código 3")
    print("4 - Sair do programa")
    op = int(input("Informe sua opção: "))
    
    #verificação das opções disponíveis
    if op == 1:
        #O que ocorrerá se a opção 1 for selecionada
        print("CÓDIGO 1 RODANDO!")
    elif op == 2:
        #O que ocorrerá se a opção 2 for selecionada
        print("CÓDIGO 2 RODANDO!")
    elif op == 3:
        #O que ocorrerá se a opção 3 for selecionada
        print("CÓDIGO 3 RODANDO!")
#Quando o looping terminar de rodar, exibir essa mensagem
print("OK! O programa está encerrado...")


#variavel para armazenar o peso total das caixas
peso_total = 0.0
#loop para repetir por 100 vezes a solicitação de peso
for x in range(1,101):
    #para cada volta do loop, solicitar o peso da caixa
    peso_atual = float(input("Informe o peso da caixa atual:"))
    #para cada peso solicitado, somar ao peso total
    peso_total = peso_total + peso_atual
#ao final do loop, calcular a média aritmética
media = peso_total/100
#exibição dos resultados!
print("O peso total de caixas é {}. A média de peso é {}".format(peso_total, media))