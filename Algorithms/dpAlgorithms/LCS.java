package dpAlgorithms;

public class LCS {
	
	public static int getLongestCommonSubsequence(String a, String b){
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
	 
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}else if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	 
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		String a = "abcdef";
		String b = "acf";
		
		int lcs_length = getLongestCommonSubsequence(a, b);
		
		System.out.println("1st string: "+ a + "\n2nd string: " + b);
		System.out.println("LCS length is: " + lcs_length);
	}

}
