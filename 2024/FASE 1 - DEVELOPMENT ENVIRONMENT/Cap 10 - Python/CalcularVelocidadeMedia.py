print("Esse programa calcula a velocidade média de um patinete")
distancia = input("Qual foi a distância em metros percorrida pelo patinete? ")
tempo = input("Quantos minutos o patinete demorou para percorrer essa distância? ")
velocidade_media = float(distancia) / float(tempo)
print("O patinete atingiu uma velocidade de {0:.2f} m/min".format(velocidade_media))

#Para exibir 2 casas indicaremos {0:.2f}, para exibir 1 casa {0:.1f} e assim por diante...