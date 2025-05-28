using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class CapturaSimplesExcecao
    {

        public static void ExecutarCapturaSimplesExcecao()
        {
            Console.WriteLine("Exemplo de captura simples de exececao:");
            try
            {
                int divisor = 0;
                int resultado = 10 / divisor;
            }
            catch (Exception ex)
            {
                Console.WriteLine("Ocorreu um erro: " + ex.Message);
            }
        }
    }
}
