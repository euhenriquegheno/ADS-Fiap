using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class TratamentoExcecaoEspecifica
    {

        public static void ExecutarTratamentoExcecaoEspecifica()
        {
            Console.WriteLine("Exemplo de execução do tratamento de excecao especifica:");
            try
            {
                int[] numeros = new int[3];
                Console.WriteLine(numeros[5]); // Isso irá gerar uma exceção
            }
            catch (IndexOutOfRangeException)
            {
                Console.WriteLine("Índice acessado não existe no array.");
            }
        }

    }
}
