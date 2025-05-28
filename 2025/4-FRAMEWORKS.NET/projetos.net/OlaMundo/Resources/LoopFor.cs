using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class LoopFor
    {

        public static void ExibirLoopFor()
        {
            Console.WriteLine("Exemplo de Loop For:");
         
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine($"Valor de i: {i}");
            }
        }

    }
}
