using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class LoopDoWhile
    {
        public static void ExibirLoopDoWhile()
        {
            Console.WriteLine("Exemplo de Loop Do While:");
            int valor = 0;
            do
            {
                Console.WriteLine($"Valor: {valor}");
                valor++;
            }
            while (valor < 5);
        }

    }
}
