package dp;

import java.util.*;
//finds the number of subsets of a set that add up to a number x. 
class Subsets
{

 int maxN = 20;
int maxSum = 70;
 int minSum = 20;
int base = 50;
 int reqSum;
// To store the states of DP
 int[][] dp = new int[maxN][maxSum + minSum];
 boolean [][] bool = new boolean[maxN][maxSum + minSum];
 
Subsets(int reqSum) {
	this.reqSum = reqSum;
}

    int findCnt(int []arr, int i,int reqSum, int n){
    if (i == n){
        if (reqSum == 0) {return 1;}
        else { return 0;}
    }
    
    if (bool[i][reqSum + base]) {return dp[i][reqSum + base];}
 
     bool[i][reqSum + base] = true;
 
     dp[i][reqSum + base] =findCnt(arr, i + 1, reqSum, n) +
          findCnt(arr, i + 1, reqSum - arr[i], n);
    
    return dp[i][reqSum + base];
}
 
// Driver code
public static void main(String[] args)
{
    Subsets sb=new Subsets(7);
	int arr[] = { -3, -4, 2, -3, 8, 1, 10, 5};
    int n = arr.length;
   System.out.println("using the set "+Arrays.toString(arr)+" the number of subsets "
   		+ "that add to "+sb.reqSum+" are "+sb.findCnt(arr, 0, 20, n));
   
   StrtoInt sti = new StrtoInt("352791");
	sti.printAr(sti.intar);

}
}

class StrtoInt{
	String str;
	int int1;
	int len; 
	int[] intar;
	
	StrtoInt(String str)
	{
		intar = new int[str.length()];
		this.str=str;
		int1 = Integer.parseInt(str);
		len = str.length();
	    for(int j=0;j<len-1;j++) {
	    	intar[j] =  int1%10;
	    	int1 = int1/10;
	    }
	    intar[len-1] = int1;
	}
	
    public void printAr(int[] ar) {
    	for(int j=0;j<ar.length;j++) {
    		System.out.print(ar[j]+" ");
    	}
    }


    
}
 
// This code is contributed by 29AjayKumar
