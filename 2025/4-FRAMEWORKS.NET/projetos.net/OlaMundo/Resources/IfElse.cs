using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class IfElse
    {

        public static void ExibirIfElse()
        {
            Console.WriteLine("Exemplo de IF-ELSE:");
            int numero = 10;
            if (numero > 5)
            {
                Console.WriteLine("O número é maior que 5.");
            }
            else
            {
                Console.WriteLine("O número é menor ou igual a 5.");
            }
        }

    }
}
