package dp;
//'0' are blockages.

public class Maze2 {
	      int row,col;
	      char[][] maze;
	      Maze2(int row,int col){
	    	  this.row = row;
	    	  this.col = col;
	    	  this.maze = new char[row][col];
	      }
	      
	      public  char[][] maze2() {
		    	//char[][] maze = new char[10][10];
		    	for(int x = 0; x < row; x++) {
		            //System.out.print("| ");
		            for(int y = 0; y < col; y++) {
		             int rand = (int)(2.7*Math.random());
		             if(rand<1.4) {maze[x][y]='.';}
		             else {maze[x][y]='0';}
		             }}
		    	return maze;
		    	}
             
	public void print(char[][] maze) {
	        System.out.println("-----------------------");
	        for(int x = 0; x < row; x++) {
	            System.out.print("| ");
	            for(int y = 0; y < col; y++) {
	                System.out.print(maze[x][y] + " ");
	            }
	            System.out.println("|");
	        }
	        System.out.println("-----------------------");
	    }

	    public  boolean isValidSpot(char[][] maze, int r, int c) {
	        if(r >= 0 && r < row && c >= 0 && c < col) {
	            return maze[r][c] == '.';
	        }
	        return false;
	    }

	    public boolean traverse(char[][] maze, int r, int c) {
	        if(isValidSpot(maze, r, c)) {
	            //it is a valid spot
	            if(r == row-1 && c == col-1) {
	                return true;
	            }

	            maze[r][c] = '1';
//up
	            boolean returnValue = traverse(maze, r - 1, c);
//right        
	            if(!returnValue) {
	                returnValue = traverse(maze, r, c + 1);
	            }
//down
	            if(!returnValue) {
	                returnValue = traverse(maze, r + 1, c);
	            }
//left
	            if(!returnValue) {
	                returnValue = traverse(maze, r, c - 1);
	            }

	            if(returnValue) {
	                //System.out.println(r + ", " + c);
	                maze[r][c] = '*';
	            }
	            return returnValue;
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
	        char[][] maze = {
	                {'.', '.', '.', '0', '0', '0', '0', '0', '0', '0'},
	                {'0', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
	                {'0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
	                {'.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
	                {'.', '0', '0', '0', '.', '.', '.', '0', '.', '0'},
	                {'.', '.', '.', '.', '0', '0', '0', '.', '.', '0'},
	                {'.', '0', '0', '.', '.', '.', '0', '.', '.', '0'},
	                {'.', '.', '.', '0', '0', '.', '0', '0', '.', '.'},
	                {'0', '0', '.', '0', '0', '.', '.', '.', '0', '0'},
	                {'0', '0', '0', '0', '0', '0', '0', '.', '.', '.'},
	        };

	        //print(maze);
	        Maze2 m2 = new Maze2(12,10);
	        
	        char[][] mazeTest = m2.maze2();
	        m2.print(mazeTest);

	        if(m2.traverse(mazeTest, 0, 0)) {
	            System.out.println("SOLVED maze");
	        } else {
	            System.out.println("could NOT SOLVE maze");
	        }
	       // print(maze);
	        m2.print(mazeTest);
	    }
	
}

