package dp;

import java.util.Scanner;

//this is the bowling pr. of MIT 6.006 2020
//you can knock down 0 or 1 or 2 pins
public class Bowling {
       int[] pins;
       
       Bowling(int [] pins){
    	   this.pins=pins;
    	   //this.pins=new int[20];
    	   //pins=new int[] {-2,-3,4,-5,10,6};
    	   
       }
       
       public int Bowl(int i) {
    	   int n=pins.length;  
    	   int total=0;
    	   if(i<0) {return 0;}
    	   if(i>=n) {return 0;}
    	   
    	     for(int k=n-2;k>=i;k--) {
    	    	 total = max(Bowl(k+1),Bowl(k+1)+pins[k],Bowl(k+2)+pins[k]*pins[k+1]);}
    	   
    	   return total;
       }
       
       public int max(int x,int y, int z) {
    	   if(x>=y&&x>=z) {return x;}
    	   if(y>=x&&y>=z) {return y;}
    	   if(z>=x&&z>=y) {return z;}
    	   return 0;
       }
       
       public static void main(String[] args) {
    	  
    	   Scanner scan=new Scanner(System.in);
    	   System.out.println("enter a set of integers separated by commas. ");
    	   String str= scan.nextLine();
    	   String[] strAr=str.split(",");
    	   int[] intAr=new int[strAr.length];
    	   for(int j=0;j<strAr.length;j++) {
    		intAr[j]=Integer.parseInt(strAr[j]);
    		System.out.print(intAr[j]+", ");
    	   }
    	   int[] test = new int[] {-2,-3,4,-5,10,6};
    	   Bowling bow=new Bowling(intAr);
    	   System.out.println("\n"+bow.Bowl(0));
       
       /*PathsInMbyN path1=new PathsInMbyN(3,4);
       System.out.println(""+path1.maze.toString());
       path1.findPaths(path1.maze, 3,4);
       System.out.println(" size of paths is "+path1.allPaths.size());*/   
       //System.out.println(""+path1.allPaths.toString());
}}
