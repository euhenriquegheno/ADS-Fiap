#ATIVIDADE 01
#Desenvolva um programa em que os colaboradores informem um dos 5 dias da semana 
#(segunda-feira, terça-feira, quarta-feira, quinta-feira e sexta-feira) da sua 
#preferência para participar da live. Verifique e exiba ao final, qual dia foi 
#o escolhido pelos colaboradores.

qtde_colaboradores = int(input("Informe quantos colaboradores irão particiapar da votação: "));

votos_segunda = 0;
votos_terca = 0;
votos_quarta = 0;
votos_quinta = 0;
votos_sexta = 0;

for i in range (1, qtde_colaboradores + 1):
  print(f"Colaborador {i}, vote em qual dia " +
        "da semana deve ser realizada as lives com o time da mentoria financeira");
  
  voto_colaborador = int(input("1 - SEGUNDA-FEIRA\n2 - TERÇA-FEIRA\n3 - QUARTA-FEIRA\n4 - QUINTA-FEIRA\n5 - SEXTA-FEIRA\n"));

  if (voto_colaborador == 1):
    votos_segunda = votos_segunda + 1
  elif (voto_colaborador == 2):
    votos_terca = votos_terca + 1
  elif (voto_colaborador == 3):
    votos_quarta = votos_quarta + 1
  elif (voto_colaborador == 4):
    votos_quinta = votos_quinta + 1
  elif (voto_colaborador == 5):
    votos_sexta = votos_sexta + 1


if (votos_segunda >= votos_terca) and (votos_segunda >= votos_quarta) and (votos_segunda >= votos_quinta) and (votos_segunda >= votos_sexta):
  print(f"O dia vencedor é Segunda-Feira, com {votos_segunda} votos!")
elif (votos_terca > votos_segunda) and (votos_terca > votos_quarta) and (votos_terca > votos_quinta) and (votos_terca > votos_sexta):
  print(f"O dia vencedor é Terça-Feira, com {votos_terca} votos!")
elif (votos_quarta > votos_segunda) and (votos_quarta > votos_terca) and (votos_quarta > votos_quinta) and (votos_quarta > votos_sexta):
  print(f"O dia vencedor é Quarta-Feira, com {votos_quarta} votos!")
elif (votos_quinta > votos_segunda) and (votos_quinta > votos_terca) and (votos_quinta > votos_quarta) and (votos_quinta > votos_sexta):    
  print(f"O dia vencedor é Quinta-Feira, com {votos_quinta} votos!")
elif (votos_sexta > votos_segunda) and (votos_sexta > votos_terca) and (votos_sexta > votos_quarta) and (votos_sexta > votos_quinta):    
  print(f"O dia vencedor é Sexta-Feira, com {votos_sexta} votos!")


