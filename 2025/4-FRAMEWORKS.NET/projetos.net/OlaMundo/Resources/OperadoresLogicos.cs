using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class OperadoresLogicos
    {

        public static void ExibirOperadoresLogicos()
        {
            Console.WriteLine("Exemplo de Operadores Lógicos:");

            void NegacaoLogica()
            {
                bool passed = false;
                Console.WriteLine(!passed);  // output: True
                Console.WriteLine(!true);    // output: False
            }

            NegacaoLogica();

            void AndLogico()
            {
                bool SecondOperand()
                {
                    Console.WriteLine("Second operand is evaluated.");
                    return true;
                }
                bool a = false & SecondOperand();
                Console.WriteLine(a);
                // Output:
                // Second operand is evaluated.
                // False
                bool b = true & SecondOperand();
                Console.WriteLine(b);
                // Output:
                // Second operand is evaluated.
                // True
            }

            AndLogico();

            void OrLogico()
            {
                bool SecondOperand()
                {
                    Console.WriteLine("Second operand is evaluated.");
                    return true;
                }
                bool a = true | SecondOperand();
                Console.WriteLine(a);
                // Output:
                // Second operand is evaluated.
                // True
                bool b = false | SecondOperand();
                Console.WriteLine(b);
                // Output:
                // Second operand is evaluated.
                // True
            }

            OrLogico();

            void AndLogicoCondicional()
            {
                bool SecondOperand()
                {
                    Console.WriteLine("Second operand is evaluated.");
                    return true;
                }
                bool a = false && SecondOperand();
                Console.WriteLine(a);
                // Output:
                // False
                bool b = true && SecondOperand();
                Console.WriteLine(b);
                // Output:
                // Second operand is evaluated.
                // True
            }

            AndLogicoCondicional();

            void OrLogicoCondicional()
            {
                bool SecondOperand()
                {
                    Console.WriteLine("Second operand is evaluated.");
                    return true;
                }
                bool a = true || SecondOperand();
                Console.WriteLine(a);
                // Output:
                // True
                bool b = false || SecondOperand();
                Console.WriteLine(b);
                // Output:
                // Second operand is evaluated.
                // True
            }
        }

    }
}
