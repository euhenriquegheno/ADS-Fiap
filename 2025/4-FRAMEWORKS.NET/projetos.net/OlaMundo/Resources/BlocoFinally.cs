using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class BlocoFinally
    {

        public static void ExecutarBlocoFinally()
        {
            Console.WriteLine("Exemplo de execução do bloco finally:");
            try
            {
                int a = 10;
                int b = 0;
                Console.WriteLine(a / b);
            }
            catch (DivideByZeroException)
            {
                Console.WriteLine("Tentativa de divisão por zero.");
            }
            finally
            {
                Console.WriteLine("Bloco finally executado.");
            }
        }

    }
}
