rm = input("Por favor, digite RM: ")
idade = int(input("Por favor, digite sua idade: ")) 

if int(idade) >= 18:
  print("Sua participação foi autorizada, aluno de RM {}!".format(rm))
  print("Mais instruções serão enviadas ao seu e-mail cadastrado na FIAP!")
else:
  autorizado = input("Voce possui autorização dos responsaveis para participar? S - SIM ou N - NÃO")
  if autorizado == "S":
    print("Sua participação foi autorizada, aluno de RM {}".format(rm))
  else:
    print("Sua participação não foi autorizada por causa da sua idade")

