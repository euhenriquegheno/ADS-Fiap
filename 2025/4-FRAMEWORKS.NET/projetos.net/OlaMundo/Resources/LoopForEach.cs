using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class LoopForEach
    {

        public static void ExibirLoopForEach()
        {
            Console.WriteLine("Exemplo de Loop For Each:");
            string[] nomes = { "Thiago", "João", "Rita" };
            foreach (string nome in nomes)
            {
                Console.WriteLine(nome);
            }
        }

    }
}
