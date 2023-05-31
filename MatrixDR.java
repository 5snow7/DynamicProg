package dp;
 //counting paths in a matrix where going down and right.

public class MatrixDR {
		int[][]  dp;
		int rtotal,ctotal;
		int total=0;
		
		MatrixDR(int rtotal,int ctotal){
		 this.rtotal=rtotal;this.ctotal=ctotal;
		 dp = new int[rtotal][ctotal];
		 
		 for(int j=0;j<rtotal;j++) {
			 for(int k=0;k<ctotal;k++) {
				 dp[j][k] =0;// (int) (Math.random() * 10);
				 dp[0][k]=1;dp[j][0]=1;
			 }
		 }dp[0][0]=0;
		 
		}
			public int uniquePaths(int m, int n) {
		        if(m==0&&n==0) return 0;
		        if(m==0||n==0) return 1;
		        //this works because of how a call stack works.
		        total= (uniquePaths(m-1,n)+uniquePaths(m,n-1));
		        return total;
			}

              void printM() {
            	  for(int j=0;j<rtotal;j++) {
         			 for(int k=0;k<ctotal;k++) {
         			System.out.print(dp[j][k]+" ");
         			 }System.out.println("");
         		 }
              }
              //The row and col is one off.  ie (3,4) is actually (4,5)
           public static void main(String[] args) {
        	   MatrixDR dr = new MatrixDR(3,3);
        	   dr.printM();
        	   System.out.println(" total is "+dr.uniquePaths(3,3)+ "... "+dr.dp[0][1]+"\n");
        	   dr.printM();
           }
			
}

