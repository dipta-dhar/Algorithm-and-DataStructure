using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
    public static class Program
    {
        public static void Main(string[] args)
        {
            new[] {7, 9, 8, 7, 3, 15, 6, 6, 4, 3}.Sort().Flatten().Output();
        }

        static int[] Sort(this int[] array)
        {
            var sorted = false;
            while(!sorted)
            {
                sorted = true;
                for(var i = 1; i < array.Length-1; i += 2)
                {
                    if(array[i] > array[i+1])
                    {
                        Swap(array, i, i+1);
                        sorted = false;
                    }
                }
 
                for(var i = 0; i < array.Length-1; i += 2)
                {
                    if(array[i] > array[i+1])
                    {
                        Swap(array, i, i+1);
                        sorted = false;
                    }
                }
            }
            return array;
        }

        static void Swap(int[] array, int i, int j)
        {
            var temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        static string Flatten(this int[] array)
        {
            return array.Select(x => x.ToString()).Aggregate((acc, x) => acc + ";" + x);
        }

        static void Output(this string output)
        {
            Console.WriteLine(output);
        }
    }
}