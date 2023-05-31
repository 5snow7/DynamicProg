package dp;
import java.util.ArrayList;

public class TestStuff {
	
	ArrayList<Character> ch;
	int left, right, middle;
	
	TestStuff(ArrayList<Character> test){
		ch=new ArrayList<Character>();
		ch=test;
	}
	
	public void mergeSort(int left,int right) {
		if(left>=right) {return;}
		middle=(left+right)/2;
		System.out.println(" before left is "+left+" and right is "+right);
	    mergeSort(left,middle);
	    System.out.println("  after left is "+left+" and right is "+right);
	    mergeSort(middle+1,right);
	}
	
	public String revStr(String input) {
		if(input.length()==0) {return "a";}
		return revStr(input.substring(1))+input.charAt(0)+revStr(input.substring(1));
	}
	
	public void prtArray(ArrayList<Character> list) {
				System.out.print(list);
		}
	
	public static void main(String[] args) {
          String words =new String("helpmedothis");		
		ArrayList<Character> test=new ArrayList<Character>();
		for(int i = 0; i<words.length(); i++){test.add(words.charAt(i));}
		
		TestStuff ts=new TestStuff(test);
		ts.prtArray(ts.ch);
		//System.out.print("\n  "+ts.ch.get(4));
		//System.out.println("\n"+words.substring(2, 3).equals(words.substring(5,6)));
		//System.out.println(words.substring(2,3)+"  "+words.charAt(5));
	    //System.out.println(" reversing string twice is "+ts.revStr("tes"));
	    ts.mergeSort(0, 10);
	    //int x=0,y=1;
	    //System.out.println(" integer by 2 " + x/y);
	    //System.out.println("  a is first");
	    //System.out.println("  b is second");
	}
	
}
