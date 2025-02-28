valor1 = input("Digite o primeiro valor:");
valor2 = input("Digite o segundo valor:");
soma = float(valor1) + float(valor2);
print("A soma de", valor1, "+", valor2, "é igual a {}".format(soma));
subtracao = float(valor1) - float(valor2);
print("A subtracao de", valor1, "-", valor2, "é igual a {}".format(subtracao));
divisao = float(valor1) / float(valor2);
print("A divisão de", valor1, "/", valor2, "é igual a {}".format(divisao));
multiplicacao = float(valor1) * float(valor2);
print("A multiplicação de", valor1, "*", valor2, "é igual a {}".format(multiplicacao));

#Tipos de conversões
# Tipos básicos  |          Descrição          | Exemplo
#     int               Números inteiros        1, 2, 100
#    float       Números reais(ponto flutuante) 1.5, 2.07, 50.29
#   complex             Números complexos       4j, 5+2j, 15j
#    bool                Valores lógicos        True, False, 1, 0
#   string                   Textos             "Texto", "a", "10"