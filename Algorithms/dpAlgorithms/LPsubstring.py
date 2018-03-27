import sys

def printSubStr(st,low,high) :
    sys.stdout.write(st[low : high + 1])
    sys.stdout.flush()
    return ''
 

def longestPalSubstr(st) :
    n = len(st)
 
    table = [[0 for x in range(n)] for y in range(n)]
     
    # All substrings of length 1 are
    # palindromes
    maxLength = 1
    i = 0
    while (i < n) :
        table[i][i] = True
        i = i + 1
     
    # check for sub-string of length 2.
    start = 0
    i = 0
    while i < n - 1 :
        if (st[i] == st[i + 1]) :
            table[i][i + 1] = True
            start = i
            maxLength = 2
        i = i + 1
     
    # Check for lengths greater than 2. 
    # k is length of substring
    k = 3
    while k <= n :
        i = 0
        while i < (n - k + 1) :
            j = i + k - 1
			
            if (table[i + 1][j - 1] and
                      st[i] == st[j]) :
                table[i][j] = True
     
                if (k > maxLength) :
                    start = i
                    maxLength = k
            i = i + 1
        k = k + 1
    print "Longest palindrome substring is: ",printSubStr(st, start, start+maxLength-1)
 
    return maxLength
 
 
str = "jjkabcdsdcbajjk"
l = longestPalSubstr(str)
print "Length is: ", l