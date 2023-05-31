package dp;

public class Fib_and_Mem {
          long[] cache;
          long fibcnst,restart;
          
          Fib_and_Mem(int restart){
        	  this.restart=restart;
        	  cache = new long[restart];
        	  
        	fibcnst=0;
          }
          
          public void reCache() {
        	  for(int j=0;j<restart;j++) {
        		  cache[j]=0;
        	  }
          }
          
          
          
          
          
          
          public long fib(long n) {
        	  if(n==1||n==2) {return 1;}
        	  else {
        	return  fib(n-1)+fib(n-2);}
          }
        	 
          
          
          
          
          long fibMem(int n) {
        	  if(cache[n]!=0) {return cache[n];}
        	  if(n==1||n==2) {return 1;}
        	
             long fib =fibMem(n-1)+fibMem(n-2);
        	 cache[n]=fib;
             return cache[n];
          }
          
          public void fibF(int total){
        	long[] fib=new long[total];
        	fib[1]=1;fib[2]=1;
        	for(int j=3;j<total;j++) {
        		fib[j]=fib[j-1]+fib[j-2];
        	}
      
        	System.out.println("fibF at "+(total-1)+" is "+fib[total-1]);
      
          }

        public static void main(String[] args) {
        	Fib_and_Mem fandM = new Fib_and_Mem(400);
        	//
        	fandM.reCache();
        	fandM.fibF(201);
        	System.out.println("fibMem at 199 is "+fandM.fibMem(200));
        	System.out.println("fib at 30 is "+fandM.fibMem(30));
        	}
}
