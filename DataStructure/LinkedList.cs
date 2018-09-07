using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SLL
{
    /// <summary>
    /// A simple basic implementation of singly linked list in C#. The List class implements Add, Find and Delete funcationality without using built-in .NET classes.
    /// </summary> 
    internal class List
    {        
        /// <summary>
        /// Node class
        /// </summary>
        internal class Node
        {
            private int data; 
            private Node next = null;

            /// <summary>
            /// Pointer to next node.
            /// </summary>
            internal Node Next
            {
                get { return next; }
                set { next = value; }
            }
                       
            /// <summary>
            /// Data stored in the node.
            /// </summary>
            internal int Data
            {
                get { return data; }
                set { data = value; }
            }

            /// <summary>
            /// Constructor
            /// </summary>
            /// <param name="d"></param>
            internal Node(int d)
            {
                data = d;
            }
        }

        private int _length;
        private Node _head;

        /// <summary>
        /// Length of the list
        /// </summary>
        internal int Length
        {
            get { return _length; }
        }

        /// <summary>
        /// Default Constructor
        /// </summary>
        internal List()
        {
            _length = 0;
            _head = null;
        }

        /// <summary>
        /// Display all nodes.
        /// </summary>
        internal void ShowNodes()
        {
            // Print all nodes till the end of the list.
            Node current = _head;
            if (current == null)
            {
                Console.WriteLine("No more nodes to display.");
                Console.WriteLine();
            }
            else
            {
                ShowLength();
                while (current != null)
                {
                    Console.WriteLine("Node : " + current.Data);
                    current = current.Next;
                }
                Console.WriteLine();
            }
        }

        /// <summary>
        /// Show length of the list.
        /// </summary>
        internal void ShowLength()
        {
            string numString = "numbers";
            if (_length == 1)
            {
                numString = "number";
            }
            Console.WriteLine(String.Format("List has [{0}] {1}.", _length.ToString(), numString));
        }

        /// <summary>
        /// To insert a new Node at the end of the list.
        /// </summary>
        /// <param name="d"></param>
        internal void Add(int d)
        {
            Console.WriteLine();
            Console.WriteLine(String.Format("Add node [{0}].", d.ToString()));
            // Create a new Node instance with given data;
            Node newNode = new Node(d);
            Node current = _head;
            if (_head == null)
            {
                _head = newNode;
            }
            else
            {
                // Traverse till the end of the list....
                while (current.Next != null)
                {
                    current = current.Next;
                }
                // Add new node as the next node to the last node.
                current.Next = newNode;
            }
            _length++;
            ShowNodes();
        }

        /// <summary>
        /// Delete the node matching specified number, if it exists.
        /// </summary>
        /// <param name="d"></param>
        internal void Delete(int d)
        {
            Console.WriteLine();
            Console.WriteLine(String.Format("Delete node [{0}].", d.ToString()));
            // Find the node to be deleted. 
            Node current = _head;

            if (current != null)
            {
                // Handle the case for 'head' node when first node matches the node to be deleted.
                if (current.Data == d)
                {
                    // If first node is not the only node
                    if (current.Next != null)
                    {
                        current = current.Next;
                    }
                    else
                    {
                        current = null;
                    }
                    _head = current;
                    _length--;
                }
                else
                {
                    while (current.Next != null && current.Next.Data != d)
                    {
                        current = current.Next;
                    }
                    if (current.Next != null && current.Next.Data == d)
                    {
                        // Set the next pointer of the previous node to be the node next to the one that is being deleted.
                        current.Next = current.Next.Next;
                        // Delete the node
                        current = null;
                        _length--;
                    }
                    else
                    {
                        Console.WriteLine(d.ToString() + " could not be found in the list.");                        
                    }
                }
            }
            ShowNodes();
        }

        /// <summary>
        /// Find node matching the specified number.
        /// </summary>
        /// <param name="d"></param>
        /// <returns>Returns node matching specifying int.</returns>
        internal void Find(int d)
        {
            Console.WriteLine();
            Console.WriteLine(String.Format("Find node [{0}].", d.ToString()));
            Node current = _head;
            if (current != null)
            {
                int counter = 1;
                while (current.Next != null && current.Data != d)
                {
                    current = current.Next;
                    counter++;
                }
                if (current.Data == d)
                {
                    Console.WriteLine(String.Format("Found {0} in the list at position [{1}].", d.ToString(), counter.ToString()));
                }
                else
                {
                    Console.WriteLine(String.Format("{0} was not found in the list.", d.ToString()));
                }
            }
            else
            {
                Console.WriteLine(String.Format("{0} was not found in the list.", d.ToString()));
            }
            ShowNodes();
        }
    }

    /// <summary>
    /// Client class that runs the program.
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            List list = new List();

            // Add a few elements to the list.
            list.Add(5);
            list.Add(8);
            list.Add(9);
            list.Add(1);
            list.Add(2);
            list.Add(3);
            list.Delete(2);
            list.Delete(5);            
            list.Delete(1);            
            list.Delete(3);            
            list.Delete(4);
            list.Find(9);
            list.Delete(8);
            list.Find(8);                        
            list.Find(9);

            // This ensures the command window is displayed in case the program is not run from command prompt.
            Console.ReadLine();
        }
    }
}
