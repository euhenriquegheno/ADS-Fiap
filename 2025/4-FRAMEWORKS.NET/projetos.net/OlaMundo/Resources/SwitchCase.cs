using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class SwitchCase
    {

        public static void ExibirSwitchCase()
        {
            Console.WriteLine("Exemplo de Switch-Case:");
            int diaDaSemana = 3;
            switch (diaDaSemana)
            {
                case 1:
                    Console.WriteLine("Segunda-feira");
                    break;
                case 2:
                    Console.WriteLine("Terça-feira");
                    break;
                case 3:
                    Console.WriteLine("Quarta-feira");
                    break;
                // Adicione mais casos conforme necessário
                default:
                    Console.WriteLine("Dia inválido");
                    break;
            }
        }

    }
}
