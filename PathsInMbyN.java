package dp;

//Java program to Print all possible paths from 


//top left to bottom right of a mXn matrix
//easily treat this by adding an ArrayList holding each path
//add each path, find which is max and returning that path.  
//actually allPaths already has the complete list.  so write a
//method that takes an ArrayList and returns the row with the largest sum
import java.io.*;
import java.util.*;
//find all possible paths from upper left to lower right in a matrix.0
class PathsInMbyN
{
    ArrayList<ArrayList<Integer>> allPaths;
    ArrayList<ArrayList<Integer>> maze;
    
    PathsInMbyN(int row,int col){
    	allPaths =new ArrayList<ArrayList<Integer>>();//instantiating a 2 D answer array
    	maze =new ArrayList<ArrayList<Integer>>();//creating 2 D array ie matrix
    	
    		for(int j=0;j<row;j++) {
    			ArrayList<Integer> tempAr =new ArrayList<Integer>();
    			for(int k=0;k<col;k++) {
                //int temp=(int)(Math.random()*10);
    		    int temp=j*col+k;
                tempAr.add(temp);
    			}
    			maze.add(tempAr);
    		}
      }
    
    public void printM(ArrayList<ArrayList<Integer>> arrl) {
    	System.out.println("the size of the list is "+arrl.size());
    	for(int j=0;j<arrl.size();j++) {
    		System.out.println(arrl.get(j));
    	}
    }

    void findPaths(ArrayList<ArrayList<Integer>> maze,int m, int n){
        ArrayList<Integer> path = new ArrayList<Integer>();
        for(int i = 0; i < m + n - 1; i++){
         path.add(i);
         }
         findPathsUtil(maze, m, n, 0, 0, path, 0);
}
    
 void findPathsUtil(ArrayList<ArrayList<Integer>> maze,int m, int n, int i,int j,ArrayList<Integer> path,int index){///////
// If we reach the bottom of maze, we can only move right
 if(i == m - 1)
 {               //set the value in the array at the given index.  
   for(int k = j; k < n; k++){
	   path.set(index + k - j, maze.get(i).get(k));
	   }
       System.out.println(path);
       allPaths.add(path);
        return;
        }
 
        if(j == n - 1)
        {
        for(int k = i; k < m; k++)
        {
         path.set(index + k - i,maze.get(k).get(j));// j is fixed at n-1
         } 
        System.out.println(path);
         allPaths.add(path);
         return;
         }
         path.set(index,maze.get(i).get(j));

         findPathsUtil(maze, m, n, i + 1, j, path, index + 1);
         findPathsUtil(maze, m, n, i,j + 1 , path, index + 1);
          }


         public static void main (String[] args) {
                              
          PathsInMbyN path1= new PathsInMbyN(3,4);
           
          System.out.println(" the labelled maze to find the paths on");
          path1.printM(path1.maze);
          System.out.println("///////////////////////////////////////");
          path1.findPaths(path1.maze, 3,4);    
          
          System.out.println("\nThe # of paths is: "+path1.allPaths.size());
          System.out.println("Path 8 is: \n"+path1.allPaths.get(8));
          System.out.println("\nAll the paths are listed below:\n");
          path1.printM(path1.allPaths);
}
}

