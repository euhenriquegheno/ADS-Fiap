#Primeiro exemplo while
resposta = "";

while (resposta != "42"):
  resposta = str(input("Qual é a resposta para a vida, o universo e tudo mais?\n"));

print("Parabéns, voce acertou!");


#Verificando se o numero preenchido é par
numero = 1

#Se sobrou resto quando dividiu por 2
while (numero % 2 != 0):
    numero = int(input("Por favor, informe um numero par!"));

print("Parabéns, o numero informado é par");


#Exemplo WHILE com contador
contadora = 0;

while contadora < 10:
  print(contadora);
  contadora = contadora + 1;


#Tabuada
i = 1;
numero = int(input("Por favor, informe o valor do qual deseja a tabuada: "));

while i <= 10:
  resultado = (numero * i)
  print(f"{numero} X {i} = {resultado}");
  i = i + 1;



