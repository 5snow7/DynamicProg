package dp;

import java.util.ArrayList;
import java.util.Arrays;
//make a given change from a set of coins
public class ChangeWCoins {
              int[] numCoins;
              int amount=0;
              
           ChangeWCoins(int amt){this.amount=amt;
       
           }
           
           public int coinChange(int[] coins,int amount ) {
        	   Arrays.sort(coins);// coins are the four coins 1,5,10,25
        	    numCoins=new int[amount + 1];//numCoins is an array of dim. amount
        	   Arrays.fill(numCoins, amount + 1);//starting with many coins and minimizing
        	   //System.out.println(" numCoins at start is "+numCoins[12]);
        	   numCoins[0]=0;
        	   for(int i=1;i<=amount;i++) {
        		   for(int j=0;j<coins.length;j++) {
        	     if(coins[j]<=i) {
        	    	 numCoins[i]=Math.min(numCoins[i], 1+numCoins[i-coins[j]]);
        	    	 //System.out.println(" numCoins at i = "+i+" is "+numCoins[i]);
        	     }else {
        	    	 break;
        	     }
        		   }//end of for loop of coins
        	   }//end of for loop for amount
        	   return numCoins[amount] > amount ? -1 : numCoins[amount];
           }

           public static void main(String[] args) {
        	   ChangeWCoins cwc = new ChangeWCoins(534);
        	   int[] coins=  {1,5,10,8,15};
        	   
        	   int total=cwc.coinChange(coins, cwc.amount);
        	   System.out.println("using "+total+" coins from "+Arrays.toString(coins)+"  to make "+cwc.amount);
        	   System.out.println((5 > 4 ? Arrays.toString(coins) : 2)+"");
           }
           
}


