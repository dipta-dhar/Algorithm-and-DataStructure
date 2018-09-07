using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // New Queue of integers.
        Queue<int> queue = new Queue<int>();
        queue.Enqueue(5);
        queue.Enqueue(10);
        queue.Enqueue(15);
        queue.Enqueue(20);

        // Create new array with Length equal to Queue's element count.
        int[] array = new int[queue.Count];

        // Copy the Queue to the int array.
        queue.CopyTo(array, 0);

        // Loop through and display int[] in order.
        Console.WriteLine("Array:");
        for (int i = 0; i < array.Length; i++)
        {
            Console.WriteLine(array[i]);
        }

        // Loop through int array in reverse order.
        Console.WriteLine("Array reverse order:");
        for (int i = array.Length - 1; i >= 0; i--)
        {
            Console.WriteLine(array[i]);
        }
    }
}
