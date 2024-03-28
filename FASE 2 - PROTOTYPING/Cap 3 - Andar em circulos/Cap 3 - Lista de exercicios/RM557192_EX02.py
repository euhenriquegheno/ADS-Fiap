preco_carro = float(input("Digite o preço do carro: "))

for i in range(0, 61, 6):
  if (i == 0):
    preco_carro_desconto = (preco_carro - (preco_carro * 0.20))
    print(f"O preço final á vista com desconto 20% é: {format(preco_carro_desconto, ".2f")}")
  else:
    preco_carro_acrescimo = (preco_carro + (preco_carro * ((i - (i / 2)) / 100)))
    preco_parcela = (preco_carro_acrescimo / i)
    print(f"O preço final parcelado em {i} X é de R$ {format(preco_carro_acrescimo, ".2f")} com parcelas de R$ {format(preco_parcela, ".2f")}")

  