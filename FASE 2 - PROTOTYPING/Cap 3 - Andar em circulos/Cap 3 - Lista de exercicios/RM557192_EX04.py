#Escreva um programa que receba o tipo de investimento do qual 
#se deseja realizar um resgate (1 para CDB, 2 para LCI e 3 para LCA), 
#o valor a ser resgatado e o número de dias que esse valor permaneceu 
#investido e, se for o caso, calcule o valor referente ao imposto de renda.

print("Qual o tipo de investimento que voce deseja realizar um resgate?")
tipo_investimento = int(input("1 - CDB\n2 - LCI\n3 - LCA"))
valor_resgate = float(input("Qual o valor que deseja resgatar? "))
qtde_dias_investido = int(input("Quantos dias o valor permaneceu investido? "))

if (tipo_investimento == 1):
  if (qtde_dias_investido <= 180):
    aliquota_ir = 22.5
    valor_ir = (valor_resgate * (aliquota_ir / 100))
  elif (qtde_dias_investido >= 181) and (qtde_dias_investido <= 360):
    aliquota_ir = 20
    valor_ir = (valor_resgate * (aliquota_ir / 100))
  elif (qtde_dias_investido >= 361) and (qtde_dias_investido <= 720):
    aliquota_ir = 18.5
    valor_ir = (valor_resgate * (aliquota_ir / 100))
  elif (qtde_dias_investido > 720):
    aliquota_ir = 15
    valor_ir = (valor_resgate * (aliquota_ir / 100))

  print(f"A solicitação de resgate foi no valor de  {format(valor_resgate, ".2f")}")
  print(f"Seu resgate contém um IR de {aliquota_ir}%. O valor do IR sobre o valor resgatado é {format(valor_ir, ".2f")}")
else:
  print(f"O valor resgatado é {format(valor_resgate, ".2f")}. LCI e LCA são isentos de IR.")