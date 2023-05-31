package dp;

public class Perm {
	int[] b;
	int len;
	
	Perm(int[] a){
		this.b=a;len=b.length;
		}
	
	public static void perPerm(int[] a, int len) {
	        if(len==a.length-1) {
	        	printAr(a);
	        	return;
	        }
	        for(int j=len;j<a.length;j++) {
	        	//System.out.print(" j is "+j+" len is "+len);
	        	swap(a,j,len);
	            perPerm(a,len+1);
	            swap(a,j,len);//this is related to backtracking.. resetting
	            }
	}
	
	public static void swap(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	} 
	 
	public static void printAr(int[] a) {
		System.out.println("");
		for(int j=0;j<a.length;j++) {
			System.out.print(a[j]+", ");
		}
	}
	
	//cntD has nothing to do w/ Permutations
	
	public static void cntD(int n) {
		if(n==0) {return;}
		for(int j=0;j<n;j++) {
			System.out.println("j before is "+j+" and n  is "+n);
			cntD(n-1);
			System.out.println("j after is "+j+" and n  is "+n);
		}
	}
	
	public static void main(String[] args)
	{
		char[] ch= {'a','b','c','d'};
		int[] b= {2,3,4,5};
		int[] a= {2,3,4,5,6};
		int[] c= {2,3,4};
		System.out.println("c[2] is "+c[2]);
		perPerm(c,0);
		System.out.println(" ");
		cntD(2);
	}
}
