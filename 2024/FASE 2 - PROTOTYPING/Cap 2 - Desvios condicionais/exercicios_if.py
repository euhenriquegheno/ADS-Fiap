valor_compra = float(input("Informe o valor total dos produtos: "))
cupom = input("Para ganhar 10% de desconto, informe o cupom de desconto: ")

if cupom.upper() == "NIVER10":
  valor_final = float(valor_compra) * 0.9
else:
  valor_final = float(valor_compra)
  print(f"Cupom invalido")

print(f"O valor final da compra é: {valor_final}");






  

