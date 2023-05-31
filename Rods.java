package dp;
//X(L)=max{values[p]+X(L-p):1<= p <L} Ch 15 of Introduction to Algorithms
//this is getting you value of a rod of length-1
public class Rods {
	int length;
	int[] value;
	int[] setPrice={0,3,3,7,9,11,13,14,17,20,20,23,25,26,26};//new int[5];
	int[] setPrice2={0,2,5,7,9,13,16,19,23,27,32,37,43,49,60};
	
	Rods(int total){
		this.length=total;
		value=new int[length];
		value[0]=0;
		for(int j=0;j<length;j++) {
			//values[j]=2*j+1;
			value[j]=setPrice2[j];
		}
	   }
	
	public int X(int tot) {
		int[] cnt=new int[tot+1];
	   if(tot<=0) {return 0;}
	   else{
		  for(int j=1;j<=tot;j++) {
			cnt[j]=value[j]+X(tot-j);
		}return max(cnt);
		}
	}
	
	public int max(int[] b) {
		int max=b[0];int check=b.length;
		int k=0;
		while(k<check) {
			if(b[k]>max) {max=b[k];}
			k++;
		}return max;
	}
	
	public static void main(String[] args) {
		Rods rod=new Rods(12);
		for(int j=1;j<12;j++) {
		System.out.println("rod's total length is "+j+" and largest amount is "+rod.X(j));//gives the right total..
		}
	}

}
