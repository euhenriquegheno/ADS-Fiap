#Operadores

#Atribuição
#Operador | Exemplo | Equivalencia
#    =       x = 3     x = 3
#   +=      x += 1     x = x + 1
#   -+      x -= 1     x = x - 1
#   *=      x *= 2     x = x * 2
#   /=      x /= 2     x = x / 2
#   %=      x %= 2     x = x % 2

print("Operadores de Atribuição");
#atribuição da soma de dois números inteiros
resultado = 2 + 3
print("Resultado:", resultado)
#atribuição de um texto (string)
nome = "Pedro"
print("Nome: ", nome)
nome2 = "Maria"
#saída f"string" com a variável entre as chaves
print(f"Olá, {nome2}. Tudo bem?")
#somando dois ao valor anterior da variável
resultado += 2
print("Resultado:", resultado)

#Aritméticos
#Operador |            Operação          | Precedencia
#    +      Adição                        Menor prioridade
#    -     Subtração     
#    *     Multiplicação     
#    /      Divisão     
#   //     Divisão Inteira     
#   %      Resto da divisão ou módulo
#   **     Exponenciação ou potenciação   Maior prioridade

# Assim como na Matemática, os operadores aritméticos possuem precedencia (prioridade de execução).
print("Operadores Aritméticos");
resultado = (2 + 3 / 2);
print("Resultado: ", resultado);

#Relacionais
#Operador |    Função    | Exemplo
#   ==       Igual         5 == 5
#   !=     Diferente       5 != 5
#    >     Maior que       5 > 5
#    <     Menor que       5 < 5
#   >=     Maior igual     5 >= 5
#   <=     Menor igual     5 <= 5

#O resultado de uma comparação será True ou False. 
#Na linguagem Python, utilizamos as palavras-chaves True e False, 
#que são objetos que armazenam, respectivamente, os valore 1(True) e 0(False)

print("Operadores Relacionais");
print(1 == 5);
print(1 != 5);
print(1 > 2);
print(1 < 2);
print(1 >= 2);
print(2 <= 2);
print(1 == True);
print(0 == False);

#Lógicos
#Operador |    Exemplo    | Equivalencia
#   or         A or B         ou
#  and        A and B         e
#  not        not A          não

#O operador NOT(não) também é conhecido como inversor e representa a negação do valor de entrada,
#ou seja, o inverso da entrada, Se a entra for True, a saída sera False, e vice versa...

print("Operadores Lógicos");
A = 1 == 2
B = 2 > 3
print(A)
print(B)
#Operações
print(A and B)
print(A or B)
print(not A)
print(not B)
print(8>=5 and 8<=10)

#Associação
#Operador |    Exemplo    
#   in       "s" in resposta
# not in     "s" not in resposta

#Verificar se uma letra ou palavra está contida em um texto ou ainda se um número está em uma lista

print("Operadores de Associação");
resposta = "sim"
texto = "Brasil"
print("s" in resposta)
print("n" not in resposta)
print("b" in texto)
print("B" in texto)

#Identidade
#Operador |    Exemplo    
#   is       n1 is n2
# is not     n1 is not n2

#Quando precisamos comprar se dois objetos utilizam a mesma posição na memoria no Python, usamos os
#operadores de identidade: is e not is. O operador de identidade é diferente do operador de igualdade ==,
#pois o operador de identidade analisa o endereço e o de igualdade o valor.

#O métodos id() retorna o endereço de memória de um objeto, podemos utiliza-lo em conjunto com o comando
#print para exibir este endereço em tela.

print("Operadores de Identidade");
cidade_p1 = "São Paulo"
cidade_p2 = "São Paulo"
cidade_p3 = "Rio de Janeiro"
print(id(cidade_p1))
print(id(cidade_p2))
print(id(cidade_p3))
print(cidade_p1 is cidade_p2)

#Precedencia dos operadores
#Operador | Função | Equivalencia
# () | Parenteses | Maior prioridade
# ** | Exponenciação
# +x, -x | Sinal
# *,/,//,% | Multiplicação, divisão, divisão inteira e módulo
# +, - | Soma e subtração
# <, <=, >, >= | Relacionais
# ==, != | Igual e diferente
# is, is not | Identidade
# in, not in | Associação
# not | Não
# and | E
# or | ou
# =, +=, -=, /=, %= | Atribuição | Menor prioridade





