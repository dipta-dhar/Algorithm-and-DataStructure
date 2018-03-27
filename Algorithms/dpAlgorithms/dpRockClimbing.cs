using System;
 
class GFG
{
    static int minJumps(int[] arr, int n) 
    { 
        // jumps[n-1] will hold the 
        // result
        int []jumps = new int[n]; 
         
        // if first element is 0,
        if (n == 0 || arr[0] == 0) 
         
        // end cannot be reached
        return int.MaxValue; 
         
             
        jumps[0] = 0;
             
        // Find the minimum number of 
        // jumps to reach arr[i]
        // from arr[0], and assign 
        // this value to jumps[i]
        for (int i = 1; i < n; i++)
        {
            jumps[i] = int.MaxValue; 
            for (int j = 0; j < i; j++)
            {
                if (i <= j + arr[j] && jumps[j] != int.MaxValue )
                {
                    jumps[i] = Math.Min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
            return jumps[n - 1];
    }
     
    // Driver program 
    public static void Main()
    {
        int []arr = {1, 3, 6, 1, 0, 9};
        Console.Write("Minimum number of jumps to reach end is : "+
                                        minJumps(arr,arr.Length));
    }
}