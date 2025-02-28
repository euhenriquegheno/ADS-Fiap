#Verificar se os batimentos cardiacos por minuto se encontram na faixa adequada
bpm = int(input("Informe o seu número de batimentos por minuto(BPM): "))
idade = int(input("Informe sua idade: "))

if idade <= 2:
  if bpm >= 120 and bpm <= 140:
    print(f"Os batimentos encontram-se DETRO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 120 a 140 bpm")
  elif bpm < 120:
    print(f"Os batimentos encontram-se ABAIXO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 120 a 140 bpm")
  elif bpm > 140:
    print(f"Os batimentos encontram-se ACIMA da faixa adequada!\nA faixa adequada para a idade {idade} é entre 120 a 140 bpm")
elif idade >= 8 and idade <= 17:
  if bpm >= 80 and bpm <= 100:
    print(f"Os batimentos encontram-se DETRO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 80 a 100 bpm")
  elif bpm < 80:
    print(f"Os batimentos encontram-se ABAIXO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 80 a 100 bpm")
  elif bpm > 100:
    print(f"Os batimentos encontram-se ACIMA da faixa adequada!\nA faixa adequada para a idade {idade} é entre 80 a 100 bpm")
elif idade >= 18 and idade <= 60:
  if bpm >= 70 and bpm <= 80:
    print(f"Os batimentos encontram-se DETRO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 70 a 80 bpm")
  elif bpm < 70:
    print(f"Os batimentos encontram-se ABAIXO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 70 a 80 bpm")
  elif bpm > 80:
    print(f"Os batimentos encontram-se ACIMA da faixa adequada!\nA faixa adequada para a idade {idade} é entre 70 a 80 bpm")
else:
  if bpm >= 50 and bpm <= 60:
    print(f"Os batimentos encontram-se DETRO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 50 a 60 bpm")
  elif bpm < 50:
    print(f"Os batimentos encontram-se ABAIXO da faixa adequada!\nA faixa adequada para a idade {idade} é entre 50 a 60 bpm")
  elif bpm > 60:
    print(f"Os batimentos encontram-se ACIMA da faixa adequada!\nA faixa adequada para a idade {idade} é entre 50 a 60 bpm")