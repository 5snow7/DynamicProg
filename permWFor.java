package dp;

import java.util.Arrays;

public class permWFor {
	  String perm;
	  
	permWFor(String p){
		this.perm=p;
	}
	
	public void permFor(String str,int l,int r){
		if(l==r) {System.out.println(str);}
		else {
			for(int i=l;i<r;i++) {
				str=swap(str,i,r);
				permFor(str,l+1,r);
				str=swap(str,i,r);
			}}}
	
	public String swap(String str,int j,int k) {
		String chj=""+str.charAt(j);
		String chk=""+str.charAt(k);
		str=str.substring(0,j)+chk+str.substring(j+1);//   +str.substring(j+1);
		str=str.substring(0,k)+chj+str.substring(k+1);
		return str;
	}
	
	public static void main(String[] args) {
		permWFor pwf=new permWFor("helpl");
		System.out.println(pwf.swap("tesintwertox", 4, 7));
		pwf.permFor(pwf.perm, 0, pwf.perm.length()-1);
		
	}

	
}
