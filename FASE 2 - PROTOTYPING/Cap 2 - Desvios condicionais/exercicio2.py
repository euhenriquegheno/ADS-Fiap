#Verificar se os batimentos cardiacos por minuto se encontram na faixa adequada
valor_bruto = float(input("Informe o valor bruto do pacote: "))
categoria_assento = int(input("CATEGORIA DOS ASSENTOS:\n1 - ECONOMICA\n2 - EXECUTIVA\n3 - PRIMEIRA CLASSE\nInforme a categoria do seu assento: "))
qtde_viajantes = int(input("Quantidade de viajantes: "))

if categoria_assento == 1:
  if qtde_viajantes >= 4:
    valor_final = valor_bruto * (1 - 0.05)
  elif qtde_viajantes == 3:
    valor_final = valor_bruto *(1 - 0.04)
  elif qtde_viajantes == 2:
    valor_final = valor_bruto *(1 - 0.03)
elif categoria_assento == 2:
  if qtde_viajantes >= 4:
    valor_final = valor_bruto *(1 - 0.08)
  elif qtde_viajantes == 3:
    valor_final = valor_bruto *(1 - 0.07)
  elif qtde_viajantes == 2:
    valor_final = valor_bruto *(1 - 0.05)
elif categoria_assento == 3:
  if qtde_viajantes >= 4:
    valor_final = valor_bruto *(1 - 0.20)
  elif qtde_viajantes == 3:
    valor_final = valor_bruto *(1 - 0.15)
  elif qtde_viajantes == 2:
    valor_final = valor_bruto *(1 - 0.10)

print(f"O valor bruto da viagem é {valor_bruto}")
print(f"O valor do desconto é {valor_bruto - valor_final}")
print(f"O valor liquido da viagem é {valor_final}")
print(f"O valor médio por viajante é {valor_final / qtde_viajantes}")