valor_divida = float(input("Digite o valor da dívida: "))
juros = 0;

for i in range(0, 13, 3):
  valor_divida_juros = valor_divida + (valor_divida * (juros / 100))
  valor_juros_reais = valor_divida_juros - valor_divida
  parcela = i

  if (parcela == 0):
    parcela = 1
    juros = 10
  else:
    juros = juros + 5

  valor_parcela = (valor_divida_juros / parcela)

  print(f"Total: R$ {format(valor_divida_juros, ".2f")} Juros: R$ {format(valor_juros_reais, ".2f")}, Número de parcelas: {parcela}, Valor da Parcela: R$ {format(valor_parcela, ".2f")}");