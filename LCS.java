package dp;

import java.util.ArrayList;
import java.util.List;
//Longest Common Subsequence - 
//A subsequence doesn't have to be contiguous
public class LCS {
	
	String s,s1,s2;
	LCS(String s,String s1){
	          this.s=s;
	          this.s1=s1;
		      this.s2=""; 
	}
	
	public int lcS(int j,int k) {
		if(j==s.length()) return 0;
		if(k==s1.length()) return 0;
		if(s.charAt(j)==s1.charAt(k)) {
			this.s2=this.s2+s.charAt(j);
			//System.out.println(this.s.charAt(j)+"  s2 ");
			return 1+lcS(j+1,k+1);}
		
		else {return max(lcS(j+1,k),lcS(j,k+1));}
	}
	
	public int max(int a,int b) {
		if(a>=b)return a;
		else return b;
	}
	
	public static void main(String[] args) {
		LCS lcs=new LCS("wwidiotesrrd","hioetesba");
		System.out.println("the length of the LCS is "+lcs.lcS(0, 0)+
				"\n and the LCS is "+lcs.s2);  
		/*char x=lcs.s.charAt(5);
		System.out.println(x+" is the 5th character of the sequence and the \n 50th "
				+ "character in the builder is "+lcs.s2.charAt(20));
		for(int j=0;j<lcs.lcS(0, 0);j++) {
			System.out.print(lcs.s2.charAt(j)+", "); 
		}*/
	}
	}
