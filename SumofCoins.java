package dp;

import java.util.Arrays;
import java.util.Vector;

//import dpprac.Permute1;

public class SumofCoins {
    String strper;
    
    int[] coins = {1,2,3,4,5,6 };
    //int n = coins.length;

    SumofCoins(String str){
	this.strper = str;	
    PerStr(str,"");
    diceRoll(2);
    sumofCoins(coins,30);
    System.out.println("\n coins[1] is "+coins[1]);
	}
 
	public void PerStr(String str, String chosen) {
		if(str.length() == 0) {System.out.println(chosen);}
		else {
			for(int j = 0;j<str.length();j++) {
            String ch = str.substring(j, j+1);
            chosen = chosen + ch;
            String sr = str.replace(ch,"");			
            PerStr(sr,chosen);
            chosen = chosen.substring(0,chosen.length()-1);
			}
			}
	}
	
	public void diceRoll(int dice) {
		Vector<Integer> vec = new Vector<Integer>();
		drHelper( dice,vec);
	}
	
	public void drHelper(int nd,Vector<Integer> vec) {
		if(nd == 0 ) {System.out.println(vec);return;}
		else {
		for(int j=1;j<7;j++) {
			vec.add(j);
			drHelper(nd-1,vec);
			vec.remove(vec.size()-1);
		}}
		
	}

	public void sumofCoins(int[] coins,int sum){
		  int n = coins.length;
	      sumHelper(coins,n,sum);
	      System.out.println(" number of ways to add the array "+Arrays.toString(coins)+" to " +
	      sum+" is "+sumHelper(coins,n,sum));
	   }
	
	public int sumHelper(int coins[], int n, int sum)
	    {
	 
	        if (sum == 0)
	            return 1;
	 
	        if (sum < 0)
	            return 0;
	 
	        if (n <= 0)
	            return 0;
	        
	        return sumHelper(coins, n - 1, sum)
	            + sumHelper(coins, n, sum - coins[n - 1]);
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new SumofCoins("abcd");
     
	}

}


