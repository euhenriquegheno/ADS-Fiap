lista_intrumentos = ["Bateria", "Guitarra", "Violão", "Baixo"]

print(type(lista_intrumentos))

print(lista_intrumentos)

print(lista_intrumentos[0])

for instrumento in lista_intrumentos:
  print(instrumento)

#Qual é o tamanho da minha lista?
print(len(lista_intrumentos))

#Quantas vezes o elemento "Guitarra" aparece?
print(lista_intrumentos.count("Guitarra")) 

#Como alterar a ordem dos elementos da lista?
lista_intrumentos.reverse()
print(lista_intrumentos)

#Ordenar a lista em ordem decrescente
lista_intrumentos.sort(reverse=True)
print(lista_intrumentos)

#Ordernar a lista crescente
lista_intrumentos.sort()
print(lista_intrumentos)