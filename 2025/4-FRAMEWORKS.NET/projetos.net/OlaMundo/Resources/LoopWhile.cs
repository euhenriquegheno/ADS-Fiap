using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class LoopWhile
    {

        public static void ExibirLoopWhile()
        {
            Console.WriteLine("Exemplo de Loop While:");
            int contador = 0;
            while (contador < 5)
            {
                Console.WriteLine($"Contador: {contador}");
                contador++;
            }
        }

    }
}
